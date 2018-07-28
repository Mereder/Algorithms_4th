package com.mereder.Algs_Exercise.Exercises1_2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 编写一个Point2D的用例，从命令行接受一个整数N。
 * 在单位正方形中生成N个随机点，然后计算两点之间的最短距离。
 */
public class E_01 {
    public static void main(String[] args) {
        int N = 0;
        System.out.println("输入N：" );
        N = StdIn.readInt();
        Point2D[] randompoints = new Point2D[N];
        for (int i = 0; i < N; i++) {
            double x = StdRandom.uniform(0.0,1.0);
            double y = StdRandom.uniform(0.0,1.0);
            randompoints[i] = new Point2D(x, y);
        }
        double minimumDistance = 9999;

        for (int i = 0; i < N; i++) {
            for (int j = N-1; j > i ; j--) {
                double distance = randompoints[i].distanceTo(randompoints[j]);
                if (distance <= minimumDistance) minimumDistance = distance;
            }
        }
        System.out.println("最短距离为："+ minimumDistance);

    }
}
