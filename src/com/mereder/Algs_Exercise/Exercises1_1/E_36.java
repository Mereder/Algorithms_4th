package com.mereder.Algs_Exercise.Exercises1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

/**
 *ShuffleTest:
 */
public class E_36 {
    public static void main(String[] args) {
        System.out.println("输入M 和 N：");
        int M = StdIn.readInt();
        int N = StdIn.readInt();

        int a[] = new int[M];
        int printM[][] = new int[M][M];

        for (int k = 0; k < N ; k++) {
            for (int i = 0; i < M; i++) {
                a[i] = i;
            }
            StdRandom.shuffle(a);
            for (int i = 0; i < M; i++) {
                //对于所有的列J，行i表示的是i在打乱后落到j的位置的次数。
                printM[a[i]][i]++;
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.printf("%d ",printM[i][j]);
            }
            System.out.println();
        }

    }
}
