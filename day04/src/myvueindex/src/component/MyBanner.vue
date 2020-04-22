<template>
  <!--轮播图-->
  <div>
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
      </ol>

      <!-- Wrapper for slides -->
      <div class="carousel-inner" role="listbox">
        <!--<div class="item active">-->
        <!--<img src="..." alt="...">-->
        <!--<div class="carousel-caption">-->
        <!--...-->
        <!--</div>-->
        <!--</div>-->
        <!--<div class="item active">-->
        <!--<img style="width: 100%; height: 400px" :src="banner_imgs[0]" alt="你的图挂了">-->
        <!--<div class="carousel-caption">-->
        <!--hahaha-->
        <!--</div>-->
        <!--</div>-->

        <div v-for="(myimg, i) in banner_imgs" :key="i" :class="i==0?'active':''" class="item">
          <img style="width: 100%; height: 400px" :src="myimg" alt="你的图挂了">
          <div class="carousel-caption">
            heiheihei
          </div>
        </div>



      </div>

      <!-- Controls -->
      <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>


  </div>
</template>

<script>
    export default {
        name: "MyBanner",
//        data() {
//          return{
//            banner_imgs: [
//              "../static/img/1.jpg",
//              "../static/img/2.jpg",
//
//            ],
//          }
//        },
        props: ["banner_imgs"],
    }
</script>

<style scoped>

</style>
