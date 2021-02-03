<template>
    <div>
        <div class="welcoming">Hi pharmacist!</div>
        <div class="panelDiv">
                <PharmacistMenu/>
        </div> 
    </div>  
</template>

<script>
import PharmacistMenu from '../../components/pharmacist/PharmacistMenu.vue'
export default {
    name: 'PharmacistProfile',
    components : {   
        PharmacistMenu
    }
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