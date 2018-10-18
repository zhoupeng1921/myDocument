var express = require('express')

var app = express()

app.use('/public/', express.static('./public/'))

//配置使用art-template模板引擎
//第一个参数，表示当以art结尾的文件的时候，使用art-template模板引擎。
//express-art-template是专门用来在Express中把art-template整合到Express中

app.engine('art', require('express-art-template'))

//Express为Response响应对象提供了一个方法render,
//render方法默认不可以使用，但是如果配置了模板引擎就可以使用了
//res.render('html模板名',{模板数据})
//第一个参数不能写路径，默认会去项目中的views目录查找该文件
//也就是说，Express有一个约定，开发人员把所有的视图文件都放到views中
app.get('/', function(req, res) {
  res.render('404.art', { title: 'haha' })
})

//如果要修改默认的views目录，则可以
// app.set('views','路径')

app.listen(4000, function() {
  console.log('start')
})
