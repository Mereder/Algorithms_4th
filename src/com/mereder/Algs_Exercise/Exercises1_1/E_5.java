package com.mereder.Algs_Exercise.Exercises1_1;

import java.util.Scanner;

/**
 * 编写一段程序，如果double类型的x和y都严格位于0和1之间打印true
 * 否则打印false
 */
public class E_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x = scanner.nextDouble();
        double y = scanner.nextDouble();

        if (x > 0.0 && x < 1.0 && y > 0.0 && y < 1.0 ){
            System.out.println("true");
        }
        else System.out.println("false");
    }
}
