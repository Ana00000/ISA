<template>
  <v-container class="mainContainer">
            <v-menu
            top
            :offset-y="true"
            >
            <template v-slot:activator="{ on, attrs }">
                <v-btn
                color="error"
                dark
                v-bind="attrs"
                v-on="on"
                >
                Supplier menu
                </v-btn>
            </template>

            <v-list>
                <v-list-item>
                    <router-link class="link" to="/supplierHomePage">Home page</router-link>
                </v-list-item>
                <v-list-item>
                    <router-link class="link" to="/supplierHomePage/viewOrders">View orders</router-link>
                </v-list-item>
                <v-list-item>
                    <router-link class="link" to="/supplierHomePage/MyOffers">My offers</router-link>
                </v-list-item>
            </v-list>
            </v-menu>
            <br/>
    </v-container>
</template>

<script>
export default {
    name : 'SystemAdminMenu'
}
</script>

<style scoped>
.divBelow{
    float: left;
    clear: left;
    font-size: 40px;
}
.firstDiv{
    float: left;
}
.mainContainer{
    max-width:220px;
    float:left ; 
    height:100%;
}
.link{
    color: black;
    font-weight: bolder;
}

</style>