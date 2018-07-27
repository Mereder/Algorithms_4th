package com.mereder.Algs_Exercise.Exercises1_2;

/**
 * 有理数：
 * 为有理数实现一个不可变数据类型Rational 支持加减乘除操作
 * ====================================================================
 * public class Rational
 * --------------------------------------------------------------------
 *                  Rational(int numerator,int denominator)
 * Rational plus(Rational b)                 该数与b之和
 * Rational minus(Rational b)                该数与b之差
 * Rational times(Ratioanl b)                该数与b之积
 * Rational divides(Rational b)              该数与b之商
 * Boolean  equals(Rational that)            该数与that相等吗
 * String   toString()                       对象的字符串表示
 * 只需要使用两个long型实例变量表示分子分母来控制溢出的可能性，
 * 使用欧几里得算法来保证分子分母没有公因子。编写一个测试用例尖刺实现的所有方法
 *
 * */
public class E_16 {
    public static class Rational{
        private int Numerator;
        private int Denominator;
        private long MAX = 2147483641;
        private long MIN = -2147483641;

        public Rational(int numerator, int denominator) {
            if (denominator == 0)
                throw new ArithmeticException("denominator is zero");

            int gcd = gcd(numerator,denominator);
            Numerator = numerator / gcd;
            Denominator = denominator / gcd;

            if (denominator < 0){
                Denominator = -Denominator;
                Numerator = -Numerator;
            }
        }
        public int getNumerator() {
            return Numerator;
        }
        public int getDenominator() {
            return Denominator;
        }

        public Rational plus(Rational b){
            //if (isPlusOverflow(Numerator * b.Denominator,Denominator * b.Numerator)) System.out.println("plus  overflow");
            assert isPlusOverflow( Numerator * b.Denominator,Denominator * b.Numerator):"plus  overflow";
            assert isTimesOverflow(Denominator , b.Denominator):"times overflow";

            int Den = Denominator * b.Denominator;
            int Num = Numerator * b.Denominator + Denominator * b.Numerator;
            Rational temp = new Rational(Num,Den);
            return temp;
        }

        public Rational minus(Rational b){
            int Den = this.Denominator * b.Denominator;
            int Num = this.Numerator * b.Denominator - this.Denominator * b.Numerator;

            Rational temp = new Rational(Num,Den);

            return  temp;
        }
        public Rational times(Rational b){
           // if (isTimesOverflow(Denominator ,b.Denominator)) System.out.println("times overflow");
            assert isTimesOverflow(Denominator ,b.Denominator):"times overflow";
            assert isTimesOverflow(Numerator,b.Numerator):"times overflow";
            int Den = Denominator * b.Denominator;
            int Num = Numerator * b.Numerator;
            Rational temp = new Rational(Num,Den);
            return temp;
        }
        public Rational divides(Rational b){
            Rational daoshu = new Rational(b.Denominator,b.Numerator);
            Rational temp = this.times(daoshu);
            return temp;
        }
        public Boolean  equals(Rational that){
            if (that == null) return false;
            if (that.getClass() != this.getClass()) return false;
            Rational temp = (Rational) that;
            return this.compareTo(that) == 0;
        }

        private int compareTo(Rational that) {
            long lhs = this.Numerator * that.Denominator;
            long rhs = this.Denominator * that.Numerator;
            if (lhs < rhs) return -1;
            if (lhs > rhs) return +1;
            return 0;
        }

        private int  gcd(int a, int b){
            if (b < 0 ) b = -b;
            if (a < 0 ) a = -a;
            if (a % b == 0) return b;
            else return gcd(b,a % b);
        }

        /**
         * @param a
         * @param b
         * @return true 程序继续 false 则抛出异常
         */
        private boolean isPlusOverflow(int a,int b){
            if (a > 0 && b > 0)
                return !(a + b < 0);
            else if(a < 0 && b < 0){
                return ! (a + b > 0);
            }
            return true;
        }

        /**
         * @param a
         * @param b
         * @return true 程序顺利进行不启动assert   false 启动断言
         */
        private boolean isTimesOverflow(int a,int b){
            if (a < 0) {
                a = -a;
            }
            if (b < 0) {
                b = -b;
            }
            if (a == 0 || b == 0) {
                return true;
            } else {
                return !(a * b < 0);
            }
        }
        @Override
        public String toString() {
                if (Denominator == 1) return Numerator + "";
                else          return Numerator + "/" + Denominator;

        }
    }
    public static void main(String[] args) {
            int a = -2147483647;
            int b = 1;
            Rational rational = new Rational(-2147483645,b);
            Rational rational1 = new Rational(2,b);
            Rational rational2 = new Rational(3,5);
            Rational temp = rational.plus(rational1);
            System.out.println(temp);
            temp = rational.minus(rational1);
            System.out.println(temp);
            temp = rational.times(rational1);
            System.out.println(temp);
            temp = rational.divides(rational2);
            System.out.println(temp);
    }
}
