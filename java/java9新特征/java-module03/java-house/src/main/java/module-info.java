module java.house {
    // opens <package> 或者 opens <package> to <module1>...
    // public声明的类可以直接访问,包下的其它的类可以利用反射来获取
    opens com.xhx.house;
}
//也可以用open来指定开发模块,所有的包都可以被反射
/*
java.house {
    //里面不能再使用opens了,因为整个包都已经open了
}

 */