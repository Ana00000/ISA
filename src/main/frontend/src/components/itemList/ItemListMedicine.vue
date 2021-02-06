<template>
  <v-container>
  <v-layout row wrap>
  <v-card
    class="mx-auto" style="width: 50%; max-height: 400px; overflow-y: scroll"
  >
    <v-toolbar
      color="#3949AB"
      dark
    >

      <!-- <v-toolbar-title>{{title}}</v-toolbar-title> -->
      <v-text-field
        hide-details
        prepend-icon="mdi-magnify"
        single-line
        v-model="searchString"
        v-on:keyup="search()"
      ></v-text-field>

      <v-spacer></v-spacer>

      <v-app-bar-nav-icon  @click="drawer = !drawer"></v-app-bar-nav-icon>

    </v-toolbar>

    <v-list two-line>
      <v-list-item-group
        v-model="selected"
        active-class="pink--text"
        single
      >
        <template v-for="(item, index) in renderingItems">
          <v-list-item :key="item.title">
            <template v-slot:default="{ active }">
              <v-list-item-content >
                <v-list-item-title  v-text="item.name"></v-list-item-title>
                <v-list-item-subtitle v-text="'Manufacturer: ' + item.medicineManufacturer.name"></v-list-item-subtitle>
                <v-list-item-subtitle v-text="'Shape: ' + item.medicineShape.shapeValue"></v-list-item-subtitle>
                <v-list-item-subtitle v-text="'Needs recipe: ' + item.recipeNeed"></v-list-item-subtitle>
              </v-list-item-content>

              <v-list-item-action>
                <v-list-item-action-text v-text="item.action"></v-list-item-action-text>

                <v-icon
                  v-if="!active"
                  color="grey lighten-1"
                >
                  mdi-star-outline
                </v-icon>

                <v-icon
                  v-else
                  color="yellow darken-3"
                >
                  mdi-star
                </v-icon>
              </v-list-item-action>
            </template>
          </v-list-item>

          <v-divider
            v-if="index < items.length - 1"
            :key="index"
          ></v-divider>
        </template>
      </v-list-item-group>
    </v-list>
  </v-card>
  <v-card v-bind:class="{'cardClass':drawer}" width="25%">
    <div>
      <h2>Sort</h2>
    </div>
    <v-divider></v-divider>
    <div style="margin: 0 auto; width: 100px">
      <v-radio-group v-model="sortCriteria" column>
        <v-radio value="name" label="Name"></v-radio>
        <v-radio value="manufacturer" label="Manufacturer"></v-radio>
      </v-radio-group>
    </div>
    <v-btn v-on:click="sort">Sort</v-btn>
  </v-card>
  <v-card v-bind:class="{'cardClass':drawer}" width="25%">
    <div>
      <h2>Filter</h2>
    </div>
    <v-divider></v-divider>
      <div style="margin: 0 auto; width: 100px">
        <h3 style="margin-top: 20px;">Shape</h3>
        <v-radio-group v-model="filterCriteria" column>
          <v-radio value="all" label="All"></v-radio>
          <v-radio value="PILL" label="Pill"></v-radio>
          <v-radio value="TABLET" label="Tablet"></v-radio>
          <v-radio value="SYRUP" label="Syrup"></v-radio>
        </v-radio-group>
      </div>
    <v-btn v-on:click="filter" >Filter</v-btn>
  </v-card>
  
  </v-layout>
  </v-container>
</template>

<script>
import axios from 'axios';
  export default {
    data: () => ({
      selected: [],
      drawer: false,
      searchString: '',
      renderingItems: [],
      searchedItems: [],
      filterGrade: 0,
      sortCriteria: 'date',
      filterCriteria: 'all',
      items: []
    }),
    created(){
      axios.get('http://localhost:8081/medicine')
            .then(res => {
              this.items = res.data;
              this.renderingItems = res.data;
              this.searchedItems = res.data;
            })
            .catch(err => console.log(err));
    },
    methods:{
      search: function(){
        var i;
        var newArray = [];
        for(i = 0; i < this.items.length; i++){
          if(this.searchString == '' || this.items[i].name.indexOf(this.searchString) !== -1 ){
            newArray.push(this.items[i]);
          }
        }
        this.renderingItems = newArray;
        this.searchedItems = newArray;
      },
      filter: function(){
        var i;
        var newArray = [];
        for(i = 0; i < this.searchedItems.length; i++){
          if( this.filterCriteria == 'all' || this.searchedItems[i].medicineShape.shapeValue == this.filterCriteria ){
            newArray.push(this.items[i]);
          }
        }
        this.renderingItems = newArray;
      },
      sort: function(){
        if(this.sortCriteria == 'name'){
          this.renderingItems.sort(function(a, b){
            return a.name.localeCompare(b.name);
          })
        }else{
          this.renderingItems.sort(function(a, b){
            return a.medicineManufacturer.name.localeCompare(b.medicineManufacturer.name);
          })
        }
      }
    }
  }
</script>

<style scoped>
.cardClass {
  display: none; 
}
</style>