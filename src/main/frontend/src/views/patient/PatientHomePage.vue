<template>
    <div  class="backgroundDiv">
        <div class = "panelDiv">
            <PatientMenu/>
        </div>
        <div class = "panelDiv">

        </div>
    </div>
</template>

<script>
import PatientMenu from '@/components/PatientMenu.vue'
export default {
    name : 'PatientHomePage',
    components : {
        PatientMenu
    }
}
</script>

<style scoped>
.panelDiv {
    float: left;
    /* display: in
    
    line-block; */
}

.backgroundDiv {
  background: url('https://wallup.net/wp-content/uploads/2017/11/17/260979-pills-pharmacy.jpg');
  background-size: cover;
  width: 100%;
  height: 100%;
}
</style>