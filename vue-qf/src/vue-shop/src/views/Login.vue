<template>
  <div>
    <div class="login-box">
      <h1 class="login-title">登录页面</h1>
      <el-form :rules="rules" label-position="left" ref="form" :model="form" label-width="80px">
        <el-form-item label="手机号码" prop="userTel">
          <el-input v-model="form.userTel" placeholder="userTel"></el-input>

        </el-form-item>
        <el-form-item label="密码" prop="userPwd">
          <el-input type="password" v-model="form.userPwd" placeholder="userPwd"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="submitForm('form')">提交</el-button>
          <el-button @click="resetForm('form')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>

</template>

<script>
  import Qs from 'qs';
    export default {
        name: "Login",
        data() {
          return {
            form: {
              userTel: '',
              userPwd: '',
            },
            rules: {
              userTel: [
                { required: true, message: '请输入userTel', trigger: 'blur' },
                { min: 11, max: 11, message: '长度11个数字', trigger: 'blur' }
              ],
              userPwd: [
                { required: true, message: '请输入userPwd', trigger: 'blur' },
                { min: 3, max: 20, message: '长度3~20个字符', trigger: 'blur' }
              ],
            },
          }
        },
        methods: {
          submitForm(formName) {
            this.$refs[formName].validate((valid) => {
              // 表单验证成功
              if (valid) {
                var vm = this;
                this.axios({
                  method: 'post',
                  url: 'http://localhost:8080/login',
                  data: vm.form,
                  transformRequest: [ function (data) {
                    return Qs.stringify(data);
                  }],
                }).then(function (response) {
                  if (response.data.result){
                    // 1.往浏览器里存储
//                    sessionStorage.setItem("isLogin","true");

                    var user = response.data.data;
                    // 往vuex里存放一个user对象
                    vm.$store.dispatch('asyncUpdateUser', user);


                    vm.$message.success(response.data.message);
                    setTimeout(function () {
                      vm.$router.push("/home");
                    }, 2000)
                  } else {
                    vm.$message.error(response.data.message);
                    return false;
                  }
                });
              } else {
                // 表单验证失败
                this.$message.error('用户电话或密码格式错误!!');
                return false;
              }
            });
          },
          resetForm(formName) {
            this.$refs[formName].resetFields();
          }
        }
    }
</script>

<style scoped>
  .login-box{
    width: 50%;
    height: 300px;
    border: solid 1px;
    color: darkgray;
    margin: 150px auto;
    padding: 20px 30px 20px 30px;
    border-radius: 20px;
    box-shadow: 0px 0px 20px darkgray;
  }
  .login-title{
    text-align: center;
  }
</style>

