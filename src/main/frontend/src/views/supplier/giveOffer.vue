<template>
    <div>
        <SupplierMenu/>
        <v-card width="800" class="mx-auto mt-5" color="white"> 
            <h1>Give offer for order:</h1>
            <Order v-if="this.orderId" v-bind:orderId="this.orderId"/>
            <v-text-field
            style="margin-left:210px; margin-right:210px;"
            label="Price"
            v-model="price"
            type="number"/>
            <v-date-picker v-model="datePicker"/>
            
             <v-card-actions class="justify-center mb-5">
                <v-btn color="info mb-5" v-on:click="makeOffer">
                    Add offer  
                </v-btn>
            </v-card-actions>
        </v-card>
    </div>
</template>

<script>
import Order from '../../components/supplier/Order.vue'
import SupplierMenu from '../../components/supplier/SupplierMenu.vue';
export default {
    components: { Order, SupplierMenu },
    name:'giveOffer',
    data(){
        return{
            orderId:null,
            order:null,
            datePicker:null,
            price:0,
        }
    },
    computed: {
    offer() {
        return {'time':this.datePicker, 'medicineOrderId':this.order.id,'cost': this.price}
    }
  },
    methods:{
        makeOffer(){
            if(this.datePicker== null){
                alert("Enter date!");
                return;
            }
            if(this.price<0){
                this.price=0;
                alert("price cant be negative");
                return;
            }
            var tokenString = '';
            tokenString = localStorage.getItem("token");
            const config = {
                    headers: {Authorization: `Bearer ${tokenString}`}
            };
            this.$http.post('http://localhost:8081/medicineOffers/addOffer',this.offer,config)
            .then(resp => {
                alert(resp.data);
                window.location.href = 'http://localhost:8080/supplierHomePage';
            })
            .catch(er => {
                alert("Error !");
                console.log('Error while loading adding offer !');
                console.log(er.response.data);
            });
        },
    },
    mounted(){
        this.orderId =  this.$route.params.orderId;
        console.log("order id:",this.orderId);

        var tokenString = '';
        tokenString = localStorage.getItem("token");
        const config = {
                headers: {Authorization: `Bearer ${tokenString}`}
        };
        this.$http.get('http://localhost:8081/medicineOrder/my/'+this.$route.params.orderId,config)
        .then(resp => {
            this.order = resp.data;
            console.log(resp.data);
        })
        .catch(er => {
            console.log('Error while loading medicine orders !');
            console.log(er.response.data);
        });
    }
}
</script>

<style>

</style>