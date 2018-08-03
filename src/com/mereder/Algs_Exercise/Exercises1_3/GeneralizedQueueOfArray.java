package com.mereder.Algs_Exercise.Exercises1_3;

import java.util.NoSuchElementException;

/**
 * 数组实现该数据类型
 * public class GeneralizedQueueOfArray<Item>
 *     ====================================================================
 *     public GeneralizedQueueOfArray()           创建一条空队列
 *     public boolean isEmpty()                   队列是否为空
 *     public void insert(Item item)              添加一个元素
 *     public Item delete(int k)                  删除并返回最早插入的第K个元素
 */
public class GeneralizedQueueOfArray<Item> {
    private Item[] Queue;
    private int n;

    public GeneralizedQueueOfArray() {
        Queue = (Item[]) new Object[1];
        n = 0;
    }
    public int size() { return n; }
    public boolean isEmpty(){ return n == 0; }

    private void Resizing(int max) {
        if (max <=  0 ) throw  new NoSuchElementException();
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < n; i++) {
            temp[i] = Queue[i];
        }
        Queue = temp;
    }
    public void insert(Item item){
        if (n == Queue.length) Resizing(2 * Queue.length);
        Queue[n++] = item;
    }

    public Item delete(int k){
        if (isEmpty()) throw new NoSuchElementException("No data");
        if (k > n) throw new NoSuchElementException("too large k");
        Item item =  Queue[k-1];
        Queue[k-1] = null;
        Item[] temp = (Item[]) new Object[n];
        for (int i = 0; i < k-1; i++) {
            temp[i] = Queue[i];
        }
        for (int i = k-1; i < n ; i++) {
            temp[i] = Queue[i+1];
        }
        Queue = temp;
        n--;
        return item;
    }

    public static void main(String[] args) {
        GeneralizedQueueOfArray<Integer> test = new GeneralizedQueueOfArray<>();
        for (int i = 0; i < 10; i++) {
            test.insert(i);
        }
        System.out.println(test.delete(5));

        System.out.println(test.delete(5));

    }
}
