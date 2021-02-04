<template>
    <v-container style="padding: 0px" fluid fill-height dark class="grey lighten-1">
        <v-layout>
            <div style="width:25%;">
                <PatientMenu/>
            </div>
            <div class="panelDiv">
                <div style="margin: 50px"><h2 class="display-3">Search Pharmacies</h2></div>
                <div style="background: none; border: none;">
                    <item-list-pharmacies></item-list-pharmacies>
                </div>
            </div>
        </v-layout>
    </v-container>
</template>

<script>
import PatientMenu from '@/components/PatientMenu.vue'
import ItemListPharmacies from '@/components/itemList/ItemListPharmacies.vue'
export default {
    name : 'Pharmacies',
    components : {
        PatientMenu,
        ItemListPharmacies,
    },
    data() {
        return {
        }
    },
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