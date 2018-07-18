package com.mereder.Algs_Exercise.Exercises1_1;

/**result:
 * b   char
 * 197   ASCII  b = 98  c = 99 单个字符不能跟字符串一样拼接 自动转换为int类型进行相加
 * e   'a' = 97  基础上 +4 得到 101 ASCII中 为 e
 */
public class E_8 {
    public static void main(String[] args) {

        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char)('b' + 'c')); //test
        System.out.println((char)('a'+ 4));
    }
}
