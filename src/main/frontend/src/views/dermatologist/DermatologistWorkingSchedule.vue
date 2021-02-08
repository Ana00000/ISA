<template>
    <div>
        <div>
            <DermatologistWorkSchedule/>
        </div> 
        <div>
            <DermatologistMenu/>
        </div> 
    </div>  
</template>

<script>
import DermatologistWorkSchedule from '../../components/dermatologist/DermatologistWorkSchedule.vue'
import DermatologistMenu from '../../components/dermatologist/DermatologistMenu.vue'
export default {
    name: 'DermatologistWorkingSchedule',    
    components : {   
        DermatologistWorkSchedule,
        DermatologistMenu
    }
}
</script>