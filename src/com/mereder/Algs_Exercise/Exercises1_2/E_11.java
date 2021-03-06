package com.mereder.Algs_Exercise.Exercises1_2;

import edu.princeton.cs.algs4.Date;

/**
 * 根据Date的API 实现一个SmartDate类型
 * 在日期非法时抛出一个异常
 */
public class E_11 {
    public static class SmartDate  {
        private static final int[] DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        private final int month;   // month (between 1 and 12)
        private final int day;     // day   (between 1 and DAYS[month]
        private final int year;    // year

        public SmartDate(int month, int day, int year) {
            if (!isValid(month, day, year)) throw new IllegalArgumentException("Invalid date");
            this.month = month;
            this.day   = day;
            this.year  = year;
        }

        public SmartDate(String date) {
            String[] fields = date.split("/");
            if (fields.length != 3) {
                throw new IllegalArgumentException("Invalid date");
            }
            month = Integer.parseInt(fields[0]);
            day   = Integer.parseInt(fields[1]);
            year  = Integer.parseInt(fields[2]);
            if (!isValid(month, day, year)) throw new IllegalArgumentException("Invalid date");
        }

        public int getMonth() {
            return month;
        }

        public int getDay() {
            return day;
        }

        public int getYear() {
            return year;
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

        public String toString() {
            return month + "/" + day + "/" + year;
        }
    }
    public static void main(String[] args) {
        SmartDate smartDate = new SmartDate(1,30,2018);
        System.out.println(smartDate);
        SmartDate errorDate = new SmartDate(2,30,2018);
        System.out.println(errorDate);
        /* 标准输出结果：
            1/30/2018
           Exception in thread "main" java.lang.IllegalArgumentException: Invalid date
        * */
    }
}
