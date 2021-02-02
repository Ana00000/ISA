<template>
    <div>
        <home-background class="homeBack"/>
        <div class="panelDiv">
            <DermatologistMenu/>
        </div>
    </div>
</template>

<script>
import HomeBackground from '../components/HomeBackground.vue';
import DermatologistMenu from '../components/DermatologistMenu.vue'
export default {
    name : 'DermatologistHomePage',
    components : {
        HomeBackground,
        DermatologistMenu
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
    height: 850px;
}

.panelDiv {
    float: bottom;
}
</style>