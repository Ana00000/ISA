<template>
  <div>
<SystemAdminMenu/>
  <v-card width="400" class="mx-auto mt-5" color="white">
    <v-card-title class="justify-center">
      <h1 class="display-1 ">Change password </h1>
      <p>(this is first login)</p>
    </v-card-title>
    <v-card-text>
      <v-form class="mx-auto ml-5 mr-5">
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
      </v-form>
    </v-card-text>
    <v-card-actions class="justify-center mb-5">
      <v-btn color="info mb-5" v-on:click="editPassword">
        Submit
      </v-btn>
    </v-card-actions>
  </v-card>
  </div>
</template>

<script>
export default {
    data: () => ({
    showPassword: false,
    password: '',
    password2:'',
  }),
  methods:{
    editPassword(){
      if(this.password!==this.password2){
        console.log("Password must match");
        this.password="";
        this.password2="";
        return;
      }

      var tokenString = '';
      tokenString = localStorage.getItem("token");
      const config = {
              headers: {Authorization: `Bearer ${tokenString}`}
      };
      this.$http.post('http://localhost:8081/supplier/editPassword/'+this.password, null, config)
      .then(resp => {
          console.log(resp.data);
          alert("Successfully edited !")
          window.location.href = 'http://localhost:8080/supplierHomePage';
      })
      .catch(er => {
          console.log('Error while editing system admin');
          console.log(er.response.data);
      })
    },
  },
}
</script>

<style>

</style>