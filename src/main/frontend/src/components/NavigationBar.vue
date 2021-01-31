<template>
    <span>
        <v-navigation-drawer app temporary v-model="drawer" class="indigo" dark disable-resize-watcher>
            <v-list>
                <template v-for="(item, index) in items">
                    <v-list-tile :key="index">
                        <v-list-tile-content>
                            <v-card height="50px">
                                <h3>{{item.title}}</h3>
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
            <v-btn flat class="hidden-sm-and-down" @click="drawer = !drawer">Menu</v-btn>
            <v-spacer class="hidden-sm-and-down"></v-spacer>
            <v-btn flat class="hidden-sm-and-down"><router-link class="router" to="/login">Login</router-link></v-btn>
            <v-btn color="brown lighten-3" class="hidden-sm-and-down"><router-link class="router" to="/register">Register</router-link></v-btn>
        </v-toolbar>
    </span>
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
            appTitle: 'Pharmacy',
            drawer: false,
            items: [
                { title: 'About' },
                { title: 'Services' },
                { title: 'Clients' },
                { title: 'Contacts' }
            ]
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