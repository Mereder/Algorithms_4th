package com.mereder.Algs_Exercise.Exercises1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 随机匹配：
 * 从命令行接受一个整型参数T，并会分别针对N=10^3  ^4 ^5 ^6 将一下实验运行T遍：
 * 生成两个大小为N的随机6位正整数数组并找出同时存在于两个数组中的整数的数量。
 * 打印一个表格，对于每个N给出T次实验中该数量的平均值。
 */
public class E_39 {
    public static int BinartSearch(int key,int[] a){
        int lo = 0;
        int hi = a.length-1;
        while(lo <= hi ){
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid ]) hi = mid - 1;
            else if (key > a[mid] ) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static double ComputerAverage(int Count,int T){
        int[] whitelist = new int[Count];
        int[] compare = new int[Count];

        int[] SameNumb = new int[T];

        for (int i = 0; i < T; i++) {
            for (int k = 0; k < Count; k++) {
                whitelist[k] = StdRandom.uniform(100000,1000000);
                compare[k] = StdRandom.uniform(100000,1000000);
            }
            for (int j = 0; j < compare.length; j++) {
                if (BinartSearch(compare[j],whitelist) > 0){
                    SameNumb[i]++;
                }
            }
        }
        double Average = 0.0;
        for (int i = 0; i < T; i++) {
            Average += SameNumb[i];
        }
        Average = Average / T;
        return  Average;
    }
    public static void main(String[] args) {
        int T = 0 ;
        System.out.println("输入整数T：");
        T = StdIn.readInt();
        int N3 = 1000;
        int N4 = 10000;
        int N5 = 100000;
        int N6 = 1000000;
        double result = 0;
        result = ComputerAverage(N3,T);
        System.out.println("N = 10^3 时数量为："+result);
        result = ComputerAverage(N4,T);
        System.out.println("N = 10^4 时数量为："+result);
        result = ComputerAverage(N5,T);
        System.out.println("N = 10^5 时数量为："+result);
        result = ComputerAverage(N6,T);
        System.out.println("N = 10^6 时数量为："+result);

    }
}
