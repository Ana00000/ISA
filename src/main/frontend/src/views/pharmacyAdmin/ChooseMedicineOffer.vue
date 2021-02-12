<template>
  <v-layout justify-center align-baseline>
    <span class="bg"/>
    <v-card width="70%" elevation="10" justify-center class="text-center">
      <v-card-title style="margin: 10px">
        <v-layout justify-center style="margin: 5px">
          <h1>All Medicine Orders</h1>
        </v-layout>
        <v-layout justify-center style="margin: 5px">
          <h2>Click on each order to see more details</h2>
        </v-layout>
        <v-layout justify-center style="margin: 5px">
        </v-layout>
      </v-card-title>
      <v-layout justify-center>
        <v-data-table :items="ordersInPharmacy" :headers="headers"  >
          <template v-slot:item="row" >
            <tr>
              <td>{{row.item.id}}</td>
              <td>{{new Date(row.item.deadline).toLocaleString('sr')}}</td>
              <td>
                <v-dialog v-model="row.item.dialog" >
                  <template v-slot:activator="{ on, attrs }">
                    <v-btn :color="colorFun(row.item)" dark v-bind="attrs" v-on="on" @click="getListOfOffers(row.item)">
                      More Details
                    </v-btn>
                  </template>
                  <v-card>
                    <v-card-title class="headline grey lighten-2">
                      Offers for order ID {{ row.item.id }}
                    </v-card-title>
                    <v-data-table :items="listOfOffers" :headers="headers2" show-select single-select v-model="selectedOffer">
                    </v-data-table>
                    <v-divider/>
                    <v-card-actions>
                      <v-spacer/>
                      <v-btn color="#24f232" text @click="acceptOffer" v-if="admin.id === row.item.pharmacyAdminId" >
                        Accept selected offer
                      </v-btn>
                      <v-btn color="#e6052a" text @click="row.item.dialog = false">
                        Exit dialog
                      </v-btn>
                    </v-card-actions>
                  </v-card>
                </v-dialog>
              </td>
            </tr>
          </template>
        </v-data-table>
      </v-layout>
    </v-card>
  </v-layout>
</template>

<script>

export default {
  name: "ChooseMedicineOffer",
  mounted() {
    this.init();
  },
  data: () => ({
    admin: null,
    adminsPharmacy: null,
    ordersInPharmacy: [],
    headers: [
      { text: 'ID', value: 'id'},
      { text: 'Deadline', value: 'deadline' },
    ],
    headers2: [
      { text: 'ID', value: 'id'},
      { text: 'Supplier', value: 'medicineOrder' },
      { text: 'Cost[$]', value: 'cost' },
    ],
    listOfOffers: [],
    selectedOffer: null
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

        this.$http.get("http://localhost:8081/medicineOrder/getAllOrdersByPharmacyId=" + parseInt(this.admin.pharmacyId)).then(resp2 => {
          this.ordersInPharmacy = [];
          var allPharmacyOrders = resp2.data;

          for (let i = 0 ; i < allPharmacyOrders.length; ++i) {
            let order = allPharmacyOrders[i]

            if (order.deadline < Date.now())
              this.ordersInPharmacy.push(order);
          }
          console.log(this.ordersInPharmacy);
        });

      }).catch(err => {
        console.log('Neki error');
        console.log(err);
      });
    },
    colorFun(item) {
      if (this.admin.id === item.pharmacyAdminId) {
        this.canAcceptOffer = true;
        return "#24f232"
      }
      this.canAcceptOffer = false;
      return "#e6052a"
    },
    getListOfOffers(item) {
      this.$http.get('http://localhost:8081/medicineOrder/getOffersByMedicineOrderId=' + item.id)
      .then(resp => {
        console.log(resp.data)
        this.listOfOffers = resp.data;
      })
      .catch(err => {
        alert("Error loading offers");
        console.log(err.response.data);
      })
    },
    acceptOffer() {
      if (this.selectedOffer === null) {
        alert("Please select an offer for the order");
        return;
      }

      console.log(this.selectedOffer);

      this.selectedOffer[0].pharmacyAdmin = this.admin;

      console.log(this.selectedOffer);

      alert("This action will take a few moments");

      this.$http.post('http://localhost:8081/medicineOffers/chosenOffer', this.selectedOffer)
      .then(resp => {
          alert("You have successfuly chosen on of the offers. E-mails have been sent.");
          console.log(resp.data);
          this.$router.back();
      })
      .catch(err => {
        alert("Accepting Offer is NOT Successful");
        console.log(err.response.data);
      })

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