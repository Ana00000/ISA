<template>
    <div>
        <SystemAdminMenu/>
        <div>
            <v-card width="800" class="mx-auto mt-5" color="white">
            <h1 class="myText">Complainments</h1>
            <div style="margin: 0 auto width:100px">
                <Complainent v-for="complaintmet in complaintments" :key="complaintmet.id" v-bind:complaintment="complaintmet"/>
            </div>
            </v-card>    
        </div>
    </div>
</template>

<script>
import SystemAdminMenu from '../../components/systemAdmin/SystemAdminMenu.vue'
import Complainent from '../../components/systemAdmin/Complainment.vue'
export default {
    components: { SystemAdminMenu,Complainent },
    name:"SystemAdminAnswerOnComplaintments",
    data: ()=>({
        complaintments:[],
    }),
    beforeMount(){
        this.$http.get('http://localhost:8081/complaint/getNotAnswered')
        .then(resp => {
            this.complaintments = resp.data;
            console.log(resp.data);
        })
        .catch(er => {
            console.log('Error while loading complainments !');
            console.log(er.response.data);
        });
    },
    
}
</script>

<style>
    .myText{
        margin:10px; 
        color:blue;
    }
</style>