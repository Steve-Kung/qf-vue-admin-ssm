<template>
    <div>
      <div>首页</div>

      <div class="img_box" v-for="img in imgs">
        <img width="100%" height="100%" :src="img" alt="img not found">
      </div>

    </div>
</template>

<script>
    export default {
        name: "Home",
        data(){
          return{
            imgs: [
              "../img/1.jpg",
              "../img/2.jpg"
            ]
          }
        }
    }
</script>

<style scoped>
  .img_box{
    display: inline-block;
    width: 300px;
    height: 300px;
  }
</style>
