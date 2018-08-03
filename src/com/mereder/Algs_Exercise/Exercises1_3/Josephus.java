package com.mereder.Algs_Exercise.Exercises1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Josephus 环问题
 */
public class Josephus {
    public static void main(String[] args) {
        System.out.println("输入N和M：");
        int N = StdIn.readInt();
        int M = StdIn.readInt();

        // initialize the queue

        Queue<Integer> queue = new Queue<Integer>();
        for (int i = 0; i < N; i++)
            queue.enqueue(i);

        while (!queue.isEmpty()) {
            for (int i = 0; i < M-1; i++)
                queue.enqueue(queue.dequeue());
            StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println();
    }
}
