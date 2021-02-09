<template>
  <div id='app'>
      <ejs-schedule height='840px' width='100%' :selectedDate='selectedDate'
      :eventSettings= 'eventSettings'>
        <e-views>
          <e-view option='Week' startHour='00:00' endHour='00:00' ></e-view>
          <e-view option='WorkWeek' startHour='00:00' endHour='00:00' ></e-view>
          <e-view option='Month' showWeekend=true></e-view>
        </e-views>
      </ejs-schedule>
  </div>
</template>

<script>
import axios from 'axios';
import Vue from 'vue';
import { SchedulePlugin,  WorkWeek, Month, Week } from '@syncfusion/ej2-vue-schedule';
Vue.use(SchedulePlugin);
let data = [];
export default {
  data: () => ({
      eventSettings: {
        dataSource: data,
        fields: {
          id: 'Id',
          subject: { name: 'EventName' },
          description: { name: 'Description' },
          startTime: { name: 'StartTime' },
          endTime: { name: 'EndTime' }
        }
      },
      selectedDate: new Date(2021, 1, 15)
  }),
  mounted() {
      this.init();
  },
  created() {
      this.setData();
  },
  provide: {
    schedule: [ WorkWeek, Month, Week]
  },
  methods: {
    init() {
      this.getVacation();
      this.getConsultations();
    },
    getVacation() {
      axios.get('http://localhost:8081/vacations/doctorVacation/' + this.$route.params.id).then(resp => {
          if(resp.data != '')
            this.setVacationInfo(resp.data);
      }).catch(err => console.log(err));
    },
    getConsultations() {
      axios.get('http://localhost:8081/appointments/allConsultations/' + this.$route.params.id).then(resp => {
          this.setConsultationInfo(resp.data);
      }).catch(err => console.log(err));
    },
    setVacationInfo(item) {
      data.push({
            Id: item.id,
            EventName: 'Vacation of pharmacist ' + item.doctor.name+' '+ item.doctor.lastName,
            StartTime: new Date(item.startTime),
            EndTime: new Date(item.endTime),
            Description: 'Vacation',
      }); 
    },
    setConsultationInfo(item) {
      item.forEach(consultation => {
          data.push({
            Id: consultation.id,
            EventName: 'Consultation of pharmacist ' + consultation.doctor.name +' '+ consultation.doctor.lastName,
            StartTime: new Date(consultation.startTime),
            EndTime: new Date(consultation.endTime),
            Description: 'Patient on consultation: '+ consultation.patient.name +' '+ consultation.patient.lastName
          }); 
      })
    },
    setData(){
      data.push({
            Id: 3,
            EventName: 'Consultation of pharmacist Sanja Petrovic',
            StartTime: new Date(1626960000000),
            EndTime: new Date(1626966000000),
            Description: 'Patient on consultation: Klara Mitrovic'
      });
      data.push({
            Id: 7,
            EventName: 'Consultation of pharmacist Sanja Petrovic',
            StartTime: new Date(1621238700000),
            EndTime: new Date(1621242000000),
            Description: 'Patient on consultation: Mirko Lazarevic'
      });
      console.log(data);
    }
  }
}
</script>

<style>
@import '../../../node_modules/@syncfusion/ej2-base/styles/material.css';
@import '../../../node_modules/@syncfusion/ej2-buttons/styles/material.css';
@import '../../../node_modules/@syncfusion/ej2-calendars/styles/material.css';
@import '../../../node_modules/@syncfusion/ej2-dropdowns/styles/material.css';
@import '../../../node_modules/@syncfusion/ej2-inputs/styles/material.css';
@import '../../../node_modules/@syncfusion/ej2-navigations/styles/material.css';
@import '../../../node_modules/@syncfusion/ej2-popups/styles/material.css';
@import '../../../node_modules/@syncfusion/ej2-vue-schedule/styles/material.css';
</style>