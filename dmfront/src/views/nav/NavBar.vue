<template>
  <nav>
    <ul id="nav_ul">
     <li class="nav_li"> <router-link to="/">Home</router-link> | </li>
     <li class="nav_li"> <router-link to="/about">About</router-link> | </li>
     <li class="nav_li"> <router-link to="/123/chat">Chat</router-link> | </li>
     <li class="nav_li"> <router-link to="/signup">Sign Up</router-link> | </li>
     <li class="nav_li">
       <a v-if="isLogin" @click.prevent="logout">Logout</a>
       <router-link v-else to="/login">Login</router-link>
     </li>
    </ul>
  </nav>
</template>

<script>
import DmNavigation from '../../assets/js/nav/dmNavigation'

export default DmNavigation;
</script>

<style scoped>
@import "../../assets/css/nav/nav.css";
</style>