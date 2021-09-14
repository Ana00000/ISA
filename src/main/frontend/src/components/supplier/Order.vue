<template>
  <div class="textStyle" v-on:click="select()" v-if="order && pharmacy && pharmacyAdmin">
      <h1>Order</h1>
      <h3 style="color:green"> Pharmacy: {{this.pharmacy.name}}</h3>
      <p>Deadline:{{this.time}}</p>
      <p>Pharmacy admin: {{this.pharmacyAdmin.name}} {{this.pharmacyAdmin.lastName}}</p>
      
      <h3>Medicines:</h3>
      <p style="color:black" v-for="(list, key) in order.medicineAmount" :index="key" :key="key" >{{key}}:{{list}}</p>
  </div>
</template>

<script>
var moment = require('moment');
export default {
    name:'Order',
    props:['orderId','canBeSelected'],
    data: ()=>({
        pharmacyAdmin:null,
        pharmacy:null,
        order:null,
    }),
    beforeMount(){
        console.log("orderid:" , this.orderId);

        var tokenString = '';
        tokenString = localStorage.getItem("token");
        const config = {
                headers: {Authorization: `Bearer ${tokenString}`}
        };
        this.$http.get('http://localhost:8081/medicineOrder/my/'+this.orderId,config)
        .then(resp => {
            this.order = resp.data;
            console.log("order:",resp.data);
            this.$http.get('http://localhost:8081/pharmacyAdmins/'+resp.data.pharmacyAdminId,config)
            .then(resp => {
                this.pharmacyAdmin = resp.data;
                console.log(resp.data);

                this.$http.get('http://localhost:8081/pharmacies/'+resp.data.pharmacyId,config)
                .then(resp => {
                    this.pharmacy = resp.data;
                    console.log("pharmacy:",resp.data);
                })
                .catch(er => {
                    console.log('Error while loading pharmacy !');
                    console.log(er);
                });
            })
            .catch(er => {
                console.log('Error while loading pharmacy admin !');
                console.log(er);
            });

        })
        .catch(er => {
            console.log('Error while loading order !');
            console.log(er);
        });
        
        
    },
    methods:{
        select: function() {
            if(this.canBeSelected){
                return;
            }
            window.location.href = 'http://localhost:8080/supplierHomePage/giveOffer/'+this.order.id;
        }
    },
    computed: {
        time(){
            var date = new Date(this.order.deadline);
            var dateString = moment(date). format('YYYY-MM-DD');
            return dateString;
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