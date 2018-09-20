package com.mereder.Algs_Exercise.Exercises1_4;

public class E_12 {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7};
        int b[] = {2,4,6,8,10};
        //已经有序 无序 需要排序
        printSameElements(a,b);
    }
    public static void printSameElements(int a[],int b[]){
        int aLen = a.length;
        int bLen = b.length;
        int i = 0,j = 0;
        // 其中 aLen 或者 bLen 都是 N的数组， 必定先到一个N 最坏情况下 与N 成正比。
        while(i<aLen && j<bLen){
            if (a[i] > b[j]){
                j++;
            }
            else if (a[i] < b[j]){
                i++;
            }
            else {
                System.out.println(a[i] + " ");
                i++;
                j++;
            }
        }
    }
}
