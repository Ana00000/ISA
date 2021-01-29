<template>
    <div id="mainDiv">
        <div>
            <h2><router-link to="/pharmacies">Pharmacies</router-link></h2>
        </div>
        <div>
            <h2><a>Appointment history</a></h2>
        </div>
        <div>
            <h2><a>Scheduled appointments</a></h2>
        </div>
        <div>
            <h2><a>eRecipes</a></h2>
        </div>
        <div>
            <h2><a>Reserved medicine</a></h2>
        </div>
        <div>
            <h2><a>Penalty insight</a></h2>
        </div>
        <div>
            <h2><a>Issued medicine</a></h2>
        </div>
        <div>
            <h2><a>Promotions</a></h2>
        </div>
        <div>
            <h2><a>Write a complaint</a></h2>
        </div>
        <div>
            <h2><a>Reserve medicine</a></h2>
        </div>
        <div>
            <h2><a>Schedule appointment</a></h2>
        </div>
        <div>
            <h2><a>Profile</a></h2>
        </div>
    </div>
</template>

<script>
export default {
    name : 'PatientMenu'
}
</script>

<style scoped>
#mainDiv {
    border: solid black 1px;
}

#mainDiv div {
    background: rgb(240, 169, 179);
}
</style>