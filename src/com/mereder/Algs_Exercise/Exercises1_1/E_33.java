package com.mereder.Algs_Exercise.Exercises1_1;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 矩阵库：编写一个Matrix库并实现以下API
 * ===================================================
 * public class Matrix
 * ---------------------------------------------------
 * static double dot(double[]x double[] y) 向量点乘
 * static double[][] mult(double[][] a,double[][] b) 矩阵之积
 * static double[][] transpose(double[][] a) 矩阵转置
 * static double[] mult(double[][] a,double[] x) 矩阵向量积
 * static double[] mult(double[]y, double[][] a) 向量矩阵积
 */
public class E_33 {
    /**
     * @param x 向量x数组
     * @param y 向量y数组
     * @return dot 点乘结果
     */
    public static double dot(double[]x , double[]y){
        double dot = 0;
        if (x.length == y.length) {

            for (int i = 0; i < x.length; i++) {
                dot += x[i] * y[i];
            }
            return dot;
        }
        else return dot;
    }

    /**矩阵乘法
     * @param a
     * @param b
     * @return
     */
    public static double[][] mult(double[][] a,double[][] b){
        int arow = a.length;
        int acol = a[0].length;
        int brow = b.length;
        int bcol = b[0].length;

        if (acol != brow) return null;
        else {
            double[][] temp = new double[arow][bcol];
            for (int i = 0; i < arow; i++) {
                for (int j = 0; j < bcol; j++) {
                    for (int k = 0; k < acol; k++) {
                        temp[i][j] += a[i][k]*b[k][j];
                    }
                }
            }
            return  temp;
        }
    }

    /** 矩阵转置
     * @param a
     * @return
     */
    public static double[][] transpose(double[][] a){
        int row = a.length;
        int col = a[0].length;
        double[][] temp = new  double[row][col];

        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col; j++) {
                temp[i][j] = a[j][i];
            }
        }
        return temp;
    }

    /**矩阵 向量 乘法
     * 右向量 -》 列向量
     * @param a
     * @param x
     * @return
     */
    public static double[] mult(double[][] a,double[] x){
        int arow = a.length;
        int acol = a[0].length;
        int xlen = x.length;

        if (acol == xlen){
            double[] temp = new double[arow];
            for (int i = 0; i < arow; i++) {
                for (int j = 0; j < xlen; j++) {
                    temp[i] += a[i][j] * x[j];
                }
            }
            return temp;
        }
        else return null;
    }

    /**向量 矩阵乘法
     * 左向量-》行向量
     * @param y
     * @param a
     * @return
     */
    public static double[] mult(double[]y, double[][] a){
        int ylen = y.length;
        int arow = a.length;
        int acol = a[0].length;

        if (ylen == arow){
            double[] temp = new double[acol];
            for (int i = 0; i < acol ; i++) {
                for (int j = 0; j < arow; j++) {
                    temp[i] += y[j] * a[j][i];
                }
            }
            return temp;

        }
        else  return null;
    }


    public static void main(String[] args) {
        int row = 3;
        int col = 3;
        double[][] a = new double[row][col];
        double[][] b = new double[col][row+1];
        double []  x = new double[row];
        double []  y = new double[row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                a[i][j] = StdRandom.uniform(1.0,10.0);
            }
        }
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row+1; j++) {
                b[i][j] = StdRandom.uniform(1.0,10.0);
            }
        }

        for (int i = 0; i < x.length; i++) {
            x[i] = StdRandom.uniform(1.0,10.0);
            y[i] = StdRandom.uniform(1.0,10.0);
        }

        System.out.println("count dot");
        System.out.println(dot(x,y));

        System.out.println("multiply a[][] b[][]");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.printf("%.2f ",mult(a,b)[i][j]);
            }
            System.out.println();
        }

        System.out.println("transpose ");
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.printf("%.2f ",transpose(a)[i][j]);
            }
            System.out.println();
        }

        System.out.println("mult a[][] x[] ");
        for (int i = 0; i < a.length; i++) {
                System.out.printf("%.2f ",mult(a,x)[i]);
        }
        System.out.println();

        System.out.println("mult y[] a[][] ");
        for (int i = 0; i < a[0].length; i++) {
            System.out.printf("%.2f ",mult(y,a)[i]);
        }
        System.out.println();


    }
}
