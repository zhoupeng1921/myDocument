package com.xhx.collection;

import com.xhx.collection.entity.Student;
import org.junit.Test;

import java.util.*;

/**
 * xuhaixing
 * 2018/7/15 19:59
 **/
public class TestHashMapApp {


    /**
     * 循环的几种方式
     */
    @Test
    public void testHashMap1(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("a","aaa");
        map.put("b","bbb");
        map.put("c","ccc");
        map.put("d","ddd");

        //通过key    Set<T> key = map.keySet()
        for(String key:map.keySet()){
            System.out.println("key="+key+" value="+map.get(key));
        }

        //key和value都循环
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println("key="+entry.getKey()+" value="+entry.getValue());
        }

        //通过迭代器
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("key="+entry.getKey()+" value="+entry.getValue());
        }

        //只循环value
        for(String value : map.values()){
            System.out.println("value="+value);
        }

    }

    /**
     * HashMap与HashTable不同
     */
    public void testHashMapAndHashTable(){
        HashMap<String,Object> map = new HashMap();
        Hashtable<String,Object> hashtable = new Hashtable();
    }


    /**
     * compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
     *         Objects.requireNonNull(remappingFunction);
     *         V oldValue = get(key);
     *
     *   只要新value不为null就会插入新key或者覆盖原来value,如果新value为null,就会把这个键值对直接删除
     */
    @Test
    public void testHashMapCompute(){
        List<Student> studentList = Arrays.asList(
                new Student("apple",null,10),
                //new Student("orange","女",30),
              //  new Student("pink",null,60),
                new Student("pink","男",60),
                new Student("black","男",60),
                new Student("orange",null,150)
        );
        Map<String,String> map = new HashMap<String, String>();
        map.put("pink",null);//原来为空，测试现在不为空
        map.put("orange","女");//原来不为空，测试现在为空
        map.put("apple",null);//原来为空，测试现在为空
        studentList.stream().forEachOrdered(student->map.compute(student.getName(),(k,v)->{
            return student.getSex();}));
        System.out.println(map);
        // {pink=男, black=男}
    }

    /**
     * computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
     *         Objects.requireNonNull(mappingFunction);
     *         返回值就是Function里面的V，所以computeIfAbsent方法执行后还可以继续做一系列的操作,
     *         但是value已经放到集合中了，所以只有引用类型才可以继续操作，String不行
     *
     * 只要是原来的value为null,就会插入或者更新，如果不为null，不变
     * 如果新的value为null,则不做操作
     *
     */
    @Test
    public void testHashMapComputeIfAbsent(){
        List<Student> studentList = Arrays.asList(
                new Student("apple",null,10),
                //new Student("orange","女",30),
                //  new Student("pink",null,60),
                new Student("pink","男",60),
                new Student("black","男",60),
                new Student("orange",null,150)
        );
        Map<String,String> map = new HashMap<String, String>();
        map.put("pink",null);//原来为空，测试现在不为空
        map.put("orange","女");//原来不为空，测试现在不为空
        studentList.stream().forEachOrdered(student->map.computeIfAbsent(student.getName(),k->k).toUpperCase());
        System.out.println(map);
        // {{orange=女, apple=apple, pink=pink, black=black}   toUpperCase没有达到效果
    }

    @Test
    public void testHashMapComputeIfAbsent2(){
        List<Student> studentList = Arrays.asList(
                new Student("apple",null,10),
                new Student("pink","男",60),
                new Student("black","男",60),
                new Student("black","女",80)
        );
        Map<String,List<Student>> map = new HashMap<>();
        studentList.stream().forEachOrdered(
                student->map.computeIfAbsent(student.getName(),k->new ArrayList<Student>()).add(student)
        );
        System.out.println(map);
        // {
        // apple=[Student{name='apple', sex='null', money=10.0}],
        // pink=[Student{name='pink', sex='男', money=60.0}],
        // black=[Student{name='black', sex='男', money=60.0}, Student{name='black', sex='女', money=80.0}]
        // }   add达到效果了
    }

}

