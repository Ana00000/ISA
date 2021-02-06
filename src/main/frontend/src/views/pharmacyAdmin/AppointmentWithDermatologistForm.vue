<template>
  <v-layout>
    <span class="bg"/>
    <div class="panelDiv">
      <div style="margin: 10px"  >
        <h1 style="color: white">Make New Appointment With Dermatologist</h1>
        <h3 class="grid-item">Pick a dermatologist:</h3>
        <v-combobox class="combobox" v-model="dermatologists"></v-combobox>
        <h3 class="grid-item" style="color: white">Choose time interval:</h3>
        <v-datetime-picker name="picker1" range class="ti" v-model="dateAndTimeFrom" min="minDate" label="From"> </v-datetime-picker>
        <v-datetime-picker name="picker2" class="ti" v-model="dateAndTimeTo" min="minDate" label="To" > </v-datetime-picker>
        <h3 class="grid-item">Price</h3>
        <v-text-field
            label="Price in $"
            v-model="price"
            class="input"/>
        <v-btn class="mb-5 ">Confirm</v-btn>
      </div>
    </div>
  </v-layout>
</template>

<script>
export default {
  name: "AppointmentWithDermatologistForm",
  data: () => ({
    dateAndTimeFrom: Date.now(),
    dateAndTimeTo: Date.now(),
    dermatologists: [],
    minDate: Date.now(),
    price: 150
  }),
  mounted() {
    this.init()
  },
  methods: {
    init() {
      this.$http.get("http://localhost:8081/dermatologists/all").then(resp => {
        console.log(resp.data);
      }).catch(err => {
        console.log("Nije ucitano");
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
  color: white
}

.combobox {
  color: black;
  border: 5px black;
  margin-left: 200px;
  margin-right: 200px;
}

.ti {
  width: 300px;
  justify-content: center;
  align-content: center;

  margin-left: 200px;
  margin-right: 200px;
  background-color: #000000;
  padding: 0;
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