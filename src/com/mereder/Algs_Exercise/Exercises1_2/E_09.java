package com.mereder.Algs_Exercise.Exercises1_2;

import edu.princeton.cs.algs4.Counter;

/**
 * 修改BinartSearch，使用Counter 统计在有查找中被检查的键的总数并在查找全部接受后打印该值
 * hint ：在main中创建一个Counter对象并将它作为参数传递给rank（）
 */
public class E_09 {
    public static int rank_(int key, int[] a, Counter counter){
        int lo = 0;
        int hi = a.length-1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]){
                counter.increment();
                hi = mid - 1;
            }
            else if (key > a[mid]){
                counter.increment();
                lo = mid + 1;
            }
            else{
                counter.increment();
                return mid;
            }
        }
        return  -1;
    }
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8,9,10};
        Counter counter = new Counter("SearchTime");
        if (rank_(2,a,counter)> 0) System.out.println(counter);
        else System.out.println("No data!");
    }
}
