package com.xhx.java;

import static org.junit.Assert.assertTrue;

import com.xhx.java.entity.ChildTypeTest;
import com.xhx.java.entity.TypeTest;
import org.junit.Test;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppTest {

    /**
     * 所有数据类型的类型都是Type，Class也继承自Type
     */
    @Test
    public void testType() {
        Type type = AppTest.class;
        System.out.println(type);
    }

    /**
     * ParameterizedType参数化类型，即泛型，List<T>、Map<K,V>等带有参数的对象类型
     */
    @Test
    public void testParameterizedType() throws Exception{
        Field id = TypeTest.class.getDeclaredField("id");
        //获取该属性的类型
        Type genericType = id.getGenericType();

        //获取真实类型   sun.reflect.generics.reflectiveObjects.TypeVariableImpl
        System.out.println(genericType.getClass().getName());

        //getActualTypeArguments 获取泛型中实际类型
        Field cloth = TypeTest.class.getDeclaredField("cloth");
        Type genericType1 = cloth.getGenericType();
        System.out.println(genericType1.getClass().getName());
        //sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
        Type[] actualTypeArguments = ((ParameterizedType) genericType1).getActualTypeArguments();
        System.out.println(actualTypeArguments[0]);
        //class java.lang.String

        //getRawType  泛型中<>前面的类型
        Type rawType = ((ParameterizedType) genericType1).getRawType();
        System.out.println(rawType);
        //interface java.util.List

        //getOwnerType 获取内部类的拥有者
        Type ownerType = ((ParameterizedType) genericType1).getOwnerType();
        System.out.println(ownerType);
        //null

    }

    /**
     * GenericArrayType 泛型数组类型 List<String>[] 、T[]等
     */
    @Test
    public void testGenericArrayType() throws Exception{
        Field students = TypeTest.class.getDeclaredField("students");
        Type genericType = students.getGenericType();
        System.out.println(genericType.getClass().getName());
        //sun.reflect.generics.reflectiveObjects.GenericArrayTypeImpl

        GenericArrayType genericType1 = (GenericArrayType) genericType;

        // getGenericComponentType 返回泛型数组中元素的Type类型，
        // 即List<String>[] 中的 List<String>（ParameterizedTypeImpl）、T[] 中的T（TypeVariableImpl）
        Type genericComponentType = genericType1.getGenericComponentType();
        System.out.println(genericComponentType);
        //java.util.List<java.lang.String>

    }


    /**
     * TypeVariable 泛型的类型变量，
     * 指的是List<T>、Map<K,V>中的T，K，V等值，实际的Java类型是TypeVariableImpl（TypeVariable的子类）；
     * 此外，还可以对类型变量加上extend限定，这样会有类型变量对应的上限
     * @throws Exception
     */
    @Test
    public void testTypeVariable() throws Exception{
        Field id = TypeTest.class.getDeclaredField("id");
        Type genericType0 = id.getGenericType();
        System.out.println(genericType0.getClass().getName());
        //sun.reflect.generics.reflectiveObjects.TypeVariableImpl

        Field cloth = TypeTest.class.getDeclaredField("shoes");
        Type genericType1 = cloth.getGenericType();
        System.out.println(genericType1.getClass().getName());
        //sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
        Type[] actualTypeArguments = ((ParameterizedType) genericType1).getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getClass().getName());
        //sun.reflect.generics.reflectiveObjects.TypeVariableImpl


        TypeVariable genericType = (TypeVariable) id.getGenericType();

        //getBounds  获取类型上限,没有显示定义则为Object
        Type[] bounds = genericType.getBounds();
        System.out.println(bounds[0]);
        //class java.lang.Number

        //获取声明该类型变量实体
        GenericDeclaration genericDeclaration = genericType.getGenericDeclaration();
        System.out.println(genericDeclaration);
        //class com.xhx.java.entity.TypeTest

        //获取类型变量在源码中定义的名称
        String name = genericType.getName();
        System.out.println(name);
        //T
    }

    private List<? extends String> aa;
    @Test
    public void testWildcardType() throws  Exception{
        Field aa = AppTest.class.getDeclaredField("aa");
        Type genericType = aa.getGenericType();
        ParameterizedType genericType1 = (ParameterizedType) genericType;
        Type[] actualTypeArguments = genericType1.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getClass().getName());
        //sun.reflect.generics.reflectiveObjects.WildcardTypeImpl

        //getUpperBounds获取上界
        WildcardType actualTypeArgument = (WildcardType) actualTypeArguments[0];
        System.out.println(actualTypeArgument.getUpperBounds()[0]);
        //class java.lang.String

        //getLowerBounds 获取下界
    }
}
