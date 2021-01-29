<template>
    <div>
        <div class = "panelDiv">
            <PatientMenu/>
        </div>
        <div class = "panelDiv">

        </div>
    </div>
</template>

<script>
import PatientMenu from '../components/PatientMenu.vue'
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
    /* display: inline-block; */
}
</style>