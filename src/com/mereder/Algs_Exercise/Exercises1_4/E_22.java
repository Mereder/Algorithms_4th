package com.mereder.Algs_Exercise.Exercises1_4;

/**
 * 仅用加减实现的二分查找 ：
 * 编写一个程序，给定一个含有N个不同int值的按照升序排列的数组，判断它是否含有给定的整数，
 * 只能用加法和减法以及常数的额外内存空间。程序的运行时间最坏情况下应该和lgN成正比
 *
 */
public class E_22 {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Mihai_Patrascu(5,a));

    }
    public static int Mihai_Patrascu(int key,int a[]){
        int FibonacciK = 1;
        int FibonacciK_1 = 1;
        int FibonacciK_2 = 0;

        while(FibonacciK <= a.length){
            FibonacciK_2 = FibonacciK_1;
            FibonacciK_1 = FibonacciK;
            FibonacciK = FibonacciK_1 + FibonacciK_2;
        }

        int lo = 0;

        while(FibonacciK_2 >= 0){
            int i = lo + FibonacciK_2;
            if (i > a.length-1)
                i = a.length-1;
            else i = lo + FibonacciK_2;

            if (a[i] == key)  return i;
            else if (a[i] < key) lo = lo + FibonacciK_2;
            //else 不需要判断自动缩减FibonacciK_2 一侧
            FibonacciK = FibonacciK_1;
            FibonacciK_1 = FibonacciK_2;
            FibonacciK_2 = FibonacciK - FibonacciK_1;

        }
        return -1;
    }
}
