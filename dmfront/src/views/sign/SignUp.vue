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
      <button @click="signUp" id="signup" type="submit">
        <span>S</span><span>I</span><span>g</span><span>n</span> <span>u</span><span>p</span>
      </button>
    </div>

  </div>
</template>

<script>
import SignUp from '../../assets/js/sign/signup'

export default SignUp;
</script>

<style scoped>
@import "../../assets/css/sign/sign.css";
</style>