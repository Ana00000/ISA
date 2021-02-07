<template>
    <v-container style="padding: 0px" fluid fill-height dark class="grey lighten-1">
        <v-layout>
            <div style="width:25%;">
                <PatientMenu/>
            </div>
            <div class="panelDiv" style="width:75%;">
                <div style="margin: 50px"><h2 class="display-3">Schedule Consultation</h2></div>
                <div style="margin-left:20%;">
                    <v-container>
                        <v-layout row wrap>
                            <div style="width:20%">
                                <h2 class="display-1">Start Time</h2>
                                <v-row justify="space-around">
                                    <v-time-picker
                                    v-model="timeStep"
                                    :allowed-minutes="allowedStep"
                                    class="mt-4"
                                    format="24hr"
                                    ></v-time-picker>
                                </v-row>
                            </div>
                            <div style="width:20%; margin-right: 10px;">
                                <h2 class="display-1">End Time</h2>
                                <v-row justify="space-around">
                                    <v-time-picker
                                    v-model="timeStep"
                                    :allowed-minutes="allowedStep"
                                    class="mt-4"
                                    format="24hr"
                                    ></v-time-picker>
                                </v-row>
                            </div>
                            <v-card style="width:20%; margin-top:30px; background: linear-gradient(to right, pink, #cdc8fa, pink);">
                                <h2 class="display-1" style="margin-bottom: 30px;">Date</h2>
                                <date-picker-text @Hello="receiveDatePicker"></date-picker-text>
                            </v-card>
                        </v-layout>
                    </v-container>
                </div>
                <div style="margin-top: 50px;">
                    <v-btn large style="background: linear-gradient(to right, pink, #cdc8fa, pink);"><h2>Choose date and time</h2></v-btn>
                </div>
                <div style="background: none; border: none; margin-top: 50px;">
                    <item-list-pharmacies></item-list-pharmacies>
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
import DatePickerText from '../../components/DatePickerText.vue'
import ItemListPharmacies from '../../components/itemList/ItemListPharmacies.vue'
import ItemListPharmacists from '../../components/itemList/ItemListPharmacists.vue'
export default {
    name : 'ScheduleConsultation',
    components : {
        PatientMenu,
        DatePickerText,
        ItemListPharmacies,
        ItemListPharmacists
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