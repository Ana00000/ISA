<template>
    <div style="
        background: #13077d;
        background: -webkit-linear-gradient(to right, #5442ed, #cdc8fa, #13077d);
        background: linear-gradient(to right, #5442ed, #cdc8fa, #13077d);"> 
        <div class="searchDiv">
            <br/>
            <div>
                <h1 class="display-2">You can find your clients here!</h1>
            </div>
            <div class="welcoming">For search enter name and/or surname.</div>
            <br/>
            <dermatologist-clients-search-and-sort/>
        </div>
        <div>
            <DermatologistMenu/>
        </div>
    </div>  
</template>

<script>
import DermatologistMenu from '../../components/dermatologist/DermatologistMenu.vue'
import DermatologistClientsSearchAndSort from '../../components/dermatologist/DermatologistClientsSearchAndSort.vue'
export default {
    name: 'DermatologistClients',    
    components : {   
        DermatologistMenu,
        DermatologistClientsSearchAndSort
    }
}
</script>


<style scoped>
.template {
    min-height: 1000px;
}

.welcoming {
    font-weight: bolder;
    font-size: 25px;
}

.searchDiv {
     height: 840px; 
}
</style>