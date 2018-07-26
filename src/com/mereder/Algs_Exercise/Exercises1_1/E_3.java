package com.mereder.Algs_Exercise.Exercises1_1;

import java.util.Scanner;
/**
 * 编写一个程序，从命令行得到三个整数参数，如果他们都相等打印equal
 * 否则打印 not equal
 */
public class E_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (a == b && b == c){
            System.out.println("equal");
        }
        else System.out.println("not equal");
    }
}
