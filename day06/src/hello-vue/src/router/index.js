import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'
import Home from '../views/Home.vue'

import ProductsList from '../components/ProductsList.vue'
import UserList from '../components/UserList.vue'

import ProductInfo from '../components/ProductInfo.vue'

Vue.use(VueRouter);

export default new VueRouter({
  routes: [
    {
      path: '/login',
      name: 'Login',
      component: Login,
    },
    {
      path: '/home',
      name: 'Home',
      component: Home,
      children: [
        {
          path: '/home/UserList',
          name: 'UserList',
          component: UserList,
        },
        {
          path: '/home/ProductsList',
          name: 'ProductsList',
          component: ProductsList,
        },
        {
          path: "/home/ProductInfo/:id",
          name: 'ProductInfo',
          component: ProductInfo,
        },
      ]
    },
    {
      path: "/logout",
      redirect: '/login'
    },

  ]
});
