<template>
  <v-container class="indigo ma-0" fluid fill-width>
        <v-layout type>
            <div/>
            <div>
                <router-link class="link" to="/systemAdminHomePage">Home page</router-link>
            </div>
            <div>
                <router-link class="link" to="/systemAdminHomePage/addPharmacy">Add pharmacy</router-link>
            </div>
            <div>
                <router-link class="link" to="/systemAdminHomePage/addPharmacyAdmin">Add pharmacy admin</router-link>
            </div>
            <div/>
        </v-layout>
    </v-container>
</template>

<script>
export default {
    name : 'SystemAdminMenu'
}
</script>

<style scoped>
div {
    width: max-content;
    margin-left: 30px;
    margin-right: 30px;
    display: inline-block;
}

.link {
    color: whitesmoke;
    text-decoration: snow;
    font-weight: bolder;
    font-size: 25px;
}
</style>