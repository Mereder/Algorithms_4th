package com.mereder.Algs_Exercise.Exercises1_3;

import java.util.NoSuchElementException;

/**
 * 编写一个方法delete() 接受一个参数K，删除链表的第K个元素
 */
public class E_20 {
    private int n;
    private Node first;

    public E_20(){
        n = 0;
        first = null;
    }
    //链表的每个节点类
    private static class Node{
        private String item;
        private Node next;


    }
    public void append(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public void delete(int K){
        if (K > n) throw new NoSuchElementException("less than k");
        else if (K <= 0) throw new NoSuchElementException("error K");
        else{
            Node current;
            Node previous;
            current = first;
            previous = first;

            if (K == 1){
                System.out.println("删除元素为："+first.item);
                first = first.next;
                n--;
            }
            else {
                while(K-1 > 0 ){
                    previous = current;
                    current = current.next;
                    K--;
                }
                System.out.println("删除元素为："+current.item);
                previous.next = current.next;
                n--;
            }
        }
    }
    public void display(){
        if(n >0){
            Node node = first;
            int tempSize = n;
            if(tempSize == 1){//当前链表只有一个节点
                System.out.println("["+node.item+"]");
                return;
            }
            while(tempSize > 0){
                if(node.equals(first)){
                    System.out.print("["+node.item+"->");
                }else if(node.next == null){
                    System.out.print(node.item+"]");
                }else{
                    System.out.print(node.item+"->");
                }
                node = node.next;
                tempSize--;
            }
            System.out.println();
        }
        //如果链表一个节点都没有，直接打印[]
        else{
            System.out.println("[]");
        }
    }

    public static void main(String[] args) {
        E_20 Linklist = new E_20();

        for (int i = 0; i < 10; i++) {
            Linklist.append(Integer.toString(i));
        }
        Linklist.display();

        Linklist.delete(6);

        Linklist.display();
        //[9->8->7->6->5->4->3->2->1->0]
        //删除元素为：4
        //[9->8->7->6->5->3->2->1->0]
    }
}