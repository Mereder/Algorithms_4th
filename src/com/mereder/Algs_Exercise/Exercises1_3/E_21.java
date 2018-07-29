package com.mereder.Algs_Exercise.Exercises1_3;

/**
 * 编写一个方法find() 接受一条链表和一个字符串key作为参数。如果链表某个节点的item域 的值为key，则返回
 * true，否则返回false
 */
public class E_21 {
    private int n;
    private Node first;

    public E_21(){
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

    /** 方法用起来很奇怪，不如C++的数据结构那么舒服....
     * @param linkList
     * @param Key
     * @return
     */
    public static boolean find(E_21 linkList,String Key){
        E_21 current = linkList;
        int temp = current.n;
        Node node = current.first;
        while(temp > 0){
            if (node.item.equals(Key)) return true;
            else node = node.next;
            temp--;
        }
        return false;
    }

    public static void main(String[] args) {
        E_21 linkList = new E_21();

        linkList.append("hello");
        linkList.append("java");
        linkList.append("world");
        linkList.append("mereder");
        linkList.append("python");

        if (find(linkList,"hello"))
            System.out.println("true");
        else System.out.println("false");

        if (find(linkList,"1111"))
            System.out.println("true");
        else System.out.println("false");

    }
}
