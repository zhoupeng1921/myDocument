//在node中，每个模块自己内部有一个module
//该module对象中有一个成员：exports,也是一个对象
//也就是如果需要对外导出成员，只需要把导出的成员挂载到 module.exports
//为了简化，提供了一个变量exports = module.exports

//当一个模块需要导出单个成员的时候
//直接给exports赋值是不管用的
//exports = 'hello' //换引用了

//默认在代码的最后一句
//return module.exports
