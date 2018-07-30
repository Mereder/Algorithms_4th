package com.mereder.Algs_Exercise.Exercises1_3;

public class LinkList {
    private int size;//链表节点的个数
    private Node head;//头节点

    public LinkList(){
        size = 0;
        head = null;
    }

    public int getSize() {
        return size;
    }

    public Node getHead() {
        return head;
    }

    //链表的每个节点类
    private class Node{
        private String data;//每个节点的数据
        private Node next;//每个节点指向下一个节点的连接
    }

    public void addHead(String obj){
        Node newHead = new Node();
        newHead.data = obj;
        if(size == 0)
            head = newHead;
        else{
            newHead.next = head;
            head = newHead;
        }
        size++;
    }

        //在链表头删除元素

    public String deleteHead(){
        String obj = head.data;
        head = head.next;
        size--;
        return obj;
    }

    //查找指定元素，找到了返回节点Node，找不到返回null

    public Node find(String obj){
        Node current = head;
        int tempSize = size;
        while(tempSize > 0){
            if(obj.equals(current.data))
                return current;
            else
                current = current.next;

            tempSize--;
        }
        return null;
    }

    //删除指定的元素，删除成功返回true

    public boolean delete(String value){
            if(size == 0){
                return false;
            }
            Node current = head;
            Node previous = head;
            while(current.data != value){
                if(current.next == null){
                    return false;
                }else{
                    previous = current;
                    current = current.next;
                }
            }
            //如果删除的节点是第一个节点
            if(current == head){
                head = current.next;
                size--;
            }else{//删除的节点不是第一个节点
                previous.next = current.next;
                size--;
            }
            return true;
        }

        //判断链表是否为空
    public boolean isEmpty(){
            return (size == 0);
        }

        //显示节点信息

    public void display(){
        if(size >0) {
            Node node = head;
            int tempSize = size;
            if (tempSize == 1) {//当前链表只有一个节点
                System.out.println("[" + node.data + "]");
                return;
            }
            while (tempSize > 0) {
                if (node.equals(head)) {
                    System.out.print("[" + node.data + "->");
                } else if (node.next == null) {
                    System.out.print(node.data + "]");
                } else {
                    System.out.print(node.data + "->");
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

    }

}
