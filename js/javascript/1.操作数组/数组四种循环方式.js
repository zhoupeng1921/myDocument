var arr=[1,2,3];
for(var i = 0; i < arr.length; i++){
    console.log(arr[i]);
}

for(var i in arr){
    console.log(arr[i]);
}

arr.forEach((v,i)=>console.log(i+" "+v));


for(var v of arr){
    console.log(v);
}


var arr2=[1,2,3,4,5,6];
arr2.value='val';
//在使用for in 遍历时,实际上是对对象属性的循环
for(var i in arr2){
    console.log(i+'   '+arr2[i]);//这时的i为键值，不为数组索引
}
for(var v of arr2){
    console.log(v);
}
