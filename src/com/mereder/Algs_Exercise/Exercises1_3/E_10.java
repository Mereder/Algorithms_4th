package com.mereder.Algs_Exercise.Exercises1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

/**
 * 编写一个过滤器InfixToPostfix，将算术表达式由中序表达式变为后序表达式
 * 处理情况 均需要使用parentheses 括起来的 ((1+2)*((3-4)*(5-6)))
 * 不能很好的处理 1+2*3这种。
 */
public class E_10 {
    public static String InfixToPostfix(String infix){
        Stack<Character> opstack = new Stack<>();
        String postfix = "";
        int N = infix.length();
        for (int i = 0; i < N; i++) {
            char ch = infix.charAt(i);
            if (ch == ' ' || ch == '(') continue;
            else if (Character.isDigit(ch)) postfix += ch;
            else if ("*+/-".contains(String.valueOf(ch))) opstack.push(ch);
            else if (ch == ')'){
                postfix += opstack.pop();
            }
        }
        return postfix;
    }
    public static void main(String[] args) {
        String input = StdIn.readLine();
        System.out.println(input);
        String output = InfixToPostfix(input);
        System.out.println(output);
    }
}
