<template>
    <div>
      <h2>ProductsList....</h2>
      <el-table :data="tableData">
        <el-table-column prop="pid" label="pid" width="140">
        </el-table-column>
        <el-table-column prop="pname" label="pname" width="120">
        </el-table-column>
        <el-table-column prop="price" label="price">
        </el-table-column>
      </el-table>
    </div>
</template>

<script>
    export default {
        name: "ProductsList",
      data() {
        return {
          tableData: []
        }
      },
      created(){
        var vm = this;
        this.axios({
          method: 'get',
//          url: "http://localhost:8081/static/mock/products.json"
          url: "https://easy-mock.com/mock/5e9bc305e4134c5bd29e1e8a/test1/products"
        }).then(function (response) {
          vm.tableData = response.data.products;
        })
      }
    }
</script>

<style scoped>

</style>
