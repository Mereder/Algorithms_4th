package com.mereder.Algs_Exercise.Exercises1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** E_12题 （拿题号做类名是在太难受了）
 * 编写一个可迭代的Stack用例，它含有一个静态的copy方法，接受一个字符串的栈作为参数
 * 返回该栈的一个副本。
 * @param <Item>
 */
public class IterableStack<Item> implements Iterable<Item> {
        private Node<Item> first;     // top of stack
        private int n;                // size of the stack

        // helper linked list class
        private  class Node<Item> {
            private Item item;
            private Node<Item> next;
        }

        /**
         * Initializes an empty stack.
         */
        public IterableStack() {
            first = null;
            n = 0;
        }

        /**
         * Returns true if this stack is empty.
         *
         * @return true if this stack is empty; false otherwise
         */
        public boolean isEmpty() {
            return first == null;
        }

        /**
         * Returns the number of items in this stack.
         *
         * @return the number of items in this stack
         */
        public int size() {
            return n;
        }

        /**
         * Adds the item to this stack.
         *
         * @param  item the item to add
         */
        public void push(Item item) {
            Node<Item> oldfirst = first;
            first = new Node<Item>();
            first.item = item;
            first.next = oldfirst;
            n++;
        }

        /**
         * Removes and returns the item most recently added to this stack.
         *
         * @return the item most recently added
         * @throws NoSuchElementException if this stack is empty
         */
        public Item pop() {
            if (isEmpty())
                throw new NoSuchElementException("Stack underflow");
            Item item = first.item;        // save item to return
            first = first.next;            // delete first node
            n--;
            return item;                   // return the saved item
        }

        /**
         * Returns (but does not remove) the item most recently added to this stack.
         *
         * @return the item most recently added to this stack
         * @throws NoSuchElementException if this stack is empty
         */
        public Item peek() {
            if (isEmpty()) throw new NoSuchElementException("Stack underflow");
            return first.item;
        }

        public static IterableStack<String> copy(IterableStack<String> IterableStackString){
            IterableStack<String> temp = new IterableStack<>();
            IterableStack<String> result = new IterableStack<>();

            for (String s:IterableStackString){
                temp.push(s);
            }
            for (String s : temp) {
                result.push(s);
            }
            return result;
        }
        /**
         * Returns a string representation of this stack.
         *
         * @return the sequence of items in this stack in LIFO order, separated by spaces
         */
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (Item item : this) {
                s.append(item);
                s.append(' ');
            }
            return s.toString();
        }

        /**
         * Returns an iterator to this stack that iterates through the items in LIFO order.
         *
         * @return an iterator to this stack that iterates through the items in LIFO order
         */
        public Iterator<Item> iterator() {
            return new ListIterator<Item>(first);
        }

        // an iterator, doesn't implement remove() since it's optional
        private class ListIterator<Item> implements Iterator<Item> {
            private Node<Item> current;

            public ListIterator(Node<Item> first) {
                current = first;
            }

            public boolean hasNext() {
                return current != null;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                Item item = current.item;
                current = current.next;
                return item;
            }
        }

    public static void main(String[] args) {
        IterableStack<String> stack = new IterableStack<>();
        stack.push("hello");
        stack.push("world");
        stack.push("hello");
        stack.push("java");
        IterableStack<String> newstack = new IterableStack<>();
        newstack = copy(stack);
        for (String ss : newstack) {
            System.out.println(ss);
        }
    }

}
