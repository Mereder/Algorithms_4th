package com.mereder.Algs_Exercise.Exercises1_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;


import java.util.Arrays;

/**
 * 为BinarySearch 的测试用例添加一个参数：
 * + 打印出标准输入中不在白名单上的值
 * - 打印出标准输入中在白名单上的值
 */
public class E_23 {
    public static int BinarySearch(int key,int[] a){
        int lo = 0;
        int hi = a.length-1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return  -1;
    }

    public static void main(String[] args) {
        int N = 10;
        int[] whiteList = new  int[N];
        for (int i = 0; i < N; i++) {
            whiteList[i] = StdRandom.uniform(1,20);
        }
        Arrays.sort(whiteList);
        for (int i = 0; i < N; i++) {
            System.out.printf("%d ",whiteList[i]);
        }
        System.out.println();
        System.out.println("输入操作 '+' or '-'");
        char ops = StdIn.readChar();
        StdIn.readLine();
        System.out.println("输入测试数：");
        String[] keys = StdIn.readLine().split(" +");

        for (int i = 0; i < keys.length; i++) {
            if (BinarySearch(Integer.parseInt(keys[i]),whiteList) < 0 && ops == '+'){
                System.out.printf("%s ", keys[i]);
            }
            else if (BinarySearch(Integer.parseInt(keys[i]),whiteList) > 0 && ops == '-'){
                System.out.printf("%s ",keys[i]);
            }
        }
        System.out.println();
    }
}
