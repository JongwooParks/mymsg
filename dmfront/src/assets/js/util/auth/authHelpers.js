import axios from "axios";

export async function loginCheck(){
    const token = localStorage.getItem('jwtToken');
    if(!token) return new AuthResponse(false,'', '');

    try{
        const response = await  axios.post('/dawn/auth/loginCheck',{},{
            headers: {
                'Authorization' : token
            }
        });
        return new AuthResponse(true,response.data.dto.userId,token);
    }catch(error){
        console.error(error);
        return new AuthResponse(false,'','');
    }


}

class AuthResponse{
    constructor(result, id, token) {
        this.result = result;
        this.id = id;
        this.token = token;
    }

}