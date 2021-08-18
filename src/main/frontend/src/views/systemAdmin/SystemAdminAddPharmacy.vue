<template>
    <v-card width="400" class="mx-auto  mt-5" color="white">
        <v-card-title class="justify-center">
      <h1 class="display-1 ">Add pharmacy</h1>
    </v-card-title>
    <v-card-text>
        <v-form class="mx-auto ml-5 mr-5">
            <v-text-field 
                label="Name"
                v-model="name"/>
            <v-text-field 
                label="Contact"
                v-model="contact"/>
            <v-text-field 
                label="Country"
                v-model="country"/>
            <v-text-field 
                label="City"
                v-model="city"/>
            <v-text-field 
                label="Street"
                v-model="street"/>
            <v-text-field 
                label="Number"
                v-model="number"
                type="number"/>
            <v-text-field 
                label="Longitude"
                v-model="longitude"
                type="number"/>
            <v-text-field 
                label="Latitude"
                v-model="latitude"
                type="number"/>
        </v-form>
    </v-card-text>
    <v-card-actions class="justify-center mb-5">
      <v-btn color="info mb-5" v-on:click="addPharmacy">
        Add pharmacy
      </v-btn>
    </v-card-actions>
    </v-card>
</template>

<script>
export default {
    name:'SystemAdminAddPharmacy',
    data:()=>({
        name: '',
        contact:'',
        country: '',
        city: '',
        street: '',
        number: '',
        longitude:'',
        latitude:''
    }),
    computed: {
        pharmacy(){
            return {'name':this.name ,'contact':this.contact ,
            'country': this.country,'city':this.city,
            'street':this.street,'number':this.number,
            'longitude':this.longitude,'latitude':this.latitude}
        }
    },
    methods:{
        addPharmacy(){
            this.$http.post('http://localhost:8081/pharmacies/addPharmacy', this.pharmacy)
            .then(resp => {
                console.log(resp.data);
                alert("Successfully added !")
                window.location.href = 'http://localhost:8080/systemAdminHomePage';
            })
            .catch(er => {
                console.log('Error while adding pharmacy');
                console.log(er.response.data);
            })
        }
    }
}
</script>

<style>
</style>