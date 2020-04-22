<template>
    <div>
      <h2>userlist....</h2>
      <el-table :data="tableData">
      <el-table-column prop="uid" label="uid" width="140">
      </el-table-column>
      <el-table-column prop="uname" label="姓名" width="120">
      </el-table-column>
      <el-table-column prop="age" label="age">
      </el-table-column>
      </el-table>
    </div>
</template>

<script>
    export default {
        name: "UserList",
        data() {
          return {
            tableData: []
          }
        },
        created(){
          var vm = this;
          this.axios({
            method: 'get',
            url: "https://easy-mock.com/mock/5e9bc305e4134c5bd29e1e8a/test1/users"
          }).then(function (response) {
            vm.tableData = response.data.users;
          })
        }
    }
</script>

<style scoped>

</style>
