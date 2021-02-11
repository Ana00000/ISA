<template>
  <v-layout justify-center align-baseline>
    <span class="bg"/>
    <v-card width="70%" elevation="10" justify-center class="text-center">
      <v-card-title style="margin: 10px">
        <v-layout justify-center style="margin: 5px">
          <h1>Define new Medicine Order for Pharmacy:</h1>
        </v-layout>
        <v-layout justify-center style="margin: 5px">
          <h1 style="color: #2175a5">{{this.adminsPharmacy.name}}</h1>
        </v-layout>
      </v-card-title>
      <v-layout justify-center>
        <h3>Medicines that are already in this pharmacy:</h3>
      </v-layout>
      <v-layout justify-center>
        <v-data-table :items="medicinesInPharmacy" :headers="headers1">
          <template v-slot:item="row">
            <tr>
              <td>{{row.item.id}}</td>
              <td>{{row.item.name}}</td>
              <td>
                <v-checkbox v-model="row.item.recipeNeed" readonly>
                </v-checkbox>
              </td>
              <td>{{row.item.quantity}}</td>
              <td>
                <v-text-field v-model="row.item.newQuantity" type="number" color="black">{{row.item.newQuantity}}</v-text-field>
              </td>
            </tr>
          </template>
        </v-data-table>
      </v-layout>
      <v-layout justify-center class="mt-5 mb-5">
        <h3>Insert New Medicines For Order</h3>
      </v-layout>
      <v-layout justify-center>
        <v-data-table :items="allMedicines" :headers="headers2" >
          <template v-slot:item="row">
            <tr>
              <td>{{row.item.id}}</td>
              <td>{{row.item.name}}</td>
              <td>
                <v-checkbox v-model="row.item.recipeNeed" readonly>
                </v-checkbox>
              </td>
              <td>
                <v-text-field v-model="row.item.newQuantity" type="number" color="black">{{row.item.newQuantity}}</v-text-field>
              </td>
            </tr>
          </template>
        </v-data-table>
      </v-layout>
      <v-layout justify-center class="mt-5 mb-5">
        <h3>Insert Order Deadline</h3>
      </v-layout>
      <v-layout justify-center class="mt-5 mb-5" >
        <v-datetime-picker v-model="dateAndTime"  />
      </v-layout>
      <v-layout justify-center class="mt-5 mb-5">
        <v-btn v-on:click="onConfirm" color="#7f7f7f">confirm order</v-btn>
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
    allMedicines: null,
    allMedicineCopy: null,
    headers1: [
      { text: 'ID', value: 'id'},
      { text: 'Name', value: 'name' },
      { text: 'Need Recipe', value: 'needRecipe' },
      { text: 'Quantity', value: 'quantity' },
      { text: 'Order New Quantity ', value: 'newQuantity' }
    ],
    headers2: [
      { text: 'ID', value: 'id'},
      { text: 'Name', value: 'name' },
      { text: 'Need Recipe', value: 'needRecipe' },
      { text: 'Order New Quantity ', value: 'newQuantity' }
    ],
    dateAndTime: null,
    keys: [],
    values: [],
    map: new Map()
  }),
  computed: {
    order() {
      return { 'deadline': this.dateAndTime, 'keys': this.keys, 'values': this.values }
    }
  },
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
        this.admin = resp.data;

        this.$http.get('http://localhost:8081/pharmacies/' + this.admin.pharmacyId).then(resp2 => {
          this.adminsPharmacy = resp2.data;
        });
        this.$http.get('http://localhost:8081/medicine/findByPharmacyId=' + this.admin.pharmacyId).then(resp2 => {
          this.medicinesInPharmacy = resp2.data;
          var indexes = [];

          for (var i = 0; i < this.medicinesInPharmacy.length; ++i) {
            indexes.push(this.medicinesInPharmacy[i].id);
          }

          this.$http.get('http://localhost:8081/medicine').then(resp2 => {
            this.allMedicines = resp2.data;
            console.log(this.allMedicines);
            var k = 1;
            for ( var i = 0; i < this.medicinesInPharmacy.length; ++i ) {
              var med = this.medicinesInPharmacy[i];
              for ( var j = 0; j < indexes.length; ++j ) {
                if (med.id === indexes[i]) {
                  console.log(med.id);
                  console.log("k = " + k);
                  this.allMedicines.splice(med.id - k, 1);
                  ++k;
                  break;
                }
              }
            }
          });

          this.$http.get('http://localhost:8081/medicine').then(resp2 => {
            this.allMedicineCopy = resp2.data;
            console.log(this.allMedicineCopy);
            var k = 1;
            for ( var i = 0; i < this.medicinesInPharmacy.length; ++i ) {
              var med = this.medicinesInPharmacy[i];
              for ( var j = 0; j < indexes.length; ++j ) {
                if (med.id === indexes[i]) {
                  console.log(med.id);
                  console.log("k = " + k);
                  this.allMedicineCopy.splice(med.id - k, 1);
                  ++k;
                  break;
                }
              }
            }
          });
        });

      }).catch(err => {
        console.log('Neki error');
        console.log(err);
      });
    },
    onMedicineButtonClick(medicine) {
      console.log(medicine);
    },
    onConfirm() {
      this.keys = [];
      this.values = [];

      if (this.dateAndTime == null || this.dateAndTime < Date.now()) {
        alert('Deadline for order is not set properly! Try again.');
        return;
      }

      for (let i = 0; i < this.medicinesInPharmacy.length; i++) {
        var row = this.medicinesInPharmacy[i];
        if (row.newQuantity == null) row.newQuantity = 0;
        var newQuantity = parseInt(row.newQuantity);
        if (newQuantity < 0) {
          alert('Some input fields are negative numbers. Try again.');
          return;
        }

        let medicine = {
          id: row.id,
          medicineManufacturer: row.medicineManufacturer,
          medicineShape: row.medicineShape,
          name: row.name,
          quantity: row.quantity,
          recipe: row.recipe
        }

        // this.map[medicine] = newQuantity;
        this.keys.push(medicine);
        this.values.push(newQuantity);
        this.map.set(medicine, newQuantity);
      }

      for (let i = 0; i < this.allMedicines.length; i++) {
        var row1 = this.allMedicines[i];
        if (row1.newQuantity == null) row1.newQuantity = 0;
        var newQuantity1 = parseInt(row1.newQuantity);
        if (newQuantity1 < 0) {
          alert('Some input fields are negative numbers. Try again.');
          return;
        }
        else if (newQuantity1 == null) newQuantity1 = 0;

        let medicine = {
          id: row1.id,
          medicineManufacturer: row1.medicineManufacturer,
          medicineShape: row1.medicineShape,
          name: row1.name,
          quantity: row1.quantity,
          recipe: row1.recipe
        }

        // this.map[medicine] = newQuantity1;
        this.keys.push(medicine);
        this.values.push(newQuantity1);
        this.map.set(medicine, newQuantity1);
      }

      // var order = new this.computed.Order(this.dateAndTime.toLocaleString('sr'), map);
      console.log("--- MAP ---");
      console.log(this.map);
      console.log(this.map.entries());

      console.log("--- LOG ---");
      console.log(this.order);

      this.$http.post("http://localhost:8081/medicineOrder/saveOrder", this.order)
        .then(resp => {
          alert('Successfully confirmed new order');
          console.log(resp.data);
          this.$router.back();
        })
        .catch( err => {
          alert('An error has occurred.');
          console.log(err.response.data);
        });
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