<template>
    <div>
        <div class = "panelDiv">
            <PatientMenu/>
        </div>
        <div class = "panelDiv">
            <SearchBar title="text"/>
            <div>
                <form>
                    <input type="text">
                    <input value="Search" type="submit">
                </form>
            </div>
            <div v-bind:key="pharmacy.id" v-for="pharmacy in pharmacies">
                <p>{{pharmacy.name}}</p>
            </div>
        </div>
    </div>
</template>

<script>
import PatientMenu from '../components/PatientMenu.vue'
import SearchBar from '../components/SearchBar.vue'
export default {
    name : 'Pharmacies',
    components : {
        PatientMenu,
        SearchBar
    },
    data() {
        return{
            pharmacies: [
                {
                    id: 1,
                    name: 'Pharmacy1'
                },
                {
                    id: 2,
                    name: 'Pharmacy2'
                },
                {
                    id: 3,
                    name: 'Pharmacy3'
                }
            ]
        }
    }
}
</script>

<style scoped>
.panelDiv {
    float: left;
    margin: 60;
}
</style>