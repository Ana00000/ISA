<template>
    <v-card width="400" class="mx-auto mt-5" color="white" >
      <v-card-title class="justify-center">
        <h1 class="display-1 mt-5">Login</h1>
      </v-card-title>
      <v-card-text>
        <v-form class="mx-auto ml-5 mr-5">
          <v-text-field
            label="Username"
            v-model="username"
            prepend-icon="mdi-account-circle"/>
          <v-text-field
            :type="showPassword ? 'text' : 'password'"
            label="Password"
            v-model="password"
            prepend-icon="mdi-lock"
            :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
            @click:append="showPassword = !showPassword"/>
        </v-form>
      </v-card-text>
      <v-card-actions>
        <v-btn color="success" class="mx-auto mb-5" v-on:click="login">
          Login
        </v-btn>
        <v-btn color="success" class="mx-auto mb-5" v-on:click="proba">
          Proba
        </v-btn>
      </v-card-actions>
    </v-card>
    
    
</template>

<script>
import axios from 'axios';
export default {
  name: 'Login',
  data: () => ({
    showPassword: false,
    username: '',
    password: '',
    users: []
  }),
  computed: {
    user() {
      return {'email': this.username, 'password': this.password}
    }
  },
  methods: {
    login() {
      this.$http.post('http://localhost:8081/users/login', this.user)
      .then(resp => {
        console.log(resp.data);
        localStorage.setItem("token", resp.data.accessToken);
        window.location.href = "http://localhost:8080/";
      })
      .catch(er => {
        console.log('Error while logging in');
        console.log(er.response.data);
      })
    },
    proba() {
      alert("radi");
      var tokenString= '';
      tokenString = localStorage.getItem("token");

      // const bodyParameters = {
      //   key: "value"
      // };
      const config = {
          headers: { Authorization: `Bearer ${tokenString}` }
      };

      axios.get( 
        'http://localhost:8081/patients/all',
        config
      ).then(console.log)
      .catch(console.log);
    }
  }
};

</script>

<style>

</style>