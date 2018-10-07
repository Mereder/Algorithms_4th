package com.mereder.Algs_Exercise.Exercises1_4;

import edu.princeton.cs.algs4.Queue;

/**
 * 一个队列实现的栈。
 * 使用一个队列实现一个栈，使得每个栈操作所需的队列操作数量为线性级别。
 */
public class E_28 {
    public static class QueueStack<Item>{
        public Queue<Item> queue;

        public QueueStack() {
            this.queue = new Queue();
        }

        public void Push(Item item){
            queue.enqueue(item);
        }

        public Item Pop(){
            int size = this.Size();
            Item temp = null;

            for (int i = 0; i < size - 1; i++) {
                queue.enqueue(queue.dequeue());
            }

            temp = queue.dequeue();
            return temp;
        }
        public int Size(){
            return queue.size();
        }
    }
    public static void main(String[] args) {
        QueueStack<Integer> queueStack = new QueueStack<>();
        queueStack.Push(1);
        queueStack.Push(2);
        queueStack.Push(3);
        queueStack.Push(4);
        int n = queueStack.Size();
        for (int i = 0; i < n; i++) {
            System.out.println(queueStack.Pop());
        }
    }
}
