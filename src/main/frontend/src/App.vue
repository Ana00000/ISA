<template>
  <div>
    <span class="bg"/>
    <v-app>
      <NavigationBar/>
      <v-content>
        <router-view></router-view>
      </v-content>
    </v-app>
  </div>
</template>

<script>
import NavigationBar from './components/NavigationBar.vue'

export default {
  name: 'App',
  el: '#app',
  components: {
    NavigationBar
  },

  data: () => ({
    //
  }),
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
#nav {
  padding: 30px;
  color: #2c3e50;
}
#nav a {
  font-weight: bold;
  color: #2c3e50;
}
#nav a.router-link-exact-active {
  color: #42b983;
}

.bg {
  width: 100%;
  height: 100%;
  position: fixed;
  background: url('assets/background.jpg') no-repeat center center;
  background-attachment: fixed;
  opacity: 35%;
  background-size: cover;
}
</style>