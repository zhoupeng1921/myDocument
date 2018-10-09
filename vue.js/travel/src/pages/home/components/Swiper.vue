<template>
  <div class="wrapper">
    <swiper :options="swiperOption">
      <!-- slides -->
      <swiper-slide>
        <img class="swiper-img" src="http://img1.qunarzz.com/piao/fusion/1809/91/63a7f117b30cd202.jpg_750x200_6c2dcbc9.jpg"/>
    </swiper-slide>
        <swiper-slide>
          <img class="swiper-img"  src="http://img1.qunarzz.com/piao/fusion/1809/31/da037478f37cf202.jpg_750x200_a02cf862.jpg"/>
    </swiper-slide>
          <!-- Optional controls -->
          <div class="swiper-pagination"
               slot="pagination">

          </div>
          <!-- <div class="swiper-button-prev" slot="button-prev"></div>
    <div class="swiper-button-next" slot="button-next"></div> -->
          <!-- <div class="swiper-scrollbar"   slot="scrollbar"></div> -->
    </swiper>
  </div>
</template>
<script>
export default {
  name: 'HomeSwiper',
  data () {
    return {
      swiperOption: {
        pagination: '.swiper-pagination'
      }
    }
  }
}
</script>
<style lang="stylus" scoped>
.wrapper
  width 100%
height 0
  overflow hidden
  padding-bottom 31.25%
  background #eee
.swiper-img
  width 100%
</style>
