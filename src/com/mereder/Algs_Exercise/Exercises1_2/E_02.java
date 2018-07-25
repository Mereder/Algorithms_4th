package com.mereder.Algs_Exercise.Exercises1_2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;

/**
 * 编写一个Interval1D的用例，从命令行接受一个整数N。从标准输入
 * 中读取N个间隔并打印出所有相交的间隔对。
 */
public class E_02 {
    public static void main(String[] args) {
        int N = 0;
        System.out.println("输入 N :");
        N = StdIn.readInt();
        Interval1D[] interval = new Interval1D[N];

        for (int i = 0; i < N; i++) {
            double lo = StdIn.readDouble();
            double hi = StdIn.readDouble();
            interval[i] = new Interval1D(lo,hi);
        }

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N ; j++) {
                if (interval[i].intersects(interval[j]))
                    System.out.println(interval[i]+" "+interval[j]);
            }
        }

    }
}
