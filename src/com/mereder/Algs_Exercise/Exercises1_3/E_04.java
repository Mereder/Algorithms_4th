package com.mereder.Algs_Exercise.Exercises1_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * 编写一个Stack的用例parentheses，从标准输入中读取一个文本流并使用栈判定其中的括号是否配对完整
 * 例如 [()]{}{[()()]()} 打印true
 * [(])打印 false
 */
public class E_04 {
    public static class Parentheses{
        private static final char LEFT_PAREN     = '(';
        private static final char RIGHT_PAREN    = ')';
        private static final char LEFT_BRACE     = '{';
        private static final char RIGHT_BRACE    = '}';
        private static final char LEFT_BRACKET   = '[';
        private static final char RIGHT_BRACKET  = ']';

        public  boolean isBalanced(String s) {
            Stack<Character> stack = new Stack<Character>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == LEFT_PAREN)   stack.push(LEFT_PAREN);
                if (s.charAt(i) == LEFT_BRACE)   stack.push(LEFT_BRACE);
                if (s.charAt(i) == LEFT_BRACKET) stack.push(LEFT_BRACKET);

                if (s.charAt(i) == RIGHT_PAREN) {
                    if (stack.isEmpty())           return false;
                    if (stack.pop() != LEFT_PAREN) return false;
                }

                else if (s.charAt(i) == RIGHT_BRACE) {
                    if (stack.isEmpty())           return false;
                    if (stack.pop() != LEFT_BRACE) return false;
                }

                else if (s.charAt(i) == RIGHT_BRACKET) {
                    if (stack.isEmpty())             return false;
                    if (stack.pop() != LEFT_BRACKET) return false;
                }
            }
            return stack.isEmpty();
        }
    }
    public static void main(String[] args) {
        Parentheses parentheses = new Parentheses();
        In in = new In();
        String s = in.readAll().trim();
        StdOut.println(parentheses.isBalanced(s));
    }
}
