<template>
    <span>
        <v-navigation-drawer app temporary v-model="drawer" class="indigo" dark disable-resize-watcher>
            <v-list>
                <template v-for="(item, index) in items">
                    <v-list-tile :key="index" >
                        <v-list-tile-content>
                            <v-card height="35px" class="ma-1 text-sm-button text-center">
                                <router-link class="router" :to="item.path">{{item.title}}</router-link>
                            </v-card>
                        </v-list-tile-content>
                    </v-list-tile>
                    <v-divider :key="`divider-${index}`"></v-divider>
                </template>
            </v-list>
        </v-navigation-drawer>
        <v-toolbar app dark class="indigo">
            <v-app-bar-nav-icon class="hidden-md-and-up" @click="drawer = !drawer"></v-app-bar-nav-icon>
            <v-spacer class="hidden-md-and-up"></v-spacer>
            <v-toolbar-title><router-link class="router" to="/">{{appTitle}}</router-link></v-toolbar-title>
            <v-btn text class="hidden-sm-and-down ma-1" @click="drawer = !drawer">Menu</v-btn>
            <v-spacer class="hidden-sm-and-down"></v-spacer>
            <div  v-if="!isLogged">
                <v-btn text class="hidden-sm-and-down">
                  <router-link class="router" to="/login">Login</router-link>
                </v-btn>
            </div>
            <div v-else>
                <v-btn text class="hidden-sm-and-down" v-on:click="logoff">Logoff</v-btn>
            </div>
            <div v-if="!isLogged">
                <v-btn color="brown lighten-3" class="hidden-sm-and-down ma-1">
                  <router-link class="router" to="/register">Register</router-link>
                </v-btn>
            </div>
            <div v-else>
                <v-btn color="brown lighten-3" class="hidden-sm-and-down ma-1" v-on:click="profileFun">
                  Profile
                </v-btn>
            </div>

        </v-toolbar>
    </span>
</template>

<script>
export default {
    name: 'NavigationBar',
    props: {
        msg: String
    },
    computed:{
        isLogged: function(){
            var token = localStorage.getItem("token");
            return token !== "";
        },
        
    },
    data() {
        return {
            cat: 'Cat',
            appTitle: 'Pharmacy',
            drawer: false,
            isUserLogged:false,
            items: [
                { title: 'Search Pharmacies', path: '/' },
                { title: 'Search Medicine', path: '/searchMedicine' },
                { title: 'Clients', path: '/' },
                { title: 'Contacts', path: '/' }
            ]
        }
    },
    methods:{
      logoff() {
        localStorage.setItem("token","");
        window.location.href = "http://localhost:8080/login";
      },
      profileFun() {
        var tokenString= '';
        tokenString = localStorage.getItem("token");

        const config = {
          headers: { Authorization: `Bearer ${tokenString}` }
        };

        this.$http.get('http://localhost:8081/users/redirectMeToMyHomePage', config)
        .then(resp => {
          window.location.href = resp.data;
        })
        .catch(err => {
          alert('Profile error');
          console.log(err.response.data);
        })

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

.router {
    text-decoration: none;
    color: white;
}
</style>