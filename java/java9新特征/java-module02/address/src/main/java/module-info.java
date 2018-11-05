module address {
    // exports 用于指定一个模块中哪些包是可以对外访问的
    // exports ..to .. 用来限定哪些模块可以访问导出类  没有传递性
    exports com.xhx.address;

    // requires 用来指定当前模块的依赖模块
    // transitive 引入address模块，同时也会引入provice模块
    requires transitive province;

    // requires static 表示依赖的模块编译时是必须的,但运行时是可选的

}