package com.mereder.Algs_Exercise.Exercises1_1;

import edu.princeton.cs.algs4.StdRandom;

import java.util.*;

/**
 * 删除重复元素：
 * 修改BinarySearch 类中的测试用例来删去排序后白名单中的所有重复元素
 */
public class E_28 {
    private static int count;
    public static int BinarySearch_(int key,int[] a){
        int lo = 0;
        int hi = a.length-1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return  -1;
    }

    /**
     * @param whiteList
     * @return Nozero[]
     * s使用数组方法处理  较为繁琐
     */
    public static int[] delete_same1(int[] whiteList) {
        int[] newlist = new int[whiteList.length];
        int i = 0;
        int j = 0;
        newlist[j] = whiteList[i];
        i++;
        while (i < whiteList.length){
            if (whiteList[i] != newlist[j]){
                j++;
                newlist[j] = whiteList[i];
                i++;
            }
            else i++;
        }
        count = j+1;

        int Nozero[] = Arrays.copyOf(newlist,count);
        return Nozero;
    }

    /**
     * @param whiteList
     * 创建一个集合，遍历数组并放入集合，通过contains()方法判断是否已经存在
     * 然后用toArray转成数组
     */
    public static void delete_same2(int[] whiteList){

        List list = new ArrayList();

        for(int i=0;i < whiteList.length;i++){
            if(!list.contains(whiteList[i])){
                list.add(whiteList[i]);
            }
        }

        Object[] newArray = list.toArray();

        for(int i=0;i<newArray.length;i++){
            System.out.printf("%d ",newArray[i]);
        }
    }

    /**
     * @param  arr
     * @return Object[] objects
     * 最简单的方法就是利用Set集合无序不可重复的特性进行元素过滤
     */
    public static Object[] delete_same3(int[] arr){
        //实例化一个set集合
        Set set = new HashSet();
        //遍历数组并存入集合,如果元素已存在则不会重复存入
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        //返回Set集合的数组形式
        return set.toArray();
    }
    public static void main(String[] args) {
        int N = 10;
        int[] whiteList = new  int[N];
        for (int i = 0; i < N; i++) {
            whiteList[i] = StdRandom.uniform(1,20);
        }
        Arrays.sort(whiteList);
        System.out.println("方法1:");
        int[] Nozero = Arrays.copyOf(delete_same1(whiteList),count);
        for (int i = 0; i < Nozero.length; i++) {
            System.out.printf("%d ",Nozero[i]);
        }
        System.out.println("\n方法二:");
        delete_same2(whiteList);
        System.out.println("\n方法三:");
        Object[] objects = delete_same3(whiteList);
        Arrays.sort(objects);
        for (Object object:objects) {
            System.out.printf("%d ",object);
        }

        System.out.println("二分查找结果:");
        System.out.println(BinarySearch_(1,whiteList));
    }
}
