var express = require('express')

var app = express()

var bodyParser = require('body-parser')
//只要加入这个配置，在req请求对象上会多出来一个属性
//parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: false }))
//parse application/json
app.use(bodyParser.json())

//post请求
app.post('/common', function(req, res) {
  console.log('收到post请求了')
  //获取url中的请求参数
  var query = req.query
  console.log(query)
  //在Express中没有内置获取表单post请求的api，
  //这里我们需要使用一个第三方包 body-parser
  var params = req.body
  console.log(params)
})

app.listen(4000, function() {
  console.log('start')
})
