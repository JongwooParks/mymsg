import SockJS from 'sockjs-client';
import { Client } from '@stomp/stompjs';
import axios from 'axios';

export default {
    data() {
        return {
            stompClient: null,
            myMsg: '',
            messages: [], // 메시지를 배열로 관리
            connected: false,
            user:'',
            token: ''
        };
    },

    computed: {
        messageHtml() {
            // 메시지 배열을 HTML로 변환
            return this.messages.map(msg => `<div>${msg.sender} : ${msg.content} ${this.convertTime(msg.dateTime)}</div>`).join('');
        }
    },
    methods: {
        connect() {
            const socket = new SockJS('/dawn/chat');
            console.log('2 : '+this.token);
            this.stompClient = new Client({
                webSocketFactory: () => socket,
                connectHeaders: {
                    Authorization: this.token, // 헤더에 JWT 토큰 추가
                },
                onConnect: (frame) => {
                    console.log('Connected: ' + frame);
                    this.connected = true;
                    this.stompClient.subscribe('/topic/messages', (message) => {
                        const msg = JSON.parse(message.body);
                        this.addMessage(msg);
                    });
                    this.loadMessages(); // 연결 후 최근 메시지 로드
                },
                onDisconnect: () => {
                    console.log('해제됨');
                    this.connected = false; // 연결 해제 시 상태 업데이트
                },
                onStompError: (error) => {
                    console.error('STOMP error:', error);
                }
            });
            this.stompClient.activate();
        },
        sendMessage() {
            if (!this.connected) {
                console.error('Not connected to the server.');
                return;
            }

            const messagePayload = { content: this.myMsg };
            this.stompClient.publish({
                destination: '/app/send',
                headers: { 'Authorization': this.token }, // JWT 토큰 포함
                body: JSON.stringify(messagePayload)
            });

            this.myMsg = ''; // 입력 필드 초기화
        },
        loadMessages() {

            axios.post('/dawn/api/msg/getRecentMessages', {}, {
                headers: {
                    'Authorization': this.token // 인증 헤더 추가
                }
            })
                .then(response => {
                    this.messages = response.data; // 서버로부터 받은 메시지를 배열에 직접 할당
                })
                .catch(error => {
                    console.error('Error loading messages:', error); // 오류 처리
                });
        },
        addMessage(msg) {
            this.messages.push(msg); // 새로운 메시지 추가
            if (this.messages.length > 10) {
                this.messages.shift(); // 10개를 초과하면 가장 오래된 메시지 제거
            }
        },
        convertTime(time) {
            let date = new Date(time);
            let str = date.toTimeString().split(' ')[0];
            const month = date.getMonth() + 1; // getMonth()는 0부터 시작하므로 +1
            const day = date.getDate();
            const dateStr = `${month.toString().padStart(2, '0')}/${day.toString().padStart(2, '0')}`;

            return `${str} (${dateStr})`;
        }
    },
    mounted() {
        this.token = localStorage.getItem('jwtToken');
        console.log(this.token);
        if(!this.token){
            alert('로그인이 필요합니다.');
            this.$router.push('/login');
            return;
        }
        this.connect(); // 컴포넌트가 마운트될 때 연결
    }
};