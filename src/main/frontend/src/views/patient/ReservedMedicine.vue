<template>
    <v-container style="padding: 0px" fluid fill-height dark>
        <v-layout>
            <div style="width:25%;">
                <PatientMenu/>
            </div>
            <div class="panelDiv" style="width:75%;">
                <div style="margin: 50px"><h2 class="display-3">Reserved Medicine</h2></div>
                <div style="background: none; border: none;">
                    <item-list-medicine-reservation @sendReservedMedicine="receiveReservedMedicine" v-bind:items="reservations" v-bind:renderingItems="reservations" v-bind:searchedItems="reservations"></item-list-medicine-reservation>
                </div>
                <div style="margin-top: 30px">
                    <v-btn class="pink lighten-3" large @click="cancelReservation"><h2 display-1>Cancel Reservation</h2></v-btn>
                </div>
            </div>
        </v-layout>
    </v-container>
</template>

<script>
import PatientMenu from '@/components/PatientMenu.vue'
import axios from 'axios';
import ItemListMedicineReservation from '../../components/itemList/ItemListMedicineReservation.vue';
export default {
    name : 'AppointmentHistory',
    components : {
        PatientMenu,
        ItemListMedicineReservation
    },
    data() {
        return {
            reservedMedicine: '',
            reservations: ''
        }
    },
    created(){
        console.log("In created");
        const config = {
            headers: { Authorization: `Bearer ${localStorage.getItem("token")}` }
        };
        axios.get('http://localhost:8081/medicineReservation/patient', config)
            .then(res => {
                this.reservations = res.data;
                console.log("After get");
            })
            .catch(err => console.log(err));
    },
    methods:{
        receiveReservedMedicine: function(value){
            this.reservedMedicine = value;
        },
        cancelReservation: function(){
            if(this.reservedMedicine == '' || this.reservedMedicine == "undefined"){
                alert("choose reservation");
                return;
            }
            const config = {
                headers: { Authorization: `Bearer ${localStorage.getItem("token")}` }
            };
            axios.post('http://localhost:8081/medicineReservation/cancel', this.reservedMedicine, config)
                .then(res => {
                    console.log(res);
                    location.reload();
                })
                .catch(res => {
                    alert(res.response.data);
                    console.log(res.response.data);
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