<template>
    <v-container style="padding: 0px" fluid fill-height dark class="grey lighten-1">
        <v-layout>
            <div style="width:25%;">
                <PatientMenu/>
            </div>
            <div class = "panelDiv" style="width:75%;">
            <div style="margin: 50px;"><h2 class="display-3">Complaint page</h2></div>
            <div style="margin: 0 auto; width: 100px">
                <h3 style="margin-top: 20px;">Type</h3>
                <v-radio-group v-model="itemList" row>
                    <v-radio value="dermatologist" label="Dermatologist"></v-radio>
                    <v-radio value="pharmacy" label="Pharmacy"></v-radio>
                </v-radio-group>
            </div>
            <div style="background: none; border: none;" v-if="itemList=='dermatologist'">
                <item-list-pharmacists v-bind:items="doctors" v-bind:renderingItems="doctors" v-bind:searchedItems="doctors"></item-list-pharmacists>
            </div>
            <div style="background: none; border: none;" v-else>
                <item-list-pharmacies v-bind:items="pharmacies" v-bind:renderingItems="pharmacies" v-bind:searchedItems="pharmacies"></item-list-pharmacies>
            </div>
            <div>
                <v-textarea style="border: solid black 2px; background: white; margin-top: 50px;" v-bind="complaintText">
                </v-textarea>
            </div>
            <div>
                <v-btn large>Submit</v-btn>
            </div>
        </div>
        </v-layout>
    </v-container>
</template>

<script>
import PatientMenu from '@/components/PatientMenu.vue'
import ItemListPharmacists from '../../components/itemList/ItemListPharmacists.vue';
import ItemListPharmacies from '../../components/itemList/ItemListPharmacies.vue';
export default {
    name : 'WriteComplaint',
    components : {
        PatientMenu,
        ItemListPharmacists,
        ItemListPharmacies
    },
    data() {
        return {
            patientInfo: '',
            itemList: '',
            doctors: '',
            pharmacies: '',
            complaintText: ''
        }
    },
    created(){
        const config = {
                headers: { Authorization: `Bearer ${localStorage.getItem("token")}` }
            };
        this.id = this.$route.params.id;
        this.$http.get('http://localhost:8081/appointments/doctors', config).then(resp => {
            console.log(resp.data);
            this.doctors = resp.data;
        }).catch(err => console.log(err));

        this.$http.get('http://localhost:8081/pharmacies/patient', config).then(resp => {
            console.log(resp.data);
            this.pharmacies = resp.data;
        }).catch(err => console.log(err));
    }
}
</script>

<style scoped>
.panelDiv {
    float: left;
}

.backgroundDiv {
  background: rgb(199, 191, 191);
  background-size: cover;
  width: 100%;
  height: 100%;
}
</style>