package com.mereder.Algs_Exercise.Exercises1_1;

import java.util.Scanner;

public class E_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (a == b && b == c){
            System.out.println("equal");
        }
        else System.out.println("not equal");
    }
}
