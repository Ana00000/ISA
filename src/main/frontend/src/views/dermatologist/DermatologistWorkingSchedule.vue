<template>
    <div>
        <div>
            <WorkingSchedule/>
        </div> 
        <div class="panelDiv">
            <DermatologistMenu/>
        </div> 
    </div>  
</template>

<script>
import WorkingSchedule from '../../components/WorkingSchedule.vue'
import DermatologistMenu from '../../components/dermatologist/DermatologistMenu.vue'
export default {
    name: 'DermatologistWorkingSchedule',    
    components : {   
        WorkingSchedule,
        DermatologistMenu
    }
}
</script>