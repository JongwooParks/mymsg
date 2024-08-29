<template>
  <div>
    <!--    <input v-model="test" type="text" />-->
    <div id="id_container">
      <input v-model="userId" type="text" placeholder="id" @blur="validUserId" ref="idInput">
    </div>
    <div id="pw_container">
      <input v-model="password" type="password" placeholder="password">
    </div>
    <div class="btn_signup">
      <button @click="doLogin" id="login" type="button">
        <span>L</span><span>O</span><span>g</span><span>I</span><span>N</span>
      </button>
    </div>

  </div>
</template>

<script>
import Login from '../../assets/js/login/login'

export default Login;
</script>

<style scoped>
@import "../../assets/css/login/login.css";
</style>