<template>
    <div>
        <div class="welcoming">Hi dermatologist!</div>
        <div class="panelDiv">
                <DermatologistMenu/>
        </div> 
    </div>  
</template>

<script>
import DermatologistMenu from '../../components/dermatologist/DermatologistMenu.vue'
export default {
    name: 'DermatologistProfile',   
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