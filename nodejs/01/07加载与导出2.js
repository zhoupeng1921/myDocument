var a = 'bbb'

console.log(exports)

exports.foo = 'hello'

console.log(exports)

exports.add = function(x, y) {
  return x + y
}
