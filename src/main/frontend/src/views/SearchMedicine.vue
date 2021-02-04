<template>
    <v-container>
        <div style="margin: 50px"><h2 class="display-3">Search Medicine</h2></div>
        <item-list-medicine></item-list-medicine>
    </v-container>
</template>

<script>
import ItemListMedicine from '../components/itemList/ItemListMedicine.vue';
export default {
    name: 'SearchMedicine',
    components:{
        ItemListMedicine
    },
    data() {
        return{
        }
    }
}
</script>ItemList