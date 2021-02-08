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
      selectedDate: new Date(2021, 1, 15),
      pharmacies: []
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
      this.getExaminations();
    },
    getVacation() {
      axios.get('http://localhost:8081/vacations/doctorVacation/' + this.$route.params.id).then(resp => {
          this.setVacationInfo(resp.data);
      }).catch(err => console.log(err));
    },
    getExaminations() {
      axios.get('http://localhost:8081/appointments/allExaminations/' + this.$route.params.id).then(resp => {
          this.setExaminationInfo(resp.data);
      }).catch(err => console.log(err));
    },
    getPharmacy(id) {
      axios.get('http://localhost:8081/pharmacies/pharmacyByAppointment/' + id).then(resp => {
        this.pharmacies.push(resp.data.name);
      }).catch(err => console.log(err));
    },
    setVacationInfo(item) {
      data.push({
            Id: item.id,
            EventName: 'Vacation of dermatologist ' + item.doctor.name+' '+ item.doctor.lastName,
            StartTime: new Date(item.startTime),
            EndTime: new Date(item.endTime),
            Description: 'Vacation',
      }); 
    },
    setExaminationInfo(item) {
      item.forEach(examination => {
          this.getPharmacy(examination.id);
          var description = 'Pharmacy is ' + this.pharmacies;
          console.log(this.pharmacies);

          if(examination.status.statusValue == "UPCOMING")
             description += '. Patient on examination: '+ examination.patient.name +' '+ examination.patient.lastName;

          data.push({
            Id: examination.id,
            EventName: 'Examination of dermatologist ' + examination.doctor.name +' '+ examination.doctor.lastName,
            StartTime: new Date(examination.startTime),
            EndTime: new Date(examination.endTime),
            Description: description
          }); 
      })
    },
    setData(){
      data.push({
            Id: 1,
            EventName: 'ddas',
            StartTime: new Date(2021, 1, 15, 17, 0),
            EndTime: new Date(2021, 1, 15, 18, 30),
            Description: 'copy again'
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