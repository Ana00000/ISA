<template>
    <div>
        <div class = "panelDiv">
            <PharmacistMenu/>
        </div>
        <div class = "panelDiv"/>
    </div>
</template>

<script>
import PharmacistMenu from '../components/PharmacistMenu.vue'
export default {
    name : 'PharmacistHomePage',
    components : {
        PharmacistMenu
    }
}
</script>

<style scoped>
.panelDiv {
    float: right;
}
</style>