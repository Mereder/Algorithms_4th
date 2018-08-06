package com.mereder.Algs_Exercise.Exercises1_3;

import edu.princeton.cs.algs4.Stack;

/**
 * 栈的可生成性
 */
public class E_45 {
    public static boolean isUnderFlow(String sequence){
        int pushtimes = 0;
        int poptimes = 0;
        for (int i = 0; i < sequence.length(); i++) {
            char ch = sequence.charAt(i);
            if (Character.isDigit(ch)) pushtimes++;
            else if (ch == '-') poptimes++;
            else continue;

            if (poptimes > pushtimes) return true;
            else continue;
        }
        return  false;
    }

    public static boolean judge(int[] GivenSequence){
        Stack<Integer> stack = new Stack<>();
        int push = 0;
        for (int i = 0; i < GivenSequence.length; i++) {
                if (stack.isEmpty()){
                    stack.push(push);
                    push++;
                }
                while(stack.peek()!= GivenSequence[i]){
                    stack.push(push);
                    push++;
                }
                stack.pop();
        }

        return stack.isEmpty();

    }

    public static void main(String[] args) {
        String sequence1 = "0 1 2 3 4 - - - - - 5 6 7 8 9 - - - - -";
        String sequence2 = "0 1 2 3 4 - 5 6 - - - - - - - 7 8 9 - -";
        if (isUnderFlow(sequence2)) System.out.println("flow");
        if (isUnderFlow(sequence1)) System.out.println("flow");
        else System.out.println("No");

        int[] GivenSequence = {4,3,2,1,0,9,8,7,6,5};
        if (judge(GivenSequence)) System.out.println("ok");
        else System.out.println("No");

        System.out.println();
    }

}
