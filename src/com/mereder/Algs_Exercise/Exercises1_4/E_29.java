package com.mereder.Algs_Exercise.Exercises1_4;

import edu.princeton.cs.algs4.Stack;



/**
 *
 */
public class E_29 {
    public class Steque<Item>{
        private Stack<Item> stack1;
        private Stack<Item> stack2;
        private int  n;


        public Steque() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
            n = 0;
        }
        public boolean isEmpty(){
            return n == 0;
        }

        public int getSize() {
            return n;
        }

        public void Push(Item item){
            n++;
        }


        public Item Pop (){

        }

        public void Enqueque(Item item){

            n++;
        }
    }

    public static void main(String[] args) {

    }
}
