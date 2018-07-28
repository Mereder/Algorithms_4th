package com.mereder.Algs_Exercise.Exercises1_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Transaction;

/**
 * 使用1.3.1.5节中的readInts()作为模板为Transaction 编写一个静态方法ReadTransactions(),
 * 从标准输入中读取由练习1.2.19的表格所指定的格式的多个日期并返回一个它们的数组
 * 均需要从命令行 中断输入  ctrl + d
 */
//truning 2/22/2222 22.22
public class E_17 {
    public static Transaction[] readTransaction(){
        Queue<Transaction> queue = new Queue<>();
        while(!StdIn.isEmpty()) queue.enqueue(new Transaction(StdIn.readLine() ));

        int N = queue.size();
        Transaction[] transactions = new Transaction[N];
        for (int i = 0; i < N; i++) {
            transactions[i] = queue.dequeue();
        }
        return transactions;
    }
    public static void main(String[] args) {
        Transaction[] transactions = readTransaction();
        for (int i = 0; i < transactions.length; i++) {
            System.out.println(transactions[i]);
        }
    }
}
