<template>
    <div>
      商品列表{{id}}
      <!--<table>-->
        <!--<tr>标题</tr>-->
        <!--<tr v-for="product in products">-->
          <!--<td v-for="value in product"></td>-->
        <!--</tr>-->
      <!--</table>-->
    </div>
</template>

<script>
    export default {
        name: "Products",
        data(){
            return{
              id: this.$route.params.id,
//              products:[]
            }
        },
//      发送axios，请求后端接口，根据id参数可以查询数据库的商品分类，获得所有手机的商品列表，填充到this.products
//        created(){
//          this.axios({
//            method: "get",
//            url:"",
//
//          }).then(function (response) {
//            this.products = response.data;
//          })
//        }
    }
</script>

<style scoped>

</style>
