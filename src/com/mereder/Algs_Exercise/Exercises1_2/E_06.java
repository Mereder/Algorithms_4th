package com.mereder.Algs_Exercise.Exercises1_2;

/**
 * 如果字符串s中的字符循环移动任意位置后能够得到另一个字符串t
 * 那么s就被称为t的回环变位。编写一个程序检查两个给定的字符串s
 * 和t是否互为回环变位。
 * Hint：答案只需要一行用到indexof  length 和字符串链接的代码。
 */
public class E_06 {
    public static void main(String[] args) {
        String s = "TGACGAC";
        String t = "ACTGACG";
        if (s.length() == t.length() && (s.concat(s).indexOf(t) > 0) )
            System.out.println("true");
        else System.out.println("false");
    }
}
