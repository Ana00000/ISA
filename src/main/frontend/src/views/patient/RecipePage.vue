<template>
  <div>
        <div v-if="recipe"> 
        <v-card  width="400" class="mx-auto  mt-5" color="white">
            <v-card-title class="justify-center">
                <h1 class="display-1 ">Recipe</h1>
            </v-card-title>
            <v-card-text>
                <h3>Patient:</h3>
                <p>Name:{{this.recipe.patient.name}}<br/> Last name:{{this.recipe.patient.lastName}}</p>
                <h3>Medicines:</h3>
                <div style="color:black" v-for="(value, key) in recipe.medicineAmount" :index="key" :key="key" >{{key}}:{{value}}</div>
                <v-date-picker :disabled="true"  v-model="time"/>
            </v-card-text>
        </v-card>
        <h1 style="margin-top:50px;margin-bottom:10px">Pharmacy that contain medicines:</h1>
        <div v-if="renderListOfPharmacies">
            <item-list-pharmacies   @sendPharmacy="receivePharmacy" v-bind:items="pharmacy" v-bind:renderingItems="pharmacy" v-bind:searchedItems="pharmacy"/>
        </div>
        <div v-else>
            <h1 style="color:red">No pharmacy contain all medicine  !!</h1>
        </div>
        
        <h3 style="color:red" v-if="selectedPharmacy">Price for selected pharmacy:{{selectedPharmacy.price}}</h3>
        <v-btn class="pink lighten-3"  @click="GetMedicines"><h2 display-1>Get medicines</h2></v-btn>
        </div>
        <h1 v-else>
            NO RECIPE FOUNDED!
        </h1>
  </div>
</template>

<script>
import ItemListPharmacies from '../../components/itemList/ItemListPharmacies.vue';
export default {
  components: { ItemListPharmacies },
    name:'RecipePage',
    data(){
        return{
            recipeId:null,
            recipe:null,
            time:null,
            pharmacy:null,
            selectedPharmacy:null,
            price:0,
            renderListOfPharmacies: false,
        }
    },
     methods:{
        receivePharmacy: function(value){
            this.selectedPharmacy = value;
            console.log("selected",this.selectedPharmacy);

            var tokenString = '';
            tokenString = localStorage.getItem("token");
            const config = {
                    headers: {Authorization: `Bearer ${tokenString}`}
            };

            this.$http.get('http://localhost:8081/pharmacyMedicines/getPriceForSelectedPharmacyAndRecipe/'+this.recipeId+"/"+this.selectedPharmacy.id,config)
            .then(resp => {
                this.price = resp.data
            })
            .catch(er => {
                alert("Error !");
                console.log('Error while loading price !');
                console.log(er.response.data);
            });
        },
        GetMedicines: async function(){
            var tokenString = '';
            tokenString = localStorage.getItem("token");
            const config = {
                    headers: {Authorization: `Bearer ${tokenString}`}
            };
            if(this.selectedPharmacy == null ){
                alert("Select pharmacy first!");
                return;
            }
            const body = {'recipeId':this.recipeId, 'pharmacyId':this.selectedPharmacy.id};
            
            try {
                var res = await this.$http.post('http://localhost:8081/pharmacyMedicines/buyMedicinesForRecipe/',body,config)
                alert(res.data);
                window.location.href = "http://localhost:8080/";
            } catch (error) {
                console.log(error);
            }
            


        }
    },
    async mounted(){
        this.recipeId =  this.$route.params.recipeId;

        var tokenString = '';
        tokenString = localStorage.getItem("token");
        const config = {
                headers: {Authorization: `Bearer ${tokenString}`}
        };

        await this.$http.get('http://localhost:8081/recipe/getById/'+this.recipeId,config)
        .then(resp => {
            this.recipe = resp.data
            console.log("recipe:",this.recipe);
            this.time = (new Date(this.recipe.dateOfIssue).toISOString().substr(0, 10));
        })
        .catch(er => {
            alert("No recipe founded!");
            window.location.href ="http://localhost:8080/";
            console.log('Error while loading recipe !');
            console.log(er.response.data);
        });

        await this.$http.get('http://localhost:8081/pharmacyMedicines/getAllPharmaciesForRecipe/'+this.recipeId,config)
        .then(resp => {
            resp.data.forEach((el)=>{
                el.price = 0;
            })
            resp.data.forEach(async(el) => {
                var res = await this.$http.get('http://localhost:8081/pharmacyMedicines/getPriceForSelectedPharmacyAndRecipe/'+this.recipeId+"/"+el.id,config);
                el.price= res.data;
                console.log("element:",el);
            });
             
            this.pharmacy = resp.data
            console.log("pharmacy:",this.pharmacy);

            if(this.pharmacy.length  == 0){
                return;
            }
            this.renderListOfPharmacies = true;
            
        })
        .catch(er => {
            alert("Error !");
            console.log('Error while loading pharmacies !');
            console.log(er.response.data);
        });

        
        
    }
}
</script>

<style>

</style>