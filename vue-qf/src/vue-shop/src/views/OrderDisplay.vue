<template>
  <div>
    <el-container>
      <el-header height="60px">
        <el-col :span="12"><div class="grid-content bg-purple" align="left">
          <img style="margin-top: 5px" src="../assets/logo.png" alt="图片不见了" height="50px">
        </div></el-col>
        <el-col v-if="!isLogined" :span="12"><div class="grid-content bg-purple-light" align="right">
          <el-button type="primary" @click="login">登录</el-button>
          <el-button type="success">注册</el-button>
        </div></el-col>
        <el-col v-if="isLogined" :span="12"><div class="grid-content bg-purple-light" align="right">
          <span>welcome! {{userName}}</span>
          <el-button type="danger" @click="logout">注销</el-button>
        </div></el-col>
      </el-header>

      <el-main>
        <h1>订单页面</h1>
        <div v-for="cod in createOrderDTO">
          <span>订单时间: {{cod.createTime}}</span>
          <span>-------</span>
          <span>订单编号: {{cod.orderId}}</span>
          <el-table
            :data="cod.products"
            style="width: 100%">
            <el-table-column
              prop="pname"
              label="商品名称"
              width="120">
            </el-table-column>
            <el-table-column
              prop="price"
              label="商品价格"
              width="120">
            </el-table-column>
            <el-table-column
              prop="pcount"
              label="商品数量">
            </el-table-column>
          </el-table>
          <span style="font-size: medium; color: red">订单总金额: {{cod.orderPrice}}------</span>
          <el-button class="el-button--danger" @click="doPay(cod)">支付订单</el-button>
          <br>
          <br>
          <br>
        </div>

      </el-main>

      <el-footer height="200px">
        Footer 版权所有@steve
      </el-footer>
    </el-container>
  </div>
</template>

<script>
  export default {
    name: "OrderDisplay",
    data(){
      return{
        userName: this.$store.getters.getUser.userName,
        isLogined: this.$store.getters.getUser.userName == "" ? false : true,
        createOrderDTO :[],
//        userAmount: null,
      }
    },
    created(){
      this.getData();
    },
//    mounted(){
//      var vm = this;
//      this.axios({
//        method: 'get',
//        url: "http://localhost:8080/amount?userId=" + vm.$store.getters.getUser.userId,
//      }).then(function (response) {
//        vm.userAmount = response.data.userAmount;
//      });
//    },
    methods:{
      logout: function () {
        this.$router.push('/logout');
        sessionStorage.removeItem('state');
        var user = {
          userName: '',
        };
        this.$store.dispatch('asyncUpdateUser',user);
      },
      login: function () {
        this.$router.push("/login");
      },
      getData(){
        var vm = this;
        this.axios({
          method: 'get',
          url: "http://localhost:8080/orderList?userId=" + this.$store.getters.getUser.userId,
        }).then(function (response) {
          vm.createOrderDTO = response.data;
        });
      },
      doPay: function (cod) {
        var params = {
//          userAmount: this.userAmount,
          orderId: cod.orderId,
          orderPrice: cod.orderPrice,
        };
        this.$router.push({name:'ProductPay', params: params});
      }

    }
  }
</script>

<style scoped>
  .product{
    display: inline-block;
    width: 30%;
    /*border: solid gray 1px;*/
  }
  .product img{
    width: 50%;
    margin: 10px 5px 0px 5px;
  }
  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
    padding: 0px 50px 0px 50px;
  }



  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    /*line-height: 80px;*/
    /*height: 800px;*/
    padding: 10px 150px 50px 150px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }

</style>

