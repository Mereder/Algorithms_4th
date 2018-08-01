package com.mereder.Algs_Exercise.Exercises1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**1.3.32 Steque
 * =======================================================================
 * public class Steque<Item> implements Iterable<Item>
 * -----------------------------------------------------------------------
 *        public Steque(); 默认构造函数。
 *        public bool isEmpty(); 检查 Steque 是否为空。
 *        public int getSize(); 返回 Steque 中的元素数量。
 *        public void Push(Item item); 向 Steque 中压入一个元素。
 *        public Item Pop(); 从 Steque 中弹出一个元素。
 *        public void Enqueue(Item item); 将一个元素添加入 Steque 中
 *        public Iterator<Item> iterator(); 实现迭代
 *        ================================================================
 *        public class ListIterator<Item> implements Iterator<Item>
 *            ------------------------------------------------------------
 *              public ListIterator(Node<Item> current)
 *              public boolean hasNext() {
 *              public Item next()
 */
public class Steque<Item> implements Iterable<Item> {
    private Node<Item> QueueLast;
    private Node<Item> StackTop;
    private int  n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;

        public Node() {
             next = null;
        }
    }

    public Steque() {
        QueueLast = null;
        StackTop = null;
        n = 0;
    }
    public boolean isEmpty(){
        return n == 0;
    }

    public int getSize() {
        return n;
    }

    public void Push(Item item){

        Node<Item> oldlist = StackTop;
        StackTop = new Node<>();
        StackTop.item = item;
        if (isEmpty()) {
            QueueLast = StackTop;
        }
        StackTop.next = oldlist;
        n++;
    }
    public Item Pop(){
        if (isEmpty()) throw new NoSuchElementException("stack  underflow");
        Item item = StackTop.item;
        StackTop = StackTop.next;
        n--;
        return item;
    }

    public void Enqueque(Item item){
        Node<Item> oldLast = QueueLast;
        QueueLast = new Node<>();
        QueueLast.item = item;
        QueueLast.next = null;
        if (isEmpty()) StackTop = QueueLast;
        else oldLast.next = QueueLast;
        n++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<>(StackTop);
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
            current = current.next;
            return item ;
        }
    }

    public static void main(String[] args) {
        Steque<Integer> steque = new Steque<>();
        steque.Push(1);
        steque.Push(2);
        steque.Enqueque(3);

        for (Integer current :steque) {
            System.out.println(current);
        }

        steque.Pop();
        System.out.println("弹栈后：");
        for (Integer current :steque) {
            System.out.println(current);
        }
    }
}
