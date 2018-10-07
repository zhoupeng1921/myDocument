<template>
  <div class="header">
    <div class="header-left">
      <span class="iconfont back-icon">&#xe624;</span>
    </div>
    <div class="header-input">
      <span class="iconfont">&#xe632;</span>
      输入城市/景点主题</div>
    <div class="header-right">城市
      <span class="iconfont arrot-icon">&#xe64a;</span>
    </div>
  </div>
</template>
<script>
export default {
  name: 'HomeHeader',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>
<style lang="stylus" scoped>
// @import '~@/assets/styles/varibles.styl';
@import '~styles/varibles.styl';
.header
  display flex
  line-height 0.86rem
  background $bgColor
  color #fff
.header-left
  left 0.64rem
  float left
.back-icon
  text-align center
  font-size 0.4rem
.header-input
  flex 1
  height 0.64rem
  line-height 0.64rem
  margin-top 0.12rem
  margin-left 0.12rem
  background #fff
  border-radius 0.1rem
  color #ccc
  padding-left 0.2rem
arrot-icon
  font-size 0.2rem
  margin-left -0.4rem
.header-right
  width 1.24rem
  text-align center
  float right
</style>
