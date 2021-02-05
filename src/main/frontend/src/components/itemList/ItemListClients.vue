<template>
  <v-container>
  <v-layout row wrap>

  <v-card 
    v-bind:class="{'cardClass':drawer}" width="15%" height="450px">
    <div>
      <h2>Sort by</h2>
    </div>
    <v-divider></v-divider>
    <v-list-item>
      <v-checkbox label="Name"></v-checkbox>
    </v-list-item>
    <v-list-item>
      <v-checkbox label="Last name"></v-checkbox>
    </v-list-item>
    <v-list-item>
      <v-checkbox label="Phone number"></v-checkbox>
    </v-list-item>
    <v-list-item>
      <v-checkbox label="Address"></v-checkbox>
    </v-list-item>
    <v-list-item>
      <v-checkbox label="Email"></v-checkbox>
    </v-list-item>
    <v-list-item>
      <v-checkbox label="Date of examination"></v-checkbox>
    </v-list-item>
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
      }
    }
  }
</script>

<style scoped>
.cardClass {
  display: none; 
}
</style>