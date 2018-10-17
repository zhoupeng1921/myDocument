require('./07-5-b')
var ret = require('./07-5-c')
console.log(ret)

// b.js被执行了
// c.js被执行了
// {}
// {}

//require加载规则
//c在b中被加载执行了，在a中就不执行了，只会执行一次，，多次引用为了获取导出的对象
//已经加载过的，不会重复加载，可以拿到接口对象，提高模块加载效率，优先从缓存加载

//第三方模块加载
//require('包名)
//先找到当前文件所属目录中的node-modules目录
//然后找node-modules中的'包名'，然后找package.json文件，然后找main属性，main属性就记录了入口模块，然后加载使用
//当没有package.json或者main没有指定，会找index.js

//否则还会找上一级node-modules，依次到磁盘根目录

//模块加载机制
//  优先从缓存加载
//  核心模块
//  路径形式的文件模块
//  第三方模块
