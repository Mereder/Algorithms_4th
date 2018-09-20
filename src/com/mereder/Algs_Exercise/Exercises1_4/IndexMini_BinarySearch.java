package com.mereder.Algs_Exercise.Exercises1_4;

import java.util.Arrays;

public class IndexMini_BinarySearch {
    public static int Index_Minimum(int key,int []array,int lo,int hi){
        if (hi < lo) return -1;
        int mid = lo + (hi - lo ) / 2;
        if (key > array[mid]){
            lo = mid + 1;
            return Index_Minimum(key,array,lo,hi);
        }
        else if (key < array[mid]){
            hi = mid - 1;
            return Index_Minimum(key,array,lo,hi);
        }
        else {
            int mini = Index_Minimum(key,array,lo,mid-1);
            if (mini == -1){
                return mid;
            }
            else return mini;
        }
    }
    public static void main(String[] args) {
        int a[] = {1,6,2,3,4,5,6,7,8,2};
        Arrays.sort(a);
        int index = Index_Minimum(2,a,0,a.length-1);
        System.out.println(index);

    }
}
