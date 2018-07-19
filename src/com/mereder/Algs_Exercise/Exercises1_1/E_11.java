package com.mereder.Algs_Exercise.Exercises1_1;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 编写一段代码，打印出一个二维布尔数组的内容。其中 使用*表示真，空格表示假
 * 打印出行号和列号
 *
 * 注意：格式控制问题
 */
public class E_11 {
    public static void main(String[] args) {
        int row = 5;
        int col = 5;
        boolean[][] test = new  boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                test[i][j] = StdRandom.bernoulli(0.5);
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.printf(" %d",i);
        }
        System.out.println();
        for (int i = 0; i < row; i++) {
            System.out.printf("%d",i);
            for (int j = 0; j < col; j++) {
                if (j == 0){
                    if (test[i][j])
                        System.out.printf("*");
                    else System.out.printf(" ");
                }
                else {
                    if (test[i][j])
                        System.out.printf(" *");
                    else System.out.printf("  ");
                }
            }
            System.out.println();
        }

    }
}
