<template>
    <v-container style="padding: 0px" fluid fill-height dark >
        <v-layout>
            <div style="width:25%;">
                    <PatientMenu/>
                </div>
                <div class="panelDiv" style="width:75%;">
                    <div style="margin: 50px"><h2 class="display-3">Pharmacies your are subsribed on:</h2></div>
                    <div style="background: none; border: none;">
                        <ItemListPharmacies v-on:selectedChanged="selectedItem = $event" v-bind:items="items" v-bind:renderingItems="items" v-bind:searchedItems="items"/>
                    </div>
                    <div style="margin-top: 30px">
                        <v-btn class="pink lighten-3" large @click="Unsubscribe"><h2 display-1>Unsubscribe</h2></v-btn>
                    </div>  
                    <div style="margin: 50px"><h2 class="display-3">Pharmacies not subscribed on:</h2></div>
                    <div style="background: none; border: none;">
                        <ItemListPharmacies v-on:selectedChanged="selectedItemNotSub = $event" v-bind:items="itemsNotSub" v-bind:renderingItems="itemsNotSub" v-bind:searchedItems="itemsNotSub"/>
                    </div>
                    <div style="margin-top: 30px">
                        <v-btn class="pink lighten-3" large @click="Subscribe"><h2 display-1>Subscribe</h2></v-btn>
                    </div>  
                     
            </div>
        </v-layout>
    </v-container>
</template>

<script>
import ItemListPharmacies from '../../components/itemList/ItemListPharmacies.vue'
import PatientMenu from '../../components/PatientMenu.vue';
export default {
  components: { ItemListPharmacies, PatientMenu },
    data: () => ({
      items: [],
      selectedItem:null,
      itemsNotSub:[],
      selectedItemNotSub:null,
    }),
    mounted(){
        var tokenString= '';
            tokenString = localStorage.getItem("token");
            const config = {
                headers: { Authorization: `Bearer ${tokenString}` }
            };
            this.$http.get('http://localhost:8081/pharmacies/allSubscribed',config)
            .then(res => this.items = res.data)
            .catch(err => console.log(err));
            this.$http.get('http://localhost:8081/pharmacies/allUserIsNotSubscribedOn',config)
            .then(res => this.itemsNotSub = res.data)
            .catch(err => console.log(err));
    },
    methods:{
        Subscribe(){
            var tokenString= '';
            tokenString = localStorage.getItem("token");
            const config = {
                headers: { Authorization: `Bearer ${tokenString}` }
            };
            this.$http.post('http://localhost:8081/patients/subscribeToPharmacyPromotionsByPharmacyId/'+this.selectedItemNotSub.id,null,config)
            .then((res) => {
                alert(res.data);
                this.loadPharmacies();
            })
            .catch(err => console.log(err));
        },
        loadPharmacies(){
            var tokenString= '';
            tokenString = localStorage.getItem("token");
            const config = {
                headers: { Authorization: `Bearer ${tokenString}` }
            };
            this.$http.get('http://localhost:8081/pharmacies/allSubscribed',config)
            .then(res => this.items = res.data)
            .catch(err => console.log(err));
            this.$http.get('http://localhost:8081/pharmacies/allUserIsNotSubscribedOn',config)
            .then(res => this.itemsNotSub = res.data)
            .catch(err => console.log(err));
        },
        Unsubscribe(){
            var tokenString= '';
            tokenString = localStorage.getItem("token");
            const config = {
                headers: { Authorization: `Bearer ${tokenString}` }
            };
            this.$http.post('http://localhost:8081/patients/usubscribeToPharmacyPromotionsByPharmacyId/'+this.selectedItem.id,null,config)
            .then((res) => {
                alert(res.data);
                this.loadPharmacies();
            })
            .catch(err => console.log(err));
        }
    },
}
</script>

<style>
.panelDiv {
    width: 100%;
    margin: 0 auto;
    background: none;
    border: none;
}
</style>