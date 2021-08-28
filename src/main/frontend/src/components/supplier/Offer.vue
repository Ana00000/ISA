<template>
    <div class="textStyle">
        <h1>OFFER</h1>
        <v-date-picker v-model="datePickerTime"/>
        <v-text-field
            style="margin-left:150px; margin-right:150px; margin-top:20px;"
            label="Price"
            outlined
            v-model="offer.cost"
            type="number"/>
        <Order v-bind:orderId="this.offer.medicineOrder.id" canBeSelected="adsad"/>
        <p> STATUS: {{offer.status}}</p>
        <v-btn
            depressed
            color="primary"
            style="margin:6px"
            v-on:click="edit"
            >
            Edit
        </v-btn>
        <v-btn
            depressed
            color="primary"
            style="margin:6px;"
            v-on:click="deleteOffer"
            >
            Delete offer
        </v-btn>
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
    }, 
    methods:{
        edit(){
            var tokenString = '';
            tokenString = localStorage.getItem("token");
            const config = {
                    headers: {Authorization: `Bearer ${tokenString}`}
            };
            this.$http.post('http://localhost:8081/medicineOffers/editOffer',this.offerToEdit,config)
            .then(resp => {
                alert(resp.data);
                window.location.href = 'http://localhost:8080/supplierHomePage/MyOffers';
            })
            .catch(er => {
                alert("Error !");
                console.log('Error while loading adding offer !');
                console.log(er.response.data);
            });
        },
        deleteOffer(){
            var tokenString = '';
            tokenString = localStorage.getItem("token");
            const config = {
                    headers: {Authorization: `Bearer ${tokenString}`}
            };
            this.$http.delete('http://localhost:8081/medicineOffers/deteteById/'+this.offer.id,config,null)
            .then(() => {
                window.location.href = 'http://localhost:8080/supplierHomePage/MyOffers';
                alert("Deleted offer !");
            })
            .catch(er => {
                alert("Error !");
                console.log('Error while loading adding offer !');
                console.log(er.response.data);
            });
        }
    },
    computed: {
        offerToEdit() {
            return {'id':this.offer.id,'time':this.datePickerTime, 'medicineOrderId':this.offer.medicineOrder.id,'cost': this.offer.cost}
        }
    }
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