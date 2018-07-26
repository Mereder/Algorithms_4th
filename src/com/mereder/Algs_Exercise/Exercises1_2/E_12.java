package com.mereder.Algs_Exercise.Exercises1_2;

/**
 * 添加一个dayOfweek的方法，为日期中每周日返回Monday、Tuesday、Wednesday
 * Thursday、Friday、Saturday、Sunday 假定时间是21世纪
 */
public class E_12 {
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

        /** Zeller Formula
         * @return
         */
        public String dayOfWeek(){

                int d = this.getDay();
                int m = this.getMonth();
                int y = this.getYear();

                if (m < 3)
                {
                    m += 12;
                    y--;
                }
                int w = (d + 2 * m + 3 * (m + 1) / 5 + y + y / 4 - y / 100 + y / 400) % 7;

            String[] dayOfWeek = {"Monday",
                    "Tuesday",
                    "Wednesday"
                    ,"Thursday",
                    "Friday",
                    "Saturday",
                    "Sunday"};
            return dayOfWeek[w];

        }
        public String toString() {
            return month + "/" + day + "/" + year;
        }
    }

    public static void main(String[] args) {
        SmartDate smartDate = new SmartDate(7,26,2018);
        String s = smartDate.dayOfWeek();
        System.out.println(s);
    }
}
