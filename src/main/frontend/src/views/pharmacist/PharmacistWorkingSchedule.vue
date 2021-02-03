<template>
    <div style="
        background: #13077d;
        background: -webkit-linear-gradient(to right, #5442ed, #cdc8fa, #13077d);
        background: linear-gradient(to right, #5442ed, #cdc8fa, #13077d);">
        <br/>
        <div class="welcoming">Pharmacist you can find your working schedule here!</div>
        <div class="panelDiv">
                <PharmacistMenu/>
        </div> 
    </div>  
</template>

<script>
import PharmacistMenu from '../../components/pharmacist/PharmacistMenu.vue'
export default {
    name: 'PharmacistWorkingSchedule',    
    components : {   
        PharmacistMenu
    }
}
</script>


<style scoped>
.welcoming {
    font-weight: bolder;
    font-size: 25px;
    height: 816px;
}

.panelDiv {
    float: bottom;
}
</style>