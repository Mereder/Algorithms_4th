package com.mereder.Algs_Exercise.Exercises1_2;

import edu.princeton.cs.algs4.StdDraw;

/**
 * 编写一个VisualCounter类，支持加一减一操作。它的构造函数接受两个参数N和MAX 其中N指定了操作的最大次数。
 * max指定了计数器的最大绝对值。作为副作用，用图像显示每次计数器变化后的值
 */
public class E_10 {
    public static class VisualCounter{
        private int times;
        private final int N;
        private final int Max;
        private int count = 0;

        public VisualCounter(int max,int n) {
            times = 0;
            if (max < 0) {
                Max = -max;
                System.out.println("Input max error");
            }
            else{
                Max = max;
            }
            N = n;

            StdDraw.setXscale(0,n+1);
            StdDraw.setYscale(-(max+1),max+1);
            StdDraw.point(0,0);
        }

        public void increment(){
            if (times < N && Math.abs(count) < Max) {
                count++;
                times++;
            }
            else System.out.println("out of N or Max!");
        }

        public int getTimes() {
            return times;
        }

        public int getCount() {
            return count;
        }

        public void decrement(){
            if (times < N && Math.abs(count) < Max) {
                count--;
                times++;
            }
            else System.out.println("out of N or Max!");
        }

    }
    public static void main(String[] args){
        int N = 100;
        int Max = 100;
        VisualCounter visualCounter = new VisualCounter(Max,N);
        int count = 0;
        int times = 0;
        for (int i = 0; i < 40; i++) {
            count = visualCounter.getCount();
            times = visualCounter.getTimes();
            visualCounter.increment();
            StdDraw.point(times,count);
        }
        for (int i = 0; i < 30; i++) {
            count = visualCounter.getCount();
            times = visualCounter.getTimes();
            visualCounter.decrement();
            StdDraw.point(times,count);
        }
        for (int i = 0; i < 30; i++) {
            count = visualCounter.getCount();
            times = visualCounter.getTimes();
            visualCounter.increment();
            StdDraw.point(times,count);
        }
    }
}
