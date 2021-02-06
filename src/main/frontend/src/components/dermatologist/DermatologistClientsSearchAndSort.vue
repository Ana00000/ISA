<template>
  <v-container>
  <v-layout row wrap>

  <v-card 
    v-bind:class="{'cardClass':drawer}" width="15%" height="410px">
    <div class="sort">
      <h2>Sort by</h2>
    </div>
    <v-divider></v-divider>
    <v-radio-group v-model="sortOption" column>
        <v-radio class="optionButtons" value="name" label="Name"></v-radio>
        <v-radio class="optionButtons" value="lastName" label="Last name"></v-radio>
        <v-radio class="optionButtons" value="phoneNumber" label="Phone number"></v-radio>
        <v-radio class="optionButtons" value="address" label="Address"></v-radio>
        <v-radio class="optionButtons" value="email" label="Email"></v-radio>
        <v-radio class="optionButtons" value="dateOfExamination" label="Date of examination"></v-radio>
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
    class="mx-auto" style="width: 55%; height: 550px; overflow-y: scroll">
    <v-toolbar
      color="#13077d" dark>
      <v-app-bar-nav-icon  @click="drawer = !drawer"/>
    </v-toolbar>
    <v-list two-line>
      <v-list-item-group
        v-model="selected"
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
          <v-divider v-if="id <clients.length-1" :key="id"/>
        </template>
      </v-list-item-group>
    </v-list>
  </v-card>

  <v-card
    class="mx-auto" style="width: 21%; height: 550px; overflow-y: scroll">
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
        v-model="selected"
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
          <v-divider v-if="id <clients.length-1" :key="id"/>
        </template>
      </v-list-item-group>
    </v-list>
  </v-card>

  </v-layout>
  </v-container>
</template>

<script>
import axios from 'axios';
export default {
    data: () => ({
      drawer: false,
      sortOption: 'name',
      searchInput: null,
      clients: [],
      clientsCopy : []
    }),
    created(){
       axios.get('http://localhost:8081/patients/all')
            .then(res => {
              this.clients = res.data;
              this.clientsCopy = res.data
            })
            .catch(err => console.log(err));
    }, 
    watch: {
      selectedsortOption: function(newSortOption)
      {
        this.$dispatch('sortOption', newSortOption)
      }
    },
    methods: {
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
        }else {
          this.clients.sort(function(a, b){
            return a.dateOfExamination.localeCompare(b.dateOfExamination);
          })
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
</style>