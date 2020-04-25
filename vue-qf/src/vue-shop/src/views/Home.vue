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
          <div class="block">
            <!--<span class="demonstration">默认 Hover 指示器触发</span>-->
            <el-carousel indicatorPosition="none" height="500px">
              <el-carousel-item v-for="item in bannerimgs">
                <h3 class="small">
                  <img :src="item" alt="img not found">
                </h3>
              </el-carousel-item>
            </el-carousel>
          </div>
          <br>
          <div class="products">
            <div v-for="product in products" class="product">
              <img :src="product.pimg" alt="">
              <br>
              <h4>{{product.pname}}</h4>
              <h5>{{product.price}}</h5>
              <!--<router-link :to="{name:'ProductInfo',params:{pid:product.pid}}">点击购买</router-link>-->
              <el-button type="primary" round @click="productInfo(product.pid)">点击详情</el-button>
            </div>
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
      name: "Home",
      data(){
        return{
          bannerimgs: [
            "../../static/banner1.jpg",
            "../../static/banner2.jpg"
          ],
          products: null,
          userName: this.$store.getters.getUser.userName,
          isLogined: this.$store.getters.getUser.userName == "" ? false : true,
        }
      },
      created(){
        this.getProducts();
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
        getProducts: function () {
          var vm = this;
          this.axios({
            method: "get",
            url: "http://localhost:8080/products",
          }).then(function (response) {
            vm.products = response.data;
          })
        },
        productInfo: function (pid) {
          this.$router.push("/productInfo/" + pid);
        }
      }
    }
</script>

<style scoped>
  .product{
    display: inline-block;
    width: 100%;
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
