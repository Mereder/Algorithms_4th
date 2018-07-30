package com.mereder.Algs_Exercise.Exercises1_3;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

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
    }


    @Override
    public Iterator iterator() {
        return null;
    }

    public static void main(String[] args) {
        DoubleNode<Integer> test = new DoubleNode<>();
        test.Head_add(1);
        test.Head_add(2);

        test.Tail_add(9);
        test.Tail_add(10);

        System.out.println(test.first.item);
    }
}
