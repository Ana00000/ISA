<template>
  <div>
      <SystemAdminMenu/>
      <v-card width="400" class="mx-auto  mt-5" color="white">
        <v-card-title class="justify-center">
      <h1 class="display-1 ">Loyalty program</h1>
    </v-card-title>
    <v-card-text>
        <v-form class="mx-auto ml-5 mr-5">
            <v-text-field 
                label="pointsForConsultation"
                v-model="loyaltyProgram.pointsForConsultation"
                prepend-icon="mdi-application-edit"
                type="number"/>
            <v-text-field 
                label="pointsForExamination"
                v-model="loyaltyProgram.pointsForExamination"
                prepend-icon="mdi-gamepad-round"
                type="number"/>
            <v-text-field 
                label="pointsForSilver"
                v-model="loyaltyProgram.pointsForSilver"
                prepend-icon="mdi-golds"
                type="number"/>
            <v-text-field 
                label="pointsForGold"
                v-model="loyaltyProgram.pointsForGold"
                prepend-icon="mdi-gold"
                type="number"/>
            <v-text-field 
                label="discauntForSilver"
                v-model="loyaltyProgram.discauntForSilver"
                prepend-icon="mdi-golds"
                type="number"/>
            <v-text-field 
                label="discauntForGold"
                v-model="loyaltyProgram.discauntForGold"
                prepend-icon="mdi-gold"
                type="number"/>
        </v-form>
    </v-card-text>
    <v-card-actions class="justify-center mb-5">
      <v-btn color="info mb-5" v-on:click="edit">
        Edit program
      </v-btn>
    </v-card-actions>
    </v-card>
  </div>
</template>

<script>
import SystemAdminMenu from '../../components/systemAdmin/SystemAdminMenu.vue'
export default {
    components: { SystemAdminMenu },
    name:'LoyaltyProgram',
    data: ()=>({
        loyaltyProgram:null,
    }),
    beforeMount(){
        this.$http.get('http://localhost:8081/loyaltyProgram/getIt')
        .then(resp => {
            this.loyaltyProgram = resp.data;
            console.log(resp.data);
        })
        .catch(er => {
            console.log('Error while loading Loyalty Program !');
            console.log(er.response.data);
        });
    },
    methods:{
      edit(){
        var tokenString = '';
        tokenString = localStorage.getItem("token");
        const config = {
                headers: {Authorization: `Bearer ${tokenString}`}
        };
        console.log("medicine to add ",this.medicineToAdd);
        this.$http.post('http://localhost:8081/loyaltyProgram/changeProgram',this.loyaltyProgram,config)
        .then(resp => {
          console.log(resp.data);
          alert("Successfully edited program !")
          window.location.href = 'http://localhost:8080/systemAdminHomePage';
        })
        .catch(er => {
          console.log('Error while editing program !');
          console.log(er.response.data);
        })
      },
    },
}
</script>

<style>

</style>