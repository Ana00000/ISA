<template>
    <v-container style="padding: 0px" fluid fill-height dark class="grey lighten-1">
        <v-layout>
            <div style="width:25%;">
                <PatientMenu/>
            </div>
            <div class="panelDiv">
                <div style="margin: 50px"><h2 class="display-3">Appointment History</h2></div>
                <div style="background: none; border: none;">
                    <item-list-appointments></item-list-appointments>
                </div>
            </div>
        </v-layout>
    </v-container>
</template>

<script>
import PatientMenu from '@/components/PatientMenu.vue'
import ItemListAppointments from '@/components/itemList/ItemListAppointments.vue'
export default {
    name : 'AppointmentHistory',
    components : {
        PatientMenu,
        ItemListAppointments
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
    margin: 0auto;
    background: none;
    border: none;
}
</style>