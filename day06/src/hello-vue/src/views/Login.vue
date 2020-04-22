<template>
  <div>
    <div class="login-box">
      <h1 class="login-title">登录页面</h1>
      <el-form :rules="rules" label-position="left" ref="form" :model="form" label-width="80px">
        <el-form-item label="name" prop="name">
          <el-input v-model="form.name" placeholder="name"></el-input>

        </el-form-item>
        <el-form-item label="password" prop="password">
          <el-input type="password" v-model="form.password" placeholder="password"></el-input>
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
    export default {
        name: "Login",
        data() {
          return {
            form: {
              name: '',
              password: '',
            },
            rules: {
              name: [
                { required: true, message: '请输入name', trigger: 'blur' },
                { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
              ],
              password: [
                { required: true, message: '请输入password', trigger: 'blur' },
                { min: 6, max: 6, message: '长度6个字符', trigger: 'blur' }
              ],
            },
          }
        },
        methods: {
          submitForm(formName) {
            this.$refs[formName].validate((valid) => {
              if (valid) {
                var vm = this;
                this.axios({
                  method: 'get',
//                  url: 'http://localhost:8080/login',
                  url: 'http://localhost:8080/login?name='+ vm.form.name + '&password='+ vm.form.password,
//                  data: {
//                    name: vm.form.name,
//                    password: vm.form.password,
//                  },
//                  transformRequest: [ function (data) {
//                    return Qs.stringify(data);
//                  }],
//                  headers: {
//                    'Content-Type': 'application/x-www-form-urlencoded'
//                  },
                }).then(function (response) {
                  if (response.data == "success"){
                    vm.$router.push("/home");
                  }
                  else {
                    vm.$message.error("用户密码错误，请重新输入");
                    return false;
                  }
                });
              } else {
                this.$message.error('用户名或密码格式错误!!');
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

