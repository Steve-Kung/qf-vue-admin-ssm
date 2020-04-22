<template>
  <!--商品列表-->
  <div>
    <!--第一行的商品-->
    <div>
      <div v-for="product in products" class="product">
        <img :src="product.pimg" alt=""><br>
        <p>{{product.pname}}</p>
        <p>{{product.price}}</p>
      </div>
    </div>


  </div>
</template>

<script>
    export default {
        name: "MyProducts",
//        data() {
//          return {
//            products: [
//              {
//                pname: 'huawei p30 pro',
//                pimg: '../static/img/p30.jpg',
//                price: 4988
//              },
//              {
//                pname: 'iphone xr',
//                pimg: '../static/img/iphone.jpg',
//                price: 5988
//              },
//              {
//                pname: 'nokia',
//                pimg: '../static/img/nokia.jpg',
//                price: 488
//              },
//
//            ]
//          }
//        },
        props: ["products"],
    }
</script>

<style scoped>

</style>
