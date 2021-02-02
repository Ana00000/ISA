<template>
    <v-container class="blue lighten-4">
        <v-layout column>
            <div>
                <router-link class="link" to="/clients">Clients</router-link>
            </div>
            <div >
                <router-link class="link" to="/consultationsInfo">Consultations info</router-link>
            </div>
            <div>
                <router-link class="link" to="/workingSchedule">Working schedule</router-link>
            </div>
            <div>
                <router-link class="link" to="/prescriptions">Prescriptions</router-link>
            </div>
            <div>
                <router-link class="link" to="/vacationsAndAbsences">Vacations and absences</router-link>
            </div>
            <div>
                <router-link class="link" to="/profileOfPharmacist">Profile</router-link>
            </div>
            <div>
                <router-link class="link" to="/scheduleConsultation">Schedule consultation</router-link>
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
    display: inline-block;
    max-width: 250px;
    margin-bottom: 30px;
    justify-content: center;
    display: inline-flex;
}

.link {
    color: whitesmoke;
    text-decoration: snow;
    font-weight: bolder;
    font-size: 25px;
}
</style>