<template>
    <div>
        <div class="welcoming">Pharmacist you can find your prescriptions here!</div>
        <div class="panelDiv">
                <PharmacistMenu/>
        </div> 
    </div>  
</template>

<script>
import PharmacistMenu from '../components/PharmacistMenu.vue'
export default {
    name: 'Prescriptions',    
    components : {   
        PharmacistMenu
    },
}
</script>


<style scoped>
.welcoming {
    font-weight: bolder;
    font-size: 25px;
    height: 840px;
}

.panelDiv {
    float: bottom;
}
</style>