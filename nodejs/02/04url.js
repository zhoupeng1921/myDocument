var url = require('url')
var http = require('http')

var server = http.createServer()

server.on('request', function(req, res) {
  console.log(req.url)
  // /abc/d/ef?name=aa&age=b

  var parseObj = url.parse(req.url, true)

  //{"protocol":null,"slashes":null,"auth":null,"host":null,"port":null,"hostname":null,"hash":null,"search":"?name=aa&age=b","query":{"name":"aa","age":"b"},"pathname":"/abc/d/ef","path":"/abc/d/ef?name=aa&age=b","href":"/abc/d/ef?name=aa&age=b"}
  console.log(JSON.stringify(parseObj))
  res.end(JSON.stringify(parseObj))
})

server.listen(4000, function() {
  console.log('server is running')
})
