package com.mereder.Algs_Exercise.Exercises1_3;


import edu.princeton.cs.algs4.StdRandom;

/**
 * 给出一段代码，其中链表的首节点为first 删除链表的尾结点。
 */
public class E_19 {
    public Node first;
    public int n;

    public static class Node{
        public int item;
        public Node next;
    }

    public E_19() {
        first = null;
        n = 0;
    }
    public void append(int item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }
    public void DeleteLast(){
        Node current = first;

        while(current.next.next != null){
            current = current.next;
        }
        current.next = current.next.next;
        n--;
    }

    public static void main(String[] args) {
        E_19 Linklist = new E_19();

        for (int i = 0; i < 5; i++) {
            Linklist.append(StdRandom.uniform(1,20));
        }
        Linklist.DeleteLast();
        System.out.println(Linklist.n);
    }
}
