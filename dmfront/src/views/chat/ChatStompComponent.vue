<template>
  <div>
    <div id="messages">
      <div v-html="messageHtml"></div>
    </div>
    <input v-model="myMsg" type="text" />
    <button @click="sendMessage">Send</button>
  </div>
</template>
<script>
import ChatStomp from '../../assets/js/chat/chatStomp'
export default ChatStomp;
</script>
<style scoped>
@import "../../assets/css/chat/chatStomp.css";
</style>