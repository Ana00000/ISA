<template>
  <v-app style="
    background: #13077d;
    background: -webkit-linear-gradient(to right, #5442ed, #cdc8fa, #13077d);
    background: linear-gradient(to right, #5442ed, #cdc8fa, #13077d);">
    <v-container>
        <div class="searchDiv">
            <div style="margin: 35px">
                <h1 class="display-2">Search clients</h1>
            </div>
            <item-list-clients v-bind:items="clients"/>
        </div>
    </v-container>
  </v-app>
</template>

<script>
import axios from 'axios';
import ItemListClients from '../components/itemList/ItemListClients.vue';
export default {
    name: 'SearchClients',
    components:{
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
.searchDiv {
    height: 840px;
}

.panelDiv {
    float: bottom;
}
</style>