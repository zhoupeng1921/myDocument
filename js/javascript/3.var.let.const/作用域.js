if(true){
    var a = 1; //在块内声明的变量也是全局的
}
console.log(a); //1

if(true){
    let b = 1;  //局部的
}
console.log(b); //ReferenceError: b is not defined