package com.xhx.designpattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Person person1 = Person.getPerson();
        person1.setName("aaa");
        Person person2 = Person.getPerson();
        person2.setName("bbb");

        System.out.println("person1:"+person1.getName());
        System.out.println("person2:"+person2.getName());
        /*
            person1:bbb
            person2:bbb
         */


        Person2 person3 = Person2.getPerson();
        person3.setName("aaa");
        Person2 person4 = Person2.getPerson();
        person4.setName("bbb");

        System.out.println("person3:"+person3.getName());
        System.out.println("person4:"+person4.getName());

        /**
         * person3:bbb
         * person4:bbb
         */
    }
}
