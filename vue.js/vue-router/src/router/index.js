import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Hi from '@/components/Hi'
import Hi1 from '@/components/Hi1'
import Hi2 from '@/components/Hi2'
import R1 from '@/components/r1'
import R2 from '@/components/r2'
import Params from '@/components/Params'
import Error from '@/components/Error'
import Count from '@/components/Count'

Vue.use(Router)

export default new Router({
 // mode:'history', //去掉 地址栏#
  //mode:'hash', //地址栏#
  routes: [
    {
      path: '/',
      name: 'Hello',
      components: {  //加s
        default:HelloWorld,
        left:R1,  //和route的name对应
        right:R2
      }
    },
    {
      path:'/params/:newsId(\\d+)/:newsTitle',//传递参数第二种方式,正则表达式限制传递参数
      component:Params,
      beforeEnter:(to,from,next)=>{
        console.log(to);
        console.log(from);
        next();//next(true)   没有next不跳转  或者next(false)
        //next(path:'/')
      }
    },
    {
      path: '/jspang',
      name: 'jspang',
      components: {
        default:HelloWorld,
        left:R2,  //和route的name对应
        right:R1
      }
    },{
      path:'/goHome',
      redirect:'/'
    },{
      path:'/goParams/:newsId(\\d+)/:newsTitle',
      redirect:'/params/:newsId(\\d+)/:newsTitle'
    },
    {
      path: '/Hi',
      name: 'Hi',
      component: Hi,
      children:[{
          path: '/',
          name: 'hi',
          component: Hi,
          alias:'/hialias'  //访问别名，对 主页 不起作用
        },{
          path: 'hi1',
          name: 'hi1',
          component: Hi1
        },{
          path: 'hi2',
          name: 'Hello/Hi/hi2',
          component: Hi2
        },{
          path:'*', //处理404
          component:Error
        }
      ]
    },
    {
      path:'/count',
      component:Count
    }
  ]
})
