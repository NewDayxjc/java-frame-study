package com.xjc.code.java8.func;

public class FunctionTest2 {
    public static void main(String[] args) {

        invokeCalculator(120,30,(a,b)->{
            return a+b;
        });
        invokeCalculator(120,30,(p1,p2)->{
            return p1+p2;
        });

    }


    public static void invokeCalculator(int a,int b,Calculator cal){
        int calc = cal.calc(a, b);
        System.out.println(calc);

    }
}
