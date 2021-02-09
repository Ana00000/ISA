<template>
    <v-container class="indigo ma-0" fluid fill-width>
        <v-layout type>
            <div>
                <router-link class="link" to="/pharmacistHomePage">Home page</router-link>
            </div>
            <div>
                <router-link class="link" to="/pharmacistHomePage/clients">Clients</router-link>
            </div>
            <div >
                <router-link class="link" to="/pharmacistHomePage/consultationsInfo/:id">Consultations info</router-link>
            </div>
            <div>
                <router-link class="link" to="/pharmacistHomePage/workingSchedule/:id">Working schedule</router-link>
            </div>
            <div>
                <router-link class="link" to="/pharmacistHomePage/prescriptions">Prescriptions</router-link>
            </div>
            <div>
                <router-link class="link" to="/pharmacistHomePage/vacationsAndAbsences/:id">Vacations and absences</router-link>
            </div>
            <div>
                <router-link class="link" to="/pharmacistHomePage/profile/:id">Profile</router-link>
            </div>
            <div>
                <router-link class="link" to="/pharmacistHomePage/scheduleConsultation/:id">Schedule consultation</router-link>
            </div>
        </v-layout>
    </v-container>
</template>

<script>
export default {
    name : 'PharmacistMenu'
}
</script>

<style scoped>
div {
    width: max-content;
    margin-left: 25px;
    margin-right: 25px;
    display: inline-block;
}

.link {
    color: whitesmoke;
    text-decoration: snow;
    font-weight: bolder;
    font-size: 25px;
}
</style>