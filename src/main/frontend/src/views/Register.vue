<template>
  <v-card width="400" class="mx-auto mt-5" color="white">
    <v-card-title class="justify-center">
      <h1 class="display-1 ">Registration</h1>
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
        label="Password"
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
      <v-btn color="info mb-5" v-on:click="register">
        Register
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>


export default {
  name: 'Register',
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
    register() {
      if(!this.ValidateEmail()){
        return;
      }
      if (this.password!==this.password2){
          alert("Passwords don't match !!!");
          this.password='';
          this.password2='';
          return;
      }
      this.$http.post('http://localhost:8081/user/register', this.user)
      .then(resp => {
        console.log(resp.data);
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