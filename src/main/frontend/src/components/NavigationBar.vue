<template>
    <!-- <v-toolbar app dark class="indigo">
        <v-toolbar-side-icon class="hidden-md-and-up" @click="drawer = !drawer"></v-toolbar-side-icon>
        <v-spacer class="hidden-md-and-up"></v-spacer>
        <v-toolbar-title>{{appTitle}}</v-toolbar-title>
        <v-btn flat class="hidden-sm-and-down">Menu</v-btn>
        <v-spacer class="hidden-sm-and-down"></v-spacer>
        <v-btn flat class="hidden-sm-and-down">SIGN IN</v-btn>
        <v-btn color="brown lighten-3" class="hidden-sm-and-down">JOIN</v-btn>
    </v-toolbar> -->
    <div class="nav">
        <div class="nav1 justify-center" >
            <div class="nav1 justify-center">
                <h2><router-link to="/" class="display-1">Home</router-link></h2>
            </div>
            <div class="nav1 justify-center">
                <h2><router-link to="/about" class="display-1">About</router-link></h2>
            </div>
        </div>
          <v-card-title class="nav1-mid justify-center">
            <img src="../assets/logo.jpg" alt="Nije ucitao" width="60" height="45" />
            <h1 class="display-1">Pharmacy system</h1>
            <img src="../assets/logo.jpg" alt="Nije ucitao" width="60" height="45" />
          </v-card-title>
        <div class="nav1">
            <div class="nav1">
            <h2><router-link to="/login" class="display-1">Login</router-link></h2>
            </div>
            <div class="nav1">
            <h2><router-link to="/register" class="display-1">Register</router-link></h2>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'NavigationBar',
    props: {
        msg: String
    },
    data() {
        return {
            cat: 'Cat',
            appTitle: 'Pharmacy'
        }
    }
}
</script>

<style scoped>
.nav {
    border: solid black 2px;
}
.nav1 {
    display: inline-block;
    width: 33%;
}

.nav1-mid {
  display: inline-flex;
  width: 34%;
  flex-direction: row;
}
h2 {
    margin: 40px 0 0;
}
a {
    color: #42b983;
}
</style>