<template>
    <div>
        <div class="welcoming">Pharmacist you can find your working schedule here!</div>
        <div class="panelDiv">
                <PharmacistMenu/>
        </div> 
    </div>  
</template>

<script>
import PharmacistMenu from '../../components/pharmacist/PharmacistMenu.vue'
export default {
    name: 'WorkingSchedule',    
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