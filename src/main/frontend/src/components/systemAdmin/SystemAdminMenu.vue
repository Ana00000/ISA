<template>
  <v-container class="containerClass">
        <v-container >
            <v-col >
                <v-row no-gutters> 
                    <router-link class="link" to="/systemAdminHomePage">Home page</router-link>
                </v-row>
                <v-row no-gutters>
                    <router-link class="link" to="/systemAdminHomePage/addPharmacy">Add pharmacy</router-link>
                </v-row>
                <v-row>
                    <router-link class="link" to="/systemAdminHomePage/addPharmacyAdmin">Add pharmacy admin</router-link>
                </v-row>
                <v-row>
                    <router-link class="link" to="/systemAdminHomePage/addDermatologist">Add dermatologist</router-link>
                </v-row>
                <v-row>
                    <router-link class="link" to="/systemAdminHomePage/addSupplier">Add supplier</router-link>
                </v-row>
                <v-row>
                    <router-link class="link" to="/systemAdminHomePage/addMedicine">Add medicine</router-link>
                </v-row>
                <v-row>
                    <router-link class="link" to="/systemAdminHomePage/complaintments">Answer on complaintments</router-link>
                </v-row>
            </v-col>
            <v-col>
            </v-col>
            
        </v-container>
    </v-container>
</template>

<script>
export default {
    name : 'SystemAdminMenu'
}
</script>

<style scoped>
/* div {
    margin-bottom: 30px;
    justify-content: center;
    display: flex;
}

.link {
    color: white;
    text-decoration: none;
    font-weight: bold;
    font-size: 30px;
} */
.containerClass{
    width: 2%;
    margin-right: 100%;
    font-size: 32px;
}

</style>