<template>
    <div class="textStyle">
        <h3>USER: {{complaintment.patientName}}</h3>
        <p>Text:{{complaintment.text}}</p>
        <p v-if="complaintment.doctorID" style="color:red">The doctor he/she complained about:{{complaintment.doctorName}}</p>
        <p v-else style="color:red">Pharmacy he/she complained about:  {{complaintment.pharmacyName}}</p>
        <v-btn
            v-if="!renderButton"
            depressed
            color="primary"
            style="margin-bottom:6px"
            v-on:click="answer"
            >
            Answer
        </v-btn>
    </div>
</template>

<script>
export default {
    name:"Complainment",
    props:['complaintment','renderButton'],
    beforeMount(){
        console.log("complainment:" , this.complaintment);
    },
    methods:{
        answer(){
            window.location.href = 'http://localhost:8080/systemAdminHomePage/answerOnSpecificComplainment/'+this.complaintment.id;
        }
    },
}
</script>

<style>
.textStyle{
    border: 2px;
    border-color: blue;
    border-style: groove;
    margin: 0 auto;
    margin-bottom: 10px;
    width: 50%;
    background: darkgrey;
    font-style: italic;
    color: blue;
}
</style>