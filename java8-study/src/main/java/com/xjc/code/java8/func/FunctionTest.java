package com.xjc.code.java8.func;

import com.java8.func.domain.Person;

import java.util.Arrays;
import java.util.Comparator;

public class FunctionTest {
    public static void main(String[] args) {
        invokeMethod("Hello",(a)-> System.out.println());


        Person[] list = {new Person("小米", 5),
                new Person("小红", 6),
                new Person("小李", 8)
        };

        Comparator<Person> personComparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        Arrays.sort(list,personComparator);

        for (Person person : list) {
            System.out.println(person.getAge());
        }

        System.out.println("---------------------Lambda表达式执行结果------------------------");

        Arrays.sort(list,(p1,p2)->{
            return p1.getAge()-p2.getAge();
        });

        Arrays.stream(list).map(Person::getAge).forEach(System.out::println);



    }

//     private static void invokeCalc(int a,int b,Calculator c){
//         int calc = c.calc(a, b);
//
//     }

    private static void invokeMethod(String name,QueryParameter queryParameter){
        queryParameter.query(name);
    }
}


