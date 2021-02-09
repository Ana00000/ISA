<template>
    <div style="
        background: #13077d;
        background: -webkit-linear-gradient(to right, #5442ed, #cdc8fa, #13077d);
        background: linear-gradient(to right, #5442ed, #cdc8fa, #13077d);">
        
        <br/>
        <div class="welcoming">Dermatologist you can find examinations info here!</div>
        
        <v-container>
        <v-layout row wrap>
            <v-card
                class="notEmptyExams" style="width: 35%; height: 600px; overflow-y: scroll">
                <v-toolbar
                color="#13077d" dark>
                </v-toolbar>
                <v-list two-line>
                <v-list-item-group
                    active-class="indigo--text">
                    <template v-for="(examination, id) in examinations">
                    <v-list-item :key="examination.id">
                        <template>  
                        <v-list-item-content>
                            <v-list-item-subtitle v-text="'Id: '+examination.id + ' , Patient: '+examination.patient.name + ' ' + examination.patient.lastName"></v-list-item-subtitle>
                            <v-list-item-subtitle v-text="'Start time: '+new Date(examination.startTime)"></v-list-item-subtitle>
                            <v-list-item-subtitle v-text="'End time: '+new Date(examination.endTime)"></v-list-item-subtitle>
                        </v-list-item-content>
                        </template>
                    </v-list-item>
                    <v-divider v-if="id <examinations.length-1" :key="id"/>
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
                    <template v-for="(examination, id) in examinations">
                    <v-list-item :key="examination.id">
                        <template>  
                        <v-list-item-content>
                            <v-list-item-subtitle v-text="examination.id"></v-list-item-subtitle>
                        </v-list-item-content>
                        </template>
                    </v-list-item>
                    <v-divider v-if="id <examinations.length-1" :key="id"/>
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
            <DermatologistMenu/>
        </div> 
    </div>  
</template>

<script>
import axios from 'axios';
import DermatologistMenu from '../../components/dermatologist/DermatologistMenu.vue'
export default {
    name: 'ExaminationsInfo',   
    components : {   
        DermatologistMenu
    },
    data: () => ({
      searchInput: null,
      examinations: [],
      examinationsCopy : [],
      doctor: []
    }),
    mounted() {
        this.init();
    },
    created(){
        axios.get('http://localhost:8081/appointments/allNotEmptyExaminations/' + this.$route.params.id)
            .then(res => {
              this.examinations = res.data;
              this.examinationsCopy = res.data
            })
            .catch(err => console.log(err));
    },
    methods: {
        init() {
            this.getDoctor();
        },
        searchQuery() {
            var resultOfSearch = [];
                for(var i = 0; i < this.examinationsCopy.length; i++) {
                    var id = '' + this.examinationsCopy[i].id;
                    var input = '' + this.searchInput;
                if(id.includes(input)){
                    resultOfSearch.push(this.examinationsCopy[i]);
                }
            }
            this.examinations = resultOfSearch;
        },
        makeReport() {
            this.$http.post('http://localhost:8081/reports/saveReport', 
            {         
                doctor : this.doctor,
                startTime: new Date(1610545800000),
                endTime: new Date(1610545800000)
            }
            ).then(resp => {
            console.log(resp.data);
                alert("Report is formed.");
            }).catch(err => console.log(err));
        },
        getDoctor() {
            this.$http.get('http://localhost:8081/dermatologists/' + this.$route.params.id).then(resp => {
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

.notEmptyExams {
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