package com.mereder.Algs_Exercise.Exercises1_3;

import edu.princeton.cs.algs4.StdIn;

public class MoveToFront {
    private Node head;
    private int n;

    private class Node{
        private char item;
        private Node next;
    }

    public MoveToFront() {
        this.head = null;
        this.n = 0;
    }

    public void add(char ch){
        Node oldfirst = head;
        head = new Node();
        head.item = ch;
        head.next = oldfirst;
        n++;
    }
    /**检测是否重复，且将重复的删掉
     * @param ch
     * @return
     */
    public boolean isRepeat(char ch){
        if (head == null ) return false;
        else if (head.item == ch) {
            head = null;
            return true;
        }
        Node current = head;
        while(current.next != null){
            if (current.next.item == ch){
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void operate(char[] chars){
        int N = chars.length;
        for (int i = 0; i < N; i++) {
            char ch = chars[i];
            if (isRepeat(ch)) {
                add(ch);
            }
            else {
                add(ch);
            }
        }
    }
    public String toString()
    {
        String ret = "";
        if (head == null)
            return ret;
        Node current = head;
        ret += head.item;
        while (current.next != null)
        {
            ret = ret + " " + current.next.item;
            current = current.next;
        }
        return ret;
    }

    public static void main(String[] args) {
        MoveToFront test = new MoveToFront();
        char[] data = {'1','2','4','2','3','1','5','1'};
        test.operate(data);
        //result 1 5 3 2 5
        System.out.println(test);
    }
}
