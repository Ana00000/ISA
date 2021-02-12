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
                    <v-radio value="doctor" label="Doctor"></v-radio>
                    <v-radio value="pharmacy" label="Pharmacy"></v-radio>
                </v-radio-group>
            </div>
            <div style="background: none; border: none;" v-if="itemList=='doctor'">
                <item-list-pharmacists @sendPharmacist="receivePharmacist" v-bind:items="doctors" v-bind:renderingItems="doctors" v-bind:searchedItems="doctors"></item-list-pharmacists>
            </div>
            <div style="background: none; border: none;" v-else>
                <item-list-pharmacies @sendPharmacy="receivePharmacy" v-bind:items="pharmacies" v-bind:renderingItems="pharmacies" v-bind:searchedItems="pharmacies"></item-list-pharmacies>
            </div>
            <div>
                <v-textarea style="border: solid black 2px; background: white; margin-top: 50px;" v-model="complaintText">
                </v-textarea>
            </div>
            <div>
                <v-btn large @click="createComplaint">Submit</v-btn>
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
            complaintText: '',
            pharmacistDTO: '',
            pharmacyDTO: ''
        }
    },
    computed:{
        request(){
            return {
                'text': this.complaintText,
                'pharmacyID': this.pharmacyDTO.id,
                'type': this.itemList
            }
        },
        request2(){
            return {
                'text': this.complaintText,
                'doctorID': this.pharmacistDTO.id,
                'type': this.itemList
            }
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
    },
    methods:{
        createComplaint: function(){
            const config = {
                headers: { Authorization: `Bearer ${localStorage.getItem("token")}` }
            };
            var reqq = '';
            if(this.itemList == "doctor"){
                if(this.pharmacistDTO == '' || this.pharmacistDTO == "undefined"){
                    alert("Please choose the doctor");
                    return;
                }
                reqq = this.request2;
            }else{
                if(this.pharmacyDTO == '' || this.pharmacyDTO == "undefined"){
                    alert("Please choose the pharmacy");
                    return;
                }
                reqq = this.request;
            }
            this.$http.post('http://localhost:8081/complaint/new', reqq, config).then(resp => {
            console.log(resp.data);
            this.pharmacies = resp.data;
        }).catch(err => console.log(err));
        },
        receivePharmacist: function(value){
            this.pharmacistDTO = value;
            console.log(value);
        },
        receivePharmacy: function(value){
            this.pharmacyDTO = value;
            console.log(value);
        },
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