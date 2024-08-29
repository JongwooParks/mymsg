import {loginCheck} from "@/assets/js/util/auth/authHelpers";
import axios from "axios";

export default {
    data(){
        return{
            roomName: '',
            userInfo: {}
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
        create(){
            axios.post('',{
                roomOwner : this.userInfo.userId,
                roomName : this.roomName
            },{
                headers: {
                    'Authorization' : this.userInfo.token
                }
            })
        }
    }
}