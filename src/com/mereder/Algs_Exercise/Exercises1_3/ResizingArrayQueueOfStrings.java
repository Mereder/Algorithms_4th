package com.mereder.Algs_Exercise.Exercises1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 编写一个ResizingArrayQueueOfStrings类，使用定长数组实现队列的抽象，然后扩展实现，使用
 * 调整数组的方法突破大小的限制
 */
public class ResizingArrayQueueOfStrings {
    private String[] Queue;
    private int N ;
    private int first;  //第一个元素
    private int last;  // 最后一个元素的下一个

    public ResizingArrayQueueOfStrings() {
        Queue = new String[1];
        N = 0;
        first = 0;
        last = 0;
    }

    public String[] getString() {
        return Queue;
    }
    public int size() {
        return N;
    }
    public int getFirst() {
        return first;
    }
    public int getLast() {
        return last;
    }

    public boolean isEmpty(){
        return N == 0;
    }
    public String Dequeue(){
        if (isEmpty()) throw new NoSuchElementException("No data");
        else {
            N--;
            String item = Queue[first];
            Queue[first] = null;
            first++;
            if (first == Queue.length) first = 0;
            if (N > 0 && N == Queue.length/4) Resizing(Queue.length/2);
            return item;
        }
    }
    public void Enqueue(String item){
        if (N == Queue.length) Resizing(2*Queue.length);
        Queue[last++] = item;
        if (last == Queue.length) last = 0;
        N++;
    }
    public String peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return Queue[first];
    }

    public void Resizing(int max){
        String[] strings = new String[max];
        for (int i = 0; i < N; i++) {
            strings[i] = Queue[(first + i) % Queue.length ]; // first+i 可能越界 取余
        }
        Queue = strings;
        first = 0;
        last = N;
    }

    //实现迭代
    public Iterator<String> iterator(){
        return new ArrayIterator();
    }

    public class ArrayIterator implements Iterator<String>{
        private int i = 0;
        @Override
        public boolean hasNext() {
            return i < N;
        }

        @Override
        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            String string = Queue[(first+i) % Queue.length];
            i++;
            return string;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) queue.Enqueue(item);
            else if (!queue.isEmpty()) StdOut.print(queue.Dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }
}
