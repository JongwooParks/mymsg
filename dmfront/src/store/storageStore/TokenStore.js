import {createStore} from 'vuex';

const store = createStore ({
    state : {
        value : ''
    },
    mutations: {
        set(state,token){
            state.value = token;
        }
    },
    getters: {
        get(state){
            return state.value;
        }
    }
});

export default store;
