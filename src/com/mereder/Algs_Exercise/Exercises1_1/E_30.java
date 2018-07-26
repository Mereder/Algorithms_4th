package com.mereder.Algs_Exercise.Exercises1_1;


/**
 * 数组练习：
 * 编写一段程序，创建一个N*N的布尔型数组a[][]。其中当i和j互质时（没有相同因子）
 * a[i][j]为true，否则为false
 *
 * 判断互质：最大公约数为1 互质，否则不互质
 */
public class E_30 {

    public static boolean relatively_prime(int a,int b){
        if (gcd(a,b) == 1) return true;
        else return false;
    }
    public static int gcd(int a, int b) {
        if (a < b) {
            int t = b;
            b = a;
            a = t;
        }
        if(b == 0)
            return a;
        else
            return gcd(b,a%b);
    }
    public static void main(String[] args) {
        int N = 10;
        boolean[][] a = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (relatively_prime(i,j)) a[i][j] = true;
                else a[i][j] = false;
            }
        }
        System.out.println("");
    }
}
