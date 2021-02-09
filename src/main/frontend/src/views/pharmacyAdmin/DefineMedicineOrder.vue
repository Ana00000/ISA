<template>
  <v-layout justify-center align-baseline>
    <span class="bg"/>
    <v-card width="70%" elevation="10" justify-center class="text-center">
      <v-card-title style="margin: 10px">
        <h1>Define new Medicine Order for Pharmacy:</h1>
        <h1>{{}}</h1>
      </v-card-title>
      <v-layout>
        <v-data-table calculate-widths height="100px">

        </v-data-table>
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
        })

        this.$http.get('http://localhost:8081/dermatologists/getByPharmacy=' + this.admin.pharmacyId).then(resp2 => {
          this.dermatologists = resp2.data;
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