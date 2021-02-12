<template>
    <v-container style="padding: 0px" fluid fill-height dark class="grey lighten-1">
        <v-layout>
            <div style="width:25%;">
                <PatientMenu/>
            </div>
            <div class="panelDiv" style="width:75%;">
                <div style="margin: 50px"><h2 class="display-3">Schedule Examination with dermatologist</h2></div>
                <div style="background: none; border: none;">
                    <item-list-appointments @sendAppointment="receiveAppointment" v-bind:items="appointments" v-bind:renderingItems="appointments" v-bind:searchedItems="appointments"></item-list-appointments>
                </div>
                <div style="margin-top: 30px;">
                    <v-btn large @click="schedule">Schedule</v-btn>
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
    name : 'ScheduleExamination',
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
        axios.get('http://localhost:8081/appointments/allExaminations/null')
            .then(res => {
                this.appointments = res.data;
                console.log(res.data);
            })
            .catch(res => {
                console.log(res);
            })
    },
    methods:{
        schedule: function(){
            if(this.chosenApp == '' || this.chosenApp == "undefined"){
                alert("Please, choose appointment");
                return;
            }
            const config = {
                headers: { Authorization: `Bearer ${localStorage.getItem("token")}` }
            };
            axios.post('http://localhost:8081/appointments/scheduleExaminationPatient', this.chosenApp, config)
            .then(res => {
                location.reload();
                console.log(res);
                alert("Succesfully scheduled examination");
            })
            .catch(res => {
                console.log(res);
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