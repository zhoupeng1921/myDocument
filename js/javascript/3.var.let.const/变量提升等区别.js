//在代码正式执行前，编译器会对代码进行预编译，当前作用域中的变量和
//函数，将被提升到作用域的顶部
console.log(a) //undefined
if(true){
    console.log(a);  //undefined
    var a = 1;
}
//类似下面
var a;
console.log(a) 
if(true){
    console.log(a);  
    a = 1;
}

//let规范了变量的声明，约束了变量的提升,必须先声明才能使用
if(true){
    console.log(b); //ReferenceError: b is not defined
    let b = 2;
}
//不管是var还是let，预编译过程中，都发生了变量提升，但与var不同的是，
//ES6对let进行了约束，其规定，在真正的词法变量声明之前，以任何方式访问let变量都是不允许的，所以从开发人员角度来看，let禁止了变量提升这一行为。



//let暂时性死区
//只要这个变量在块内声明，就不收外部变量影响,下面会报错
var c = 1;
if(true){
    c = 2;  //ReferenceError: c is not defined
    let c;
}

//let不允许重复声明变量
let d = 3;
let d = 5; //SyntaxError: Identifier 'd' has already been declared


//let不会成为全局对象的属性
//在全局范围内声明一个变量时，这个变量会成为全局对象的属性，
//在浏览器(window)和node(global)环境下，可以被调用
var e = 1;
global.e;

//const规则与let一样，但是const变量不能重复赋值，声明时必须初始化
const f; //SyntaxError: Missing initializer in const declaration
