package com.mereder.Algs_Exercise.Exercises1_1;

/**
 * 给出 使用欧几里得算法计算 105 和 24的最大公约数的过程中得到的一系列
 * p 和 q 的值。拓展 该算法中的代码得到一个程序Euclid，从命令行接受两个
 * 参数，计算他们的最大公约数并打印出每次调用递归方法时的两个参数。使用
 * 你的程序计算1111111和1234567 的最大公约数
 */
public class E_24 {
    public static int Euclid(int a,int b){
        if (a < b){
            System.out.println(b + " " +a);
            if (b % a == 0){
                return a;
            }
            else{
                return Euclid(a,b % a);
            }
        }
        else {
            System.out.println(a + " " +b);
            if (a % b == 0) {
                return b;
            } else{
                return Euclid(b, a % b);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Euclid(105,24));
        System.out.println(Euclid(1111111,1234567));
    }
}
