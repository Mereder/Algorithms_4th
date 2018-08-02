package com.mereder.Algs_Exercise.Exercises1_3;


import java.util.NoSuchElementException;

public class ResizingArrayDeque<Item> {
    private Item[] Deque;
    private int leftN;
    private int rightN;
    private int Left;
    private int Right;

    public ResizingArrayDeque() {
       Deque = (Item[]) new Object[1];
       leftN = 0;
       rightN = 0;
       Left = 0;
       Right = Deque.length-1;
    }

    public int size() {  return leftN+rightN; }
    public int getLeft() { return Left; }
    public int getRight() { return Right; }

    public boolean isEmpty(){ return  leftN+rightN == 0;}

    public void ResizingArray(int max){
        if (max <= 0 ) throw  new NoSuchElementException("max error");
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < leftN; i++) {
            temp[i] = Deque[i];
        }
        for (int i = 0; i < rightN; i++) {
            temp[max-1-i] = Deque[Deque.length-1-i];
        }
        Left = leftN;
        Right = max-rightN-1;
        Deque = temp;
    }
    public void pushLeft(Item item){
        if (size() == Deque.length) ResizingArray(2 * Deque.length);
        Deque[Left++] = item;
        leftN++;
    }
    public void pushRight(Item item){
        if (size() == Deque.length) ResizingArray(2 * Deque.length);
        Deque[Right--] = item;
        rightN++;
    }

    public Item popLeft(){
        if (isEmpty()) throw new NoSuchElementException("No data");
        else {
            leftN--;
            Item temp = Deque[--Left];
            Deque[Left] = null;
            if (size() > 0 && size() == Deque.length/4){
                ResizingArray(Deque.length / 2);
            }
            return temp;
        }
    }

    public Item popRight(){
        if (isEmpty()) throw new NoSuchElementException("No data");
        else {
            rightN--;
            Item temp = Deque[++Right];
            Deque[Right] = null;
            if (size() > 0 && size() == Deque.length/4){
                ResizingArray(Deque.length / 2);
            }
            return temp;
            }
    }

    public void display(){
        for (int i = 0; i < leftN; i++) {
            System.out.print(Deque[i]+" ");
        }
        for (int i = Right+1; i < Deque.length ; i++) {
            System.out.print(Deque[i]+" ");
        }
        System.out.println();
    }



    public static void main(String[] args) {
        ResizingArrayDeque<Integer> resizingArrayDeque = new ResizingArrayDeque<>();
        //左压栈  1->2->Left top
        resizingArrayDeque.pushLeft(1);
        resizingArrayDeque.pushLeft(2);
        System.out.println("左压栈：");
        resizingArrayDeque.display();

        //右压栈  1->2->Left top…… Right top<-8<-9
        resizingArrayDeque.pushRight(9);
        resizingArrayDeque.pushRight(8);
        System.out.println("左压栈：");
        resizingArrayDeque.display();
        //左弹栈
        int left =  resizingArrayDeque.popLeft();
        System.out.println("左弹栈："+left);
        resizingArrayDeque.display();
        //右弹栈
        int right =  resizingArrayDeque.popRight();
        System.out.println("右弹栈："+right);
        resizingArrayDeque.display();

    }

}
