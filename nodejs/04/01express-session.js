// 在express框架中，默认不支持Session和Cookie，可以使用第三方中间件express-session
//req.session来访问和设置session

var express = require('express')
var session = require('express-session')

var app = express()

app.use(
  session({
    secret: 'abefadfadf', //会在原来基础上加上这个字符拼起来去加密，增加安全性
    resave: false,
    saveUninitialized: true //无论是否使用session，都会分配一个session
  })
)
