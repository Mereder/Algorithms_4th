package com.mereder.Algs_Exercise.Exercises1_1;

import java.util.Arrays;

/**
 * 等键值： 为BinarySearch类添加一个静态方法 rank(),它接受一个键和一个整型有序数组
 * （可能存在重复键值）作为参数并返回数组中小于该键的元素数量，以及一个类似的方法count（）
 * 来返回数组中等于该键的元素数量，以及一个类似的方法count（）来返回数组中等于该键的元素数量。注意：如果i
 * 和j分别是rank（key，a）和count（key，a）的返回值，那么a[i...i+j-1]就是数组中所有和key相等的元素
 *
 */
public class E_29 {
    public static int count(int key,int[] a){
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) count++;
        }
        return count;
    }

    public static int rank(int key,int[] a){
        int rank = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < key){
                rank++;
            }
        }
        return rank;
    }

    public static void main(String[] args) {
        int N = 10;
        int[] whiteList ={17 ,11, 9 ,2 ,18, 5, 14, 11, 6 ,11};

        Arrays.sort(whiteList);
        int i = 0;  //rank 返回
        int j = 0;  //count 返回
        i = rank(11,whiteList);
        j = count(11,whiteList);
        System.out.println(i+" "+ j);
        //输出a[i]...a[i+j-1]的相同键值
        for (int k = i; k <= i+j-1; k++) {
            System.out.println(whiteList[k]);
        }

    }
}
