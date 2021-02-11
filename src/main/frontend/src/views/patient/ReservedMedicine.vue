<template>
    <v-container style="padding: 0px" fluid fill-height dark class="grey lighten-1">
        <v-layout>
            <div style="width:25%;">
                <PatientMenu/>
            </div>
            <div class="panelDiv">
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
            axios.post('http://localhost:8081/medicineReservation/cancel', this.reservedMedicine)
                .then(res => {
                    console.log(res);
                    location.reload();
                })
                .catch(res => {
                    alert("You didn't cancel reservation at the time, enjoy your penalty! ;)");
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