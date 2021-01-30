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
        <label>
          Date of birth
        </label>
        <v-date-picker
            label="Date of birth"
            class="v-calendar"
            value="today"
            v-model="dateOfBirth"
            prepend-icon="mdi-account-circle"/>
      </v-form>
    </v-card-text>
    <v-card-actions class="justify-center mb-5">
      <v-btn color="info mb-5">
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
    firstName: '',
    lastName: '',
    address: '',
    dateOfBirth: null,
    users: []
  }),
  methods: {
    login() {
      this.$axios.get
    }
  }
};

</script>

<style>

</style>