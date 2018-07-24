package com.mereder.Algs_Exercise.Exercises1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;


/**
 * 糟糕的打乱：数组中的所有元素的值不接近N/M 且值之间相差较大
 */
public class E_37 {
    public static void shuffle(int[] a) {
        if (a == null) {
            throw new IllegalArgumentException("argument is null");
        }
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = StdRandom.uniform(0,n);     // between 0 and n-1（包含）
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

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
            shuffle(a);
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
