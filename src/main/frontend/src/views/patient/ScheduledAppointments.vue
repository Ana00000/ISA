<template>
    <v-container style="padding: 0px" fluid fill-height dark class="grey lighten-1">
        <v-layout>
            <div style="width:25%;">
                <PatientMenu/>
            </div>
            <div class="panelDiv">
                <div style="margin: 50px"><h2 class="display-3">Scheduled Appointments</h2></div>
                <div style="background: none; border: none;">
                    <item-list-appointments v-bind:items="appointments" v-bind:renderingItems="appointments" v-bind:searchedItems="appointments"></item-list-appointments>
                </div>
            </div>
        </v-layout>
    </v-container>
</template>

<script>
import PatientMenu from '@/components/PatientMenu.vue'
import ItemListAppointments from '@/components/itemList/ItemListAppointments.vue'
import axios from 'axios'
export default {
    name : 'ScheduledAppointments',
    components : {
        PatientMenu,
        ItemListAppointments
    },
    data() {
        return {
            appointments: ''
        }
    },
    created(){
        console.log("In created");
        const config = {
            headers: { Authorization: `Bearer ${localStorage.getItem("token")}` }
        };
        axios.get('http://localhost:8081/appointments/patient/active', config)
            .then(res => {
                this.appointments = res.data;
                console.log("After get");
            })
            .catch(err => console.log(err));
    }
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