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
import WorkingSchedule from '../../components/WorkingSchedule.vue'
import PharmacistMenu from '../../components/pharmacist/PharmacistMenu.vue'
export default {
    name: 'PharmacistWorkingSchedule',    
    components : {   
        WorkingSchedule,
        PharmacistMenu
    }
}
</script>