<template>
  <v-layout justify-center align-baseline>
    <v-card width="75%">
      <v-card-title>
        <v-img src="https://www.gefu.com/media/image/4e/c0/1e/Promotion-1000x562.jpg" style="height: 35%"/>
        <h1>Define Promotion</h1>
      </v-card-title>
      <v-layout wrap justify-center align-baseline width="50%" class="mb-5 mt-5 ml-5 mr-5" >
        <v-datetime-picker name="picker1" class="ti" v-model="dateAndTimeFrom" min="minDate" label="From"> </v-datetime-picker>
        <v-datetime-picker name="picker2" class="ti" v-model="dateAndTimeTo" min="minDate" label="To" > </v-datetime-picker>
      </v-layout>
      <v-layout>
        <v-textarea label="Description" prepend-icon="mdi-text" background-color="gray" v-model="text"/>
      </v-layout>
      <v-btn style="background-color: #7d8c96" class="mb-5" v-on:click="confirmPromotion">
        Confirm
      </v-btn>
    </v-card>
  </v-layout>
</template>

<script>
export default {
  name: "DefinePromotion",
  data: () => ({
    dateAndTimeFrom: Date.now(),
    dateAndTimeTo: Date.now(),
    text: '',
    promotionId: null
  }),
  computed: {
    Promotion() {
      return {'id': this.promotionId, 'start': this.dateAndTimeFrom, 'end': this.dateAndTimeTo, 'description': this.text}
    }
  },
  methods: {
    confirmPromotion() {
      this.promotionId = Math.floor((Math.random() * 1000000) + 1);
      this.$http.post('http://localhost:8081/promotions/save', this.Promotion)
      .then(resp => {
        console.log(resp.data);
        this.$router.back();
      })
      .catch(err => {
        alert('ERROR: Something went wrong.');
        console.log(err.response.data);
      })
    }
  }
}
</script>

<style scoped>

</style>