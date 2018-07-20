package com.mereder.Algs_Exercise.Exercises1_1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;


/**
 * 斐波那契数列
 *
 * 更好的实现，用数组保存已经计算过的值：
 * 原理：不使用数组的时候，计算一个F（10）需要依次递归F（9）F（8）……F（1）F（0）
 *       使用数组时候，可以保存之前计算过的数值，F（10） = F（9） + F（8）  而F（9）与F（8）
 *       之前计算过，并进行了保存，所以可以迅速得出F（10）的结果。
 *
 *       顺便拓展下  队列实现方式  和  循环实现方式
 */
public class E_19 {

    /**
     * 递归实现   空间O（N）递归工作栈  时间 O( N^2 )
     * @param N
     * @return F(N);
     */
    public static long F(int N){
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N-1) + F(N-2 );
    }

    /**
     * 数组实现过程空间O（N） 时间 O（N）
     * @param N
     * @return F（N）
     */
    public static long F_array(int N){
        long[] array = new long[N+1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < N+1 ; i++) {
            array[i] = array[i-1] + array[i-2];
        }
        return array[N];
    }

    /**循环解决  实际上是运用 三个变量进行的  不断 相加 换位置
     * O（1）空间复杂度    O（N） 时间复杂度
     * @param N
     * @return F(N)
     */
    public static long  F_loop(int  N){
        long  first = 0;
        long second = 1;
        long temp = 0;

        for (int i = 0; i < N-1;i++){
            temp = first + second;
            first = second;
            second = temp;
        }
        return temp;
    }

    /**
     * 不知道java里面如何按序取到将要出队的前两个元素
     * 这里耍了个心机   就是 入队元素 =  出队元素 + 队头对头元素
     * 实际过程跟循环有点像。
     * 空间O（1） 时间O（N）
     * @param N
     * @return F(N)
     */
    public static long F_Queue(int N){
        Queue<Long> QL = new Queue<Long>();
        QL.enqueue((long)0);
        QL.enqueue((long)1);

        for (int i = 0; i < N-1 ; i++) {
            QL.enqueue(QL.dequeue()+ QL.peek());
        }
        QL.dequeue();
        return QL.peek();
    }
    public static void main(String[] args) {
        for (int N = 0;N < 10;N++){
            StdOut.println(N + " " + F(N));
        }
        System.out.println(F_array(9));
        System.out.println(F_loop(9));
        System.out.println(F_Queue(9));
    }
}
