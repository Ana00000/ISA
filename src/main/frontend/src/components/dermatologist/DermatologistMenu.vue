<template>
    <v-container class="indigo ma-0" fluid fill-width>
        <v-layout type>
            <div/>
            <div>
                <router-link class="link" to="/dermatologistHomePage">Home page</router-link>
            </div>
            <div>
                <router-link class="link" to="/dermatologistHomePage/clients/:id">Clients</router-link>
            </div>
            <div >
                <router-link class="link" to="/dermatologistHomePage/examinationsInfo/:id">Examinations info</router-link>
            </div>
            <div>
                <router-link class="link" to="/dermatologistHomePage/workingSchedule/:id">Working schedule</router-link>
            </div>
            <div>
                <router-link class="link" to="/dermatologistHomePage/vacationsAndAbsences/:id">Vacations and absences</router-link>
            </div>
            <div>
                <router-link class="link" to="/dermatologistHomePage/profile/:id">Profile</router-link>
            </div>
            <div>
                <router-link class="link" to="/dermatologistHomePage/scheduleExamination/:id">Schedule examination</router-link>
            </div>
            <div/>
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