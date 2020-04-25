import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex);

//全局state对象，用于保存所有组件的公共数据
const state = sessionStorage.getItem('state')?JSON.parse(sessionStorage.getItem('state')) : {
  //定义一个user对象
//在组件中是通过this.$store.state.user来获取
  user: {
    userName: ''
  }
};
//实时监听 state值的最新状态，注意这里的 getters 可以理解为计算属性
const getters = {
  //在组件中是通过this.$store.getters.getUser来获取
  getUser(state){
    return state.user;
  }
};
//定义改变state初始值的方法，
// 这里是唯一可以改变state的地方，缺点是只能同步执行
const mutations = {
  //在组件中是通过this.$store.commit（'updateUser'，user）；
  // 方法来调用mutations
  updateUser(state, user) {
    state.user = user;
  }
};
//定义触发mutations 里函数的方法，可以异步执行mutations里的函数
const actions ={
  //在组件中是通过 this.$store.dispatch（'asyncUpdateUser'，user）；
  // 来调用actions
  asyncUpdateUser(context, user){
    context.commit('updateUser',user);
  }
};
export default new Vuex.Store({
  state,
  getters,
  mutations,
  actions
});
