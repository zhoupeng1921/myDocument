var express = require('express')
var app = express()

app.engine('html', require('express-art-template'))

//express中间件

//1.拦截所有  next表示继续执行下面
app.use(function(req, res, next) {
  console.log('拦截到了1')
  next()
})

//2. 拦截以/xxx开头的
app.use('/abc', function(req, res, next) {
  console.log('拦截到了2')
  next()
})

//3. 严格的拦截
app.get('/abc/a', function(req, res, next) {
  console.log('拦截到了3')
  next()
})
app.post('/abc/a', function(req, res, next) {
  console.log('拦截到了3')
  next()
})

app.get('/', function(req, res, next) {
  fs.readFile('.d/sa./d.sa/.dsa', function(err, data) {
    if (err) {
      // 当调用 next 的时候，如果传递了参数，
      // 则直接往后找到带有四个参数的应用程序级别中间件
      //可以用来拦截全局异常
      next(err)
    }
  })
})

// 配置错误处理中间件 因为拦截是有顺序的，所以放到最后
app.use(function(err, req, res, next) {
  res.status(500).send(err.message)
})

//如果没有匹配的中间件，Express会输出Cannot GET xxxx路径
// 配置一个处理 404 的中间件
app.use(function(req, res) {
  res.render('404.html')
})

app.listen(4000, function() {
  console.log('Server is running')
})
