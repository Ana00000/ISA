<template>
    <div style="
        background: #13077d;
        background: -webkit-linear-gradient(to right, #5442ed, #cdc8fa, #13077d);
        background: linear-gradient(to right, #5442ed, #cdc8fa, #13077d);">
        <br/>
        <div class="welcoming">Dermatologist you can find your empty examinations here, and even create new ones!</div>
        <br/>
        <v-card
            class="emptyExams" style="width: 35%; overflow-y: scroll">
            <v-toolbar
            color="#13077d" dark>
            </v-toolbar>
            <v-list two-line>
            <v-list-item-group
                v-model="selected"
                active-class="indigo--text">
                <template v-for="(examination, id) in emptyExaminations">
                <v-list-item :key="examination.id">
                    <template>  
                    <v-list-item-content>
                        <v-list-item-subtitle v-text="'Price: ' +examination.price+' dollars'"></v-list-item-subtitle>
                        <v-list-item-subtitle v-text="'Start time: '+ new Date(examination.startTime)"></v-list-item-subtitle>
                        <v-list-item-subtitle v-text="'End time: '+new Date(examination.endTime)"></v-list-item-subtitle>
                    </v-list-item-content>
                    </template>
                </v-list-item>
                <v-divider v-if="id <emptyExaminations.length-1" :key="id"/>
                </template>
            </v-list-item-group>
            </v-list>
        </v-card>

        <v-layout class="startExamination">
            <v-datetime-picker name="picker1" class="ti" v-model="startTime" min="minDate" label="From"> </v-datetime-picker>
        </v-layout>

        <v-layout class="endExamination">
            <v-datetime-picker name="picker2" class="ti" v-model="endTime" min="minDate" label="To" > </v-datetime-picker>
        </v-layout>

        <v-combobox :items="patients" v-model="selectedPatient" />

        <div class="scheduleButton">
            <v-btn
                v-on:click="scheduleExamination" 
                color="#aba7ff"
                elevation="24"
                x-large
                raised
                rounded
            >Create</v-btn>
        </div>

        <div class="space"/>
        
        <div>
            <DermatologistMenu/>
        </div> 
    </div>  
</template>

<script>
import axios from 'axios';
import DermatologistMenu from '../../components/dermatologist/DermatologistMenu.vue'
export default {
    name: 'ScheduleExamination',    
    components : {   
        DermatologistMenu
    },
    data: () => ({
        emptyExaminations: [],
        doctor: null,
        startTime: null,
        endTime: null,
        patients: [],
        selectedPatient: null
    }),
    mounted() {
        this.init();
    },
    created(){
       axios.get('http://localhost:8081/appointments/allEmptyExaminations/' + this.$route.params.id)
            .then(res => {
              this.emptyExaminations = res.data;
            })
            .catch(err => console.log(err));
    },
    methods: {
        init(){
            this.getDoctor();
            this.getPatients();
        },
        scheduleExamination() {
            this.validationOfInput();
            this.$http.post('http://localhost:8081/appointments/saveExamination', 
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
            this.$http.get('http://localhost:8081/dermatologists/' + this.$route.params.id).then(resp => {
                this.doctor = resp.data;
            }).catch(err => console.log(err));
        },
        getPatients() {
            this.$http.get('http://localhost:8081/appointments/upcomingPatients/' + this.$route.params.id).then(resp => {
                resp.data.forEach(patient => {
                    //this.patients.push(patient.name+' '+patient.lastName);
                    this.patients.push(patient);
                });
            }).catch(err => console.log(err));
        }
    }
}
</script>


<style scoped>
.welcoming {
    font-weight: bolder;
    font-size: 25px;
    height: 100px;
}

.emptyExams {
    left: 150px;
    top: 0px;
    height: 500px;
}

.startExamination {
    position: absolute;
    right: 550px;
    top: 300px;
}

.endExamination {
    position: absolute;
    right: 550px;
    top: 350px;
}

.scheduleButton {
    position: absolute;
    right: 585px;
    top: 500px;
}

.space {
    height: 192px;
}
</style>