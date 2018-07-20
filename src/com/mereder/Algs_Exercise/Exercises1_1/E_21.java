package com.mereder.Algs_Exercise.Exercises1_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.Scanner;

/**
 * 编写一段程序，从标准输入按行读取数据，其中每行包含一个名字和两个整数。
 * 然后用printf打印一张表格，每行的若干列数据包含名字、两个整数和第一个
 * 整数除以第二个整数的结果，精确到小数点后三位。
 */
public class E_21 {

    public static void main(String[] args) {
        int N = 1;  //数据组数

        for (int i = 0; i < N; i++) {
            String test[] = StdIn.readLine().split(" ");
            [i] = test[0];
            [i] = Integer.parseInt(test[1]);
            [i].b = Integer.parseInt(test[2]);
        }
        System.out.printf("%4s\t|%4s\t|%4s\t|%4s\t","姓名","整数a","整数b","计算");

     //   for (int i = 0; i < N; i++) {

       // }

        String test = StdIn.readLine().split(" ")[0];
        System.out.println(test);
    }
}
