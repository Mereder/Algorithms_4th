package com.mereder.Algs_Exercise.Exercises1_4;


/**
 * 扔两个鸡蛋：假设你只有两个鸡蛋 最多扔2 sqrt(n) 次鸡蛋来确定F的值
 * 思想：
 * 两个鸡蛋的话  就将 N个层数 分为 根号N 组  其中每组都有 根号N 个数  即 N = (N**1/2)  *  (N ** 1/2)
 * 先对 根号N 组 的  上限进行 判断  当 到第i组鸡蛋碎了 则 证明  层数F在 i-1 组中 该组有 根号N个 数
 * 再对该组进行 顺序从下到上遍历。 最差根号N的复杂度
 */
public class E_25 {
    public static int F = 270;


    public static void main(String[] args) {
        int N = 1000;
        System.out.println("两个鸡蛋所用次数："+ DropTwoEggs(N));

    }
    public static boolean isBroken(int floor){
        return floor >= F;
    }
    //   2 sqrt(n)  次的成本
    public static int DropTwoEggs(int N){
        int lo = 0;
        int hi = 0;
        int ThrowTimes = 0;
        int Step = (int)Math.sqrt( N * 1.0);
        hi += Step;
        ThrowTimes++;
        while (!isBroken(lo)){
            ThrowTimes++;
            hi += Step;
            if (hi > N){
                hi = N;
            }
        }
        lo = hi - Step;
        ThrowTimes++;
        // 顺次遍历 lo -> hi
        while(!isBroken(lo)){
            ThrowTimes++;
            lo++;
        }
        return ThrowTimes;
    }
}
