package com.mereder.Algs_Exercise.Exercises1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomBag<Item> implements Iterable<Item> {
    private Item[] Bag;
    private int n;               // number of elements in bag

    // helper linked list class

    public RandomBag() {
        Bag = (Item[]) new Object[1];
        n = 0;
    }
    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void add(Item item) {
        if (n == Bag.length) Resizing(2 * Bag.length);
        Bag[n++] =  item;
    }

    private void Resizing(int capacity) {
        if (capacity <= 0) throw new NoSuchElementException(" ");
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; ++i)
        {
            temp[i] = Bag[i];
        }
        Bag = temp;
    }


    @Override
    public Iterator<Item> iterator()  {
        return new ListIterator<>();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {

        public ListIterator() {
            Random((Item[]) Bag);
        }

        public void Random(Item[] Bag){
            for (int i = 0; i < n; i++) {
                int r=i+(int)(Math.random()*(n-i));
                Item temp = Bag[i];
                Bag[i] = Bag[r];
                Bag[r] = temp;
            }
        }
        public boolean hasNext()  { return n != 0;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = (Item) Bag[--n];
            return item;
        }
    }

    public static void main(String[] args) {
        RandomBag<Integer> randomBag = new RandomBag<>();

        for (int i = 0; i < 20; i++) {
            randomBag.add(i);
        }

        for (Integer item:randomBag) {
            System.out.print(item + " ");
        }
    }
}
