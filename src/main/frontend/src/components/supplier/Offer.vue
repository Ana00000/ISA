<template>
    <div class="textStyle" v-on:click="select()">
        <h1>OFFER</h1>
        <v-date-picker v-model="datePickerTime"/>
        <v-text-field
            style="margin-left:150px; margin-right:150px; margin-top:20px;"
            label="Price"
            outlined
            v-model="offer.cost"
            type="number"/>
        <Order v-bind:orderId="this.offer.medicineOrder.id" />
  </div>
</template>

<script>
import Order from './Order.vue';
export default {
  components: { Order },
    name:'Offer',
    props:['offer'],
    data(){
        return{
            proba:null,
            datePickerTime:null,
            order:null,
        }
    },
    mounted(){
        console.log("offer:",this.offer);
        this.datePickerTime = (new Date(this.offer.time).toISOString().substr(0, 10));

        // var tokenString = '';
        // tokenString = localStorage.getItem("token");
        // const config = {
        //         headers: {Authorization: `Bearer ${tokenString}`}
        // // };
        // // this.$http.get('http://localhost:8081/medicineOrder/my/'+this.password, config)
        // // .then(resp => {
        // //     console.log(resp.data);
        // // })
        // // .catch(er => {
        // //     console.log('Error while editing system admin');
        // //     console.log(er.response.data);
        // // })
    },
}
</script>

<style>
.textStyle{
    border-top: 20px;
    border: 2px;
    border-color: blue;
    border-style: groove;
    margin: 0 auto;
    margin-bottom: 10px;
    width: 50%;
    background: white;
    font-style: italic;
    color: blue;
}
</style>