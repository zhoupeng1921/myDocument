var express = require('express')

// 1. 创建一个路由容器
var router = express.Router()

router.get('/get', function(req, res) {
  res.send('请求了/get')
})
router.get('/list', function(req, res) {
  res.send('请求了 /list')
})
router.post('/add', function(req, res) {
  res.send('请求了 /add')
})
//最后导出
module.exports = router

//自己设计路由
// module.export=function(app){
//   app.get('/get', function(req, res) {
//     res.send('请求了/get')
//   })
//   app.get('/list', function(req, res) {
//     res.send('请求了 /list')
//   })
//   app.post('/add', function(req, res) {
//     res.send('请求了 /add')
//   })
// }
