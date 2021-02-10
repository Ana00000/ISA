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
                <v-text-field type="number" color="black"/>
              </td>
            </tr>
          </template>
        </v-data-table>
      </v-layout>
      <v-layout justify-center class="mt-5 mb-5">
        <h3>Insert New Medicines For Order</h3>
      </v-layout>
      <v-layout justify-center>
        <v-data-table :items="allMedicines" :headers="headers2">
          <template v-slot:item="row">
            <tr>
              <td>{{row.item.id}}</td>
              <td>{{row.item.name}}</td>
              <td>
                <v-checkbox v-model="row.item.recipeNeed" readonly>
                </v-checkbox>
              </td>
              <td>
                <v-text-field type="number" color="black"/>
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
    headers1: [
      { text: 'ID', value: 'name'},
      { text: 'Name', value: 'calories' },
      { text: 'Need Recipe', value: 'fat' },
      { text: 'Quantity', value: 'carbs' },
      { text: 'Order New Quantity ', value: 'protein' }
    ],
    headers2: [
      { text: 'ID', value: 'name'},
      { text: 'Name', value: 'calories' },
      { text: 'Need Recipe', value: 'fat' },
      { text: 'Order New Quantity ', value: 'protein' }
    ],
    dateAndTime: null,
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