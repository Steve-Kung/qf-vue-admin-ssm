<template>
  <div id="app">
    <div class="container">
      <br>
      <br>
      <div class="row">
        <ul class="nav nav-tabs">
          <li role="presentation" class="active">
            <router-link to="/">首页</router-link>
          </li>
          <li role="presentation">
            <router-link to="/products/1">手机商品列表</router-link>
          </li>
          <li role="presentation">
            <button class="button" @click="btnfn">js路由跳转</button>
          </li>
        </ul>
      </div>
      <br>
      <br>

      <div class="row">
        <div id="rv">
          <router-view></router-view>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'app',
  data () {
    return {

    }
  },
  methods: {
    btnfn: function () {
      this.$router.push("/products/1");
    }
  }
}
</script>

<style>
  #rv{
    border: 1px solid red;
  }
</style>
