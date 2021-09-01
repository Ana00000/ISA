<template>
    <v-container style="padding: 0px" fluid fill-height dark >
        <v-layout>
            <div style="width:25%;">
                <PatientMenu/>
            </div>
            <div class="panelDiv" style="width:75%;">
                <div style="margin: 50px"><h2 class="display-3">Scheduled Appointments</h2></div>
                <div style="background: none; border: none;">
                    <item-list-appointments @sendAppointment="receiveAppointment" v-bind:items="appointments" v-bind:renderingItems="appointments" v-bind:searchedItems="appointments"></item-list-appointments>
                </div>
                <div style="margin-top: 30px">
                    <v-btn class="pink lighten-3" large @click="cancelAppointment"><h2 display-1>Cancel Appointment</h2></v-btn>
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
            appointments: '',
            chosenApp: ''
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
    },
    methods:{
        cancelAppointment: function(){
            if(this.chosenApp == '' || this.chosenApp == "undefined"){
                alert("choose appointment");
                return;
            }
            const config = {
                headers: { Authorization: `Bearer ${localStorage.getItem("token")}` }
            };
            axios.post('http://localhost:8081/appointments/cancel', this.chosenApp, config)
                .then(res => {
                    console.log(res);
                    location.reload();
                })
                .catch(res => {
                    alert(res.response.data);
                    console.log(res.response.data);
                })
        },
        receiveAppointment: function(value){
            this.chosenApp = value;
            console.log(value);
        },
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