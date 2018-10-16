//fs时file-system简写
//使用require方法加载fs核心模块
var fs = require('fs')

//成功error是null,失败是错误对象, 成功data是数据，失败是undefined
fs.readFile('./resource/hello.txt', function(error, data) {
  console.log(data)
  //<Buffer 68 65 6c 6c 6f>
  //存的是二进制，转成了十六进制，

  //通过判断error确认是否有错误
  if (error) {
    console.log(error)
  } else {
    console.log(data.toString())
    //hello
  }
})
