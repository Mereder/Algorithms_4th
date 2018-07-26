package com.mereder.Algs_Exercise.Exercises1_1;

/**
 * 以下语句有什么问题
 */
public class E_4 {
    public static void main(String[] args) {
        int  a = 2,b=3,c=0;
        /**
        * Cannot resolve symbol 'then'
        * */
        //if (a > b) then c = 0;
        // if a > b {c = 0}  //if()
         if(a > b) c = 0; //bingo

       // if (a > b) c = 0  //Lack of semicolons behind c = 0
         //       else b= 0;
    }
}
