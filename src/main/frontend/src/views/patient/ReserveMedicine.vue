<template>
    <v-container style="padding: 0px" fluid fill-height dark class="grey lighten-1">
        <v-layout>
            <div style="width:25%;">
                <PatientMenu/>
            </div>
            <div class="panelDiv" style="width:75%;" >
                <div style="margin: 50px"><h2 class="display-3">Medicine Reservation</h2></div>
                <div style="background: none; border: none;">
                    <v-card style=" padding: 10px;background: linear-gradient(to right, #5442ed, #cdc8fa, #13077d);"><h2 class="display-1">Choose Medicine</h2></v-card>
                    <item-list-medicine @sendMedicine="receiveMedicine" v-bind:items="medicine" v-bind:renderingItems="medicine" v-bind:searchedItems="medicine"></item-list-medicine>
                </div>
                <div>
                    <v-card style="padding: 10px; background: linear-gradient(to right, #5442ed, #cdc8fa, #13077d);"><h2 class="display-1">Choose Pharmacy</h2></v-card>
                    <item-list-pharmacies @sendPharmacy="receivePharmacy" v-bind:items="pharmacies" v-bind:renderingItems="pharmacies" v-bind:searchedItems="pharmacies" ></item-list-pharmacies>
                </div>
                <v-container>
                    <v-layout row>
                        <v-card width="50%" height="200px">
                            <div style="background: linear-gradient(to right, #5442ed, #cdc8fa, #13077d);">
                                <h2>Choose Quantity</h2>
                            </div>
                            <v-divider></v-divider>
                            <div style="margin: 20px;">
                                <label>Quantity: </label>
                                <input style="background:pink; border" type="number" min="0" max="10" placeholder="0" v-model="quantity"/>
                            </div>
                        </v-card>
                        <v-card width="25%">
                            <div style="background: linear-gradient(to right, #5442ed, #cdc8fa, #13077d);">
                                <h2>Choose Date</h2>
                            </div>
                            <v-divider></v-divider>
                            <div>
                                <date-picker-text @Hello="receiveDatePicker"></date-picker-text>
                            </div>
                        </v-card>
                        <v-card width="25%" style="background: linear-gradient(to right, pink, #cdc8fa, pink);">
                            <div style="margin-top: 25%">
                                <v-btn v-on:click="reserve" rounded color="#3949AB" dark>
                                    Reserve
                                </v-btn>
                            </div>
                        </v-card>
                    </v-layout>
                </v-container>
            </div>
        </v-layout>
    </v-container>
</template>

<script>
import PatientMenu from '@/components/PatientMenu.vue'
import ItemListMedicine from '../../components/itemList/ItemListMedicine.vue'
import ItemListPharmacies from '../../components/itemList/ItemListPharmacies.vue'
import DatePickerText from '../../components/DatePickerText.vue'
import axios from 'axios'
export default {
    name : 'ReserveMedicine',
    components : {
        PatientMenu,
        ItemListMedicine,
        ItemListPharmacies,
        DatePickerText
    },
    data() {
        return {
            quantity: '',
            pharmacyDTO: '',
            medicineDTO: '',
            date: '',
            pharmacies: '',
            medicine: ''
        }
    },
    computed:{
        request(){
            return {
                'quantity': this.quantity,
                'pharmacyID': this.pharmacyDTO.id,
                'medicineID': this.medicineDTO.id,
                'pickUpDate': this.date
            }
        }
    },
    created(){
        axios.get('http://localhost:8081/pharmacies/all')
            .then(res => {
                this.pharmacies = res.data;
            })
            .catch(err => console.log(err));
        axios.get('http://localhost:8081/medicine')
            .then(res => {
                this.medicine = res.data;
            })
            .catch(err => console.log(err));
    },
    methods:{
        reserve: function(){

            const config = {
                headers: { Authorization: `Bearer ${localStorage.getItem("token")}` }
            };

            console.log("Heeej", this.request );
            if(this.quantity == '' || this.pharmacyDTO == '' || this.medicineDTO == '' || this.date == '' ||
            this.quantity == 'undefined' || this.pharmacyDTO == 'undefined' || this.medicineDTO == 'undefined' || this.date == 'undefined')
            {
                alert("Please enter all data needed for search :)");
                return;
            }
            
            axios.post('http://localhost:8081/medicineReservation/create', this.request, config)
                .then(res => {
                    console.log(res);
                    alert("Successfuly created reservation");
                    location.reload();
                })
                .catch(res => {
                    console.log(res);
                    alert(res.response.data);
                })
        },
        receiveDatePicker: function(value){
            this.date = value;
            console.log(value);
        },
        receiveMedicine: function(value){
            this.medicineDTO = value;
            console.log(value);
        },
        receivePharmacy: function(value){
            this.pharmacyDTO = value;
            console.log(value);
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