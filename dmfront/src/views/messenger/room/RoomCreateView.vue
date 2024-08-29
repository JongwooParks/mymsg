<template>
  <div>
    <h1>방생성</h1>
    <input v-model="roomName" type="text">
    <button @click="create"></button>
  </div>
</template>
<script>
  import RoomCreate from "@/assets/js/chat/room/roomCreate";
  export default RoomCreate;
</script>
<style scoped>

</style>