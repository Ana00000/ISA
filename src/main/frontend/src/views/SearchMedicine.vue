<template>
    <v-container>
        <div style="margin: 50px"><h2 class="display-3">Search Medicine</h2></div>
        <item-list-medicine v-bind:items="medicine" v-bind:renderingItems="medicine" v-bind:searchedItems="medicine"></item-list-medicine>
    </v-container>
</template>

<script>
import ItemListMedicine from '../components/itemList/ItemListMedicine.vue';
import axios from 'axios';
export default {
    name: 'SearchMedicine',
    components:{
        ItemListMedicine
    },
    data() {
        return{
            medicine: ''
        }
    },
    created: function(){
        axios.get('http://localhost:8081/medicine')
            .then(res => {
                this.medicine = res.data;
            })
            .catch(err => console.log(err));
    }
}
</script>ItemList