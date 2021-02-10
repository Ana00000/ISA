<template>
    <div style="
        background: #13077d;
        background: -webkit-linear-gradient(to right, #5442ed, #cdc8fa, #13077d);
        background: linear-gradient(to right, #5442ed, #cdc8fa, #13077d);">
        
        <br/>
        <div class="welcoming">Pharmacist you can find consultations info here!</div>
        
        <v-container>
        <v-layout row wrap>
            <v-card
                class="notEmptyCons" style="width: 35%; height: 600px; overflow-y: scroll">
                <v-toolbar
                color="#13077d" dark>
                </v-toolbar>
                <v-list two-line>
                <v-list-item-group
                    active-class="indigo--text">
                    <template v-for="(consultation, id) in consultations">
                    <v-list-item :key="consultation.id">
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
                class="notEmptyIds" style="width: 10%; height: 600px; overflow-y: scroll">
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
                    <v-divider v-if="id <consultations.length-1" :key="id"/>
                    </template>
                </v-list-item-group>
                </v-list>
            </v-card>
        </v-layout>
        </v-container>

        <div class="reportButton">
            <v-btn
                v-on:click="makeReport" 
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
      doctor: []
    }),
    mounted() {
        this.init();
    },
    created(){
        axios.get('http://localhost:8081/appointments/allNotEmptyConsultations/' + this.$route.params.id)
            .then(res => {
              this.consultations = res.data;
              this.consultationsCopy = res.data
            })
            .catch(err => console.log(err));
    },
    methods: {
        init() {
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
            this.$http.post('http://localhost:8081/reports/saveReport', 
            {         
                doctor : this.doctor,
                startTime: new Date(2021, 10, 14),
                endTime: new Date(2021, 10, 15)
            }
            ).then(resp => {
            console.log(resp.data);
                alert("Report is formed.");
            }).catch(err => console.log(err));
        },
        getDoctor() {
            this.$http.get('http://localhost:8081/pharmacists/' + this.$route.params.id).then(resp => {
                this.doctor = resp.data;
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

.reportButton {
    position: absolute;
    right: 550px;
    top: 300px;
}

.notEmptyCons {
    left: 20px;
    top: 0px;
    height: 500px;
}

.notEmptyIds {
    left: 70px;
    top: 0px;
    height: 500px;
}

.space {
    height: 116px;
}
</style>