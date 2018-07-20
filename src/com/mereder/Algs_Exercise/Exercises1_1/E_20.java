package com.mereder.Algs_Exercise.Exercises1_1;

/**
 * 编写一个递归的静态方法计算  ln（N！） 的值
 */
public class E_20 {
    public static double calculate(int N){
        if (N == 1 || N == 0) return 1;
        return N * calculate(N-1);
    }
    public static void main(String[] args) {
        int N = 5;
        double result= Math.log(calculate(N));
       // System.out.println(calculate(N));
        System.out.printf("%.5f\n",result);
    }
}
