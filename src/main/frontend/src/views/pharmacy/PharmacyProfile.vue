<template>
  <div>
    <span class="bg"/>
    <div class="panelDiv">
      <div style="margin: 10px"  >
        <h1 style="color: white">Pharmacy Profile</h1>
      </div>
      <div class="grid-container1">
        <v-list style="background: transparent" class="display-4">
          <v-list-item>
            <v-btn style="margin: 0 auto" class="buttons">Reserve medicine</v-btn>
          </v-list-item>
          <v-list-item>
            <v-btn style="margin: 0 auto" class="buttons">check if medicine is available via E-Receipt</v-btn>
          </v-list-item>
          <v-list-item>
            <v-btn style="margin: 0 auto" class="buttons">reserve appointment with pharmacist</v-btn>
          </v-list-item>
          <v-list-item>
            <v-btn style="margin: 0 auto" class="buttons">reserve appointment with dermatologist</v-btn>
          </v-list-item>
          <v-list-item>
            <v-btn style="margin: 0 auto" class="buttons">become a premium member</v-btn>
          </v-list-item>
          <v-list-item>
            <v-btn style="margin: 0 auto" class="buttons">Statistics</v-btn>
          </v-list-item>
        </v-list>
        <div>
          <div class="grid-container2">
            <h3 class="grid-item">Name:</h3>
            <h3 class="grid-item">{{name}}</h3>
            <h3 class="grid-item">Contact:</h3>
            <h3 class="grid-item">{{contact}}</h3>
            <h3 class="grid-item">Country:</h3>
            <h3 class="grid-item">{{country}}</h3>
            <h3 class="grid-item">City:</h3>
            <h3 class="grid-item">{{city}}</h3>
            <h3 class="grid-item">Street:</h3>
            <h3 class="grid-item">{{street}}</h3>
            <h3 class="grid-item">Number:</h3>
            <h3 class="grid-item">{{number}}</h3>
            <h3 class="grid-item">Average Grade:</h3>
            <h3 class="grid-item">{{averageGrade}}</h3>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "PharmacyProfile",
  data: () => ({
    name: '',
    contact: '',
    country: '',
    city: '',
    street: '',
    number: '',
    averageGrade: null,
    pharmacyId: 0
  }),
  mounted() {
    this.init();
  },
  methods: {
    init() {
      this.pharmacyId = this.$route.params.pharmacyId;
      this.$http.get('http://localhost:8081/pharmacies/' + this.pharmacyId).then(resp => {
        console.log(resp.data);
        this.setInfo(resp.data);
      }).catch(err => {
        console.log("Ne radi");
        console.log(err.response.data);
      })
    },
    setInfo(item) {
        this.name = item.name;
        this.contact = item.contact;
        this.country = item.country;
        this.city = item.city;
        this.street = item.street;
        this.number = item.number;
        this.averageGrade = item.averageGrade;
    }
  }
}
</script>

<style scoped>
.bg {
  background: url('https://images.unsplash.com/photo-1584362917165-526a968579e8?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=782&q=80');
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