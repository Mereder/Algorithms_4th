package com.mereder.Algs_Exercise.Exercises1_1;

import edu.princeton.cs.algs4.StdIn;

/**
 * 编写一段程序，从标准输入按行读取数据，其中每行包含一个名字和两个整数。
 * 然后用printf打印一张表格，每行的若干列数据包含名字、两个整数和第一个
 * 整数除以第二个整数的结果，精确到小数点后三位。
 */
public class E_21 {

    public static void main(String[] args) {
        int N = 3;  //数据组数

        String[] name = new String[N];
        int[] a = new  int[N];
        int[] b = new int[N];
        for (int i = 0; i < N; i++) {
            String[] content = StdIn.readLine().split(" "); // 按行读取
            name[i] = content[0];
            a[i] = Integer.parseInt(content[1]);
            b[i] = Integer.parseInt(content[2]);
        }

        System.out.printf("%4s\t|%4s\t|%4s\t|%4s\n","姓名","整数a","整数b","计算");

        for (int i = 0; i < N; i++) {
            System.out.printf("%4s\t|%4d\t|%4d\t|%.3f\n",name[i],a[i],b[i],a[i]/(b[i]*1.0));

        }
    }
}
