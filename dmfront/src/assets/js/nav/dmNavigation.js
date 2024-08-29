import {useStore} from "vuex";

export default {

    data() {
        return {
            store: useStore() // store를 data 속성으로 가져오기
        };
    },
    computed: {
        isLogin() {
            // localStorage에서 토큰을 가져와서 상태를 설정
            this.store.commit('set', localStorage.getItem('jwtToken'));
            const token = this.store.getters.get;
            return !!token;
        }
    },
    methods: {
        logout() {
            localStorage.removeItem('jwtToken');
            this.store.commit('set', '');
            this.$router.push('/');
        }
    }
};