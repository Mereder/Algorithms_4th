package com.mereder.Algs_Exercise.Exercises1_3;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomQueue<Item> implements Iterable<Item> {
    private Item[] Queue;
    private int n;


    public RandomQueue() {
         n = 0;
         Queue = (Item[]) new Object[1];
    }

    public boolean isEmpty(){ return n == 0;}

    public int size(){ return  n; }

    public void Enqueue(Item item ){
        if(n == Queue.length) Resizing( 2 * Queue.length);
        Queue[n++] = item;
    }

    private void Resizing(int max) {
        if (max <=  0 ) throw  new NoSuchElementException();
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < n; i++) {
            temp[i] = Queue[i];
        }
        Queue = temp;
    }

    public void Random(){
        int r = StdRandom.uniform(0,n);  // 左闭右开集合
        Item temp = Queue[r];
        Queue[r] =  Queue[n-1];
        Queue[n-1] = temp;
    }
    /**随机返回一个元素并删除它
     * @return
     */
    public Item Dequeue(){
        if (isEmpty()) throw new NoSuchElementException("no data");

        Random();

        Item item = Queue[--n];
        Queue[n] = null;
        if (n > 0 && n == Queue.length/4) Resizing(Queue.length/2);
        return item;
    }

    /** 随机返回一个元素但不删除它
     * @return
     */
    public Item Sample(){
        if (isEmpty()) throw new NoSuchElementException("No data");
        Random();
        Item item = Queue[n-1];
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<>();
    }
    public  class ListIterator<Item> implements Iterator<Item>{

        public ListIterator() {
            Random();
        }

        @Override
        public boolean hasNext() {
            return n != 0;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = (Item) Queue[--n];
            return item;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        RandomQueue<Integer> randomQueue = new RandomQueue<>();
        for (int i = 0; i < 10; i++) {
            randomQueue.Enqueue(i);
        }

        System.out.println(randomQueue.Dequeue());

        for (Integer temp :
                randomQueue) {
            System.out.print(temp+" ");
        }
    }
}
