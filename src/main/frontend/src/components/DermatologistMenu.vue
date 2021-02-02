<template>
    <v-container class="indigo ma-0" fluid fill-width>
        <v-layout type>
            <div>
                <router-link class="link" to="/dermatologistHomePage/clients">Clients</router-link>
            </div>
            <div >
                <router-link class="link" to="/dermatologistHomePage/examinationsInfo">Examinations info</router-link>
            </div>
            <div>
                <router-link class="link" to="/dermatologistHomePage/workingSchedule">Working schedule</router-link>
            </div>
            <div>
                <router-link class="link" to="/dermatologistHomePage/vacationsAndAbsences">Vacations and absences</router-link>
            </div>
            <div>
                <router-link class="link" to="/dermatologistHomePage/profile">Profile</router-link>
            </div>
            <div>
                <router-link class="link" to="/dermatologistHomePage/scheduleExamination">Schedule examination</router-link>
            </div>
        </v-layout>
    </v-container>
</template>

<script>
export default {
    name : 'DermatologistMenu'
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