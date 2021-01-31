<template>
  <span>
    <home-background></home-background>
    <map-container></map-container>
  </span>
  <!-- <div>
    <div class="panel-mid">
      Mid panel
    </div>
    <div class="panel-map">
      <MapContainer/>
    </div>
    <div class="panel-footer">
    </div>

  </div> -->
</template>

<script>
import HomeBackground from '../components/HomeBackground.vue';
// @ is an alias to /src
import MapContainer from '../components/MapContainer.vue';

export default {
  name: 'Home',
  data() {
    return {
      sidePanelWidth: false
    }
  },
  components: {
    MapContainer,
    HomeBackground
  }

}
</script>

<style>

/* The side navigation menu */

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
