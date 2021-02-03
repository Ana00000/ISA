import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/register',
    name: 'Register',
    component: () => import('../views/Register.vue')
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/Login.vue')
  },
  {
    path: '/profile',
    name: 'Profile',
    component: () => import('../views/Profile.vue'),
  },
  {
    path: '/patientHomePage',
    name: 'PatientHomePage',
    component: () => import('../views/PatientHomePage.vue')
  },
  {
    path: '/pharmacies',
    name: 'Pharmacies',
    component: () => import('../views/Pharmacies.vue')
  },
  {
    path: '/searchMedicine',
    name: 'SearchMedicine',
    component: () => import('../views/SearchMedicine.vue')
  },
  {
    path: '/dermatologistHomePage',
    name: 'DermatologistHomePage',
    component: () => import('../views/dermatologist/DermatologistHomePage.vue')
  },
  {
    path: '/dermatologistHomePage/clients',
    name: 'DermatologistClients',
    component: () => import('../views/dermatologist/DermatologistClients.vue')
  },
  {
    path: '/dermatologistHomePage/examinationsInfo',
    name: 'ExaminationsInfo',
    component: () => import('../views/dermatologist/ExaminationsInfo.vue')
  },
  {
    path: '/dermatologistHomePage/workingSchedule',
    name: 'DermatologistWorkingSchedule',
    component: () => import('../views/dermatologist/DermatologistWorkingSchedule.vue')
  },
  {
    path: '/dermatologistHomePage/vacationsAndAbsences',
    name: 'DermatologistVacationsAndAbsences',
    component: () => import('../views/dermatologist/DermatologistVacationsAndAbsences.vue')
  },
  {
    path: '/dermatologistHomePage/profile',
    name: 'DermatologistProfile',
    component: () => import('../views/dermatologist/DermatologistProfile.vue')
  },
  {
    path: '/dermatologistHomePage/scheduleExamination',
    name: 'ScheduleExamination',
    component: () => import('../views/dermatologist/ScheduleExamination.vue')
  },
  {
    path: '/pharmacistHomePage',
    name: 'PharmacistHomePage',
    component: () => import('../views/pharmacist/PharmacistHomePage.vue')
  },
  {
    path: '/pharmacistHomePage/clients',
    name: 'PharmacistClients',
    component: () => import('../views/pharmacist/PharmacistClients.vue')
  },
  {
    path: '/pharmacistHomePage/consultationsInfo',
    name: 'ConsultationsInfo',
    component: () => import('../views/pharmacist/ConsultationsInfo.vue')
  },
  {
    path: '/pharmacistHomePage/workingSchedule',
    name: 'PharmacistWorkingSchedule',
    component: () => import('../views/pharmacist/PharmacistWorkingSchedule.vue')
  },
  {
    path: '/pharmacistHomePage/prescriptions',
    name: 'Prescriptions',
    component: () => import('../views/pharmacist/Prescriptions.vue')
  },
  {
    path: '/pharmacistHomePage/vacationsAndAbsences',
    name: 'PharmacistVacationsAndAbsences',
    component: () => import('../views/pharmacist/PharmacistVacationsAndAbsences.vue')
  },
  {
    path: '/pharmacistHomePage/profile',
    name: 'PharmacistProfile',
    component: () => import('../views/pharmacist/PharmacistProfile.vue')
  },
  {
    path: '/pharmacistHomePage/scheduleConsultation',
    name: 'ScheduleConsultation',
    component: () => import('../views/pharmacist/ScheduleConsultation.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
