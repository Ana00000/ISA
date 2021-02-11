<template>
  <div>
    <span class="bg"/>
    <div class="panelDiv">
      <div style="margin: 10px"  >
        <h1 style="color: white">Pharmacy Administrator Profile</h1>
      </div>
      <div class="grid-container1">
        <v-list style="background: transparent" class="display-4">
          <v-list-item>
            <v-btn style="margin: 0 auto" class="buttons" v-on:click="goToPharmacyProfile">Pharmacy profile</v-btn>
          </v-list-item>
          <v-list-item>
            <v-btn style="margin: 0 auto" class="buttons">Reserve medicine</v-btn>
          </v-list-item>
          <v-list-item>
            <v-btn style="margin: 0 auto" class="buttons">check if medicine is available via E-Receipt</v-btn>
          </v-list-item>
          <v-list-item>
            <v-btn style="margin: 0 auto" class="buttons">define new appointment with pharmacist</v-btn>
          </v-list-item>
          <v-list-item>
            <v-btn style="margin: 0 auto" class="buttons" v-on:click="defineAppWithDermatologist">define new appointment with dermatologist</v-btn>
          </v-list-item>
          <v-list-item>
            <v-btn style="margin: 0 auto" class="buttons" v-on:click="definePromotion">define new promotion</v-btn>
          </v-list-item>
          <v-list-item>
            <v-btn style="margin: 0 auto" class="buttons" v-on:click="defineMedicineOrder">define new medicine order</v-btn>
          </v-list-item>
        </v-list>
        <div>
          <div class="grid-container2">
            <h3 class="grid-item">First Name:</h3>
            <h3 class="grid-item">{{name}}</h3>
            <h3 class="grid-item">Last Name:</h3>
            <h3 class="grid-item">{{lastName}}</h3>
            <h3 class="grid-item">Email:</h3>
            <h3 class="grid-item">{{email}}</h3>
            <h3 class="grid-item">Address:</h3>
            <h3 class="grid-item">{{address}}</h3>
            <h3 class="grid-item">Phone Number:</h3>
            <h3 class="grid-item">{{phoneNumber}}</h3>
            <h3 class="grid-item">Working in pharmacy:</h3>
            <h3 class="grid-item">{{workingInPharmacy}}</h3>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
name: "PharmacyAdminProfile",
  data: () => ({
    name: '',
    lastName: '',
    email: '',
    address: '',
    phoneNumber: null,
    active: true,
    workingInPharmacy: null,
    pharmacyAdminId: null,
    pharmacyId: null
  }),
  mounted() {
    this.init();
  },
  methods: {
    init() {
      this.pharmacyAdminId = this.$route.params.pharmacyAdminId;
      this.$http.get('http://localhost:8081/pharmacyAdmins/' + this.pharmacyAdminId).then(resp => {
        console.log(resp.data);
        this.setInfo(resp.data);
      }).catch(err => {
        console.log("Ne radi");
        console.log(err.response.data);
      })
    },
    setInfo(item) {
      this.name = item.name;
      this.lastName = item.lastName;
      this.email = item.email;
      this.address = item.address;
      this.phoneNumber = item.phoneNumber;
      this.active = item.active;
      this.pharmacyId = item.pharmacyId;
      this.$http.get('http://localhost:8081/pharmacies/' + item.pharmacyId)
      .then(resp => {
        this.workingInPharmacy = resp.data.name;
      })
      this.pharmacyAdminId = item.pharmacyAdminId;
    },
    defineAppWithDermatologist() {
      this.$router.push('/pharmacyAdmin/AppointmentWithDermatologistForm');
    },
    definePromotion() {
      this.$router.push('/pharmacyAdmin/definePromotion');
    },
    goToPharmacyProfile() {
      this.$router.push('/pharmacy/profile/' + this.pharmacyId);
    },
    defineMedicineOrder() {
      this.$router.push('/pharmacyAdmin/defineMedicineOrder');
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

.panelDiv {
  align-content: center;
  background: gray;
  width: 98.5%;
  height: 800px;
  margin: 10px;
  opacity: 0.8;
  position: center;
}

.grid-container1 {
  display: grid;
  grid-template-columns: 400px auto;
  background-color: #000000;
  padding: 0;
  height: auto;
  margin: 30px;
}

.buttons {
  height: 50px;
  width: 400px;
}

.grid-container2 {
  display: grid;
  grid-template-columns: auto auto;
  grid-template-rows: auto auto auto auto auto auto auto;
  background-color: #000000;
  padding: 0;
  margin: 30px;
}
.grid-item {
  padding: 20px;
  font-size: 30px;
  text-align: center;
  color: #ffffff;
  opacity: 1;
  justify-content: left;
}

</style>