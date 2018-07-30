package com.mereder.Algs_Exercise.Exercises1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 环形链表实现Queue。环形链表也是一条链表，只是没有任何结点的链接为空，且只要链表非空，则last.next的值为first
 * 只能使用一个Node类型的实例变量Last
 */
public class Queue<Item> implements Iterable<Item> {
   // private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Queue() {
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }
    public int size() {
        return n;
    }

    public void Enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        if (isEmpty())  last.next = last;
        else           {
            last.next = oldlast.next;
            oldlast.next = last;
        }
        n++;
    }
    public Item Dequeue(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = last.next.item;
        last.next = last.next.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }


    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>();}
    public class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                Item item = current.item;
                current = current.next;
                return item;
            }
            @Override
            public void remove() {

            }

        }


    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < 10; i++) {
            queue.Enqueue(i);
        }

        int first = queue.Dequeue();
        int second = queue.Dequeue();
        System.out.println(first +" "+ second);
    }
}
