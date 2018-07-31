package com.mereder.Algs_Exercise.Exercises1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleNode<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int n;

    private class Node<Item>{
        private Node<Item> previous;
        private Item item;
        private Node<Item> subsequent;

        public Node() {
            previous = null;
            subsequent = null;
        }
    }

    public DoubleNode() {
        first = null;
        last = null;
        n = 0;
    }
    public int getN() { return n; }

    public boolean isEmpty(){ return  n ==  0;}

    /**表头插入结点
     * @param item
     */
    public void Head_add(Item item){
        Node<Item> newHead = new Node<>();
        newHead.item = item;
        if (isEmpty()){
            first = newHead;
            last = first;
        }
        else {
            newHead.subsequent = first;
            first.previous = newHead;
            first = newHead;
        }
        n++;
    }

    /**表尾插入结点
     * @param item
     */
    public void Tail_add(Item item){
        Node<Item> newTail = new Node<>();
        newTail.item =  item;
        if (isEmpty()){
            last = newTail;
            first = last;
        }
        else {
            newTail.previous = last;
            last.subsequent = newTail;
            last = newTail;
        }
        n++;
    }

    public Item deleteHead(){
        if (isEmpty()) throw new NoSuchElementException("No Node");
        Item item = first.item;

        first = first.subsequent;
        first.previous = null;
        n--;
        return item;
    }

    public Item deleteTail(){
        if (isEmpty()) throw new NoSuchElementException("No Node");
        Item item = last.item;
        n--;
        last = last.previous;
        last.subsequent = null;
        return item;
    }

    public boolean insertBeforeSpecific(Item Key,Item insertItem){
        if(n == 0){
            return false;
        }
        Node newnode = new Node();
        newnode.item = insertItem;

        Node current = first;
        while (current != null){
            if (current.item.equals(Key)){
                if (current.previous == null){
                    current.previous = newnode;
                    newnode.subsequent = current;
                    first = newnode;
                }
                else {
                    current.previous.subsequent = newnode;
                    newnode.subsequent = current;
                    newnode.previous = current.previous;
                    current.previous = newnode;
                }
                n++;
                return true;
            }
            else {
                current = current.subsequent;
            }
        }
        return false;
    }

    public boolean insertAfterSpecific(Item Key,Item insertItem){
        if(n == 0){
            return false;
        }
        Node newnode = new Node();
        newnode.item = insertItem;

        Node current = first;
        while(current != null){
            if (current.item.equals(Key)){
                if (current.subsequent == null){
                    current.subsequent = newnode;
                    newnode.previous = current;
                    last = newnode;
                }
                else {
                    current.subsequent.previous = newnode;
                    newnode.subsequent = current.subsequent;
                    current.subsequent = newnode;
                    newnode.previous = current;
                }
                n++;
                return true;
            }
            else {
                current = current.subsequent;
            }
        }
        return false;

    }

    public boolean deleteSpecific(Item Key){
        if(n == 0){
            return false;
        }
        Node current = first;
        while(current.subsequent != null) {
            if (current.item.equals(Key)){
                if (current.previous == null){
                    first = first.subsequent;
                    first.previous = null;
                }
                else if (current.subsequent == null){
                    last = last.previous;
                    last.subsequent = null;
                }
                else {
                    current.previous.subsequent = current.subsequent;
                    current.previous.subsequent.previous = current.previous;
                }
                n--;
                return true;
            }
            else {
                current = current.subsequent;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    public static void main(String[] args) {
        DoubleNode<Integer> test = new DoubleNode<>();
        test.Head_add(1);
        //-1-
        if (test.insertBeforeSpecific(1,3)) System.out.println("insert correctly");
        else System.out.println("error");
        //-3<=>1-
        if (test.insertAfterSpecific(1,4)) System.out.println("insert correctly");
        else System.out.println("error");
        //-3<=>1<=>4-
        test.Head_add(2);
        //-2<=>3<=>1<=>4-
        if (test.deleteSpecific(1)) System.out.println("delete correctly");
        else System.out.println("error");
        //-2<=>3<=>4-
        test.Tail_add(9);
        //-2<=>3<=>4<=>9-
        test.Tail_add(10);
        //-2<=>3<=>4<=>9<=>10-
        test.deleteHead();
        //-3<=>4<=>9<=>10-
        test.deleteTail();
        //-3<=>4<=>9-
        System.out.println(test.first.item);
    }
}
