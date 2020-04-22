import Vue from 'vue'
import App from './App.vue'

import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.use(VueAxios, axios);

import MyNav from './component/MyNav.vue'
import MyBanner from './component/MyBanner.vue'
import MyProducts from './component/MyProducts.vue'


Vue.component("MyNav", MyNav);
Vue.component("MyBanner", MyBanner);
Vue.component("MyProducts", MyProducts);

new Vue({
  el: '#app',
  render: h => h(App)
})
