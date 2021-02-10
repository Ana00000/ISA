<template>
  <v-container>
  <v-layout row wrap>
  <v-card
    class="mx-auto" style="width: 50%; max-height: 700px; overflow-y: scroll"
  >
    <v-toolbar
      color="#3949AB"
      dark
    >
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
          <v-list-item :key="item.id" @click="$emit('sendReservedMedicine',item)">
            <template v-slot:default="{ active }">
              <v-list-item-content >
                <v-list-item-title  v-text="item.medicineName"></v-list-item-title>
                <v-list-item-subtitle v-text="'Pharmacy: ' + item.pharmacyName"></v-list-item-subtitle>
                <v-list-item-subtitle v-text="'Date: ' + item.pickUpDate"></v-list-item-subtitle>
                <v-list-item-subtitle v-text="'Patient: ' + item.patientName + ' ' + item.patientLastName"></v-list-item-subtitle>
                <v-list-item-subtitle v-text="'Quantity: ' + item.quantity"></v-list-item-subtitle>
                <v-list-item-subtitle v-text="'Status: ' + item.reservationStatus"></v-list-item-subtitle>
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
        <v-radio value="quantity" label="Quantity"></v-radio>
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
        <h3 style="margin-top: 20px;">Status</h3>
        <v-radio-group v-model="filterCriteria" column>
          <v-radio value="all" label="All"></v-radio>
          <v-radio value="ACTIVE" label="Active"></v-radio>
          <v-radio value="CANCELED" label="Canceled"></v-radio>
        </v-radio-group>
      </div>
    <v-btn v-on:click="filter" >Filter</v-btn>
  </v-card>
  
  </v-layout>
  </v-container>
</template>

<script>
  export default {
    data: () => ({
      selected: [2],
      drawer: false,
      searchString: '',
      filterGrade: 0,
      sortCriteria: 'date',
      filterCriteria: 'all',
    }),
    props: [
      "items",
      "renderingItems",
      "searchedItems"
    ],
    methods:{
      search: function(){
        var i;
        var newArray = [];
        for(i = 0; i < this.items.length; i++){
          if(this.searchString == '' || this.items[i].medicineName.indexOf(this.searchString) !== -1 ){
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
          if( this.filterCriteria == 'all' || this.searchedItems[i].reservationStatus == this.filterCriteria ){
            newArray.push(this.items[i]);
          }
        }
        this.renderingItems = newArray;
      },
      sort: function(){
        if(this.sortCriteria == 'name'){
          this.renderingItems.sort(function(a, b){
            return a.medicineName.localeCompare(b.medicineName);
          })
        }else{
          this.renderingItems.sort(function(a, b){
            return a.quantity-b.quantity;
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