import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import ProductInfo from '../views/ProductInfo.vue'
import ProductPay from '../views/ProductPay.vue'
import Cart from '../views/Cart.vue'
import Login from '../views/Login.vue'
import OrderDisplay from '../views/OrderDisplay.vue'

Vue.use(VueRouter);

export default new VueRouter({
  mode: "history",
  routes: [
    {
      path: '/productInfo/:pid',
      name: 'ProductInfo',
      component: ProductInfo,
    },
    {
      path: '/home',
      name: 'Home',
      component: Home,
    },
    {
      path: '/productPay',
      name: 'ProductPay',
      component: ProductPay,
    },
    {
      path: '/cart',
      name: 'Cart',
      component: Cart,
    },
    {
      path: '/login',
      name: 'Login',
      component: Login,
    },
    {
      path: '/orderDisplay',
      name: 'OrderDisplay',
      component: OrderDisplay,
    },
    {
      path: '/logout',
      redirect:'/login',
    },
    {
      path: '/*',
      redirect: '/home',
    },


  ]
});
