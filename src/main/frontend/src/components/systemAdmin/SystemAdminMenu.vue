<template>
  <v-container class="mainContainer">
        <!-- <v-layout >
            <div class="firstDiv">
                <div class="divBelow"> 
                    <router-link class="link" to="/systemAdminHomePage">Home page</router-link>
                </div>
                <div class="divBelow">
                    <router-link class="link" to="/systemAdminHomePage/addPharmacy">Add pharmacy</router-link>
                </div>
                <div class="divBelow">
                    <router-link class="link" to="/systemAdminHomePage/addPharmacyAdmin">Add pharmacy admin</router-link>
                </div>
                <div class="divBelow"> 
                    <router-link class="link" to="/systemAdminHomePage/addDermatologist">Add dermatologist</router-link>
                </div>
                <div class="divBelow">
                    <router-link class="link" to="/systemAdminHomePage/addSupplier">Add supplier</router-link>
                </div>
                <div class="divBelow">
                    <router-link class="link" to="/systemAdminHomePage/addMedicine">Add medicine</router-link>
                </div>
                <div class="divBelow">
                    <router-link class="link" to="/systemAdminHomePage/complaintments">Answer on complaintments</router-link>
                </div>
            </div> -->
            <v-menu
            top
            :offset-y="true"
            >
            <template v-slot:activator="{ on, attrs }">
                <v-btn
                color="primary"
                dark
                v-bind="attrs"
                v-on="on"
                >
                System admin menu
                </v-btn>
            </template>

            <v-list>
                <v-list-item>
                    <router-link class="link" to="/systemAdminHomePage">Home page</router-link>
                </v-list-item>
                <v-list-item>
                    <router-link class="link" to="/systemAdminHomePage/addPharmacy">Add pharmacy</router-link>
                </v-list-item>
                <v-list-item>
                    <router-link class="link" to="/systemAdminHomePage/addPharmacyAdmin">Add pharmacy admin</router-link>
                </v-list-item>
                <v-list-item>
                    <router-link class="link" to="/systemAdminHomePage/addDermatologist">Add dermatologist</router-link>
                </v-list-item>
                <v-list-item>
                    <router-link class="link" to="/systemAdminHomePage/addSupplier">Add supplier</router-link>
                </v-list-item>
                <v-list-item>
                    <router-link class="link" to="/systemAdminHomePage/addMedicine">Add medicine</router-link>
                </v-list-item>
                <v-list-item>
                    <router-link class="link" to="/systemAdminHomePage/complaintments">Answer on complaintments</router-link>
                </v-list-item>
                <v-list-item>
                    <router-link class="link" to="/systemAdminHomePage/LoyaltyProgram">Loyalty program</router-link>
                </v-list-item>
                <v-list-item>
                    <router-link class="link" to="/systemAdminHomePage/AddSystemAdmin">Add system admin</router-link>
                </v-list-item>
                
            </v-list>
            </v-menu>
            <br/>
        <!-- </v-layout> -->
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