package com.mereder.Algs_Exercise.Exercises1_1;

/**
 * 使用rank()的递归方法重现实现BinarySearch() 并跟踪该方法的调用，
 * 每当该方法被调用时，打印出它的参数lo和hi并按照递归的深度缩进。
 * hint:为递归方法添加一个参数来保存递归的深度
 */
public class E_22 {
    public static int BinarSearch(int key,int[] a){
        return  rank(key,a,0,a.length-1,0);
    }

    private static int rank(int key, int[] a, int lo, int hi,int depth) {
        int para = depth;
        while(para > 0){
            System.out.print(" ");
            para--;
        }
        System.out.println(lo + " " + hi);

        if (lo > hi) return -1;
        int mid = lo + ( hi - lo )/ 2;
        if (key < a[mid]   ) return rank(key,a,lo,mid-1,++depth);
        else if (key > a[mid] ) return rank(key,a,mid+1,hi,++depth);
        else return mid;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8,9,10};
        int result  = BinarSearch(2,a);
        System.out.println(result);
    }
}
