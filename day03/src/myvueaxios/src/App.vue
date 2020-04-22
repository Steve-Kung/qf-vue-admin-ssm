<template>
  <div id="app">
    <div style="width: 50%" class="container">
      <div>
        <h3>Regist</h3>
        <h5>Email</h5>
        <input type="text" class="form-control" v-model="mail"><br>
        {{mail}}
        <h5>Password</h5>
        <input type="password" class="form-control" v-model="password"><br>
        {{password}}
        <h5>Gender</h5>
        <input type="radio" name="gender" v-model="gender" value="female">男
        <input type="radio" name="gender" v-model="gender" value="male">女 <br>
        {{gender}}
        <h5>Hobby</h5>
        <input type="checkbox" name="hobby" v-model="hobby" value="music">music
        <input type="checkbox" name="hobby" v-model="hobby" value="movie">movie
        <input type="checkbox" name="hobby" v-model="hobby" value="sport">sport <br>
        {{hobby}}
        <br>
        <button type="button" class="btn btn-success" @click="registfnGet">Get注册</button>
        <br>
        <button type="button" class="btn btn-success" @click="registfnPost">Post注册</button>

      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'app',
  data(){
    return{
      mail: "xxx@126.com",
      password: "",
      gender: "",
      hobby: [],
    }
  },
  methods: {
//    changeName: function (name) {
//      this.name = name;
//    }
      registfnGet: function () {
        this.axios({
          method: 'get',
          url: 'http://localhost:8080/regist/'+ this.mail + '/' + this.password,
        }).then(function (response) {
            console.log(response.data);
          }
        );
      },
      registfnPost: function () {
        this.axios({
          method: 'post',
          url: 'http://localhost:8080/regist',
          data: {
            mail: this.mail,
            password: this.password,
          },
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
          },
        }).then(function (response) {
          console.log(response.data);
        });
      }
  }

}
</script>

<style>

</style>
