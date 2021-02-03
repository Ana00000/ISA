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
            <item-list-clients v-bind:items="clients"/>
        </div>
        <div class="panelDiv">
                <DermatologistMenu/>
        </div>
    </div>  
</template>

<script>
import axios from 'axios';
import DermatologistMenu from '../../components/dermatologist/DermatologistMenu.vue'
import ItemListClients from '../../components/itemList/ItemListClients.vue'
export default {
    name: 'DermatologistClients',    
    components : {   
        DermatologistMenu,
        ItemListClients
    },
    data() {
        return{
            clients: []
        }
    },
    created() {
        axios.get('http://localhost:8081/patients/all')
            .then(res => this.clients = res.data)
            .catch(err => console.log(err));
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