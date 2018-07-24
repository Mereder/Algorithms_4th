package com.mereder.Algs_Exercise.Exercises1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 用实验模拟N次掷骰子，并在计算两个1到6之间的随机整数之和时记录每个值出现的频率
 * 以验证他们的概率。N要多大时才能够保证你的经验数据和准确数据的吻合程度达到小数点后三位。
 *Result： 测试区间在  7*10^5 ~ 8*10^5 之间
 */
public class E_35 {
    public static double[] Standard(){
        int SIDES = 6;
        double[] dist = new double[2*SIDES+1];
        for (int i = 1; i <= SIDES; i++) {
            for (int j = 1; j <= SIDES ; j++) {
                dist[i+j] += 1.0;
            }
        }
        for (int i = 2; i <= 2*SIDES ; i++) {
            dist[i] /= 36.0;
        }
        return dist;
    }

    public static void main(String[] args) {
        int N = 0;
        N = StdIn.readInt();
        int SIDES = 6;
        double[] Experiment = new  double[2*SIDES+1];
        for (int i = 0; i < N; i++) {
            int a = StdRandom.uniform(1,7); //包括1 但是不包括 7  所以为1-6
            int b = StdRandom.uniform(1,7);
            Experiment[a+b] += 1.0;
        }
        double[] Standard = Standard();
        for (int i = 1; i <= 2*SIDES; i++) {
            Experiment[i] /= N;
            if (Math.abs(Experiment[i]-Standard[i]) > 0.001){
                System.out.println("精度不够！");
            }
            System.out.printf("%.3f ",Standard[i]);
        }

    }
}
