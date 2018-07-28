package com.mereder.Algs_Exercise.Exercises1_3;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;

/**
 * 使用1.3.1.5节中的readInts()作为模板为Date 编写一个静态方法ReadDates(),
 * 从标准输入中读取由练习1.2.19的表格所指定的格式的多个日期并返回一个它们的数组
 * 命令行 中断输入  ctrl + d
 */
public class E_16 {
    public static Date[] readDates(){
        Queue<Date> queue = new Queue<>();
        while(!StdIn.isEmpty()) queue.enqueue(new Date(StdIn.readString()));

        int N = queue.size();
        Date[] dates = new Date[N];
        for (int i = 0; i < N; i++) {
            dates[i] = queue.dequeue();
        }
        return dates;
    }
    public static void main(String[] args) {
        Date[] dates = readDates();
        for (int i = 0; i < dates.length; i++) {
            System.out.println(dates[i]);
        }
    }
}
