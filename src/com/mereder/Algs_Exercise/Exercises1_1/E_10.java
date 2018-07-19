package com.mereder.Algs_Exercise.Exercises1_1;


/**Error Message:
 * Variable 'a' might not have been initialized
 *
 * solution:
 * 没有用new 为a[]
 */
public class E_10 {
    public static void main(String[] args) {
        int a[]  = new int[10];
        for (int i = 0; i < 10; i++) {   //unexpected token
            a[i] = i * i;
        }
    }
}
