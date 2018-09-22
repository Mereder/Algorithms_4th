package com.mereder.Algs_Exercise.Exercises1_4;

import java.util.Scanner;

public class E_18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int a[] = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(Search(a));
    }
    public static int Search(int a[]){
        if(a[0] < a[1])
            return a[0];
        if(a[a.length-2] > a[a.length-1])
            return a[a.length-1];
        int lo = 0;
        int hi = a.length-1;

        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > a[mid-1] && a[mid] < a[mid+1])
                return a[mid];
            else {
                if (a[mid - 1] < a[mid + 1]) {
                    hi = mid - 1;
                }
                else if (a[mid - 1] > a[mid + 1]) {
                    lo = mid + 1;
                }
            }
        }
        return -1;
    }
}
