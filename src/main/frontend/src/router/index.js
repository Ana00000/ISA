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
    component: () => import('../views/DermatologistHomePage.vue')
  },
  {
    path: '/dermatologistHomePage/clients',
    name: 'Clients',
    component: () => import('../views/DermatologistClients.vue')
  },
  {
    path: '/dermatologistHomePage/examinationsInfo',
    name: 'ExaminationsInfo',
    component: () => import('../views/ExaminationsInfo.vue')
  },
  {
    path: '/dermatologistHomePage/workingSchedule',
    name: 'WorkingSchedule',
    component: () => import('../views/DermatologistWorkingSchedule.vue')
  },
  {
    path: '/dermatologistHomePage/profile',
    name: 'Profile',
    component: () => import('../views/DermatologistProfile.vue')
  },
  {
    path: '/pharmacistHomePage',
    name: 'PharmacistHomePage',
    component: () => import('../views/PharmacistHomePage.vue')
  },
  {
    path: '/pharmacistHomePage/clients',
    name: 'Clients',
    component: () => import('../views/PharmacistClients.vue')
  },
  {
    path: '/pharmacistHomePage/consultationsInfo',
    name: 'ConsultationsInfo',
    component: () => import('../views/ConsultationsInfo.vue')
  },
  {
    path: '/pharmacistHomePage/workingSchedule',
    name: 'WorkingSchedule',
    component: () => import('../views/PharmacistWorkingSchedule.vue')
  },
  {
    path: '/pharmacistHomePage/profile',
    name: 'Profile',
    component: () => import('../views/PharmacistProfile.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
