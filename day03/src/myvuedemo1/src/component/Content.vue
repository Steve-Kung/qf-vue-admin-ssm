<template>
    <div>
      {{content}}
      <div>
        {{MyProp}}<br>
        <button type="button" @click="btnfn('hello java')">点我</button>
      </div>
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
        props: {
          'MyProp': {
            type: String,
            required: true,
            default: '默认的父传子参数值'
          },
          'btnfn': {
//            子传父的函数
            type: Function,
          }
        }
    }
</script>

<style scoped>

</style>
