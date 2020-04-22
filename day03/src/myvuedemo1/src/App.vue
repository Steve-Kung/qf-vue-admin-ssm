<template>
  <div id="app">
    <Header></Header>
    <br>
    <Content :MyProp="msg" :btnfn="FCfn"></Content>
    <br>
    <Bottom></Bottom>
  </div>
</template>

<script>
  import Header from "./component/Header.vue"
  import Content from "./component/Content.vue"
  import Bottom from "./component/Bottom.vue"
export default {
  name: 'app',
  components: {
    Header: Header,
    Content: Content,
    Bottom: Bottom,
  },
  data(){
    return{
      msg: "父传子的参数"
    }
  },
  methods: {
    FCfn: function (m) {
      this.msg = m;
    }
  }
}
</script>

<style>

</style>
