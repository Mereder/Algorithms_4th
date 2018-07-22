package com.mereder.Algs_Exercise.Exercises1_1;

import javax.swing.*;

/**
 * 二项分布：
 * 估计用以下代码计算binomial(100,50,0.25) 将会产生的递归调用次数
 *
 * 将计算过的值保存在数组中，并给出一个更好的实现
 */
public class E_27 {
    public static int count = 0;
    public static double array[][];

    public static double binomial(int N,int k,double p){
        count ++;
        System.out.println(count);
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        return (1.0 - p)*binomial(N-1,k,p) + p * binomial(N-1,k-1,p);
    }
    public static double binomial_array(int N,int k,double p){
        array = new double[N+1][k+1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= k; j++) {
                array[i][j] = -1;
            }
        }
        return calculate(N,k,p);
    }

    private static double calculate(int N,int k,double p) {
        count++;
        if (N == 0 && k == 0) {
        //    array[0][0] = 1.0;
            return  1.0;
        }
        if (N < 0 || k < 0) return 0.0;
        if (array[N][k] == -1){
            array[N][k] = (1.0 - p)*calculate(N-1,k,p) + p * calculate(N-1,k-1,p);
        }
        return array[N][k];
    }


    public static void main(String[] args) {
      //  double result = binomial(5,1,0.25);
        double result1 = binomial_array(100,50,0.25);
        System.out.println(count);
        System.out.println(result1);
    }
}
