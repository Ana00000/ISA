import Vue from 'vue'
import App from './App.vue'
import router from './router'
import vuetify from './plugins/vuetify'
import axios from "axios"
import DatetimePicker from 'vuetify-datetime-picker'
import Statistics from "vue-chartjs"

Vue.config.productionTip = false
Vue.prototype.$http = axios

new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')

Vue.use(DatetimePicker)
Vue.use(Statistics)
// Vue.use()
// Vue.use(Boo)


