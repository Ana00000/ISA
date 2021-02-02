<template>
    <div>
        <home-background class="homeBack"/>
        <div class="panelDiv">
            <PharmacistMenu/>
        </div>
    </div>
</template>

<script>
import HomeBackground from '../../components/HomeBackground.vue';
import PharmacistMenu from '../../components/pharmacist/PharmacistMenu.vue'
export default {
    name : 'PharmacistHomePage',
    components : {   
        HomeBackground,
        PharmacistMenu
    },
    data() {
        return{
            items: []
        }
    }
}
</script>

<style scoped>
.homeBack {
    height: 840px;
}

.panelDiv {
    float: bottom;
}
</style>