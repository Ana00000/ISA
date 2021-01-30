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
        <v-btn color="success" class="mx-auto mb-5">
          Login
        </v-btn>
      </v-card-actions>
    </v-card>
    
    
</template>

<script>

export default {
  name: 'Login',
  data: () => ({
    showPassword: false,
    username: '',
    password: '',
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