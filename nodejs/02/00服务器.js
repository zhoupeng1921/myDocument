var http = require('http')
var fs = require('fs')

var server = http.createServer()

//根据文件名 拼路径，读取文件
var dir = 'C:/Users/Administrator/Pictures'

server.on('request', function(req, res) {
  var url = req.url
  if (url === '/') {
    res.end('Index html')
  }
  fs.readFile(dir + url, function(err, data) {
    if (err) {
      return res.end('404 Not Found')
    } else {
      res.end(data)
    }
  })
})

server.listen(4000, function() {
  console.log('server is running')
})
