package com.mereder.Algs_Exercise.Exercises1_4;

import java.util.Arrays;

/**
 * 分数的二分查找：设计一个算法，使用对数级别的比较次数找出有理数p/q 其中 0<p<q<N
 * 中文书里面的翻译有点难以理解
 * 英文： Hint : Two fractions with denominators less than N cannot differ by more than 1/N2.
 * 也就是说不能直接比较两个浮点数的大小，必须通过作差法来比较，对于做差得到的值，我们认为小于1/N*N
 * 就可以认为 两个浮点数相等。
 */
public class E_23 {
    public static int FractionBinarySearch(double key,double a[]){
        int lo = 0;
        int hi = a.length-1;
        double N_N = 1.0 / 10*10;
        while (lo < hi ){
            int mid = lo + (hi - lo ) / 2;
            if (Math.abs(a[mid] - key) < N_N )
                return mid ;
            else if (a[mid] > key)
                hi = mid - 1;
            else if (a[mid] < key)
                lo = mid + 1;
        }
        return -1;

    }
    public static void main(String[] args) {
        double a[] = {1.0/2.0,2.0/3.0,3.0/4.0,4.0/5.0,5.0/6.0,6.0/7.0};
        Arrays.sort(a);

        if (FractionBinarySearch(4.0/5.0,a) != -1)
            System.out.println("find");
        else System.out.println("None");

    }
}
