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
        multiple
      >
        <template v-for="(item, index) in renderingItems">
          <v-list-item :key="item.title">
            <template v-slot:default="{ active }">
              <v-list-item-content >
                <v-list-item-title  v-text="item.startTime + '-' + item.endTime"></v-list-item-title>
                <v-list-item-subtitle v-text="'Price: ' + item.price"></v-list-item-subtitle>
                <v-list-item-subtitle v-text="'Type: ' + item.appointmentType.appointmentTypeValue"></v-list-item-subtitle>
                <v-list-item-subtitle v-text="'Doctor: ' + item.doctor.name + ' ' + item.doctor.lastName"></v-list-item-subtitle>
                <v-list-item-subtitle v-text="'Status: ' + item.status.statusValue"></v-list-item-subtitle>
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
        <v-radio value="date" label="Date"></v-radio>
        <v-radio value="price" label="Price"></v-radio>
        <v-radio value = "duration" label="Duration"></v-radio>
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
        <h3 style="margin-top: 20px;">Type</h3>
        <v-radio-group v-model="filterCriteria" column>
          <v-radio value="all" label="All"></v-radio>
          <v-radio value="EXAMINATION" label="Examination"></v-radio>
          <v-radio value="CONSULTATION" label="Consultation"></v-radio>
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
          if(this.searchString == '' || this.items[i].name.indexOf(this.searchString) !== -1 || this.items[i].street.indexOf(this.searchString) !== -1 ){
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
          if( this.filterCriteria == 'all' || this.searchedItems[i].appointmentType.appointmentTypeValue == this.filterCriteria ){
            newArray.push(this.items[i]);
          }
        }
        this.renderingItems = newArray;
      },
      sort: function(){
        if(this.sortCriteria == 'date'){
          this.renderingItems.sort(function(a, b){
            return a.startTime-b.startTime;
          })
        }else if(this.sortCriteria == 'price'){
          this.renderingItems.sort(function(a, b){
            return a.price - b.price;
          })
        }
        else{
          this.renderingItems.sort(function(a, b){
            return Math.abs(a.startTime - a.endTime) - Math.abs(b.startTime - b.endTime);
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