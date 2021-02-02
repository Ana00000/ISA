<template>
    <v-container class="blue ma-0" fluid fill-width>
        <v-layout type>
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