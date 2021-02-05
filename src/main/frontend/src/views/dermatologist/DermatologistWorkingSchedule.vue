<template>
    <div>
        <div>
            <WorkingSchedule/>
        </div> 
        <div>
            <DermatologistMenu/>
        </div> 
    </div>  
</template>

<script>
import WorkingSchedule from '../../components/doctor/WorkingSchedule.vue'
import DermatologistMenu from '../../components/dermatologist/DermatologistMenu.vue'
export default {
    name: 'DermatologistWorkingSchedule',    
    components : {   
        WorkingSchedule,
        DermatologistMenu
    }
}
</script>