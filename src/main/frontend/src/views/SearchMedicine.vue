<template>
    <v-container>
        <div style="margin: 50px"><h2 class="display-3">Search Medicine</h2></div>
        <item-list-medicine v-bind:items="items" v-if="items"></item-list-medicine>
    </v-container>
</template>

<script>
import axios from 'axios';
import ItemListMedicine from '../components/itemList/ItemListMedicine.vue';
export default {
    name: 'SearchMedicine',
    components:{
        ItemListMedicine
    },
    data() {
        return{
            items: []
        }
    },
    created() {
        axios.get('http://localhost:8081/medicine')
            .then(res => this.items = res.data)
            .catch(err => console.log(err));
    }
}
</script>ItemList