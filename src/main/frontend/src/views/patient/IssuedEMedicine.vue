<template>
    <v-container style="padding: 0px" fluid fill-height dark class="grey lighten-1">
        <v-layout>
            <div style="width:25%;">
                <PatientMenu/>
            </div>
            <div class="panelDiv" style="width:75%;">
                <div style="margin: 50px"><h2 class="display-3">Issued E-Medicine</h2></div>
                <div style="background: none; border: none;">
                    <item-list-medicine v-bind:items="medicine" v-bind:renderingItems="medicine" v-bind:searchedItems="medicine"></item-list-medicine>
                </div>
            </div>
        </v-layout>
    </v-container>
</template>

<script>
import PatientMenu from '@/components/PatientMenu.vue'
import axios from 'axios';
import ItemListMedicine from '../../components/itemList/ItemListMedicine.vue';
export default {
    name : 'IssuedEMedicine',
    components : {
        PatientMenu,
        ItemListMedicine
    },
    data() {
        return {
            medicine: ''
        }
    },
    created(){
        const config = {
            headers: { Authorization: `Bearer ${localStorage.getItem("token")}` }
        };
        axios.get('http://localhost:8081/prescriptions/medicine', config)
            .then(res => {
                this.medicine = res.data;
                console.log("After get");
            })
            .catch(err => console.log(err));
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