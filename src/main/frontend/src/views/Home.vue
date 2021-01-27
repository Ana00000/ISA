<template>
  <div class="sidenav">
    <h1>
      <Introduction />
    </h1>
    <div class="panel-map">
      <MapContainer/>
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

.sidenav {
  padding-top: 20px;
  background-color: #f1f1f1;
  height: 100%;
}

.panel-map {
  padding-left: 20px;
  padding-right: 20px;
  background-color: #42b983;
}

</style>
