package com.mereder.Algs_Exercise.Exercises1_3;

/**
 * 假设x是一条链表的某个结点而不是尾结点，下面这条语句的效果是什么？
 * x.next= x.next.next
 * 1 2 3 4 5
 * x 为 3
 * x.next 为 4
 * x.next.next 为5
 * x.next= x.next.next
 * 链表变为 1 2 3 5
 */
public class E_18 {
    public static class Node{
        public int item;
        public Node next;
    }

    public static void main(String[] args) {
        Node first = new Node();
        first.item = 1;
        Node second = new Node();
        second.item = 2;
        Node third = new Node();
        third.item = 3;

        first.next = second;
        second.next = third;
        third.next = null;

        //x.next= x.next.next
        first.next = first.next.next;

        while (first != null){
            System.out.println(first.item);
            first = first.next;
        }
        // 结果为
        // 1
        // 3

    }
}
