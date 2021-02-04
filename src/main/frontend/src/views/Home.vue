<template>
  <span>
    <home-background></home-background>
    <v-container class="grey lighten-2" fluid fill-height>
      <v-layout column>
        <div style="margin: auto 0">
          <h2>Search pharmacies</h2>
        </div>
        <div height="300px">
          <v-container>
            <v-layout column>
                <item-list-pharmacies v-bind:items="items"></item-list-pharmacies>
            </v-layout>
          </v-container>
        </div>
        <v-flex>
            <map-container></map-container> 
        </v-flex>
      </v-layout>
    </v-container>
    <Footer></Footer>
  </span>
</template>

<script>
import Footer from '../components/Footer.vue';
import HomeBackground from '../components/HomeBackground.vue';
import ItemListPharmacies from '../components/itemList/ItemListPharmacies.vue';
import MapContainer from '../components/MapContainer.vue';
import axios from 'axios';

export default {
  name: 'Home',
  components: {
    MapContainer,
    HomeBackground,
    Footer,
    ItemListPharmacies
  },
  data() {
    return{
      items: []
    }
  },
  created() {
      axios.get('http://localhost:8081/pharmacies/all')
          .then(res => this.items = res.data)
          .catch(err => console.log(err));
  }

}
</script>

<style>

/* The side navigation menu */

#waterDiv{
  background: url('https://www.treehugger.com/thmb/xPeXCbh_Yb5tGtATB-j1XtInMbM=/3500x2334/filters:fill(auto,1)/closeupbrightbluewater-61f0f88d81004729a7385484bcd38998.jpg');
  background-size: cover;
  width: 100%;
  height: 100%;
}

.backgroundDiv {
  background: url('https://wallup.net/wp-content/uploads/2017/11/17/260979-pills-pharmacy.jpg');
  background-size: cover;
  width: 100%;
  height: 100%;
}

.sidenav {
  height: 100%; /* 100% Full-height */
  width: 200px; /* 0 width - change this with JavaScript */
  position: fixed; /* Stay in place */
  z-index: 1; /* Stay on top */
  top: 180px;
  left: 0;
  margin: 0 0 0 8px;
  background-color: #2c3e50; /* Black*/
  color: #42b983;
  overflow-x: hidden; /* Disable horizontal scroll */
  padding-top: 60px; /* Place content 60px from the top */
  transition: 0.5s; /* 0.5 second transition effect to slide in the sidepanel */
  opacity: 0.75;
}

/* The sidepanel links */
.sidepanel a {
  padding: 8px 8px 8px 32px;
  text-decoration: #42b983;
  font-size: 25px;
  /*color: rgb(66,185,131);*/
  background-color: #2c3e50;
  display: block;
  transition: 0.3s;
}

/* When you mouse over the navigation links, change their color */
.sidepanel a:hover {
  color: #f1f1f1;
}

/* Position and style the close button (top right corner) */
.sidepanel .closebtn {
  position: absolute;
  top: 0;
  right: 25px;
  font-size: 36px;
  margin-left: 50px;
}

/* Style page content - use this if you want to push the page content to the right when you open the side navigation */
/*#main {*/
/*  transition: margin-left .5s;*/
/*  padding: 20px;*/
/*}*/

/* On smaller screens, where height is less than 450px, change the style of the sidenav (less padding and a smaller font size) */
@media screen and (max-height: 450px) {
  .sidenav a {font-size: 18px;}
}

/* Style the button that is used to open the sidepanel */
.openbtn {
  font-size: 20px;
  cursor: pointer;
  background-color: #2c3e50;
  color: rgb(66,185,131);
  padding: 10px 32.5px 10px 32.5px;
  border: none;
  margin: 0;
  float: left;
}
.openbtn:hover {
  background-color: #3c4e59;
}


.panel-map {
  padding-left: 20px;
  padding-right: 20px;
}

.panel-mid {
  width: 95%;
  height: 500px;
}

.panel-footer {
  height: 65px;
  width: 99%;
}

</style>
