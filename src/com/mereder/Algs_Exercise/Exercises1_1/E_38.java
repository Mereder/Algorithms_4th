package com.mereder.Algs_Exercise.Exercises1_1;

import edu.princeton.cs.algs4.In;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 对比二分查找和暴力查找：
 * 暴力查找用时为：365078ms
 * 二分查找用时为：3864ms
 */
public class E_38 {
    public static int rank(int key,int[] a){
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

    public static int BruteForceSearch(int key,int[] a){
        for (int i = 0; i < a.length ; i++) {
            if (a[i] == key) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] whitelist = In.readInts("data/largeW.txt");
        FileInputStream fis= null;
        try {
            fis = new FileInputStream("data/largeT.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setIn(fis);
        Scanner sc = new Scanner(System.in);
        //计算暴力算法时间：
        long starTime = System.currentTimeMillis();

        while(sc.hasNext()){
            int key = sc.nextInt();
            if (BruteForceSearch(key,whitelist) < 0) System.out.println(key);
        }
        long endTime = System.currentTimeMillis();
        long BruteTime = endTime - starTime;


        try {
            fis = new FileInputStream("data/largeT.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setIn(fis);
        Scanner sc1 = new Scanner(System.in);
        starTime = System.currentTimeMillis();
        Arrays.sort(whitelist);

        while(sc1.hasNext()){
            int key = sc1.nextInt();
           if (rank(key,whitelist) < 0) System.out.println(key);
        }
        endTime = System.currentTimeMillis();
        long BinaryTime = endTime - starTime;
        System.out.println("暴力查找用时为：" + BruteTime+"ms");
        System.out.println("二分查找用时为：" + BinaryTime+"ms");
    }
}
