<template >
  <v-container style="padding: 0px" fluid fill-height dark >
    <v-layout>
    <div style="width:25%;">
        <PatientMenu/>
    </div>
    <div class="panelDiv" style="width:50%;">
        <div style="margin: 50px"><h2 class="display-3">Choose QRcode:</h2></div>
        <qrcode-capture @decode="onDecode" />
    </div>
  </v-layout>
    </v-container>
</template>

<script>
import {  QrcodeCapture } from 'vue-qrcode-reader'
import PatientMenu from '@/components/PatientMenu.vue'
export default {

  components: { QrcodeCapture,PatientMenu },

  data () {
    return {
      result: ''
    }
  },

  methods: {
    onDecode (result) {
      this.result = result
      window.location.href= this.result;
    }
  }
}
</script>

<style scoped>

.panelDiv {
    width: 100%;
    margin: 0 auto;
    background: none;
    border: none;
}

.backgroundDiv {
  background: url('https://wallup.net/wp-content/uploads/2017/11/17/260979-pills-pharmacy.jpg');
  background-size: cover;
  width: 100%;
  height: 100%;
}
</style>