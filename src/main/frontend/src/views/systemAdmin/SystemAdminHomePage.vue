<template>
    <div>
        <SystemAdminMenu/>
        <HomeBackground/>
    </div>
</template>

<script>
import HomeBackground from '../../components/HomeBackground.vue'
import SystemAdminMenu from '../../components/systemAdmin/SystemAdminMenu.vue'
export default {
    name:'SystemAdminHomePage',
    components: { SystemAdminMenu, HomeBackground },

}
</script>

<style>

.panelDiv {
    float: bottom;
}
</style>