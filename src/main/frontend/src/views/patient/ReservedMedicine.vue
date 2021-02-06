<template>
    <v-container style="padding: 0px" fluid fill-height dark class="grey lighten-1">
        <v-layout>
            <div style="width:25%;">
                <PatientMenu/>
            </div>
            <div class="panelDiv">
                <div style="margin: 50px"><h2 class="display-3">Reserved Medicine</h2></div>
                <div style="background: none; border: none;">
                    <item-list-reserved-medicine></item-list-reserved-medicine>
                </div>
            </div>
        </v-layout>
    </v-container>
</template>

<script>
import PatientMenu from '@/components/PatientMenu.vue'
import ItemListReservedMedicine from '../../components/itemList/ItemListReservedMedicine.vue'
export default {
    name : 'AppointmentHistory',
    components : {
        PatientMenu,
        ItemListReservedMedicine
    },
    data() {
        return {
        }
    },
}
</script>

<style scoped>

.panelDiv {
    width: 100%;
    margin: 0 auto;
    background: none;
    border: none;
}
</style>