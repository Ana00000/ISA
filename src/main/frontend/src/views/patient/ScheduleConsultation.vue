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
                                    :allowed-minutes="allowedStep"
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
                                    :allowed-minutes="allowedStep"
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
                <div style="background: none; border: none; margin-top: 50px;">
                    <item-list-pharmacies v-bind:items="availablePharmacies"></item-list-pharmacies>
                </div>
                <div style="margin-top: 50px;">
                    <v-btn large style="background: linear-gradient(to right, pink, #cdc8fa, pink);"><h2>Choose Pharmacy</h2></v-btn>
                </div>
                <div style="background: none; border: none; margin-top: 50px;">
                    <item-list-pharmacists></item-list-pharmacists>
                </div>
                <div style="margin-top: 50px; margin-bottom: 200px;">
                    <v-btn large style="background: linear-gradient(to right, pink, #cdc8fa, pink);"><h2>Choose Pharmacist and schedule consultation</h2></v-btn>
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
export default {
    name : 'ScheduleConsultation',
    components : {
        PatientMenu,
        ItemListPharmacies,
        ItemListPharmacists
    },
    data() {
        return {
            timeStart: '',
            timeEnd: '',
            availablePharmacies: ''
        }
    },
    computed:{
        pharmaciesRequest(){
            return {
                "start" : this.timeStart,
                "end" : this.timeEnd
            }
        },

    },
    methods: {
        getAvailablePharmacies: function(){
            console.log(this.timeStart + " " + this.timeEnd);
            axios.get('http://localhost:8081/scheduleConsultation/pharmacies', this.request)
                .then(res => {
                    this.availablePharmacies = res;
                    console.log(res);
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