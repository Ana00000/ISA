<template>
    <div style="
        background: #13077d;
        background: -webkit-linear-gradient(to right, #5442ed, #cdc8fa, #13077d);
        background: linear-gradient(to right, #5442ed, #cdc8fa, #13077d);">

        <br/><br/>

        <v-container fluid class="container">
            <v-row>
            <v-col cols="5"/>
            <v-col cols="2">
                <v-text-field
                    label="Medicine reservation number"
                    hint="Enter unique number of the medicine reservation!"
                    color="indigo"
                    prepend-icon="mdi-magnify"
                    single-line
                    v-model="searchReservation"/>
            </v-col>
            </v-row>
        </v-container>
        
        <br/><br/>
        
        <div class="searchButton">
            <v-btn 
                v-on:click="searchReservation" 
                color="#aba7ff"
                elevation="24"
                x-large
                raised
                rounded
            >Search reservation</v-btn>
        </div>

        <div class="panelDiv">
                <PharmacistMenu/>
        </div> 
    </div>  
</template>

<script>
import PharmacistMenu from '../../components/pharmacist/PharmacistMenu.vue'
export default {
    name: 'Prescriptions',    
    components : {   
        PharmacistMenu
    }
}
</script>


<style scoped>
.searchButton {
    height: 650px;
}
</style>