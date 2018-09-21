package com.mereder.Algs_Exercise.Exercises1_4;

/**
 * a. Accumulator
 * double + int + Object开销 + 填充= 32
 * b. Transaction
 * Date + double + String + Object开销 + 填充
 * (Object开销 + 填充 + int * 3)+ 8 + (40 + char数组开销 ) + 16 + 4
 * = 32 + 8 + 40 + (16 Object + 4 int + 2 *N + 4 填充) + 20
 * = 80 + 24 + 2*N + 20 = 124 + 2 * N
 * c. FixedCapacityStackOfStrings
 * String[C] + N*String + int + Object + 填充
 * (16+4+4+8*C个引用) + N * 40 + 4 + 16 +4
 * =48 + 8C + 40*N
 * d. Point2D
 * doublex + doubley + Object + 填充 = 36
 * e.Interval1D
 * double * 2 + Object * 1 + 填充= 36
 * f.Interval2D
 * = Interval1D * 2 + Object * 1 + 填充 + 2 引用
 * = 36 * 2 + 16 * 1 + 4 + 8*2
 * = 108
 * g. Double 进Double声明查看
 * Object + 填充 + double*7 + int*4 + long + Class<Double>   TYPE
 * 16+4+56+16+8+Class<Double>   TYPE
 * 100+Class<Double>   TYPE
 */
public class E_13 {
    public static void main(String[] args) {

    }
}
