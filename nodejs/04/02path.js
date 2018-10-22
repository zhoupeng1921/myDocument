var express = require('express')
var path = require('path')

var app = express()

app.use('/public/', express.static(path.join(__dirname, '/public/')))
app.use(
  '/node_modules/',
  express.static(path.join(__dirname, '/node_modules/'))
)

app.engine('html', require('express-art-template'))

app.get('', (req, res) => {
  res.send('success')
})

app.listen(4000, () => {
  console.log('Server is running')
})
