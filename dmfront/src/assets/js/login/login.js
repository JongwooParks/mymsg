import axios from 'axios';
import {useStore} from "vuex";

export default {
    data(){
        return {
            userId: '',
            password: '',
            store : useStore()
        }
    },
    methods:{
        validUserId(){
            axios.post(`/dawn/sign/validUserId`,{userId:this.userId})
                .then(response=>{
                    if(!response.data){
                        alert('존재하지 않는 id 입니다.');
                        this.userId = '';
                        this.$refs.idInput.focus();
                    }
                }).catch(error=>{
                console.error(error);
            })
        },
        doLogin(){
            const data = {
                userId : this.userId,
                password : this.password
            };

            if(!data.userId || !data.password){
                alert('no padding!');
                return;
            }

            axios.post(`/dawn/auth/login`,data)
                .then(response=>{
                    if(response.data){
                        console.log(response.data);
                        localStorage.setItem('jwtToken', response.data);
                        this.store.commit('set', localStorage.getItem('jwtToken'));
                        this.$router.push('/123/chat');
                    }
                })
                .catch(error=>{
                    alert(error);
                    console.error(error);
                })
        }
        }

}