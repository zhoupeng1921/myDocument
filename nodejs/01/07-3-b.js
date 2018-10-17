function defa(x) {
  return x
}

//导出单个成员，可以直接引用，不用.出来了
module.exports = defa

//下面这样就倒出了多个
module.exports = {
  add: function(x, y) {
    return x + y
  },
  str: 'hello world'
}
