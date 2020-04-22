<template>
  <div id="app" class="container">
    <MyNav :navigateData="navigateData"></MyNav>
    <MyBanner :banner_imgs="banner_imgs"></MyBanner>
    <MyProducts :products="products"></MyProducts>
  </div>
</template>

<script>
export default {
  name: 'app',
  data(){
    return{
      navigateData: ["首页", "最新商品", "搜索", "购物车", "我的订单"],
      banner_imgs: [
        "../static/img/1.jpg",
        "../static/img/2.jpg"
      ],
      products: [
        {
          pname: "huawei p30 pro",
          pimg: "../static/img/p30.jpg",
          price: 4988
        },
        {
          pname: "iphone xr",
          pimg: "../static/img/iphone.jpg",
          price: 5988
        },
        {
          pname: "nokia",
          pimg: "../static/img/nokia.jpg",
          price: 488
        }
      ]
    }
  },
//  created(){
//    this.axios({
//      method: 'get',
//      url: 'http://localhost:8080/static/mock/data.json',
//
//    }).then(function (response) {
//      this.navigateData = response.data.navigateData;
//      this.banner_imgs = response.data.banner_imgs;
//      this.products = response.data.products;
//    })
//  }
}
</script>

<style>

</style>
