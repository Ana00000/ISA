<template>
  <div>
    <div id="mySidenav" class="sidenav">
      <a href="#" >&times;</a>
      <a href="#" >About</a>
      <a href="#" >Services</a>
      <a href="#" >Clients</a>
      <a href="#" >Contact</a>
    </div>
    <!-- Use any element to open the sidenav -->
    <span onclick="openNav()">open</span>
    <h1>
      <Introduction />
    </h1>

    <div class="panel-mid">
      Mid panel
    </div>
    <div class="panel-map">
      <MapContainer/>
    </div>
    <div class="panel-footer">
    </div>

  </div>
</template>

<script>
// @ is an alias to /src
import MapContainer from "@/components/MapContainer";
import Introduction from "@/textual_components/home/Introduction";


export default {
  name: 'Home',
  components: {
    MapContainer,
    Introduction
  }

}



</script>

<style>

/* The side navigation menu */
.sidenav {
  height: 100%; /* 100% Full-height */
  width: 200px; /* 0 width - change this with JavaScript */
  position: fixed; /* Stay in place */
  z-index: 1; /* Stay on top */
  top: 100px; /* Stay at the top */
  left: 0px;
  background-color: #2c3e50;
  opacity: 0.85;
  overflow-x: visible; /* Disable horizontal scroll */
  padding-top: 100px; /* Place content 60px from the top */
  transition: 0.5s; /* 0.5 second transition effect to slide in the sidenav */
}

/* The navigation menu links */
.sidenav a {
  padding: 5px 5px 5px 0px;
  text-decoration: none;
  font-size: 25px;
  color: rgb(66,185,131);
  background-color: #2c3e50;
  display: block;
  transition: 0.3s;
}

/* When you mouse over the navigation links, change their color */
.sidenav a:hover {
  color: #f1f1f1;
}

/* Position and style the close button (top right corner) */
.sidenav .closebtn:active {
  position: absolute;
  top: 0;
  right: 25px;
  font-size: 36px;
  margin-left: 50px;
}

/* Style page content - use this if you want to push the page content to the right when you open the side navigation */
#main {
  transition: margin-left .5s;
  padding: 20px;
}

/* On smaller screens, where height is less than 450px, change the style of the sidenav (less padding and a smaller font size) */
@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}


.panel-map {
  padding-left: 20px;
  padding-right: 20px;
  background-color: #42b983;
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
