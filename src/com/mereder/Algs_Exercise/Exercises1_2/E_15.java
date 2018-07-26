package com.mereder.Algs_Exercise.Exercises1_2;

import edu.princeton.cs.algs4.In;


/**
 * 文件输入：
 * 基于String 的split方法实现In中的静态方法 readInts（）;
 * readAll 的函数中，直接将文件test.txt的所有内容都读到一个字符串中
 */
public class E_15 {
    public static int[] readInts(String name){
        In in = new In(name);
        String input = in.readAll();
        String[] words = input.split("\\s+");
        int[] ints = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            ints[i] = Integer.parseInt(words[i]);
        }
        return ints;
    }
    public static void main(String[] args) {
        int[] ints;
        ints = readInts("e://test.txt");
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
