package com.mereder.Algs_Exercise.Exercises1_3;

/**
 * 为FixedCapacityStackOfStrings 添加一个方法 isFull();
 */
public class E_01 {
    public static class FixedCapacityStackOfStrings{
        private String[] a;
        private int N;
        public FixedCapacityStackOfStrings(int cap){
            a = new String[cap];
        }
        public boolean isEmpty(){
            return N == 0;
        }
        public boolean isFull(){
            return N == a.length;
        }
        public int size(){
            return N;
        }
        public void push(String item){
            a[N++] = item;
        }
        public String pop(){
            return a[--N];
        }
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings fixedCapacityStackOfStrings = new FixedCapacityStackOfStrings(3);
        fixedCapacityStackOfStrings.push("hello");
        fixedCapacityStackOfStrings.push("java");
        fixedCapacityStackOfStrings.push("hello");
        if (fixedCapacityStackOfStrings.isFull()) System.out.println("full");
        else fixedCapacityStackOfStrings.push("world");
    }
}
