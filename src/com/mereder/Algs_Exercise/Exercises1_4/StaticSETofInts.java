package com.mereder.Algs_Exercise.Exercises1_4;


import java.util.Arrays;

/**
 *  The {@code StaticSETofInts} class represents a set of integers.
 *  It supports searching for a given integer is in the set. It accomplishes
 *  this by keeping the set of integers in a sorted array and using
 *  binary search to find the given integer.
 *  <p>
 *  The <em>rank</em> and <em>contains</em> operations take
 *  logarithmic time in the worst case.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/12oop">Section 1.2</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class StaticSETofInts {
    private int[] a;

    /**
     * Initializes a set of integers specified by the integer array.
     * @param keys the array of integers
     * @throws IllegalArgumentException if the array contains duplicate integers
     */
    public StaticSETofInts(int[] keys) {

        // defensive copy
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++)
            a[i] = keys[i];

        // sort the integers
        Arrays.sort(a);

        // check for duplicates
        for (int i = 1; i < a.length; i++)
            if (a[i] == a[i-1])
                throw new IllegalArgumentException("Argument arrays contains duplicate keys.");
    }

    public boolean contains(int key) {
        return rank(key,0,a.length-1) != -1;
    }

    public int rank(int key,int lo,int hi) {
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public  int howMany(int key){
        int lo = 0;
        int hi = a.length-1;

        return howMany(key,lo,hi);

    }
    public  int howMany(int key,int lo,int hi){
        int mid = rank(key,lo,hi);
        if (mid == -1) return  0;
        else
            return 1 + howMany(key,lo,mid-1) + howMany(key,mid+1,hi);

    }
}
