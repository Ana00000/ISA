<template>
    <v-container class="pink lighten-2 white--text">
        <v-layout style="padding:0px" column>
            <div>
                <router-link class="link" to="/patientPharmacies">Pharmacies</router-link>
            </div>
            <div >
                <router-link class="link" to="/patientAppointmentHistory">Appointment history</router-link>
            </div>
            <div>
                <router-link class="link" to="/patientScheduledAppointments">Scheduled appointments</router-link>
            </div>
            <div>
                <router-link class="link" to="/pharmacies">eRecipes</router-link>
            </div>
            <div>
                <router-link class="link" to="/pharmacies">Reserved medicine</router-link>
            </div>
            <div>
                <router-link class="link" to="/pharmacies">Penalty insight</router-link>
            </div>
            <div>
                <router-link class="link" to="/pharmacies">Issued medicine</router-link>
            </div>
            <div>
                <router-link class="link" to="/pharmacies">Promotions</router-link>
            </div>
            <div>
                <router-link class="link" to="/pharmacies">Write a complaint</router-link>
            </div>
            <div>
                <router-link class="link" to="/pharmacies">Reserve medicine</router-link>
            </div>
            <div>
                <router-link class="link" to="/pharmacies">Schedule appointment</router-link>
            </div>
            <div>
                <router-link class="link" to="/pharmacies">Profile</router-link>
            </div>
        </v-layout>
    </v-container>
</template>

<script>
export default {
    name : 'PatientMenu'
}
</script>

<style scoped>
div {
    margin-bottom: 20px;
    justify-content: center;
    display: flex;
}

.link {
    color: white;
    text-decoration: none;
    font-weight: bold;
    font-size: 30px;
}

.menuDiv {
}
</style>