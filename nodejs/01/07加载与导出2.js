var a = 'bbb'

console.log(exports)

exports.foo = 'hello'

console.log(exports)

exports.add = function(x, y) {
  return x + y
}

//exports 是一个对象，导出的是多个成员
