// mongodb 比较原生，用mongoose操作比较方便
var mongoose = require('mongoose')
//连接数据库
mongoose
  .connect(
    'mongodb://192.168.94.151:27017/mytest',
    { useNewUrlParser: true }
  )
  .then(
    () => {
      console.log('connect succeful')
    },
    err => {
      console.log(err)
    }
  )

//var col1 = mongoose.model('col1', { name: String })

//创建schema，文档结构
var schema = new mongoose.Schema({
  name: {
    type: String,
    require: true
  },
  email: String
})
//创建模型
//若第一个参数字符串大写开头，会自动转换成小写复数users
//第二个参数是Schema
var col1 = mongoose.model('User', schema)

//保存
var a = new col1({ name: '小白', email: '11@qq.com' })
a.save(function(err, data) {
  if (err) {
    console.log(err)
  } else {
    console.log('success')
    console.log(data)
  }
})

col1.find(function(err, data) {
  if (err) {
    console.log(err)
  } else {
    console.log(data)
  }
})
