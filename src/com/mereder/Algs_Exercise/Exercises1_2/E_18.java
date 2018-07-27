package com.mereder.Algs_Exercise.Exercises1_2;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 累加器的方差：
 * 以下代码为Accumulator 类添加了var（） 和stddev（）方法，他们计算了
 * addDataValue（）方法的参数的方差和标准差 验证这段代码
 *
 * 与直接对所有数据的平方求和的方法相比较。这种实现能够更好的避免四舍五入产生的误差。
 */
public class E_18 {
    public static class Accumulator{
        private double m;
        private double s;
        private int    N;

        public Accumulator() {
            m = 0;
            s = 0;
            N = 0;
        }

        public void addDaraValue(double x){
            N++;
            s = s + 1.0 * (N-1) / N * (x - m) * (x - m);
            m = m + (x - m) / N;
        }
        public double mean(){
            return m;
        }
        public double var(){
            return s / (N-1);
        }

        public double stddev(){
            return Math.sqrt(this.var());
        }

        @Override
        public String toString() {
            return "Mean (" + N + " values ):"
                    + String.format("%7.5f",mean())
                    + " var : " + var()
                    + " stddev :" + stddev();
        }
    }

    public static void main(String[] args) {
        Accumulator accumulator = new Accumulator();
        for (int i = 0; i < 10; i++) {
            double temp = StdRandom.uniform(1,100);
            accumulator.addDaraValue(temp);
        }

        System.out.println(accumulator);
    }
}
