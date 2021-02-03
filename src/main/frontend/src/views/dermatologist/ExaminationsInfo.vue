<template>
    <div style="
        background: #13077d;
        background: -webkit-linear-gradient(to right, #5442ed, #cdc8fa, #13077d);
        background: linear-gradient(to right, #5442ed, #cdc8fa, #13077d);">
        <br/>
        <div class="welcoming">Dermatologist you can find examinations info here!</div>
        <div class="panelDiv">
                <DermatologistMenu/>
        </div> 
    </div>  
</template>

<script>
import DermatologistMenu from '../../components/dermatologist/DermatologistMenu.vue'
export default {
    name: 'ExaminationsInfo',   
    components : {   
        DermatologistMenu
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