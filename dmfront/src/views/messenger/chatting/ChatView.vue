<template>
  <div>
    <div id="messages">
      <div id="message_container" v-html="messageList"></div>
    </div>
    <div id="send_container">
      <input v-model="content" type="text" />
      <button @click="send">Send</button>
    </div>

  </div>
</template>
<script>
  import DmChatting from "@/assets/js/messenger/chatting/dmChatting";
  export default DmChatting;
</script>
<style scoped>
@import "../../../assets/css/messenger/chatting/chatView.css";
</style>