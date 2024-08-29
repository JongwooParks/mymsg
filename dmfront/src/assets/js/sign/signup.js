import axios from 'axios';

export default {
    data(){
        return {
            userId: '',
            password: ''
        }
    },
    methods:{
        validUserId(){
            axios.post(`/dawn/sign/validUserId`,{userId:this.userId})
                .then(response=>{
                    if(response.data){
                        alert('already exist id');
                        this.userId = '';
                        this.$refs.idInput.focus();
                    }
                }).catch(error=>{
                    console.error(error);
            })
        },
        signUp(){
            const data = {
                userId : this.userId,
                password : this.password
            };

            if(!data.userId || !data.password){
                alert('no padding!');
                return;
            }

            axios.post(`/dawn/sign/up`,data)
                .then(response=>{
                    if(response.data){
                        alert('success');
                        this.userId = '';
                        this.password = '';
                    }
                })
                .catch(error=>{
                    console.error(error);
                })
        }
    }

}