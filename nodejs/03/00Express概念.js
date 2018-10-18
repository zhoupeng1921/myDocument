//原生http在某些方面表现不足以应对我们的开发需求
var express = require('express')

//创建应用程序
var app = express()

//当服务器接收到get请求 / 时，执行回调函数
app.get('/', function(req, res) {
  //在express中可以直接req.query来获取查询字符串参数
  console.log(req.query)
  res.send('hello express!')
})
app.get('/about', function(req, res) {
  res.send("I'm express!")
})

//公开指定目录，第一个参数是拦截的请求路径
app.use('/public/', express.static('./public/'))
//省略第一个参数，可以不用那个路径来访问
app.use(express.static('./public/'))

app.listen(4000, function() {
  console.log('app is running at http://localhost:4000')
})
