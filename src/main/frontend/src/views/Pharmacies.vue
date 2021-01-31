<template>
    <v-container style="padding: 0px" fluid fill-height dark class="grey lighten-1">
        <v-layout>
            <div style="width:25%;">
                <PatientMenu/>
            </div>
            <div class="panelDiv">
                <div style="background: none; border: none;">
                    <item-list title="Pharmacies"></item-list>
                </div>
            </div>
        </v-layout>
    </v-container>
</template>

<script>
import PatientMenu from '../components/PatientMenu.vue'
import ItemList from '../components/ItemList.vue'
//import SearchBar from '../components/SearchBar.vue'
export default {
    name : 'Pharmacies',
    components : {
        PatientMenu,
        ItemList,
  //      SearchBar
    },
    data() {
        return{
            pharmacies: [
                {
                    id: 1,
                    name: 'Pharmacy1'
                },
                {
                    id: 2,
                    name: 'Pharmacy2'
                },
                {
                    id: 3,
                    name: 'Pharmacy3'
                }
            ]
        }
    }
}
</script>

<style scoped>

.panelDiv {
    /* justify-content: center;
    display: flex; */
    width: 100%;
    margin: 0auto;
    background: none;
    border: none;

}
</style>