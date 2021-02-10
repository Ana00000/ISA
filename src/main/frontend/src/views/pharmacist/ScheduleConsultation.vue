<template>
    <div style="
        background: #13077d;
        background: -webkit-linear-gradient(to right, #5442ed, #cdc8fa, #13077d);
        background: linear-gradient(to right, #5442ed, #cdc8fa, #13077d);">

        <br/>
        <br/>
        <div class="welcoming">Pharmacist you can create new consultations here!</div>
        <br/>
        <br/>

        <v-layout class="startConsultation">
            <v-datetime-picker name="picker1" class="ti" v-model="startTime" min="minDate" label="From"> </v-datetime-picker>
        </v-layout>

        <v-layout class="endConsultation">
            <v-datetime-picker name="picker2" class="ti" v-model="endTime" min="minDate" label="To"> </v-datetime-picker>
        </v-layout>

        <v-combobox :items="patients" :item-text="text" v-model="selectedPatient" :label="label" hint="Choose patient for scheduled consultation." class="comboPatients"/>

        <div class="scheduleButton">
            <v-btn
                v-on:click="scheduleConsultation" 
                color="#aba7ff"
                elevation="24"
                x-large
                raised
                rounded
            >Create</v-btn>
        </div>

        <div class="space"/>
        
        <div>
            <PharmacistMenu/>
        </div> 
    </div>  
</template>

<script>
import PharmacistMenu from '../../components/pharmacist/PharmacistMenu.vue'
export default {
    name: 'ScheduleConsultation',    
    components : {   
        PharmacistMenu
    },
    data: () => ({
        doctor: null,
        startTime: null,
        endTime: null,
        patients: [],
        selectedPatient: null,
        label: 'Patients'
    }),
    mounted() {
        this.init();
    },
    methods: {
        init(){
            this.getDoctor();
            this.getPatients();
        },
        scheduleConsultation() {
            this.validationOfInput();
            this.$http.post('http://localhost:8081/appointments/saveConsultation', 
            {         
                doctor : this.doctor,
                startTime : new Date(this.startTime),
                endTime : new Date(this.endTime),
                patient: this.selectedPatient
            }
            ).then(resp => {
               console.log(resp.data);
                alert("Examination is created.");
            }).catch(err => console.log(err));
        },
        validationOfInput() {
            if(this.endTime == null) {
                alert("End time needs a value!");
                return;
            }else if(this.startTime == null) {
                alert("Start time needs a value!");
                return;
            }else if ((this.startTime > this.endTime)) {
                alert("Start time comes before end time!");
                return;
            }else if(this.startTime < Date.now()) {
                alert("Start time has passed!");
                return;
            }else if(this.endTime < Date.now()) {
                alert("End time has passed!");
                return;
            }else if (this.selectedPatient === null) {
                alert('You did not select a patient.');
                return;
            }
        },
        getDoctor() {
            this.$http.get('http://localhost:8081/pharmacists/' + this.$route.params.id).then(resp => {
                this.doctor = resp.data;
            }).catch(err => console.log(err));
        },
        getPatients() {
            this.$http.get('http://localhost:8081/appointments/upcomingPatients/' + this.$route.params.id).then(resp => {
                resp.data.forEach(patient => {
                    this.patients.push(patient);
                });
            }).catch(err => console.log(err));
        },
        text: item => item.name + ' ' + item.lastName
    }
}
</script>


<style scoped>
.welcoming {
    font-weight: bolder;
    font-size: 25px;
    height: 100px;
}

.startConsultation {
    position: absolute;
    left: 900px;
    top: 300px;
}

.endConsultation {
    position: absolute;
    left: 1300px;
    top: 300px;
}

.comboPatients { 
    position: absolute;
    left: 450px;
    top: 300px;
}

.scheduleButton {
    position: absolute;
    left: 900px;
    top: 500px;
}

.space {
    height: 644px;
}
</style>