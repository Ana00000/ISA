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
    component: () => import('../views/patient/PatientHomePage.vue')
  },
  {
    path: '/patientPharmacies',
    name: 'PatientPharmacies',
    component: () => import('../views/patient/Pharmacies.vue')
  },
  {
    path: '/patientPharmacists',
    name: 'PatientPharmacists',
    component: () => import('../views/patient/Pharmacists.vue')
  },
  {
    path: '/patientAppointmentHistory',
    name: 'PatientAppointmentHistory',
    component: () => import('../views/patient/AppointmentHistory.vue')
  },
  {
    path: '/patientScheduledAppointments',
    name: 'PatientScheduledAppointments',
    component: () => import('../views/patient/ScheduledAppointments.vue')
  },
  {
    path: '/patientReserveMedicine',
    name: 'PatientReserveMedicine',
    component: () => import('../views/patient/ReserveMedicine.vue')
  },
  {
    path: '/patientReservedMedicine',
    name: 'PatientReservedMedicine',
    component: () => import('../views/patient/ReservedMedicine.vue')
  },
  {
    path: '/patientProfile',
    name: 'PatientProfile',
    component: () => import('../views/patient/PatientProfile.vue')
  },
  {
    path: '/patientScheduleConsultation',
    name: 'PatientScheduleConsultation',
    component: () => import('../views/patient/ScheduleConsultation.vue')
  },
  {
    path: '/patientPromotions',
    name: 'PatientPromotions',
    component: () => import('../views/patient/Promotions.vue')
  },
  {
    path: '/patientMedicinePrescriptions',
    name: 'PatientMedicinePrescriptions',
    component: () => import('../views/patient/MedicinePrescriptions.vue')
  },
  {
    path: '/patientIssuedMedicine',
    name: 'PatientIssuedMedicine',
    component: () => import('../views/patient/IssuedEMedicine.vue')
  },
  {
    path: '/patientPenaltyInsight',
    name: 'PatientPenaltyInsight',
    component: () => import('../views/patient/PenaltyInsight.vue')
  },
  {
    path: '/patientWriteComplaint',
    name: 'PatientWriteComplaint',
    component: () => import('../views/patient/WriteComplaint.vue')
  },
  {
    path: '/patientScheduleExamination',
    name: 'PatientScheduleExamination',
    component: () => import('../views/patient/ScheduleExamination.vue')
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
  },
  {
    path: '/pharmacy/profile/:pharmacyId',
    name: 'PharmacyProfile',
    component: () => import('../views/pharmacy/PharmacyProfile.vue')
  },
  {
    path: '/pharmacyAdmin/profile/:pharmacyAdminId',
    name: 'PharmacyAdminProfile',
    component: () => import('../views/pharmacyAdmin/PharmacyAdminProfile.vue')
  },
  {
    path: '/pharmacyAdmin/AppointmentWithDermatologistForm',
    name: 'AppointmentWithDermatologistForm',
    component: () => import('../views/pharmacyAdmin/AppointmentWithDermatologistForm.vue')
  },
  {
    path: '/pharmacyAdmin/definePromotion',
    name: 'DefinePromotion',
    component: () => import('../views/pharmacyAdmin/DefinePromotion.vue')
  },
  {
    path: '/pharmacyAdmin/defineMedicineOrder',
    name: 'DefineMedicineOrder',
    component: () => import('../views/pharmacyAdmin/DefineMedicineOrder.vue')
  },
  {
    path: '/pharmacyAdmin/chooseMedicineOffer',
    name: 'ChooseMedicineOffer',
    component: () => import('../views/pharmacyAdmin/ChooseMedicineOffer.vue')
  },
  {
    path: '/users/verify/:hash',
    component: () => import('../views/Verify.vue'),
    name: 'Vefrification'
  },
  {
    path: '/systemAdminHomePage',
    name: 'SystemAdminHomePage',
    component: () => import('../views/systemAdmin/SystemAdminHomePage.vue')
  },
  {
    path: '/systemAdminHomePage/addPharmacy',
    name: 'SystemAdminAddPharmacy',
    component: () => import('../views/systemAdmin/SystemAdminAddPharmacy.vue')
  },
  {
    path: '/systemAdminHomePage/addPharmacyAdmin',
    name: 'SystemAdminAddPharmacyAdmin',
    component: () => import('../views/systemAdmin/SystemAdminAddPharmacyAdmin.vue')
  },
  {
    path: '/systemAdminHomePage/addDermatologist',
    name: 'SystemAdminAddDermatologist',
    component: () => import('../views/systemAdmin/SystemAdminAddDermatologist.vue')
  },
  {
    path: '/systemAdminHomePage/addSupplier',
    name: 'SystemAdminAddSupplier',
    component: () => import('../views/systemAdmin/SystemAdminAddSupplier.vue')
  },
  {
    path: '/systemAdminHomePage/addMedicine',
    name: 'SystemAdminAddMedicine',
    component: () => import('../views/systemAdmin/SystemAdminAddMedicine.vue')
  },
  {
    path: '/systemAdminHomePage/complaintments',
    name: 'SystemAdminAnswerOnComplaintments',
    component: () => import('../views/systemAdmin/SystemAdminAnswerOnComplaintments.vue')
  },
  {
    path: '/systemAdminHomePage/answerOnSpecificComplainment/:complainmentID',
    name: 'AnswerOnSpecificComplainment',
    component: () => import('../views/systemAdmin/AnswerOnSpecificComplainment.vue')
  },
  {
    path: '/systemAdminHomePage/LoyaltyProgram',
    name: 'LoyaltyProgram',
    component: () => import('../views/systemAdmin/LoyaltyProgram.vue')
  },
  {
    path: '/systemAdminHomePage/AddSystemAdmin',
    name: 'AddSystemAdmin',
    component: () => import('../views/systemAdmin/AddSystemAdmin')
  },
  {
    path: '/systemAdminHomePage/FirstLogin',
    name: 'FirstLogin',
    component: () => import('../views/systemAdmin/FirstLogin.vue')
  },
  {
    path: '/supplierHomePage',
    name: 'supplierHomePage',
    component: () => import('../views/supplier/supplierHomePage.vue')
  },
  {
    path: '/supplierHomePage/viewOrders',
    name: 'viewOrders',
    component: () => import('../views/supplier/ViewOrders.vue')
  },
  {
    path: '/supplierHomePage/giveOffer/:orderId',
    name: 'giveOffer',
    component: () => import('../views/supplier/giveOffer.vue')
  },
  {
    path: '/supplierHomePage/MyOffers',
    name: 'MyOffers',
    component: () => import('../views/supplier/MyOffers.vue')
  },
  {
    path: '/supplierHomePage/Profile',
    name: 'profile',
    component: () => import('../views/supplier/profile.vue')
  },
  {
    path: '/supplierHomePage/ChangePassword',
    name: 'ChangePassword',
    component: () => import('../views/supplier/ChangePassword.vue')
  },
  {
    path: '/patient/subscribeToPharmacypromotion',
    name: 'SubscribeToPharmacy',
    component: () => import('../views/patient/SubscribeToPharmacy.vue')
  },
  {
    path: '/patient/RecipePage/:recipeId',
    name: 'RecipePage',
    component: () => import('../views/patient/RecipePage.vue')
  },
  {
    path: '/patient/QRCodeRecipe',
    name: 'QRCodeRecipe',
    component: () => import('../views/patient/QRCodeRecipe.vue')
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
