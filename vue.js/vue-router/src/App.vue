<template>
  <div id="app">
    <div>
      <router-link to="/">首页</router-link>|

    <div>
      <button @click="goFron">前进</button>
      <button @click="goBack">后退</button>
      <button @click="goHome">返回首页</button>
    </div>

      <router-link to="/Hi">Hi</router-link>|   
      <!--向h1，传值 第一种方式  name和route对应-->
      <router-link :to="{name:'hi1',params:{username:'jsPang'}}">Hi1</router-link>|
      <router-link to="/Hi/hi2">Hi2</router-link>|
      <router-link to="/params/198/jspang website">params</router-link>|
      <router-link to="/goHome">goHome</router-link>|
      <router-link to="/goParams/999/aaa">goParams</router-link>|
      <router-link to="/hialias">hialias</router-link>|
      <router-link to="//Hi/hi1/fa">Error</router-link>|
    </div>

  <p>{{$route.name}}</p>

  <!--过度效果-->
    <transition name="fade" mode="out-in">
      <router-view/>
    </transition>
      <router-view name="left" style="float:left;width:50%;height:300px;background-color:yellow;"/>
      <router-view name="right" style="float:left;width:50%;height:300px;background-color:#c0c;"/>
   
  </div>
</template>

<script>
export default {
  name: 'app',
  methods:{
    goBack(){
      this.$router.go(-1);
    },
    goFron(){
      this.$router.go(1);
    },
    goHome(){
      this.$router.push('/');  //js中跳转页面
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

.fade-enter{
  opcity:0px;
}
.fade-enter-active{
  transition:opacity .5s; 
}
.fade-leave{
  opcity:1;
}
.fade-leave-active{
  opcity:0;
  transition:opacity .5s;
}
</style>
