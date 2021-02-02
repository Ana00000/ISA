<template>
    <v-container fluid fill-height class="backgroundDiv" style="max-height: 100vh;">
      <v-layout justify-center align-center column pa-5 style="background-color: grey; opacity:0.65">
        <div class="display-4 font-weight-black white--text text-xs-center">STAY HEALTHY</div>
        <div class="display-4 font-weight-black white--text text-xs-center mb-3">WITH PHARMACY SYSTEM</div>
        <div class="display-1 font-weight-bold white--text text-xs-center">When you feel sick, we are your number one pick</div>
        <v-btn fab class="mt-5 blue darken-4">
            <v-icon large color="white">mdi-chevron-down</v-icon>
        </v-btn>
      </v-layout>
  </v-container>
</template>

<script>
export default {
    name: 'HomeBackground'
}
</script>

<style scoped>
.backgroundDiv {
  background: url('https://wallup.net/wp-content/uploads/2017/11/17/260979-pills-pharmacy.jpg');
  background-size: cover;
  width: 100%;
  height: 100%;
}
</style>