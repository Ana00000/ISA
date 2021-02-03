<template>
    <div id="map"></div>
</template>

<script>
/* eslint-disable */
// import openlayer css for style
import "ol/ol.css";
// This is library of openlayer for handle map
import Map from "ol/Map";
import View from "ol/View";
import { defaults as defaultControls, ScaleLine } from "ol/control";
import {Tile as TileLayer, Vector as VectorLayer} from 'ol/layer';
import {OSM, Vector as VectorSource} from 'ol/source';
import VectorSource2 from 'ol/source/Vector'
import MousePosition from "ol/control/MousePosition";
import * as ol from 'ol'
import * as source from 'ol/source'
import * as geom from 'ol/geom'
import * as layer from 'ol/layer'
import * as proj from 'ol/proj'
import * as style from 'ol/style'
import Point from "ol/geom/Point";




export default {
  mounted() {
    this.initiateMap();
  },
  data: () => ({
    markers: [],
    features: [],
    map: null
  }),
  methods: {
    doInverseGeoCoding(item) {

    },
    getPharmacies(markers, map){
      this.markers = markers;
      console.log(this.markers);

      var features = [];

      for( var i = 0 ; i < this.markers.length; i++){
        var item = this.markers[i];                                     //get item
        var longitude = item.longitude;                         //coordinates
        var latitude = item.latitude;
        var name = item.name;


        /*....
        * now get your specific icon...('..../ic_customMarker.png')
        * by e.g. switch case...
        */
        var iconPath = 'https://upload.wikimedia.org/wikipedia/commons/d/d1/Google_Maps_pin.svg';

        //create Feature... with coordinates
        // var markerFeature = new ol.Feature({
        //   geometry: new Point(proj.transform([longitude, latitude], 'EPSG:4326',  'EPSG:4326'))
        // });

        var iconFeature = new ol.Feature({
          geometry: new Point(proj.transform([longitude, latitude], 'EPSG:4326',  'EPSG:4326')),
          label: name,
          labelActive: true
        });

        // iconFeature.label(name);

        //create style for your feature...
        var iconStyle = new style.Style({
          image: new style.Icon(/** @type {olx.style.IconOptions} */ ({
            anchor: [0.5, 46],
            anchorXUnits: 'fraction',
            anchorYUnits: 'pixels',
            opacity: 1,
            src: iconPath
          }))
        });

        iconFeature.setStyle(iconStyle);
        features.push(iconFeature);
        // features.push(markerFeature);
        //next item...
      }

      /*
      * create vector source
      * you could set the style for all features in your vectoreSource as well
      */

      var vectorSource = new VectorSource({
        features: features      //add an array of features
        //,style: iconStyle     //to set the style for all your features...
      });

      var vectorLayer = new VectorLayer({
        source: vectorSource
      });

      this.map.addLayer(vectorLayer);
    },
    initiateMap() {
      // create vector layer
      var source = new VectorSource();
      var vector = new VectorLayer({
        source: source
      });
      // create title layer
      var raster = new TileLayer({
        source: new OSM(),
      });
      // create map with 2 layer
      this.map = new Map({
        controls: defaultControls().extend([
          new ScaleLine({
            units: "degrees",
          }),
          new MousePosition()
        ]),

        target: "map",

        layers: [raster, vector],
        view: new View({
          projection: "EPSG:4326",
          center: [19.83, 45.25],
          zoom: 13.9,
        }),
      });

      // ADDING PHARMACIES TO THE MAP
      this.$http.get('http://localhost:8081/pharmacies/all').then(resp => {
        this.getPharmacies(resp.data);
      }).catch(err => {
        console.log("Unsuccessful");
        console.log(err);
      })

      // var layer = new VectorLayer({
      //   source: new VectorSource2({
      //     features: [
      //       new ol.Feature({
      //         geometry: new geom.Point(proj.fromLonLat([19.83312, 45.25437], 'EPSG:4326', 'EPSG:4326'))
      //       })
      //     ]
      //   })
      // });
      // console.log(this.markers);
      // console.log("AAAAAAAAAA");


      // var layer = new VectorLayer({
      //   source: new VectorSource2({
      //     features: [
      //       new ol.Feature({
      //         geometry: new geom.Point(proj.fromLonLat([19.83312, 45.25437], 'EPSG:4326', 'EPSG:4326'))
      //       })
      //     ]
      //   })
      // });

    },
  },
};
</script>

<style>
#map {
  /* position: absolute; */
  margin: 0 auto;
  padding: 60px;
  height: 700px;
  width: 80%;
}

</style>