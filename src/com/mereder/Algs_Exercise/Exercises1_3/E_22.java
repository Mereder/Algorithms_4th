package com.mereder.Algs_Exercise.Exercises1_3;

/**
 * 假设x是一条链表中的某个结点，下面这段代码做了什么？
 */
public class E_22 {
    public static class Node{
        int item;
        Node next;
    }

    public static void main(String[] args) {
        Node first = new Node();
        first.item = 1;
        Node second = new Node();
        second.item = 2;
        Node t = new Node();
        t.item = 20;
        Node x = new Node();
        x.item = 10;
        //1->2->10
        first.next = second;
        second.next = x;
        x.next = null;
        //操作
        t.next = x.next;
        x.next = t;
        //1->2->10->20
        //插入t 结点  并使之成为x的后续结点
        while(first.next != null){
            System.out.println(first.item);
            first = first.next;
        }
        System.out.println(first.item);


    }
}
