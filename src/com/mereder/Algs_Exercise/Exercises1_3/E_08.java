package com.mereder.Algs_Exercise.Exercises1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 给定以下输入，给出DoublingStackOfStrings 的数组的内容和大小。
 * doublingstackofstrings 应该是那个可以动态调整数组大小的栈的实现形式
 * it was - the best - of times - - - it was - the - -
 * output:was best times of the was the it ^D
 * (1 left on stack)
 *   it
 *   大小为：2
 *
 *   数组内容仅剩下一个it 大小 次数数组大小为 2
 */
public class E_08 {
    public static class DoublingStackOfStrings{
        private String[] a = new String[1];
        private int N = 0;

        public boolean isEmpty(){ return N == 0; }
        public int size(){
            return N;
        }
        public int Arraysize(){return a.length; }
        private void resize(int max){
            String[] temp = new String[max];
            for (int i = 0; i < N; i++) {
                temp[i] = a[i];
            }
            a = temp;
        }
        public void push(String item){
            if (N == a.length) resize(2 * a.length);
            a[N++] = item;
        }
        public String pop(){
            String string = a[--N];
            a[N] = null;
            if (N > 0 && N == a.length/4)
                resize(a.length/2);
            return string;
        }

        @Override
        public String toString() {
            String string = " ";
            for (int i = 0; i < N; i++) {
                string += " "+a[i];
            }
            return string;
        }
    }

    public static void main(String[] args) {
        DoublingStackOfStrings stack = new DoublingStackOfStrings();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                stack.push(item);
            else if (!stack.isEmpty())
                StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
        System.out.println(stack);
        System.out.println("大小为："+stack.Arraysize());
    }
}
