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
          购物车。。。
          {{this.$route.params.userId}} <br>
          {{this.$route.params.pid}} <br>
          {{this.$route.params.count}} <br>
          <el-table
            ref="multipleTable"
            :data="tableData"
            tooltip-effect="dark"
            style="width: 100%"
            @selection-change="handleSelectionChange">
            <el-table-column
              type="selection"
              width="55">
            </el-table-column>
            <el-table-column
              prop="pname"
              label="商品名称"
              width="240">
            </el-table-column>
            <el-table-column
              prop="price"
              label="商品价格"
              width="120">
            </el-table-column>
            <el-table-column
              prop="pcount"
              label="商品数量"
              show-overflow-tooltip>
            </el-table-column>
          </el-table>
          <div align="right" style="margin: 10px">
            <h3>
              TotalMoney: {{totalMoney}} 元
            </h3>
          </div>


          <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="收件人名称" prop="orderUser">
              <el-input v-model="ruleForm.orderUser"></el-input>
            </el-form-item>
            <el-form-item label="收件人电话" prop="orderTel">
              <el-input v-model="ruleForm.orderTel"></el-input>
            </el-form-item>
            <el-form-item label="收件人地址" prop="orderAddr">
              <el-input v-model="ruleForm.orderAddr"></el-input>
            </el-form-item>

          </el-form>


          <div style="margin-top: 20px">
            <el-button class="el-button--danger" @click="createOrder">提交订单</el-button>
            <el-button class="el-button--success" @click="">返回</el-button>
          </div>
        </el-main>

        <el-footer height="200px">
          Footer 版权所有@steve
        </el-footer>
      </el-container>
    </div>
</template>

<script>
  import Qs from 'qs';
    export default {
        name: "Cart",
      data() {
        return {
          tableData: [{
            pname: 'p30',
            price: 5955,
            pcount: 1
          }],
          multipleSelection: [],
          totalMoney: 0,

          ruleForm: {
            orderUser: '',
            orderTel: '',
            orderAddr: '',
          },
          rules: {
            orderUser: [
              {required: true, message: '请输入收件人名称', trigger: 'blur'},
              {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
            ],
            orderTel: [
              {required: true, message: '请输入收件人电话', trigger: 'blur'},
              {min: 11, max: 11, message: '长度11个字符', trigger: 'blur'}
            ],
            orderAddr: [
              {required: true, message: '请输入收件人地址', trigger: 'blur'},
              {min: 0, max: 20, message: '长度在 0 到 20 个字符', trigger: 'blur'}
            ],
          },
          userName: this.$store.getters.getUser.userName,
          isLogined: this.$store.getters.getUser.userName == "" ? false : true,
        }
      },
      mounted(){
          this.getData();
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
        createOrder: function () {
          // 封装orderData
          var orderDTO = {
            userId: this.$route.params.userId,
            orderPrice: this.totalMoney,
            orderUser: this.ruleForm.orderUser,
            orderTel:  this.ruleForm.orderTel,
            orderAddr:  this.ruleForm.orderAddr,

            pids: [],
          };
          var i = 0;
          this.multipleSelection.forEach((row)=>{
            orderDTO.pids[i] = row.pid;
            i++;
          });
          console.log(orderDTO);
          // 发送请求
          var vm = this;
          this.axios({
            method: 'post',
            url: 'http://localhost:8080/order',
            data: orderDTO,
            transformRequest: [function (data) {
              return Qs.stringify(data)
            }]
          }).then(function (response) {
//              console.log(response.data);
              if (response.data.result){
                vm.$message.success(response.data.message);
                setTimeout(function () {
                  vm.$router.push("/orderDisplay");
                }, 2000)
              } else {
                vm.$message.error(response.data.message);
              }
          });
        },

//        submitForm(formName) {
//          this.$refs[formName].validate((valid) => {
//            if (valid) {
//              alert('submit!');
//            } else {
//              console.log('error submit!!');
//              return false;
//            }
//          });
//        },
//        resetForm(formName) {
//          this.$refs[formName].resetFields();
//        },
        handleSelectionChange(val) {
          this.totalMoney = 0;
          this.multipleSelection = val;
          console.log(val);
          this.multipleSelection.forEach((row)=>{
            console.log(row);
            this.totalMoney += row.price * row.pcount;
          })
        },
        getData: function () {
            var vm = this;
            var params = {
                userId: this.$route.params.userId,
                pid: this.$route.params.pid,
                pcount: this.$route.params.count,
            };
            this.axios({
              method: "post",
              url: "http://localhost:8080/addCart",
              data: params,
              transformRequest: [function (data) {
                return Qs.stringify(data)
              }]
            }).then(function (response) {
                vm.tableData = response.data;
              });
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
