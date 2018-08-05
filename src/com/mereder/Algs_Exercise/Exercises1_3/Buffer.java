package com.mereder.Algs_Exercise.Exercises1_3;

import edu.princeton.cs.algs4.Stack;

import java.util.NoSuchElementException;

/**
 * 文本编辑器缓冲区
 *
 */
public class Buffer {
    private Stack<Character> left;
    private Stack<Character> right;
    private int leftnum;
    private int rightnum;
    /**
     * 创建一块空缓冲区
     */
    public Buffer() {
        left = new Stack<>();
        right = new Stack<>();
        leftnum = 0;
        rightnum  = 0;
    }

    public void insert(char c){
        left.push(c);
        leftnum++;
    }

    public char delete(){
        if (left.isEmpty()) throw new NoSuchElementException("No content to delete");
        char ch = left.pop();
        leftnum--;
        return ch;
    }
    public void left(int k){
        if (k <= 0) throw new NoSuchElementException("error k");
        if (leftnum < k)
        {
            System.out.println("no enough char to move,Already moving to the head");
            for (int i = 0; i < leftnum; i++) {
                right.push(left.pop());
            }
            rightnum += leftnum;
            return;
        }
        for (int i = 0; i < k; i++) {
            right.push(left.pop());
            leftnum--;
            rightnum++;
        }
    }

    public void right(int k){
        if (k <= 0) throw new NoSuchElementException("error k");
        if (rightnum < k)
        {
            System.out.println("no enough char to move,Already moving to the tail");
            for (int i = 0; i < rightnum; i++) {
                left.push(right.pop());
            }
            leftnum += rightnum;
            return;
        }
        for (int i = 0; i < k; i++) {
            left.push(right.pop());
            rightnum--;
            leftnum++;
        }
    }

    public int size(){
        return leftnum+rightnum;
    }
    public void  display(){

        Stack<Character> temp = new Stack<>();
        while(!left.isEmpty()){
            temp.push(left.pop());
        }
        for (Character ch : temp) {
            left.push(ch);
            System.out.print(ch);
        }
        System.out.print('|');
        temp = new Stack<>();
        for (Character ch : right) {
            temp.push(ch);
            System.out.print(ch);
        }
        for (Character ch : temp) {
            right.push(ch);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Buffer test = new Buffer();

        for (int i = 0; i < 10; i++) {
            test.insert(String.valueOf(i).charAt(0));
        }
        test.display();
        test.right(2);
        test.display();
        test.left(2);
        test.display();
    }
}
