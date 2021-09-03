<template>
    <div class="topSpace">
        <h1>Complainment:</h1>
        <Complainment v-bind:complaintment="this.complainment" renderButton="dont render buttton"/> 
        <h1>Answer on complainment:</h1>
        <v-textarea class="textAreSize" v-model="text"></v-textarea>
        <v-btn
            depressed
            color="primary"
            style="margin-top:20px; font-size:32px; width:20%; height:50px;"
            v-on:click="add">
            Answer 
        </v-btn>
    </div>
</template>

<script>
import Complainment from '../../components/systemAdmin/Complainment.vue'
export default {
    name:"AnswerOnSpecificComplainment",
    components: {Complainment },
    props:['complaintment'],
    beforeMount(){
        this.$http.get('http://localhost:8081/complaint/'+this.$route.params.complainmentID)
        .then(resp => {
            this.complainment = resp.data;
            console.log(resp.data);
        })
        .catch(er => {
            console.log('Error while loading complainment !');
            console.log(er.response.data);
        });
    },
    data: ()=>({
        complainment:null,
        text:"",
    }),
    methods:{
      add(){
        var tokenString = '';
        tokenString = localStorage.getItem("token");
        const config = {
                headers: {Authorization: `Bearer ${tokenString}`}
        };
        this.$http.post('http://localhost:8081/complaint/addCompalintAnswer',this.answerToAdd,config)
        .then(resp => {
            console.log(resp.data);
            alert("Successfully added !")
            window.location.href = 'http://localhost:8080/systemAdminHomePage/complaintments';
        })
        .catch(er => {
            console.log('Error while registering in');
            console.log(er.response.data);
        })
      },
    },
    computed: {
    answerToAdd(){
        return {
            'complaintId':this.complainment.id,
            'text':this.text,
        }
    }
  },
}
</script>

<style>
.topSpace{
    margin-top: 20px;
}
.textAreSize{
    width: 50%;
    border: blue;
    border-style: groove;
    margin: 0 auto;
    font-size: 20px;
}

</style>