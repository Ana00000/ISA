<template>
    <div style="
        background: #13077d;
        background: -webkit-linear-gradient(to right, #5442ed, #cdc8fa, #13077d);
        background: linear-gradient(to right, #5442ed, #cdc8fa, #13077d);"> 
        <div class="searchDiv">
            <br/>
            <div>
                <h1 class="display-2">You can find your clients here!</h1>
            </div>
            <div class="welcoming">For search enter name and/or surname.</div>
            <br/>

            <v-container>
                <v-layout row wrap>
                <v-card 
                    v-bind:class="{'cardClass':drawer}" width="15%" height="410px">
                    <div class="sort">
                    <h2>Sort by</h2>
                    </div>
                    <v-divider/>
                    <v-radio-group v-model="sortOption" column>
                        <v-radio class="optionButtons" value="name" label="Name" color="#aba7ff"/>
                        <v-radio class="optionButtons" value="lastName" label="Last name" color="#aba7ff"/>
                        <v-radio class="optionButtons" value="phoneNumber" label="Phone number" color="#aba7ff"/>
                        <v-radio class="optionButtons" value="address" label="Address" color="#aba7ff"/>
                        <v-radio class="optionButtons" value="email" label="Email" color="#aba7ff"/>
                        <v-radio class="optionButtons" value="startTime" label="Date of appointment" color="#aba7ff"/>
                    </v-radio-group>
                    <br/><br/>
                    <v-btn v-on:click="sortClients" 
                        color="#aba7ff"
                        elevation="24"
                        x-large
                        raised
                        rounded>
                            Sort
                    </v-btn>
                </v-card>

                <v-card
                    class="mx-auto" style="width: 59%; height: 300px; overflow-y: scroll">
                    <v-toolbar
                    color="#13077d" dark>
                    </v-toolbar>
                    <v-list two-line>
                    <v-list-item-group
                        active-class="indigo--text"
                        multiple>
                        <template v-for="(client, id) in clients">
                        <v-list-item :key="client.id">
                            <template>  
                            <v-list-item-content>
                                <v-list-item-subtitle v-text="client.name+' '+client.lastName+', '+client.phoneNumber+', '+client.address+', '+client.email"></v-list-item-subtitle>
                            </v-list-item-content>
                            </template>
                        </v-list-item>
                        <v-divider v-if="`A-${id}` <clients.length-1" :key="`A-${id}`"/>
                        </template>
                    </v-list-item-group>
                    </v-list>
                </v-card>

                <v-card
                    class="mx-auto" style="width: 20%; height: 300px; overflow-y: scroll">
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
                        active-class="indigo--text"
                        multiple>
                        <template v-for="(client, id) in clients">
                        <v-list-item :key="client.id">
                            <template>  
                            <v-list-item-content>
                                <v-list-item-subtitle v-text="client.name+' '+client.lastName"></v-list-item-subtitle>
                            </v-list-item-content>
                            </template>
                        </v-list-item>
                        <v-divider v-if="`B-${id}` <clients.length-1" :key="`B-${id}`"/>
                        </template>
                    </v-list-item-group>
                    </v-list>
                </v-card>
                </v-layout>
                </v-container>

                <v-container>
                <v-layout row wrap>
                    <v-card
                        style="width: 55%; height: 300px; overflow-y: scroll" class="allCons">
                        <v-toolbar
                        color="#13077d" dark>
                        </v-toolbar>
                        <v-list two-line>
                        <v-list-item-group
                            active-class="indigo--text">
                            <template v-for="(consultation, id) in consultations">
                            <v-list-item :key="consultation.id" :value="consultation">
                                <template>  
                                <v-list-item-content>
                                    <v-list-item-subtitle v-text="'Appointment id: '+consultation.id + ', Patient: ' +consultation.patient.name+' '+consultation.patient.lastName"/>
                                    <v-list-item-subtitle v-text="'Start time: '+new Date(consultation.startTime)"></v-list-item-subtitle>
                                    <v-list-item-subtitle v-text="'End time: '+new Date(consultation.endTime)"></v-list-item-subtitle>
                                </v-list-item-content>
                                </template>
                            </v-list-item>
                            <v-divider v-if="`C-${id}` <consultations.length-1" :key="`C-${id}`"/>
                            </template>
                        </v-list-item-group>
                        </v-list>
                    </v-card>
                </v-layout>
                </v-container>
                
        </div>
        <div>
            <PharmacistMenu/>
        </div>
    </div>  
</template>

<script>
import axios from 'axios';
import PharmacistMenu from '../../components/pharmacist/PharmacistMenu.vue'
export default {
    name: 'PharmacistClients', 
    components : {   
        PharmacistMenu
    },   
    data: () => ({
      sortOption: 'name',
      searchInput: null,
      clients: [],
      clientsCopy : [],
      consultations: [],
      doctor: null
    }),
    watch: {
      selectedsortOption: function(newSortOption)
      {
        this.$dispatch('sortOption', newSortOption)
      }
    },
    mounted() {
        this.init();
    },
    methods: {
      init() {
          var tokenString = '';
          tokenString = localStorage.getItem("token");
          const config = {
            headers: {Authorization: `Bearer ${tokenString}`}
          };
          
          this.$http.get('http://localhost:8081/doctors/findLoggedDoctor', config
          ).then(resp => {
              this.doctor = resp.data
              this.getClients();
              this.getCons();
          }).catch(console.log);
      },
      getClients() {
          axios.get('http://localhost:8081/appointments/patientsFromDoneAppointmentsByDoctor/' + this.doctor.id)
            .then(res => {
              this.clients = res.data;
              this.clientsCopy = res.data
            })
            .catch(err => console.log(err));
      },
      getCons() {
         axios.get('http://localhost:8081/appointments/appointmentsOfPatientsByDoctor/' + this.doctor.id)
                .then(res => {
                this.consultations = res.data;
            })
          .catch(err => console.log(err));
      },
      searchQuery() {
        var resultOfSearch = [];
        for(var i = 0; i < this.clientsCopy.length; i++) {
          var fullName = this.clientsCopy[i].lastName + ' ' + this.clientsCopy[i].name;
          var fullNameReverse = this.clientsCopy[i].name + ' ' + this.clientsCopy[i].lastName;
          if(fullName.toLowerCase().includes(this.searchInput.toLowerCase()) || fullNameReverse.toLowerCase().includes(this.searchInput.toLowerCase()))
                resultOfSearch.push(this.clientsCopy[i])
        }
        this.clients = resultOfSearch;
      },
      sortClients() {
        if(this.sortOption == 'name'){
          this.clients.sort(function(a, b){
            return a.name.localeCompare(b.name);
          })
        }else if(this.sortOption == 'lastName'){
          this.clients.sort(function(a, b){
            return a.lastName.localeCompare(b.lastName);
          })
        }else if(this.sortOption == 'phoneNumber'){
          this.clients.sort(function(a, b){
            return a.phoneNumber.localeCompare(b.phoneNumber);
          })
        }else if(this.sortOption == 'address'){
        this.clients.sort(function(a, b){
          return a.address.localeCompare(b.address);
        })
        }else if(this.sortOption == 'email'){
          this.clients.sort(function(a, b){
            return a.email.localeCompare(b.email);
          })
        }else if(this.sortOption == 'startTime'){
                return this.consultations.sort((a, b) => new Date(a.startTime) - new Date(b.startTime))
        }
      }
    }
  }
</script>

<style scoped>
.sort {
  padding-top: 15px;
  padding-bottom: 15px;
}

.optionButtons {
  padding-top: 10px;
  padding-bottom: 10px;
  padding-left: 35px;
}

.cardClass {
  display: none; 
}

.template {
    min-height: 1000px;
}

.allCons {
    position: absolute;
    right: 500px;
    top: 490px;
}

.welcoming {
    font-weight: bolder;
    font-size: 25px;
}

.searchDiv {
     height: 840px; 
}
</style>
