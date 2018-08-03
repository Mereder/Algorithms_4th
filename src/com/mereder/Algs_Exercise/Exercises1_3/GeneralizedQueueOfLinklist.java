package com.mereder.Algs_Exercise.Exercises1_3;

import java.util.NoSuchElementException;

public class GeneralizedQueueOfLinklist<Item> {
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int n;               // number of elements on queue

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }
    public GeneralizedQueueOfLinklist() {
        first = null;
        last  = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void insert(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }

    public Item delete(int k) {
        Item item;
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        if (k > n || k <= 0){
           throw new NoSuchElementException("error k");
        }
        else if (k == 1){
            item = first.item;
            first = first.next;
        }
        else {
            Node<Item> current = first;
            for (int i = 0; i < k - 2; i++) {
                current = current.next;
            }
             item = current.next.item;
            current.next = current.next.next;
        }
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    public static void main(String[] args) {
        GeneralizedQueueOfLinklist<Integer> test1 = new GeneralizedQueueOfLinklist<>();
        for (int i = 0; i < 10; i++) {
            test1.insert(i);
        }

        System.out.println(test1.delete(5));

        System.out.println(test1.delete(2));

    }
}
