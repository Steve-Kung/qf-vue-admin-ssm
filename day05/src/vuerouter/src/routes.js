import Home from './views/Home.vue'
import Products from './views/Products.vue'

export const routes = [
  {
    path: '/',
    component: Home
  },
  {
    //路由的参数传递
    path: '/products/:id',
    component:Products
  }

]
