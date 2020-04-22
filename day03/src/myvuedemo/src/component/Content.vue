<template>
    <div>
      {{content}}<br>
      <button type="button" @click="doClick">点我</button>
      <br>
      {{MyProp2}}
    </div>
</template>

<script>
    export default {
        name: "Content",
        data(){
          return{
            content: "products list"
          }
        },
        methods: {
          doClick: function () {
            this.$emit('prop1','hello js');
          }
        },
        props: ["MyProp2"],
    }
</script>

<style scoped>

</style>
