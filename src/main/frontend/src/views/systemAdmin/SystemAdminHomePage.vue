<template>
    <div class="backgroundDiv">
        <SystemAdminMenu/>
    </div>
</template>

<script>
import SystemAdminMenu from '../../components/systemAdmin/SystemAdminMenu.vue'
export default {
    name:'SystemAdminHomePage',
    components: { SystemAdminMenu },

}
</script>

<style>

.panelDiv {
    float: bottom;
}

.backgroundDiv {
  background: url('https://wallup.net/wp-content/uploads/2017/11/17/260979-pills-pharmacy.jpg');
  background-size: cover;
  width: 100%;
  height: 100%;
}
</style>