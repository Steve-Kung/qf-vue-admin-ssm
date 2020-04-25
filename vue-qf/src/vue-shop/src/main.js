// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import axios from 'axios'
import VueAxios from 'vue-axios'

import router from './router'

import Vuex from 'vuex'
import store from './store'

import GoEasy from 'goeasy';

Vue.use(Vuex);

Vue.use(VueAxios, axios);


Vue.use(ElementUI);

Vue.config.productionTip = false

// // 在跳转前执行
// router.beforeEach((to, from, next) => {
//   // 获取用户登录状态
//   let isLogin = sessionStorage.getItem('isLogin');
//   // 注销
//   if (to.path == '/logout'){
//     // 清空
//     // sessionStorage.clear();
//     sessionStorage.removeItem('isLogin');
//     // 跳转到登录
//     next({path: '/login'});
//   }
//   // 如果请求的是登录页面
//   else if(to.path == '/login') {
//     if (isLogin != null){
//       // 跳转到首页
//       next({path: '/home'});
//     }
//   }
//   // 如果为非登录状态
//   else if (isLogin == null){
//     // 跳转到登录页
//     next({path: '/login'});
//   }
//   // 下一个路由
//   next();
// });


//创建全局GoEasy对象
Vue.prototype.$goEasy = new GoEasy({
  host:'hangzhou.goeasy.io', //应用所在的区域地址: 【hangzhou.goeasy.io |singapore.goeasy.io】
  appkey: "BC-b5e939205b4146e08f46c49e3f44a5a9", //替换为您的应用appkey
  onConnected: function() {
    console.log('连接成功！')
  },
  onDisconnected: function() {
    console.log('连接断开！')
  },
  onConnectFailed: function(error) {
    console.log('连接失败或错误！')
  }
});


/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  store,
});
