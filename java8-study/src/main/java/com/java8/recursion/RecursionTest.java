package com.java8.recursion;

public class RecursionTest {
    public static void main(String[] args) {
        /**
         * 斐波那契列数
         * 0 1 1 2 3 5 8 13
         * a=0,b=1;
         * a=a+b
         * 第100个数
         * 0+1
         * 1+1
         * 1+2
         * 2+3
         * 3+5
         *
         * a=0,b=1;
         * a=a+b;
         *
         */

        int fibonacci = fibonacci(7);
        System.out.println(fibonacci);

    }

    public static int  fibonacci(int n){
        if(n<3){
            return 1;
        }

        n=n-1;
        return fibonacci(n)+fibonacci(n-1);

    }

    public static int  recursion(int a,int b,int n,int i){
        b=a;
        a=a+b;
        ++i;
        if(i<n){
            recursion(a,b,n,i);
        }

        return a;
    }
}
