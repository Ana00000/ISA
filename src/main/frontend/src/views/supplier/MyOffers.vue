<template>
    <div>
        <div class="float-child">
        <SupplierMenu/>
        <br/>
        <v-card style="margin-top: 50px" width="100%">
            <div>
            <h2>Filter</h2>
            </div>
            <v-divider></v-divider>
            <div style="margin: 0 auto; width: 100px">
                <h3 style="margin-top: 20px;">Status</h3>
                <v-radio-group v-model="filterCriteria" column>
                <v-radio value="ALL" label="ALL"></v-radio>
                <v-radio value="ACCEPTED" label="ACCEPTED"></v-radio>
                <v-radio value="DECLINED" label="DECLINED"></v-radio>
                <v-radio value="WAITING" label="WAITING"></v-radio>
                </v-radio-group>
            </div>
            <v-btn v-on:click="filter" style="margin:10px">Filter</v-btn>
        </v-card>
        </div>
        <div class="float-child2">
            <v-card width="1000" class="mx-auto mt-5" color="white">
                <Offer v-for="offer in offersRendering" :key="offer.id" v-bind:offer="offer"/>
            </v-card>
        </div>
    </div>
</template>

<script>
import Offer from '../../components/supplier/Offer.vue';
import SupplierMenu from '../../components/supplier/SupplierMenu.vue';
export default {
  components: { Offer, SupplierMenu },
    name:'MyOffers',
    data(){
        return{
           offersRendering:[],
           offersInMem:[],
           filterCriteria:"ALL"
        }
    },
    mounted(){
        var tokenString = '';
        tokenString = localStorage.getItem("token");
        const config = {
                headers: {Authorization: `Bearer ${tokenString}`}
        };
        this.$http.get('http://localhost:8081/medicineOffers/getAllMyOffers',config)
        .then(resp => {
            this.offersRendering = [...resp.data];
            this.offersInMem = [...resp.data];
            console.log("offers:",resp.data);
        })
        .catch(er => {
            console.log('Error while loading adding offer !');
            console.log(er.response.data);
        });
    },
    methods:{
        filter(){
            var i;
            var newArray = [];
            for(i = 0; i < this.offersInMem.length; i++){
                if( this.filterCriteria == 'ALL' || this.offersInMem[i].status == this.filterCriteria ){
                    newArray.push(this.offersInMem[i]);
                }
            }
            console.log("criterijum je:", this.filterCriteria)
            console.log("lista je:", newArray)
            this.offersRendering = newArray;
        }
    },
}
</script>

<style>
.float-child {
    width: 15%;
    float: left;
    padding: 20px;
}  
.float-child2 {
    width: 85%;
    float: left;
    padding: 20px;
}  
</style>