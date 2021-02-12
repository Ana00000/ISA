<template>
    <div style="
        background: #13077d;
        background: -webkit-linear-gradient(to right, #5442ed, #cdc8fa, #13077d);
        background: linear-gradient(to right, #5442ed, #cdc8fa, #13077d);">
        
        <br/>
        <label class="welcoming">For selected consultation you can give penal for absence of the patient or create report!</label>
        <div class="welcomingHint">If you choose report than you can add a medicine therapy in it. Therapy is optional!</div>
        <div class="welcomingHint">Double click that button :)</div>
        <br/>
        
        <v-container>
        <v-layout row wrap>
            <v-card
                style="width: 35%; height: 550px; overflow-y: scroll">
                <v-toolbar
                color="#13077d" dark>
                </v-toolbar>
                <v-list two-line>
                <v-list-item-group
                    v-model="selected"
                    active-class="indigo--text">
                    <template v-for="(consultation, id) in consultations">
                    <v-list-item :key="consultation.id" :value="consultation" @mouseover="getMedicines">
                        <template>  
                        <v-list-item-content>
                            <v-list-item-subtitle v-text="'Id: '+consultation.id + ' , Patient: '+consultation.patient.name + ' ' + consultation.patient.lastName"></v-list-item-subtitle>
                            <v-list-item-subtitle v-text="'Start time: '+new Date(consultation.startTime)"></v-list-item-subtitle>
                            <v-list-item-subtitle v-text="'End time: '+new Date(consultation.endTime)"></v-list-item-subtitle>
                        </v-list-item-content>
                        </template>
                    </v-list-item>
                    <v-divider v-if="id <consultations.length-1" :key="id"/>
                    </template>
                </v-list-item-group>
                </v-list>
            </v-card>

             <v-card
                class="notEmptyIds" style="width: 10%; height: 550px; overflow-y: scroll">
                <v-toolbar
                color="#13077d" dark>
                <v-text-field
                    hide-details
                    prepend-icon="mdi-magnify"
                    single-line
                    v-model="searchInput"
                    v-on:keyup="searchQuery()"/>
                </v-toolbar>
                <v-list two-line>
                <v-list-item-group
                    active-class="indigo--text">
                    <template v-for="(consultation, id) in consultations">
                    <v-list-item :key="consultation.id">
                        <template>  
                        <v-list-item-content>
                            <v-list-item-subtitle v-text="consultation.id"></v-list-item-subtitle>
                        </v-list-item-content>
                        </template>
                    </v-list-item>
                    <v-divider v-if="`A-${id}` <consultations.length-1" :key="`A-${id}`"/>
                    </template>
                </v-list-item-group>
                </v-list>
            </v-card>
        </v-layout>
        </v-container>

         <v-container fluid class="descriptionInput" v-on:click="getMedicines">
            <v-row>
            <v-col cols="7"/>
            <v-col cols="3">
                <v-text-field
                    label="Report"
                    v-model="description"
                    hint="Write a description for report only!"
                    color="indigo"/>
            </v-col>
            </v-row>
        </v-container>
        
       <v-container>
        <v-layout row wrap>
            <v-card
                style="width: 35%; height: 350px; overflow-y: scroll" class="comboMedicines">
                <v-list two-line>
                <v-list-item-group
                    v-model="selectedMedicine"
                    active-class="indigo--text">
                    <template v-for="(medicine, id) in medicines">
                    <v-list-item :key="medicine.id" :value="medicine">
                        <template>  
                        <v-list-item-content>
                            <v-list-item-subtitle v-text="'Name: '+medicine.name"/>
                            <v-list-item-subtitle v-text="'Manufacturer: '+medicine.medicineManufacturer.name "/>
                            <v-list-item-subtitle v-text="'Shape: '+medicine.medicineShape.shapeValue "/>
                            <v-list-item-subtitle v-text="'Recipe need: '+medicine.recipeNeed "/>
                        </v-list-item-content>
                        </template>
                    </v-list-item>
                    <v-divider v-if="`B-${id}` <medicines.length-1" :key="`B-${id}`"/>
                    </template>
                </v-list-item-group>
                </v-list>
            </v-card>
        </v-layout>
        </v-container>

        <v-container fluid class="days">
                <v-row>
                <v-col cols="9"/>
                <v-col cols="1">
                    <v-text-field
                        label="Days for therapy"
                        v-model="therapyInDays"
                        hint="Choose number of days for the length of therapy."
                        color="indigo"/>
                </v-col>
                </v-row>
        </v-container>

        <div class="penalButton">
            <v-btn
                v-on:click="givePenal" 
                color="#aba7ff"
                elevation="24"
                x-large
                raised
                rounded
            >Give penal</v-btn>
        </div>

        <div class="reportButton">
            <v-btn
                v-on:click="makeReport" 
                color="#aba7ff"
                elevation="24"
                x-large
                raised
                rounded
            >Create report</v-btn>
        </div>
        
        <div class="space"/>

        <div>
            <PharmacistMenu/>
        </div> 
    </div>  
</template>

<script>
import axios from 'axios';
import PharmacistMenu from '../../components/pharmacist/PharmacistMenu.vue'
export default {
    name: 'ConsultationsInfo',   
    components : {   
        PharmacistMenu
    },
    data: () => ({
        searchInput: null,
        consultations: [],
        consultationsCopy : [],
        doctor: [],
        selected: null,
        patient: [],
        from: null,
        to: null,
        id: null,
        description: null,
        medicines: [],
        selectedMedicine: null,
        therapyInDays: 0,
        pharmacy: null,
        pharmacyMedicine: null
    }),
    mounted() {
        this.init();
    },
    methods: {
        init() {
            this.getCons();
            this.getDoctor();
        },
        searchQuery() {
            var resultOfSearch = [];
                for(var i = 0; i < this.consultationsCopy.length; i++) {
                    var id = '' + this.consultationsCopy[i].id;
                    var input = '' + this.searchInput;
                if(id.includes(input)){
                    resultOfSearch.push(this.consultationsCopy[i]);
                }
            }
            this.consultations = resultOfSearch;
        },
        makeReport() {
            if(this.selected != null) {
                this.patient = this.selected.patient;
                this.from = new Date(this.selected.startTime);
                this.to = new Date(this.selected.endTime);
                this.id =  this.selected.id;
            }else{
                alert("You need to select consultation.");
                return;
            }

            if(this.description == null){
                alert("You need to write a report description.");
                return;
            }

            if(this.selectedMedicine == null & this.therapyInDays != 0){
                alert("For therapy is needed both medicine and length of therapy.");
                return;
            }else if(this.selectedMedicine != null & this.therapyInDays <= 0){
                alert("Therapy length isn't valid.");
                return;
            }

            if(this.selectedMedicine != null & this.therapyInDays != 0){
                this.$http.get('http://localhost:8081/pharmacies/pharmacyByAppointment/' + this.selected.id)
                .then(resp => {
                    this.pharmacy = resp.data;
                }).catch(err => console.log(err));
            
                this.$http.get('http://localhost:8081/pharmacyMedicines/findPharmacyMedicineByMedicine/' + this.selectedMedicine.id)
                .then(resp => {
                    this.pharmacyMedicine = resp.data;
                }).catch(err => console.log(err));
            }

            if(this.selectedMedicine != null & this.therapyInDays != 0){
                if(this.pharmacy.id == this.pharmacyMedicine.pharmacy.id & this.pharmacyMedicine.quantity > 0){
                    alert("Medicine is available!");
                }else if(this.pharmacy.id != this.pharmacyMedicine.pharmacy.id){
                    alert("Medicine is not in current pharmacy. Choose another one!");
                    this.$http.get('http://localhost:8081/pharmacyMedicines/sendMedicineNotification/'+this.pharmacyMedicine.id).then().catch(err => console.log(err));
                    return;
                }else if(this.pharmacyMedicine.quantity < 0){
                    alert("There is no more of this medicine. Choose another one!");
                    this.$http.get('http://localhost:8081/pharmacyMedicines/sendMedicineNotification/'+this.pharmacyMedicine.id).then().catch(err => console.log(err));
                    return;
                }

                this.$http.put('http://localhost:8081/pharmacyMedicines/update', 
                {         
                    id : this.pharmacyMedicine.id,
                    quantity : this.pharmacyMedicine.quantity
                }
                ).then(resp => {
                    console.log(resp.data);
                }).catch(err => console.log(err));
            }

            this.$http.post('http://localhost:8081/reports/saveReport', 
            {         
                doctor : this.doctor,
                startTime: this.from,
                endTime: this.to,
                patient: this.patient,
                description: this.description,
                medicine: this.selectedMedicine,
                therapyInDays: this.therapyInDays
            }).then(resp => {
                console.log(resp.data);
                alert("Report is formed.");
            }).catch(err => console.log(err));

            this.$http.put('http://localhost:8081/appointments/setAppointmentAsDone', 
            {         
                id : this.id
            }).then(resp => {
                console.log(resp.data);
                alert("Appointment is finished.");
            }).catch(err => console.log(err));

            setTimeout(this.getCons, 3000);
        },
        givePenal() {
            if(this.selected != null) {
                this.patient = this.selected.patient;
                this.id =  this.selected.id;
            }else{
                alert("You need to select examination.");
                return;
            }

            this.$http.put('http://localhost:8081/patients/givePenalty', 
            {         
                id : this.patient.id,
                penalties : this.patient.penalties
            }
            ).then(resp => {
                console.log(resp.data);
                alert("Penalty is given.");
            }).catch(err => console.log(err));

            this.$http.put('http://localhost:8081/appointments/setAppointmentAsDone', 
            {         
                id : this.id
            }).then(resp => {
                console.log(resp.data);
                alert("Appointment is closed.");
            }).catch(err => console.log(err));

            setTimeout(this.getCons, 2000);
        },
        getDoctor() {
            this.$http.get('http://localhost:8081/pharmacists/' + this.$route.params.id).then(resp => {
                this.doctor = resp.data;
            }).catch(err => console.log(err));
        },
        getCons() {
             axios.get('http://localhost:8081/appointments/allNotEmptyUpcomingConsultations/' + this.$route.params.id)
            .then(res => {
              this.consultations = res.data;
              this.consultationsCopy = res.data
            })
            .catch(err => console.log(err));
        },
        getMedicines() {
            this.$http.get('http://localhost:8081/medicine/healthyMedicineForPatient/' + this.selected.patient.id).then(resp => {
                this.medicines = resp.data;
            }).catch(err => console.log(err));
        },
        text: item => item.name
    }
}
</script>

<style scoped>
.welcoming {
    font-weight: bolder;
    font-size: 25px;
    height: 100px;
}

.welcomingHint {
    font-weight: bolder;
    font-size: 20px;
    height: 50px;
}

.descriptionInput { 
    position: absolute;
    left: 40px;
    top: 125px;
}

.comboMedicines { 
    position: absolute;
    right: 200px;
    top: 240px;
}

.days {
    position: absolute;
    right: 140px;
    top: 620px;
}

.penalButton {
    position: absolute;
    left: 300px;
    bottom: 100px;
}

.reportButton {
    position: absolute;
    right: 440px;
    bottom: 100px;
}

.notEmptyIds {
    left: 70px;
}

.space {
    height: 81px;
}
</style>