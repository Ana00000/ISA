<template>
  <div>
    <div style="width:25%;">
        <SystemAdminMenu/>
    </div>

  <v-card width="400" class="mx-auto mt-5" color="white">
    <v-card-title class="justify-center">
      <h1 class="display-1 ">Add dermatologist</h1>
    </v-card-title>
    <v-card-text>
      <v-form class="mx-auto ml-5 mr-5">
        <v-text-field
            label="Username/Email"
            v-model="username"
            prepend-icon="mdi-account-circle"/>
        <v-text-field
            :type="showPassword ? 'text' : 'password'"
            label="Password"
            v-model="password2"
            prepend-icon="mdi-lock"
            :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
            @click:append="showPassword = !showPassword"/>
        <v-text-field
        :type="showPassword ? 'text' : 'password'"
        label="Confirm Password"
        v-model="password"
        prepend-icon="mdi-lock"
        :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
        @click:append="showPassword = !showPassword"/>
        <v-text-field
            label="First name"
            v-model="firstName"
            prepend-icon="mdi-name-circle"/>
        <v-text-field
            label="Last name"
            v-model="lastName"
            prepend-icon="mdi-address-circle"/>
        <v-text-field
            label="Address"
            v-model="address"
            prepend-icon="mdi-address-circle"/>
        <v-text-field
            label="Phone number"
            v-model="phoneNumber"
            prepend-icon="mdi-address-circle"/>
        
      </v-form>
    </v-card-text>
    <v-card-actions class="justify-center mb-5">
      <v-btn color="info mb-5" v-on:click="add">
        Add dermetologist
      </v-btn>
    </v-card-actions>
  </v-card>
  </div>
</template>

<script>
import SystemAdminMenu from '../../components/systemAdmin/SystemAdminMenu.vue';
export default {
  components: { SystemAdminMenu },
  name: 'SystemAdminAddDermatologist',
  data: () => ({
    showPassword: false,
    username: '',
    password: '',
    password2:'',
    phoneNumber:'',
    firstName: '',
    lastName: '',
    address: '',
    users: []
  }),
  computed: {
    user() {
      return {'email': this.username, 'password': this.password, 'phoneNumber':this.phoneNumber,'name':this.firstName,'lastName':this.lastName,'address':this.address}
    }
  },
  methods: {
    add() {
      if(!this.ValidateEmail()){
        return;
      }
      if (this.password!==this.password2){
          alert("Passwords don't match !!!");
          this.password='';
          this.password2='';
          return;
      }
      
      var tokenString = '';
      tokenString = localStorage.getItem("token");
      const config = {
              headers: {Authorization: `Bearer ${tokenString}`}
      };
      this.$http.post('http://localhost:8081/dermatologists/addDermatolog',this.user,config)
      .then(resp => {
        console.log(resp.data);
        alert("Successfully added !")
        window.location.href = 'http://localhost:8080/systemAdminHomePage';
      })
      .catch(er => {
        console.log('Error while registering in');
        console.log(er.response.data);
      })
    },

    ValidateEmail() 
    {
    if (/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(this.username))
      {
        return (true)
      }
        alert("You have entered an invalid email address!")
        return (false)
    }
  }
};

</script>

<style>

</style>