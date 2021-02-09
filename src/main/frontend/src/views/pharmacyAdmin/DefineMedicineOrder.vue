<template>
  <v-layout justify-center align-baseline>
    <span class="bg"/>
    <v-card width="70%" elevation="10" justify-center class="text-center">
      <v-card-title style="margin: 10px">
        <v-layout justify-center style="margin: 5px">
          <h1>Define new Medicine Order for Pharmacy:</h1>
        </v-layout>
        <v-layout justify-center  style="margin: 5px">
          <h2>{{this.adminsPharmacy.name}}</h2>
        </v-layout>
      </v-card-title>
      <v-layout justify-center>
        <h3>Medicines that allready are in this pharmacy:</h3>
      </v-layout>
    </v-card>
  </v-layout>
</template>

<script>
export default {
  name: "DefineMedicineOrder",
  mounted() {
    this.init();
  },
  data: () => ({
    admin: null,
    adminsPharmacy: null,
    medicinesInPharmacy: null,
  }),
  methods: {
    init() {
      var tokenString = '';
      tokenString = localStorage.getItem("token");

      const config = {
        headers: {Authorization: `Bearer ${tokenString}`}
      };

      console.log(config);

      this.$http.get(
          'http://localhost:8081/pharmacyAdmins/findLoggedPharmacyAdmin',
          config
      ).then(resp => {
        this.admin = resp.data

        this.$http.get('http://localhost:8081/pharmacies/' + this.admin.pharmacyId).then(resp2 => {
          this.adminsPharmacy = resp2.data;
          console.log(this.adminsPharmacy);
        })
        console.log(this.admin.pharmacyId);
        this.$http.get('http://localhost:8081/medicine/findByPharmacyId=' + this.admin.pharmacyId).then(resp2 => {
          this.medicinesInPharmacy = resp2.data;
          console.log("Returned Medicine");
          console.log(this.medicinesInPharmacy);
        })
      }).catch(console.log);
    }
  }
}
</script>

<style scoped>

.bg {
  background: url('https://media.capc.org/images/AdobeStock_274131656.original.jpg');
  background-size: cover;
  width: 100%;
  height: 100%;
  opacity: 1;
  display: flex;
  justify-content: center;
  align-items: center;
}

</style>