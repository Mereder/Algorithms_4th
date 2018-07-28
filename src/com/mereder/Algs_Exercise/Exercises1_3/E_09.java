package com.mereder.Algs_Exercise.Exercises1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

/**
 * 编写一段程序从标准输入得到一个缺少左括号的表达式并打印出补全括号之后的中序表达式。
 * 例如：1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 */
public class E_09 {
    public static String FillLeftparentheses(String string){
        Stack<String> opsstack = new Stack<>();
        Stack<String> datastack = new Stack<>();

        int N = string.length();
        for (int i = 0; i < N; i++) {
            char ch = string.charAt(i);
            if (Character.isSpaceChar(ch) ) continue;
            if (Character.isDigit(ch)) datastack.push(Character.toString(ch));
            else if ("*+-/".contains(Character.toString(ch))) opsstack.push(Character.toString(ch));

            else if (ch == ')'){
                String data2 = datastack.pop();
                String data1 = datastack.pop();
                String op = opsstack.pop();
                String expression = "("+data1+op+data2+")";
                datastack.push(expression);
            }
        }

        return datastack.pop();
    }
    public static void main(String[] args) {
        String input = StdIn.readLine();
        System.out.println(input);
        String output = FillLeftparentheses(input);
        System.out.println(output);
    }
}
