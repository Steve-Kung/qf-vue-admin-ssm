import Vue from 'vue'
import App from './App.vue'

import Header from "./component/Header.vue"
import Content from "./component/Content.vue"
import Bottom from "./component/Bottom.vue"

// 全局注册了三个组件==》可以把组件拿来当标签一样的使用
Vue.component("myHeader", Header);
Vue.component("myContent", Content);
Vue.component("myBottom", Bottom);

new Vue({
  el: '#app',
  render: h => h(App)
})
