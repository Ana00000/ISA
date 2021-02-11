<template>
    <v-container class="pink lighten-3 white--text">
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
                <router-link class="link" to="/patientMedicinePrescriptions">Medicine Prescriptions</router-link>
            </div>
            <div>
                <router-link class="link" to="/patientIssuedMedicine">Issued e-medicine</router-link>
            </div>
            <div>
                <router-link class="link" to="/patientReservedMedicine">Medicine Reservations</router-link>
            </div>
            <div>
                <router-link class="link" to="/patientPenaltyInsight">Penalty insight</router-link>
            </div>
            <div>
                <router-link class="link" to="/patientPromotions">Promotions</router-link>
            </div>
            <div>
                <router-link class="link" to="/patientWriteComplaint">Write a complaint</router-link>
            </div>
            <div>
                <router-link class="link" to="/patientReserveMedicine">Reserve medicine</router-link>
            </div>
            <div>
                <router-link class="link" to="/patientScheduleConsultation">Schedule consultation with pharmacist</router-link>
            </div>
            <div>
                <router-link class="link" to="/patientProfile">Profile</router-link>
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
    margin-bottom: 30px;
    justify-content: center;
    display: flex;
}

.link {
    color: white;
    text-decoration: none;
    font-weight: bold;
    font-size: 30px;
}

.pagePlacing {
    height: 840px;
}

.userImage {
    position: absolute;
    left: 110px;
    top: 150px;
}

.updatePng {
    position: absolute;
    right: 160px;
    top: 100px;
}

.updateButton {
    position: absolute;
    right: 250px;
    top: 600px;
}

.menuDiv {
}
</style>