<template>
    <v-container style="padding: 0px" fluid fill-height dark class="grey lighten-1">
        <v-layout>
            <div style="width:25%;">
                <PatientMenu/>
            </div>
            <div class="panelDiv">
                <div style="margin: 50px"><h2 class="display-3">Search Pharmacies</h2></div>
                <div style="background: none; border: none;">
                    <item-list-pharmacies v-bind:items="pharmacies" v-bind:renderingItems="pharmacies" v-bind:searchedItems="pharmacies"></item-list-pharmacies>
                </div>
            </div>
        </v-layout>
    </v-container>
</template>

<script>
import PatientMenu from '@/components/PatientMenu.vue'
import ItemListPharmacies from '@/components/itemList/ItemListPharmacies.vue'
import axios from 'axios'
export default {
    name : 'Pharmacies',
    components : {
        PatientMenu,
        ItemListPharmacies,
    },
    data() {
        return {
            pharmacies: ''
        }
    },
    created(){
    const config = {
        headers: { Authorization: `Bearer ${localStorage.getItem("token")}` }
    };
    axios.get('http://localhost:8081/pharmacies/all', config)
        .then(res => {
            this.pharmacies = res.data;
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