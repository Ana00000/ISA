<template>
    <div>
        <div>
            <WorkingSchedule/>
        </div> 
        <div>
            <PharmacistMenu/>
        </div> 
    </div>  
</template>

<script>
import WorkingSchedule from '../../components/doctor/WorkingSchedule.vue'
import PharmacistMenu from '../../components/pharmacist/PharmacistMenu.vue'
export default {
    name: 'PharmacistWorkingSchedule',    
    components : {   
        WorkingSchedule,
        PharmacistMenu
    }
}
</script>