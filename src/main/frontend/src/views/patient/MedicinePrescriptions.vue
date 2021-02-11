<template>
    <v-container style="padding: 0px" fluid fill-height dark class="grey lighten-1">
        <v-layout>
            <div style="width:25%;">
                <PatientMenu/>
            </div>
            <div class="panelDiv">
                <div style="margin: 50px"><h2 class="display-3">Medicine Prescriptions</h2></div>
                <div style="background: none; border: none;">
                    <item-list-medicine-prescriptions v-bind:items="prescriptions" v-bind:renderingItems="prescriptions" v-bind:searchedItems="prescriptions"></item-list-medicine-prescriptions>
                </div>
            </div>
        </v-layout>
    </v-container>
</template>

<script>
import PatientMenu from '@/components/PatientMenu.vue'
import axios from 'axios'
import ItemListMedicinePrescriptions from '../../components/itemList/ItemListMedicinePrescriptions.vue'
export default {
    name : 'MedicinePrescriptions',
    components : {
        PatientMenu,
        ItemListMedicinePrescriptions
    },
    data() {
        return {
            prescriptions: ''
        }
    },
    created(){
        const config = {
            headers: { Authorization: `Bearer ${localStorage.getItem("token")}` }
        };
        axios.get('http://localhost:8081/prescriptions/patient', config)
            .then(res => {
                this.prescriptions = res.data;
                console.log(res.data);
            })
            .catch(res => {
                console.log(res);
            })
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