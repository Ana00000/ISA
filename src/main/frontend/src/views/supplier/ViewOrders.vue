<template>
  <div>
      <SupplierMenu/>
      <v-card width="800" class="mx-auto mt-5" color="white"> 
        <Order v-for="order in orders" :key="order.id" v-bind:orderId="order.id"/>
      </v-card>
  </div>
</template>

<script>
import Order from '../../components/supplier/Order.vue'
import SupplierMenu from '../../components/supplier/SupplierMenu.vue';
export default {
    components: { Order, SupplierMenu },
    name:"ViewOrders",
    data: ()=>({
        orders:[],
    }),
    beforeMount(){
        var tokenString = '';
        tokenString = localStorage.getItem("token");
        const config = {
                headers: {Authorization: `Bearer ${tokenString}`}
        };
        this.$http.get('http://localhost:8081/medicineOrder/getAllActive',config)
        .then(resp => {
            this.orders = resp.data;
            console.log("all active",resp.data);
        })
        .catch(er => {
            console.log('Error while loading active medicine orders !');
            console.log(er.response.data);
        });
    },
}
</script>

<style>

</style>