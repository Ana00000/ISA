<template>
  <v-app class="grey lighten-4">
    <div>
      <NavigationBar/>
    </div>
    <v-content style="border: solid black 2px">
      <router-view></router-view>
    </v-content>
  </v-app>
</template>

<script>
import NavigationBar from './components/NavigationBar.vue'

export default {
  name: 'App',

  components: {
    NavigationBar
  },

  data: () => ({
  }),
};
</script>
