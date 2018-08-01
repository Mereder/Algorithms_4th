package com.mereder.Algs_Exercise.Exercises1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** 1.3.33 Deque
 *========================================================================
 * public class Deque<Item> implements Iterable<Item>
 * -----------------------------------------------------------------------
 *        public Deque();                  //创建空双向队列
 *        public boolean isEmpty();        //双向队列是否为空
 *        public int size()                //双向队列中的元素数量
 *        public void pushLeft(Item item)  //向左端添加一个新元素
 *        public void pushRight(Item item) //向右端添加一个新元素
 *        public Item popLeft()            //从左端删除一个元素
 *        public Item popRight()           //从右端删除一个元素
 */
public class Deque<Item> implements Iterable<Item> {
    private Node<Item> Left;
    private Node<Item> Right;
    private int n ;

    private static class Node<Item>{
        private Node<Item> previous;
        private Item item;
        private Node<Item> subsequent;

        public Node() {
            previous = null;
            subsequent = null;
        }
    }

    public Deque() {
        Left = null;
        Right = null;
        n = 0;
    }

    public int size() {
        return n;
    }

    /**双向队列是否为空
     * @return
     */
    public boolean isEmpty(){ return  n == 0;}

    /**向左端添加一个新元素
     * @param item
     */
    public void pushLeft(Item item){
        Node<Item> oldlist = Left;
        Left = new Node<>();
        Left.item = item;
        if (isEmpty()){
            Left.subsequent = oldlist;
            Left.previous = oldlist;
            Right = Left;
        }
        else {
            Left.subsequent = oldlist;
            oldlist.previous = Left;
        }
        n++;
    }

    /** 向右端添加一个新元素
     * @param item
     */
    public void pushRight(Item item){
        Node<Item> oldlist = Right;
        Right = new Node<>();
        Right.item = item;
        if (isEmpty()){
            Right.subsequent = oldlist;
            Right.previous = oldlist;
            Left = Right  ;
        }
        else {
            Right.previous = oldlist;
            oldlist.subsequent = Right;
        }
        n++;
    }

    /** 从左端删除一个元素
     * @return
     */
    public Item popLeft(){
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item  = Left.item;
        Left = Left.subsequent;
        Left.previous = null;
        n--;
        return item;
    }

    /** 从右端删除一个元素
     * @return
     */
    public Item popRight(){
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item  = Right.item;
        Right = Right.previous;
        Right.subsequent = null;
        n--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<>(Left);
    }
    public class ListIterator<Item> implements Iterator<Item>{
        Node<Item> current = new Node<>();

        public ListIterator(Node<Item> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.subsequent;
            return item ;
        }
    }
    public void display(){
        for (Item current :this) {
            System.out.print(current+" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();

        System.out.println("左压栈：");
        deque.pushLeft(1);
        deque.pushLeft(2);
        deque.pushLeft(3);
        deque.pushLeft(4);
        deque.display();

        System.out.println("右压栈：");
        deque.pushRight(9);
        deque.pushRight(8);
        deque.display();

        System.out.println("左出栈：");
        int left = deque.popLeft();
        System.out.println("弹出："+left);
        deque.display();

        System.out.println("右出栈：");
        int right = deque.popRight();
        System.out.println("弹出："+right);
        deque.display();

    }
}
