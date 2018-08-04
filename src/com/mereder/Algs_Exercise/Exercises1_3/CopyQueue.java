package com.mereder.Algs_Exercise.Exercises1_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;

/**
 * 复制队列 编写一个新的构造函数
 * Queue<Item> r = new Queue<Item>(q);
 *
 */
public class CopyQueue {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            queue.enqueue(item);
        }
        // 调用 复制队列的构造函数 在 edu.princeton.cs.algs4.Queue 中实现
        Queue<String> copyqueue = new Queue<>(queue);
        System.out.println(queue);
        //测试不互相影响
        queue.dequeue();

        System.out.println(queue);

        System.out.println(copyqueue);
    }
}
