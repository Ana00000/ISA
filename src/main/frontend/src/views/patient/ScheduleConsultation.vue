<template>
    <v-container style="padding: 0px" fluid fill-height dark class="grey lighten-1">
        <v-layout>
            <div style="width:25%;">
                <PatientMenu/>
            </div>
            <div class="panelDiv" style="width:75%;">
                <div style="margin: 50px"><h2 class="display-3">Schedule Consultation</h2></div>
                <div>
                    <v-container>
                        <v-layout row wrap>
                            <div style="margin-left: 35%; margin-right: 50px;">
                                <h2 class="display-1">Start Time</h2>
                                <v-row justify="space-around">
                                    <v-datetime-picker
                                    v-model="timeStart"
                                    class="mt-4"
                                    format="24hr"
                                    ></v-datetime-picker>
                                </v-row>
                            </div>
                            <div>
                                <h2 class="display-1">End Time</h2>
                                <v-row justify="space-around">
                                    <v-datetime-picker
                                    v-model="timeEnd"
                                    class="mt-4"
                                    format="24hr"
                                    ></v-datetime-picker>
                                </v-row>
                            </div>
                        </v-layout>
                    </v-container>
                </div>
                <div style="margin-top: 50px;">
                    <v-btn @click="getAvailablePharmacies" large style="background: linear-gradient(to right, pink, #cdc8fa, pink);"><h2>Choose date and time</h2></v-btn>
                </div>
                <div v-if="pharmacyDiv" style="background: none; border: none; margin-top: 50px;">
                    <item-list-pharmacies @sendPharmacy="receivePharmacy" v-bind:items="availablePharmacies" v-bind:renderingItems="availablePharmacies" v-bind:searchedItems="availablePharmacies"></item-list-pharmacies>
                </div>
                <div v-if="pharmacyDiv" style="margin-top: 50px;">
                    <v-btn @click="getAvailablePharmacists" large style="background: linear-gradient(to right, pink, #cdc8fa, pink);"><h2>Choose Pharmacy</h2></v-btn>
                </div>
                <div v-if="pharmacistsDiv" style="background: none; border: none; margin-top: 50px;">
                    <item-list-pharmacists @sendPharmacist="receivePharmacist" v-bind:items="availablePharmacists" v-bind:renderingItems="availablePharmacists" v-bind:searchedItems="availablePharmacists"></item-list-pharmacists>
                </div>
                <div v-if="pharmacistsDiv" style="margin-top: 50px;">
                    <v-btn @click="getAvailableTimeIntervals" large style="background: linear-gradient(to right, pink, #cdc8fa, pink);"><h2>Choose Pharmacist</h2></v-btn>
                </div>
                <div v-if="timeIntervalDiv" style="background: none; border: none; margin-top: 50px;">
                    <item-list-time-intervals @sendTimeInterval="receiveTimeInterval" v-bind:items="availableTimeIntervals" v-bind:renderingItems="availableTimeIntervals" v-bind:searchedItems="availableTimeIntervals"></item-list-time-intervals>
                </div>
                <div v-if="timeIntervalDiv" style="margin-top: 50px; margin-bottom: 200px;">
                    <v-btn @click="createAppointment" large style="background: linear-gradient(to right, pink, #cdc8fa, pink);"><h2>Schedule Consultation</h2></v-btn>
                </div>
            </div>
        </v-layout>
    </v-container>
</template>

<script>
import PatientMenu from '@/components/PatientMenu.vue'
import ItemListPharmacies from '../../components/itemList/ItemListPharmacies.vue'
import ItemListPharmacists from '../../components/itemList/ItemListPharmacists.vue'
import axios from 'axios'
import ItemListTimeIntervals from '../../components/itemList/ItemListTimeIntervals.vue'
export default {
    name : 'ScheduleConsultation',
    components : {
        PatientMenu,
        ItemListPharmacies,
        ItemListPharmacists,
        ItemListTimeIntervals
    },
    data() {
        return {
            timeStart: '',
            timeEnd: '',
            availablePharmacies: '',
            availablePharmacists: '',
            availableTimeIntervals: '',
            pharmacyDTO: '',
            pharmacistDTO: '',
            timeInterval: '',
            pharmacyDiv: false,
            pharmacistsDiv: false,
            timeIntervalDiv: false
        }
    },
    computed:{
        pharmaciesRequest(){
            return {
                "start" : this.timeStart,
                "end" : this.timeEnd
            }
        },
        createRequest(){
            return {
                "pharmacyID": this.pharmacyDTO.id,
                "pharmacistID": this.pharmacistDTO.id,
                "timeInterval": this.timeInterval
            }
        }
    },
    methods: {
        getAvailablePharmacies: function(){
            console.log(this.timeStart + " " + this.timeEnd);
            if(this.timeStart == '' || this.timeStart == "undefined" || this.timeEnd == '' || this.timeEnd == "undefined"){
                alert("Please enter start and end time");
                return;
            }
            
            axios.post('http://localhost:8081/scheduleConsultation/pharmacies', this.pharmaciesRequest)
                .then(res => {
                    this.availablePharmacies = res.data;
                    console.log(res.data);
                })
                .catch(res => {
                    console.log(res);
                })

            this.pharmacyDiv = !this.pharmacyDiv;
        },
        getAvailablePharmacists: function(){
            if(this.pharmacyDTO == '' || this.pharmacyDTO == "undefined"){
                alert("Please choose pharmacy");
                return;
            }

            axios.post('http://localhost:8081/scheduleConsultation/pharmacists', this.pharmacyDTO)
                .then(res => {
                    this.availablePharmacists = res.data;
                    console.log(res.data);
                })
                .catch(res => {
                    console.log(res);
                })

            this.pharmacistsDiv = !this.pharmacistsDiv;
        },
        getAvailableTimeIntervals: function(){
            if(this.pharmacistDTO == '' || this.pharmacistDTO == "undefined"){
                alert("Please choose pharmacist");
                return;
            }
            axios.post('http://localhost:8081/scheduleConsultation/timeIntervals', this.pharmacistDTO)
                .then(res => {
                    this.availableTimeIntervals = res.data;
                    console.log(res.data);
                })
                .catch(res => {
                    console.log(res);
                })

            this.timeIntervalDiv = !this.timeIntervalDiv;
        },
        receivePharmacy: function(value){
            this.pharmacyDTO = value;
            console.log(value);
        },
        receivePharmacist: function(value){
            this.pharmacistDTO = value;
            console.log(value);
        },
        receiveTimeInterval: function(value){
            this.timeInterval = value;
            console.log(value);
        },
        createAppointment: function(){
            if(this.timeInterval == '' || this.timeInterval == "undefined"){
                alert("Please choose timeInterval");
                return;
            }
            const config = {
                headers: { Authorization: `Bearer ${localStorage.getItem("token")}` }
            };
            axios.post('http://localhost:8081/scheduleConsultation/new', this.createRequest, config)
                .then(res => {
                    console.log(res);
                    alert("Successfuly created appointment");
                    location.reload();
                })
                .catch(res => {
                    console.log(res);
                })
        }
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