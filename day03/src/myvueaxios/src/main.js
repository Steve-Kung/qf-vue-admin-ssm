import Vue from 'vue'
import App from './App.vue'

import axios from 'axios'
import VueAxios from 'vue-axios'
import qs from 'qs'

Vue.use(VueAxios, axios);
Vue.use(qs);

new Vue({
  el: '#app',
  render: h => h(App)
})
