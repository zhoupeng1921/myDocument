/**
 * 根据单一职责
 *    入口文件做请求处理不太好，可以用路由来解决
 */
var express = require('express')
var router = require('./03router')
var bodyParser = require('body-parser')

var app = express()
app.use('/public/', express.static('./public'))

app.use(bodyParser.urlencoded({ extended: false }))
app.use(bodyParser.json())

//自己设计
//router(app)

app.use(router)

app.listen(4000, function() {
  console.log('server is running...')
})
