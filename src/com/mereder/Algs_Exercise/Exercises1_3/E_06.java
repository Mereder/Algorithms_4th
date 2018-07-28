package com.mereder.Algs_Exercise.Exercises1_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * 下面这段代码对队列q进行了什么操作？
 * 借助一个栈 将队列q逆序
 */
public class E_06 {
    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        Stack<String> stack = new Stack<>();
        while(!q.isEmpty())
            stack.push(q.dequeue());
        while (!stack.isEmpty())
            q.enqueue(stack.pop());
    }
}
