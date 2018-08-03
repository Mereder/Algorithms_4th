package com.mereder.Algs_Exercise.Exercises1_3;

import edu.princeton.cs.algs4.StdRandom;

import java.util.NoSuchElementException;

/**
 * 环形缓冲区：
 * 环形缓冲区，又称环形队列，是一种定长为 N 的先进先出的数据结构。它在进程间的异步数据传输或记录
 * 日志文件时十分有用。当缓冲区为空时，消费者会在数据存入缓冲区前等待；当缓冲区满时，生产者会等待
 * 将数据存入缓冲区。设计一份API并用（回环）数组将其实现。
 */
public class RingBuffer<Item> {
    private Item[] ringBuffer;
    private int n;
    private int first;
    private int last;

    public RingBuffer( int N) {
        ringBuffer = (Item[]) new Object[N];
        this.n = 0;
        this.first = 0;
        this.last = 0;
    }
    public boolean isFull(){ return n == ringBuffer.length; }
    public boolean isEmpty(){ return n == 0; }

    public void WriteBuffer(Item item){
        if (isFull()) throw new OutOfMemoryError("Buffer is full");
        ringBuffer[last] = item;
        last = (last + 1) % ringBuffer.length;
        n++;
    }

    public Item ReadBuffer(){
        if (isEmpty()) throw new NoSuchElementException("Buffer is empty");
        Item item = ringBuffer[first];
        first = (first + 1) % ringBuffer.length;
        n--;
        return item;
    }


    public static void main(String[] args) {
        RingBuffer<Integer> buffer = new RingBuffer<>(10);

        //模拟生产消费随机过程，进程并发
        // 学了多线程 再来修改这部分
        for (int i = 0; i < 10; i++) {
            int rand = StdRandom.uniform(1,100);
            if (rand % 5 == 0) System.out.println(buffer.ReadBuffer());
            else buffer.WriteBuffer(rand);
        }
    }
}
