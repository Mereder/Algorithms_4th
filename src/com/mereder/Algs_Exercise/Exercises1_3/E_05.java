package com.mereder.Algs_Exercise.Exercises1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

/**
 * 当N等于50 时 下面这段代码会打印出什么？从较高抽象层次描述给定正整数N时这段代码的行为。
 * Result:
 * 当N=50时，打印 110010
 * 抽象层次描述：打印N的二进制
 */
public class E_05 {

    public static void main(String[] args) {
        int N = StdIn.readInt();
        Stack<Integer> stack = new Stack<Integer>();
        while (N > 0){
            stack.push(N % 2);
            N = N / 2;
        }
        for (int d : stack) {
            System.out.print(d);
        }
        System.out.println();
    }
}
