package com.mereder.Algs_Exercise.Exercises1_3;

import java.util.NoSuchElementException;

/**
 * 参考Deque
 *
 * 其中通过一个双向队列实现
 */
public class BidirectionalQueue<Item> {
    private Node<Item> Left;
    private Node<Item> Right;
    private int leftNum ;
    private int rightNum;

    private static class Node<Item>{
        private Node<Item> previous;
        private Item item;
        private Node<Item> subsequent;

        public Node() {
            previous = null;
            subsequent = null;
        }
    }

    public BidirectionalQueue() {
        Left = null;
        Right = null;
        leftNum = 0;
        rightNum = 0;
    }

    public int Leftsize() {
        return leftNum;
    }
    public int Rightsize() {
        return rightNum;
    }
    /**双向队列是否为空
     * @return
     */
    public boolean LeftisEmpty(){ return  leftNum == 0;}
    public boolean RightisEmpty(){ return  rightNum == 0;}

    public void LeftEnqueue(Item item){
        Node<Item> oldlist = Left;
        Left = new Node<>();
        Left.item = item;
        if (Right == null && LeftisEmpty()){
            Left.subsequent = oldlist;
            Left.previous = oldlist;
            Right = Left;
        }
        else {
            Left.subsequent = oldlist;
            oldlist.previous = Left;
        }
        leftNum++;
    }

    public void RifhtEnqueue(Item item){
        Node<Item> oldlist = Right;
        Right = new Node<>();
        Right.item = item;
        if (Left == null && RightisEmpty()){
            Right.subsequent = oldlist;
            Right.previous = oldlist;
            Left = Right  ;
        }
        else {
            Right.previous = oldlist;
            oldlist.subsequent = Right;
        }
        rightNum++;
    }


    /**向左端添加一个新元素
     * @param item
     */
    public void pushLeft(Item item){
        Node<Item> oldlist = Left;
        Left = new Node<>();
        Left.item = item;
        if (LeftisEmpty()){
            Left.subsequent = oldlist;
            Left.previous = oldlist;
            Right = Left;
        }
        else {
            Left.subsequent = oldlist;
            oldlist.previous = Left;
        }
        leftNum++;
    }

    /** 向右端添加一个新元素
     * @param item
     */
    public void pushRight(Item item){
        Node<Item> oldlist = Right;
        Right = new Node<>();
        Right.item = item;
        if (RightisEmpty()){
            Right.subsequent = oldlist;
            Right.previous = oldlist;
            Left = Right  ;
        }
        else {
            Right.previous = oldlist;
            oldlist.subsequent = Right;
        }
        rightNum++;
    }

    /** 从左端删除一个元素
     * @return
     */
    public Item popLeft(){
        if (LeftisEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item  = Left.item;
        Left = Left.subsequent;
        Left.previous = null;
        leftNum--;
        return item;
    }

    /** 从右端删除一个元素
     * @return
     */
    public Item popRight(){
        if (RightisEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item  = Right.item;
        Right = Right.previous;
        Right.subsequent = null;
        rightNum--;
        return item;
    }
}
