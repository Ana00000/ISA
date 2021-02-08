<template>
    <div>
        <div>
            <PharmacistWorkSchedule/>
        </div> 
        <div>
            <PharmacistMenu/>
        </div> 
    </div>  
</template>

<script>
import PharmacistWorkSchedule from '../../components/pharmacist/PharmacistWorkSchedule.vue'
import PharmacistMenu from '../../components/pharmacist/PharmacistMenu.vue'
export default {
    name: 'PharmacistWorkingSchedule',    
    components : {   
        PharmacistWorkSchedule,
        PharmacistMenu
    }
}
</script>