package com.mereder.Algs_Exercise.Exercises1_4;

import edu.princeton.cs.algs4.Stack;

import java.util.NoSuchElementException;


/**
 * 两个栈实现的队列。
 *
 * 用两个栈实现一个队列，使得每个队列操作所需要的堆栈操作均摊后为一个常数。
 */
public class E_27 {
    public static class StackQueue<Item>{
        public Stack<Item> L;  //出队
        public Stack<Item> R;  //入队

        public StackQueue() {
            L = new Stack<Item>();
            R = new Stack<Item>();
        }

        public void enQueue(Item item){
            R.push(item);
        }

        public Item deQueue(){
            Item retunItem;
            if (L.isEmpty() && R.isEmpty()){
                throw new NoSuchElementException("Queue underflow");
            }
            else if (L.isEmpty()){
                while(!R.isEmpty()){
                    L.push(R.pop());
                }
                retunItem =  L.pop();
            }
            else {
                retunItem =  L.pop();
            }
            return retunItem;
        }
        public int size(){
            return L.size()+R.size();
        }
    }


    public static void main(String[] args) {
        StackQueue<Integer> test = new StackQueue<>();
        test.enQueue(1);
        test.enQueue(2);
        test.enQueue(3);
        test.enQueue(4);
        int len = test.size();
        for (int i = 0; i < len ; i++) {
            System.out.println(test.deQueue());
        }

    }
}
