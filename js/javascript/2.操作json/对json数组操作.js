var users = [
    { name: "aaa", age: 23 },
    { name: "bbb", age: 22 },
    { name: "ccc", age: 25 },
    { name: "ddd", age: 22 }
];
//过滤对象
var user = users.filter(p => p.age == 22);
console.log(user)

//根据索引删除某个对象
var index = users.indexOf(users[1]);
index>-1&&users.splice(index,1)
console.log(users);

//往数组中添加元素
users.push({name:"zzz",age:20});
console.log(users);