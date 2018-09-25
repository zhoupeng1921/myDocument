package com.xhx.java.javatransient;


import com.xhx.java.javatransient.entity.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class JavaTransientApplication {

    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setName("xu");
        user.setGender("man");
        user.setPassword("abcdefg");
        String path = "/media/xuhaixing/java/myDocument/java/java-transient/src/main/java/aa.txt";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(user);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        Object o = objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(o);
        //transient 修饰后不可被通过Serializable接口的序列化
        //输出结果
        //User{name='xu', gender='man', password='null'}

    }
}
