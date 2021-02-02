<template>
    <div>
        <div class = "panelDiv">
            <DermatologistMenu/>
        </div>
        <div class = "panelDiv"/>
    </div>
</template>

<script>
import DermatologistMenu from '../components/DermatologistMenu.vue'
export default {
    name : 'DermatologistHomePage',
    components : {
        DermatologistMenu
    }
}
</script>

<style scoped>
.panelDiv {
    float: right;
}
</style>