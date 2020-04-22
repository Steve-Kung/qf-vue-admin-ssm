<template>
  <div id="app">
    <h1>{{ msg }}</h1>

    <myHeader></myHeader>
    <myContent :MyProp2="getProp1" @prop1="getProp1=$event"></myContent>
    <myBottom></myBottom>

  </div>
</template>

<script>
export default {
  name: 'app',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      getProp1: "hello vue"
    }
  }
}
</script>

<style>

</style>
