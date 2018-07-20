package com.mereder.Algs_Exercise.Exercises1_1;

/**
 * mystery（2,25）== 50
 * mystery(3,11) == 33
 * mystery (a,b) 给出的计算结果是 a*b
 * mystery (a,b) 给出的计算结果是 a^b
 */
public class E_18 {
    /**
     * @param a
     * @param b
     * @return a*b
     */
    public static int mystery(int a,int b){
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a+a,b/2);
        return mystery(a+a,b/2) + a;
    }

    /**
     * @param a
     * @param b
     * @return a^b
     */
    public static int mystery_1(int a,int b){
        if (b == 0) return 1;
        if (b % 2 == 0) return mystery_1(a*a,b/2);
        return mystery_1(a*a,b/2) * a;
    }
    public static void main(String[] args) {
        int a = 4;
        int b = 5;
        int result = mystery_1(a,b);
        System.out.println(result);
    }
}
