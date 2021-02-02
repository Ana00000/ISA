<template>
    <div>
        <div class="welcoming">Dermatologist you can find your working schedule here!</div>
        <div class="panelDiv">
                <DermatologistMenu/>
        </div> 
    </div>  
</template>

<script>
import DermatologistMenu from '../components/DermatologistMenu.vue'
export default {
    name: 'WorkingSchedule',    
    components : {   
        DermatologistMenu
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