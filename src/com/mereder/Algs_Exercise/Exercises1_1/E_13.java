package com.mereder.Algs_Exercise.Exercises1_1;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 编写一段代码，打印出一个M行N列的二维数组的转置
 *
 */
public class E_13 {
    public static void main(String[] args) {
        int M = 5;
        int N = 8;
        int[][] original = new int[M][N];
        //M行N列初始化
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                original[i][j] = StdRandom.uniform(1,10);
                System.out.printf("%d ",original[i][j]);
            }
            System.out.println();
        }
        //转置输出
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M ; j++) {
                System.out.printf("%d ",original[j][i]);
            }
            System.out.println();
        }
    }
}
