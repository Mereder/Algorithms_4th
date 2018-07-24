package com.mereder.Algs_Exercise.Exercises1_1;

import edu.princeton.cs.algs4.StdIn;


import java.util.Arrays;

/**写在前面：
 * 本题各个方法或者实现 都是单独的，如果考虑整体操作的话，只需要一次标准输入即可，此时需要一个数组保存
 * 标准输入的结果，然后再进行各个操作。
 * 过滤：
 * 以下哪些任务需要（比如在数组中）保存标准输入中的所有值？
 * 2  6 7 8
 * 哪些可以被实现为一个过滤器且仅使用固定数量的变量和固定大小的数组（和N无关）？
 * 1 两个变量 4 一个变量  5一个变量   3 使用k大小数组
 * 4 和 5可以写在一个过滤器里面
 * 在每个问题中，输入都来自于标准输入且含有N个0到1的实数。
 * 1 打印出最大和最小的数
 * 2 打印出所有数的中位数
 * 3 打印出第k小的数，k<100
 * 4 打印出所有数的平方和
 * 5 打印出N个数的平均值
 * 6 打印出大于平均值的数的百分比
 * 7 将N个数按照升序打印
 * 8 将N个数按照随机顺序打印
 */
public class E_34 {
    /**1 打印出最大和最小的数
     * 需要两个变量
     * @param N
     */
    public static void max_min(int N){
        double max = 0.0;
        double min = 1.0;
        for (int i = 0; i < N; i++) {
            double value = StdIn.readDouble();
            if (value >= max) max = value;
            if (value <= min) min = value;
        }
        System.out.println("最大值:"+max);
        System.out.println("最小值:"+min);
    }

    /** 打印出所有数的中位数
     * 需要保存整个数组
     * @param N
     */
    public static void Median(int N){
        double Median = 0.0;
        double[] sort = new double[N];
        for (int i = 0; i < N; i++) {
            sort[i] = StdIn.readDouble();
        }
        Arrays.sort(sort);
        if (N%2 == 0){
            Median = (sort[N/2]+sort[N/2-1])/2.0;
        }
        else {
            Median = sort[N/2];
        }
        System.out.println("中位数为："+Median);
    }

    /**第K小的数 效率不高使用K大小数组
     * 效率高的话 还是用全数组 排一次序
     * @param N
     * @param k
     */
    public static void Kth_minum(int N,int k){
        double[] kth_minum = new    double[k];
        for (int i = 0; i < k; i++) {
            kth_minum[i] = StdIn.readDouble();
        }
        Arrays.sort(kth_minum);
        for (int i = k; i < N; i++) {
            double value = StdIn.readDouble();
            if (value < kth_minum[k-1]){
                kth_minum[k-1] = value;
                Arrays.sort(kth_minum);
            }
            else continue;
        }
        System.out.println("第K小的数为："+kth_minum[k-1]);

    }

    /**打印出所有数的平方和
     * 打印出N个数的平均值
     * @param N
     */
    public static void Ave_Quadraticsum(int N){
        double Ave= 0.0;
        double Quadraticsum = 0.0;
        for (int i = 0; i < N; i++) {
            double value = StdIn.readDouble();
            Ave += value;
            Quadraticsum += value*value;
        }
        System.out.println("平均数为："+(Ave/N));
        System.out.println("平方和为："+Quadraticsum);
    }

    /** 先求平均数 再就百分比
     * @param N
     */
    public static void LargerThanAverage(int N){
        double Ave = 0.0;
        double value[] = new  double[N];

        for (int i = 0; i < N; i++) {
            value[i] = StdIn.readDouble();
            Ave += value[i];
        }
        Ave = Ave / N;
        int count = 0;
        for (int i = 0 ; i < N; i++) {
            if (value[i] > Ave) count++;
        }
        double percent = count / (N*1.0)*100 ;
        System.out.println("大于平均值的数的百分比："+percent+"%");
    }

    public static void printSeq(int N){
        double[] Ascendingorder = new double[N];

        System.out.println("随机顺序打印：");
        for (int i = 0; i < N; i++) {
            double value = StdIn.readDouble();
            Ascendingorder[i] = value;
            System.out.printf("%f ",value);
        }
        System.out.println("升序打印：");
        Arrays.sort(Ascendingorder);
        for (int i = 0; i < N; i++) {
            System.out.printf("%f ",Ascendingorder[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int N = 10;
        int k = 5;
        System.out.println("打印出最大最小值：");
        max_min(N);
        System.out.println("打印中位数：");
        Median(N);
        System.out.println("打印第K小的数：");
        Kth_minum(N,k);
        System.out.println("打印平均数和平方和:");
        Ave_Quadraticsum(N  );

        printSeq(N);


    }
}
