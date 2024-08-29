import SockJS from "sockjs-client";
import {Client} from "@stomp/stompjs";
import axios from "axios";
import {loginCheck} from "@/assets/js/util/auth/authHelpers";
import {timeFormatter} from "@/assets/js/util/date/dateHelpers";


export default {
    data(){
        return{
            stompClient : null,
            content: '',
            messages: [],
            connected : false,
            userInfo : {}
        };
    },
    props:{
        roomId: {
            type: String,
            required: true
        }
    },
    computed:{
        messageList(){
            let list = this.messages.map(msg => this.parseHtml(msg));
            return list.join('');
        }
    },
    methods:{
       async beforeCheck(){
            const response = await loginCheck();
            if(!response.result){
               alert('로그인이 필요합니다.');
               this.$router.push('/login');
               return;
            }

            this.userInfo.userId =  response.id;
            this.userInfo.token = response.token;
        },

        connect(){
           console.log('1')
           const socket = new SockJS('/dawn/chat');
           this.stompClient = new Client({
               webSocketFactory: () => socket,
               connectHeaders:{
                   Authorization: this.userInfo.token
               },
               onConnect: (frame) => {
                   console.log('Connected: ' + frame);
                   this.connected = true;
                   this.stompClient.subscribe('/topic/messages', (message) => {
                       const msg = JSON.parse(message.body);
                       console.log(msg);
                       this.pushMessage(msg);
                   })
                   this.loadMessage();
               },

               onDisconnect: () => {
                   this.connected = false;
                   console.log('socket disconnected');
               },
               onStompError: (error) => {
                   console.error('STOMP error : ',error);
               }

           });
            this.stompClient.activate();
        },

        pushMessage(msg){
           this.messages.push(msg);
           if(this.messages.length > 7){
               this.messages.shift();
           }
        },

        send(){
          if(!this.connected){
              alert('not connected');
              return;
          }
          const sendRequest = {content : this.content, roomId : this.roomId};
          this.stompClient.publish({
             destination: '/app/send',
             headers : {'Authorization' : this.userInfo.token},
             body: JSON.stringify(sendRequest)
          });

          this.content = '';
        },

        parseHtml(msg){

           const isMe = msg.sender === this.userInfo.userId;
           const sendTime =  timeFormatter(false).format(new Date(msg.dateTime));

            return `<div class="message ${isMe ? 'mine' : 'guest'}">
                <div class="header"> 
                    <span class="sender"> ${isMe ? '' : msg.sender} </span>
                    <span class="sendTime">${sendTime}</span>
                </div>
                <div class="content"> ${msg.content} </div>
            </div>`;
        },

        async loadMessage(){
           try{
               console.log({
                   roomId : this.userInfo.roomId
               })

               let messageList = await axios.post('/dawn/api/msg/getRecentMessages'
                   ,{
                    roomId : this.roomId
                   },{
                   headers: {
                       'Authorization' : this.userInfo.token
                   }
               });

               this.messages = messageList.data;

           }catch(error){
               console.error(error);
           }
        }

    },
    async mounted(){
        await this.beforeCheck();
        this.connect();
    }
}