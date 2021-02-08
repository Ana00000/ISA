<template>
  <v-layout justify-center align-baseline>
    <span class="bg"/>
    <v-card style="opacity: 0.7" >
      <v-card-title style="margin: 5px">
        <h1 style="color: black">Make New Appointment With Dermatologist</h1>
      </v-card-title>
      <h2 class="grid-item" style="color: black">Pick a dermatologist that works in pharmacy:</h2>
      <h1 class="grid-item" style="color: black">{{ this.adminsPharmacy.name }}</h1>
      <v-combobox hint="This is mandatory" :items="dermatologists" :item-text="text" @change="comboboxSelectionChange" v-model="pickedDermatologist" />
      <h3 v-if="pickedDermatologist">Doctor is busy in the following periods:</h3>
      <v-layout justify-center align-baseline>
        <v-list v-if="pickedDermatologist" color="gray" >
          <v-list-item v-for="key in appointments" :key="key">
            <h3 >{{ 'From: ' + key.startTime.toLocaleString("sr") + ' To: ' + key.endTime.toLocaleString("sr") }}</h3>
          </v-list-item>
        </v-list>
      </v-layout>
      <h3 class="grid-item" style="color: black">Choose time interval:</h3>
      <v-datetime-picker name="picker1" date-format="dd.MM.yyyy." time-format="HH:mm" class="ti mb-5 mt-5" v-model="dateAndTimeFrom" min="minDate" label="From"/>
      <v-datetime-picker name="picker2" date-format="dd.MM.yyyy." time-format="HH:mm" class="ti" v-model="dateAndTimeTo" min="minDate" label="To"/>
      <h3 class="grid-item" style="color: black">Price:</h3>
      <v-text-field
          label="Price in $"
          v-model="price"
          class="input"/>
      <v-layout justify-center class="mt-5 mb-5">
        <v-radio-group label="Choose Appointment type:" v-model="appType">
          <v-radio label="Consultation" value="CONSULTATION"/>
          <v-radio label="Examination" value="EXAMINATION"/>
        </v-radio-group>
      </v-layout>
      <v-layout justify-center class="mt-5 mb-5">
        <v-btn style="background-color: gray" v-on:click="onConfirm">Confirm</v-btn>
      </v-layout>
    </v-card>
  </v-layout>
</template>

<script>

export default {
  name: "AppointmentWithDermatologistForm",
  data: () => ({
    dateAndTimeFrom: Date.now(),
    dateAndTimeTo: Date.now(),
    dermatologists: [],
    pickedDermatologist: null,
    minDate: Date.now(),
    price: null,
    admin: null,
    adminsPharmacy: null,
    appointments: [],
    appStart: null,
    appEnd: null,
    appType: null,
    disabledDates: {
      to: new Date(Date.now() - 8640000)
    }
  }),
  mounted() {
    this.init();
  },
  computed: {
    appStruct() {
      return {'startTime': this.startTime, 'endTime': this.endTime}
    },
    newAppStruct() {
      return {
        'startTime': this.dateAndTimeFrom, 'endTime': this.dateAndTimeTo, 'price': this.price, 'doctor': this.pickedDermatologist,
        'appointmentType': {'appointmentTypeValue': this.appType}
      }
    },
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
        this.admin = resp.data

        this.$http.get('http://localhost:8081/pharmacies/' + this.admin.pharmacyId).then(resp2 => {
          this.adminsPharmacy = resp2.data;
        })

        this.$http.get('http://localhost:8081/dermatologists/getByPharmacy=' + this.admin.pharmacyId).then(resp2 => {
          this.dermatologists = resp2.data;
        })
      }).catch(console.log);

    },
    text: item => item.name + ' ' + item.lastName,
    comboboxSelectionChange() {
      this.appointments = [];
      console.log(this.pickedDermatologist);

      this.$http.post('http://localhost:8081/appointments/byDoctor', this.pickedDermatologist).then(resp => {
        console.log('Appointments');
        console.log(resp.data);
        for (var i = 0; i < resp.data.length; ++i) {
          var app = resp.data[i];
          var start = new Date(app.startTime);
          var end = new Date(app.endTime);
          var appStruct = { 'startTime': start, 'endTime': end };
          this.appointments.push(appStruct);
        }
      }).catch(err => {
        console.log('Appointments error');
        console.log(err.response.data);
      })

      this.$http.get('http://localhost:8081/vacations/doctorVacation/' + this.pickedDermatologist.id).then(resp => {
        console.log('Vacation');
        console.log(resp.data);

        var start = new Date(resp.data.startTime);
        var end = new Date(resp.data.endTime);
        var appStruct = { 'startTime': start, 'endTime': end };
        this.appointments.push(appStruct);
      }).catch(err => {
        console.log('Vacation error');
        console.log(err.response.data);
      })
    },
    onConfirm() {
      if (this.pickedDermatologist === null) {
        alert('You did not pick a dermatologist.\nPlease do that first and try again.');
        return;
      }
      console.log(this.pickedDermatologist);
      if (this.dateAndTimeFrom > this.dateAndTimeTo ||
          this.dateAndTimeFrom < Date.now() ||
          this.dateAndTimeTo < Date.now()) {
        alert('Time interval is not set properly');
        return;
      }

      if (this.price === null || this.price <= 0) {
        alert('Please set price');
        return;
      }

      console.log(this.appType);
      if (this.appType === null) {
        alert('Please set appointment type');
        return;
      }

      for (let i = 0; i < this.appointments.length; ++i) {
        let app = this.appointments[i];
        if (!((this.dateAndTimeFrom.getTime() < app.startTime.getTime() && this.dateAndTimeTo.getTime() < app.startTime.getTime()) ||
            (this.dateAndTimeFrom.getTime() > app.endTime.getTime() && this.dateAndTimeTo.getTime() > app.endTime.getTime()))) {
          alert('This time interval is overlapping with one already');
          return;
        }
      }
      console.log(this.newAppStruct);
      this.$http.post('http://localhost:8081/appointments/defineNewAppointment', this.newAppStruct)
          .then(resp => {
            console.log("Defined new Appointment");
            console.log(resp.data);
            alert('Successfully defined new appointment');
            this.$router.back();
          }).catch(err => {
        console.log("Error while defining new Appointment");
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

.panelDiv {
  align-content: center;
  background: #7d8c96;
  width: 98.5%;
  height: 800px;
  margin: 10px;
  opacity: 0.8;
  position: center;
}

.input {
  height: 50px;
  width: 50%;
  display: inline-flex;
  align-items: center;
  justify-content: center;
  color: white;
  font-size: 2em;
}

.combobox {
  color: black;
  border: 5px black;
  margin-left: 200px;
  margin-right: 200px;
}

.ti {
  width: 30%;
  text-justify: initial;
  string-set: revert;
  margin-left: 5px;
  margin-right: 5px;
  font-size: 2em;
}

.grid-item {
  font-size: 30px;
  text-align: center;
  color: #ffffff;
}

</style>