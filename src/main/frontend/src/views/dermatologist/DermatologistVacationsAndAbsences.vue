<template>
    <div style="
        background: #13077d;
        background: -webkit-linear-gradient(to right, #5442ed, #cdc8fa, #13077d);
        background: linear-gradient(to right, #5442ed, #cdc8fa, #13077d);">

        <div class="pagePlacing">
            <div class="vacationImage">
                <img :src="vacationImage" width="1900px" height="500px"/>
            </div>

            <v-layout class="startVacation">
                <v-datetime-picker name="picker1" class="ti" v-model="startTime" min="minDate" label="From"> </v-datetime-picker>
            </v-layout>

            <v-layout class="endVacation">
                <v-datetime-picker name="picker2" class="ti" v-model="endTime" min="minDate" label="To" > </v-datetime-picker>
            </v-layout>

            <div class="requestButton">
                <v-btn
                    v-on:click="makeRequest" 
                    color="#aba7ff"
                    elevation="24"
                    x-large
                    raised
                    rounded
                >Request</v-btn>
            </div>
        </div>

        <div>
            <DermatologistMenu/>
        </div> 
    </div>  
</template>

<script>
import vacationImage from "../../assets/vacation.jpg"
import DermatologistMenu from '../../components/dermatologist/DermatologistMenu.vue'
export default {
    name: 'DermatologistVacationsAndAbsences',    
    components : {   
        DermatologistMenu
    },
    data: () => ({
        vacationImage: vacationImage,
        doctor: null,
        startTime: null,
        endTime: null,
        dermatologist: null
    }),
    created() {
          var tokenString = '';
          tokenString = localStorage.getItem("token");
          const config = {
            headers: {Authorization: `Bearer ${tokenString}`}
          };
          
          this.$http.get('http://localhost:8081/doctors/findLoggedDoctor', config
          ).then(resp => {
              this.dermatologist = resp.data
          }).catch(console.log);
    },
    methods: {
        makeRequest() {
            this.confirmVacationInterval();
            var tokenString = '';
            tokenString = localStorage.getItem("token");
            const config = {
                    headers: {Authorization: `Bearer ${tokenString}`}
            };
            this.$http.get('http://localhost:8081/doctors/findLoggedDoctor', config
             ).then(resp => {
                this.dermatologist = resp.data
                this.$http.post('http://localhost:8081/vacations/saveVacation', 
                {         
                    status : 'PENDING',
                    doctor : this.dermatologist,
                    startTime : new Date(this.startTime),
                    endTime : new Date(this.endTime)
                }).then(resp => {
                    console.log(resp.data);
                    alert("Request is formed!");
                }).catch(err => {
                    alert("You already have one vacation request!");
                    console.log(err.response.data);
                })
             }).catch(console.log);
        },
        confirmVacationInterval() {
            if(this.endTime == null) {
                alert("End time needs a value!");
                return;
            }else if(this.startTime == null) {
                alert("Start time needs a value!");
                return;
            }else if ((this.startTime > this.endTime)) {
                alert("Start time comes before end time!");
                return;
            }else if(this.startTime < Date.now()) {
                alert("Start time has passed!");
                return;
            }else if(this.endTime < Date.now()) {
                alert("End time has passed!");
                return;
            }
        }
    }
}
</script>


<style scoped>
.pagePlacing {
    height: 840px;
}

.startVacation {
    position: absolute;
    left: 250px;
    top: 550px;
}

.endVacation {
    position: absolute;
    left: 250px;
    top: 650px;
}

.requestButton {
    position: absolute;
    left: 550px;
    top: 600px;
}
</style>