package com.mereder.Algs_Exercise.Exercises1_2;


/**
 * 字符串解析为Date 和 Transaction 类型编写能够解析字符串数据的构造函数。它接受一个String参数指定的初始值：
 * =================================================================================
 * 类型                      格式                                   举例
 * ---------------------------------------------------------------------------------
 * Date              由斜杠分割的整数                         5/22/1939
 * Transaction       客户、日期和金额，由空白字符分隔         Turing 5/22/1939 11.99
 */
public class E_19 {
    /**
     * 由于前面写了该类型的其他方法 这里仅放一个构造函数 和 toString检验
     */
    public static class Transaction {
        private String Customer;
        private Date Date;
        private double Money;

        public Transaction(String information) {
            String[] words = information.split(" ");
            Customer = words[0];
            Date = new Date(words[1]);
            Money = Double.parseDouble(words[2]);
        }

        @Override
        public String toString() {
            return "用户："+Customer+" 日期："+Date+" 金额："+Money;
        }
    }

    /**
     * 更全的参考 edu.princeton.cs.algs4/Date.java
     */
    public static class Date{
        private static final int[] DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        private final int month;   // month (between 1 and 12)
        private final int day;     // day   (between 1 and DAYS[month]
        private final int year;    // year

        public Date(String date) {
            String[] fields = date.split("/");
            if (fields.length != 3) {
                throw new IllegalArgumentException("Invalid date");
            }
            month = Integer.parseInt(fields[0]);
            day   = Integer.parseInt(fields[1]);
            year  = Integer.parseInt(fields[2]);
            if (!isValid(month, day, year)) throw new IllegalArgumentException("Invalid date");
        }
        private static boolean isValid(int m, int d, int y) {
            if (m < 1 || m > 12)      return false;
            if (d < 1 || d > DAYS[m]) return false;
            if (m == 2 && d == 29 && !isLeapYear(y)) return false;
            return true;
        }
        private static boolean isLeapYear(int y) {
            if (y % 400 == 0) return true;
            if (y % 100 == 0) return false;
            return y % 4 == 0;
        }

        @Override
        public String toString() {
            return "年："+year+" 月："+month+" 日："+day;
        }
    }

    public static void main(String[] args) {
        Date date = new Date("5/22/1939");
        Transaction transaction = new Transaction("Turing 5/22/1939 11.99");
        System.out.println(date);
        System.out.println(transaction);
        /**Result
         * 年：1939 月：5 日：22
         * 用户：Turing 日期：年：1939 月：5 日：22 金额：11.99
        * */
    }
}
