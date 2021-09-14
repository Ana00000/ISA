<template>
    <v-container style="padding: 0px" fluid fill-height dark >
        <v-layout>
            <div style="width:25%;">
                <PatientMenu/>
            </div>
            <div class = "panelDiv">
            <div style="margin: 50px;"><h2 class="display-3">Penalties</h2></div>
            <div style="margin: 50px;"><h2 class="display-2">Dear {{patientInfo.name}}, you have {{patientInfo.penalties}} penalties. Be careful.</h2></div>
        </div>
        </v-layout>
    </v-container>
</template>

<script>
import PatientMenu from '@/components/PatientMenu.vue'
export default {
    name : 'PenaltyInsight',
    components : {
        PatientMenu
    },
    data() {
        return {
            patientInfo: ''
        }
    },
    created(){
        const config = {
                headers: { Authorization: `Bearer ${localStorage.getItem("token")}` }
            };
        this.id = this.$route.params.id;
        this.$http.get('http://localhost:8081/patients/getInfo', config).then(resp => {
            console.log(resp.data);
            this.patientInfo = resp.data;
        }).catch(err => console.log(err));
    }
}
</script>

<style scoped>
.panelDiv {
    float: left;
}

.backgroundDiv {
  background: rgb(199, 191, 191);
  background-size: cover;
  width: 100%;
  height: 100%;
}
</style>