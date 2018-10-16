//art-template 不仅可以在浏览器使用，也可以在node中使用
//1. 安装npm install art-template
//2. 在需要的文件模块中加载art-template
//3. 查文档，使用模板引擎api

var template = require('art-template')
var ret = template.render('hello {{name}}', {
  name: 'jack'
})
console.log(ret)
