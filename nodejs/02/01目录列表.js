var fs = require('fs')

fs.readdir('C:/Users/Administrator/Pictures', function(err, data) {
  if (err) {
    console.log('没有此目录')
  } else {
    console.log(data)
  }
})

//在EcmaScript 6中，` 字符串中，可以用${}来引用变量
