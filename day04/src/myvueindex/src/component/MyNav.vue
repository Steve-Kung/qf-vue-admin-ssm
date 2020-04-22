<template>
  <!--导航条-->
  <div>
    <ul class="nav nav-pills">
      <!--<li role="presentation" class="active"><a href="#">Home</a></li>-->
      <!--<li role="presentation"><a href="#">Profile</a></li>-->
      <li v-for="nav in navigateData" role="presentation"><a href="#">{{nav}}</a></li>
    </ul>
  </div>
</template>

<script>
    export default {
        name: "MyNav",
//        data() {
//          return {
//            navigateData: [
//              "首页", "最新商品", "搜索", "购物车", "我的订单"
//            ],
//          }
//        },
        props: ["navigateData"],
    }
</script>

<style scoped>

</style>
