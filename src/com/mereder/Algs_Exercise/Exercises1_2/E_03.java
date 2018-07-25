package com.mereder.Algs_Exercise.Exercises1_2;

import edu.princeton.cs.algs4.*;

/**
 * 编写一个Interval2D的用例，从命令行接受参数N、min和max。生成N个随机的2D间隔，其宽和高均匀地分布在单位正方形中
 * 的min和max之间。用StdDraw画出他们并打印出相交的间隔对的数量以及有包含关系的间隔对数量。
 */
public class E_03 {
    public static void main(String[] args) {
        System.out.println("输入 N ：");
        int N = StdIn.readInt();
        System.out.println("输入min 和 max :");
        double min = StdIn.readDouble();
        double max = StdIn.readDouble();

        StdDraw.setXscale(0.0,1.0);
        StdDraw.setYscale(0.0,1.0);
        Interval2D[] boxes = new Interval2D[N];
        //保存一个box的左下和右上点  通过对角点判断是否在Box中 box.contains 只能判断点
        Point2D[] leftbottom = new Point2D[N];
        Point2D[] righttop = new Point2D[N];


        for (int i = 0; i < N; i++) {
            double xmin = StdRandom.uniform(min, max);
            double xmax = StdRandom.uniform(min, max);
            double ymin = StdRandom.uniform(min, max);
            double ymax = StdRandom.uniform(min, max);
            if(xmin > xmax){
                double temp = xmax;
                xmax = xmin;
                xmin = temp;
            }
            if(ymin > ymax){
                double temp = ymax;
                ymax = ymin;
                ymin = temp;
            }
            Interval1D xinterval = new Interval1D(xmin,xmax);
            Interval1D yinterval = new Interval1D(ymin,ymax);
            leftbottom[i] = new Point2D(xmin,ymin);
            righttop[i] = new Point2D(xmax,ymax);
            boxes[i] = new Interval2D(xinterval,yinterval);
            boxes[i].draw();
        }
        int countintersects = 0;
        int countcontains = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (boxes[i].intersects(boxes[j])) countintersects++;
                if (boxes[i].contains(leftbottom[j]) && boxes[i].contains(righttop[j])) countcontains++;
            }

        }

        System.out.println("相交的间隔对的数量:"+countintersects);
        System.out.println("有包含关系的间隔对数量:"+countcontains);





    }
}
