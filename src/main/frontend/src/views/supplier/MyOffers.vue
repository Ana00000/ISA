<template>
    <div>
        <SupplierMenu/>
        <v-card width="1200" class="mx-auto mt-5" color="white">
            <Offer v-for="offer in offers" :key="offer.id" v-bind:offer="offer"/>
        </v-card>
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
           offers:[],
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
            this.offers = resp.data;
            console.log("offers:",resp.data);
        })
        .catch(er => {
            console.log('Error while loading adding offer !');
            console.log(er.response.data);
        });
    },
}
</script>

<style>

</style>