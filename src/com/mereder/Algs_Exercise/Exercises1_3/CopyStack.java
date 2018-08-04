package com.mereder.Algs_Exercise.Exercises1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

/**
 * 复制栈；为基于链表实现的栈编写一个新的构造函数
 */
public class CopyStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            stack.push(item);
        }
        System.out.println(stack);
        // 调用 复制栈的构造函数 在 edu.princeton.cs.algs4.Stack 中实现
        Stack<String> test = new Stack<>(stack);
        //测试测试不互相影响
        stack.push("test");
        System.out.println(stack);
        System.out.println(test);

    }
}
