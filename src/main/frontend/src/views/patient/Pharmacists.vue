<template>
    <v-container style="padding: 0px" fluid fill-height dark >
        <v-layout>
            <div style="width:25%;">
                <PatientMenu/>
            </div>
            <div class="panelDiv" style="width:75%;">
                <div style="margin: 50px"><h2 class="display-3">Search Pharmacists</h2></div>
                <div style="background: none; border: none;">
                    <item-list-pharmacists v-bind:items="pharmacists" v-bind:renderingItems="pharmacists" v-bind:searchedItems="pharmacists"></item-list-pharmacists>
                </div>
            </div>
        </v-layout>
    </v-container>
</template>

<script>
import PatientMenu from '@/components/PatientMenu.vue'
import axios from 'axios'
import ItemListPharmacists from '../../components/itemList/ItemListPharmacists.vue'
export default {
    name : 'Pharmacists',
    components : {
        PatientMenu,
        ItemListPharmacists,
    },
    data() {
        return {
            pharmacists: ''
        }
    },
    created(){
    axios.get('http://localhost:8081/pharmacists/all')
        .then(res => {
            this.pharmacists = res.data;
            console.log(res.data);
        })
        .catch(res => {
            console.log(res);
        })
    }
}
</script>

<style scoped>

.panelDiv {
    width: 100%;
    margin: 0auto;
    background: none;
    border: none;

}
</style>