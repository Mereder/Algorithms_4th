package com.mereder.Algs_Exercise.Exercises1_3;

/**
 * 为什么下面这段代码和上道题中的代码效果不同
 */
public class E_23 {
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
        x.next = t;
        t.next = x.next;
        //           |--|
        //           v  |
        //1->2->10->20--    20结点形成环
        // 更新t.next时,x.next 已经不再指向x的后续结点，而是指向t本身
        //死循环！！！！！
        while(first.next != null){
            System.out.println(first.item);
            first = first.next;
        }
        System.out.println(first.item);

    }
}
