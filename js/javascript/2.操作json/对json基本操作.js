// js操作json

//创建json对象
var json={};
json["name"] = "haha";
json.age = 12;
json.gender = "man"
console.log(json.name +"  "+ json.age);

//删除json元素
delete json.name
console.log(json.name +"  "+ json.age);

//创建json数组
var json2=[];
json2.push({"name":"haha"});
console.log(json2[0]["name"]);

//字符串转json
var str = '{"name":"haha","age":12}';
var json3 = JSON.parse(str);
console.log(json3.name);

//json转字符串
var str2 = JSON.stringify(json3);
console.log(str2);

