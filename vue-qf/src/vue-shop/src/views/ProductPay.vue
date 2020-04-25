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
          <h1>支付页面</h1>
          <h2>当前余额：{{userAmount}}</h2>
          <h2>要支付的金额：{{orderPrice}}</h2>
          <h3>订单编号：{{orderId}}</h3>
          <h3>pid：{{pid}}</h3>
          <h2>是否使用余额支付</h2>
          <div v-if="isAmountEnough">
            <el-radio v-model="isUseAmount" label="1">余额支付</el-radio>
            <el-radio v-model="isUseAmount" label="2">微信支付</el-radio>
          </div>
          <div v-else>
            <h5>余额不足,请使用微信支付</h5>
            <el-radio disabled v-model="isUseAmount" label="1">余额支付</el-radio>
            <el-radio v-model="isUseAmount" label="2">微信支付</el-radio>
          </div>

          <div v-if="isUseAmount == '2'">
            <br>
            <br>
            <!--orderId,pid,orderPrice-->
            <img :src="getQRcodeURL()" alt="图片找不到">
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
      name: "ProductPay",
      data(){
          return{
            userName: this.$store.getters.getUser.userName,
            isLogined: this.$store.getters.getUser.userName == "" ? false : true,
//            userAmount: this.$route.params.userAmount,
            userAmount: 0,
            isUseAmount: '1',
            isAmountEnough: true,
            orderPrice: this.$route.params.orderPrice,
            orderId: this.$route.params.orderId,
            pid: 1,
          }
      },
      created(){
        this.getData();
      },
      mounted(){
        var vm= this;
        this.$goEasy.subscribe({
          channel: this.orderId, //替换为您自己的channel
          onMessage: function (message) {
            console.log("Channel:" + message.channel + " content:" + message.content);
//            message.content只是个json格式的json字符串，并不是json数据
//            console.log(message.content.msg);
//            console.log(message.content.msg == "支付成功");
            var result = eval("("+message.content+")");
            alert(result.msg);
//                console.log(typeof result.msg); // string
            if (result.msg == "支付成功"){
              vm.$message.success("支付成功");
              location.href='http://localhost:8081/';
            } else {
              vm.$message.error("支付失败");
              location.href='http://localhost:8081/';
            }
          }
        });
      },
//      mounted(){
////        this.userAmount 在前一个页面先请求好，再通过路由参数传递的的方式，传递到本页面
//        if (this.userAmount >= this.orderPrice){
//          this.isAmountEnough = true;
//        } else{
//          this.isAmountEnough = false;
//        }
//      },
      methods:{
        getQRcodeURL(){
          return 'http://localhost:8080/doPay?orderId='+this.orderId+'&pid='+this.pid+'&orderPrice='+this.orderPrice;
        },
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
            url: "http://localhost:8080/amount?userId=" + vm.$store.getters.getUser.userId,
          }).then(function (response) {
            vm.userAmount = response.data.userAmount;
            if (vm.userAmount >= vm.orderPrice){
              vm.isAmountEnough = true;
            } else{
              vm.isAmountEnough = false;
            }
          })
        },
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
