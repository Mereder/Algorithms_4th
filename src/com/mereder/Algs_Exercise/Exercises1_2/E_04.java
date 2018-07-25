package com.mereder.Algs_Exercise.Exercises1_2;

/**
 * 以下代码会打印出什么？
 *
 * Result:String2 指向“hello” 当String1被赋值指向“world”时，String1仍然是“hello”
 * world
 * hello
 */
public class E_04 {
    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        System.out.println(string1);
        System.out.println(string2);
    }
}
