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
          <!--左图右价格-->
          <el-row>
            <el-col :span="8"><div class="grid-content bg-purple">
              <img :src="product.pimg" alt="">
            </div></el-col>
            <el-col :span="16"><div class="grid-content bg-purple-light">
              <el-row>
                <el-col :span="12"><div class="grid-content bg-purple" align="right">
                  <h1>商品名字：</h1>
                </div></el-col>
                <el-col :span="12"><div class="grid-content bg-purple-light">
                  <h2>{{product.pname}}</h2>
                </div></el-col>
              </el-row>

              <el-row>
                <el-col :span="12"><div class="grid-content bg-purple" align="right">
                  <h1>商品价格：</h1>
                </div></el-col>
                <el-col :span="12"><div class="grid-content bg-purple-light">
                  <h2>{{product.price}}</h2>
                </div></el-col>
              </el-row>
              <el-row>
                <el-col :span="12"><div class="grid-content bg-purple" align="right">
                  <h1>商品数量：</h1>
                </div></el-col>
                <el-col :span="12"><div class="grid-content bg-purple-light">
                  <h2><el-input v-model="count" placeholder="请输入数量"></el-input></h2>
                </div></el-col>
              </el-row>
              <el-button type="danger" round @click="toCart(product.pid)">加入购物车</el-button>
            </div></el-col>
          </el-row>
          <!--商品详情介绍-->
          <el-row>
            <el-col :span="24"><div class="grid-content bg-purple">
              商品详情介绍。。。
            </div></el-col>
          </el-row>
        </el-main>

        <el-footer height="200px">
          Footer 版权所有@steve
        </el-footer>
      </el-container>
    </div>
</template>

<script>
    export default {
      name: "ProductInfo",
      data(){
          return{
            userId: this.$store.getters.getUser.userId,
            count: 1,
            product: {
              "id": this.$route.params.pid,
              "pid": 10001,
              "pname": "p30",
              "price": 6899,
              "pimg": "/static/p30.jpg",
            },
            userName: this.$store.getters.getUser.userName,
            isLogined: this.$store.getters.getUser.userName == "" ? false : true,

          }
      },
      mounted(){
        this.getdata();
      },
      methods: {
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
        getdata: function () {
          var vm = this;
          this.axios({
            url: "http://localhost:8080/product/"+this.$route.params.pid,
            method: "get",
          }).then(function (response) {
            vm.product = response.data;
          })
        },
//        buyProduct: function (pid) {
//          this.$router.push("/productPay/" + pid);
//        },
        toCart: function (pid) {
          this.$router.push({name: 'Cart', params: {
            userId: this.userId,
            pid: pid,
            count: this.count
          }});
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
