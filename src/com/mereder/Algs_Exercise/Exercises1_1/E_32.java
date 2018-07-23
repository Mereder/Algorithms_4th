package com.mereder.Algs_Exercise.Exercises1_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 直方图：
 * 假设标准输入中有一系列double值。编写一段程序，从命令行接受一个整数N和
 * 两个double值l和r，将（l，r）分为N段并用StdDraw 画出输入流中的值落入每段
 * 的数量的直方图。
 */
public class E_32 {
    public static void main(String[] args) {
        int N = 10;
        double l = 0.3;
        double r = 0.8;
        //标准输入doubles
        int numdouble = 50;
        double[] doubles = new  double[numdouble];
        for (int i = 0; i < numdouble; i++) {
            doubles[i] = StdRandom.uniform(l,r);
        }
        double divi = (r-l) / N;
        int count[] = new int[N];
        for (int i = 0; i < numdouble; i++) {
            count[(int)((doubles[i]-l)/divi)]++;
        }
        for (int i = 0; i < N; i++) {
            System.out.println(count[i]);
        }
        for (int i = 0; i < N; i++) {
            double x = l+i*divi;
            double y = count[i]/2.0 /10.0; //保证横纵坐标比例 加上一个 /10.0
            double rw = 0.5 * divi;
            double rh = count[i] / 2.0 /10.0;//保证横纵坐标比例 加上一个 /10.0
            StdDraw.filledRectangle(x,y,rw,rh);
        }


    }
}
