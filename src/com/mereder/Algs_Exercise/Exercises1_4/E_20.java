package com.mereder.Algs_Exercise.Exercises1_4;

import edu.princeton.cs.algs4.BinarySearch;

/**
 *
 *  双调查找:
 *  如果一个数组中的所有元素是先递增后递减的，则称这个数组为双调的。
 *  编写一个程序，给定一个含有 N 个不同 int 值的双调数组，判断它是否含有给定的整数。
 *  程序在最坏情况下所需的比较次数为 ~3lgN
 */
public class E_20 {
    public static void main(String[] args) {
        //先生成双调数组
        int[] a = BitonicMax.bitonic(100);
        int max = BitonicMax.max(a,0,a.length-1);
        int key = a[20];
        int lowSide = BinarySearchAscending(key,a,0,max);
        int highSide = BinarySearchDescending(key,a,max,a.length-1);

        if (lowSide != -1) System.out.println(lowSide);
        else if (highSide != -1) System.out.println(highSide);
        else System.out.println("no Answer");
    }
    public static int BinarySearchAscending(int key,int a[],int lo,int hi){

        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) return mid;
            else if (a[mid] > key) hi = mid - 1;
            else lo = mid + 1;
        }
        return -1;
    }
    public static int BinarySearchDescending(int key,int a[],int lo,int hi){

        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) return mid;
            else if (a[mid] > key) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}
