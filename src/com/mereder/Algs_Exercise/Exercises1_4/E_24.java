package com.mereder.Algs_Exercise.Exercises1_4;

/**
 * 扔鸡蛋
 * 设定27层会摔碎鸡蛋  总楼层 为100层
 * 通过扔鸡蛋来找到 确定F的值
 *
 */
public class E_24 {
    public static int F = 27 ;
    public static int eggs = 0; // 记录摔碎鸡蛋数量
    public static int F_predict = 0; // 记录确认的F层

    public static void main(String[] args) {
        int N = 100; //楼高设置为100层
        System.out.println("次数:"+DropEgg(N));
        System.out.println("摔碎鸡蛋数:"+eggs);
        System.out.println( "是否确定F值:" + (F == F_predict) );
        System.out.println("------------------------------------------------------------");
        System.out.println("次数:"+DropEggs_2(N));
        System.out.println("摔碎鸡蛋数:"+eggs);
        System.out.println( "是否确定F值:" + (F == F_predict) );
    }

    /**扔lgN次鸡蛋后 摔碎的鸡蛋数量为  lgN 的方案
     * @return
     */
    public static int DropEgg(int N){
        int lo = 0;
        int hi = N;
        int throwTimes = 0;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (isBroken(mid)){
                eggs++;
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
            throwTimes++;
        }
        F_predict = lo;
        return throwTimes;
    }

    public static int DropEggs_2(int N ){
        int lo = 0;
        int hi = 1;
        int throwTimes = 0;
        eggs = 0;
        F_predict = 0;
        while (!isBroken(hi)){
            lo = hi;
            hi *= 2;
            throwTimes++;
        }
        eggs++;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (isBroken(mid)){
                eggs++;
                hi = mid -1;
            }
            else {
                lo = mid + 1;
            }
            throwTimes++;
        }
        F_predict = lo;
        return throwTimes;
    }

    public static boolean isBroken(int floor){
        return floor >= F;
    }
}
