package com.mereder.Algs_Exercise.Exercises1_4;

/**
 * 矩阵的局部最小元素
 * 给定一个N*N 个不同整数的数组，找到一个局部最小的元素: 满足a[i][j] < a[i+1][j]
 * a[i][j] < a[i-1][j]  a[i][j] < a[i][j+1] a[i][j] < a[i][j-1]
 */
public class E_19 {
    public static void main(String[] args) {
        int [][] matrix = new  int[][]
        {
                { 26, 3, 4 , 10, 11},
                { 5, 1, 6, 12, 13 },
                { 7, 8, 9 , 14, 15 },
                { 16, 17, 18, 27, 20},
                { 21, 22, 23, 24, 25 },
        };
        System.out.println(MinimumRow(matrix, 0, 5, 0, 5));
    }

    /**
     * @param matrix
     * @param rowStart
     * @param rowLength
     * @param colStart
     * @param colLength
     * @return
     */
    public static int MinimumRow(int[][] matrix, int rowStart, int rowLength, int colStart, int colLength)
    {
        int min = Integer.MAX_VALUE;
        if (rowLength < 3)
            return Integer.MAX_VALUE;
        int mid = rowStart + rowLength / 2;
        int minCol = 0;
        // 获取矩阵中间行的最小值
        for (int i = 0; i < colLength; ++i)
        {
            if (min > matrix[mid][colStart + i])
            {
                min = matrix[mid][colStart + i];
                minCol = i;
            }
        }
        // 检查是否满足条件
        if (matrix[mid][ minCol] < matrix[mid - 1][minCol] && matrix[mid][minCol] < matrix[mid + 1][ minCol])
        {
            return matrix[mid][ minCol];
        }
        // 如果不满足则向较小一侧移动
        if (matrix[mid - 1][minCol] > matrix[mid + 1][ minCol])
        {
            return MinimumCol(matrix, rowStart, rowLength, mid + 1, colLength / 2 + 1);
        }
            else
        {
            return MinimumCol(matrix, rowStart, rowLength, colStart, colLength / 2 + 1);
        }
    }


    /**
     * @param matrix
     * @param rowStart
     * @param rowLength
     * @param colStart
     * @param colLength
     * @return
     */
    public static int MinimumCol(int[][] matrix, int rowStart, int rowLength, int colStart, int colLength)
    {
        int min = Integer.MAX_VALUE;
        int n = matrix[0].length;
        int mid = n / 2;
        int minRow = 0;

        // 获取矩阵中间列最小值
        for (int i = 0; i < n; ++i)
        {
            if (min > matrix[i][mid])
            {
                min = matrix[i][ mid];
                minRow = i;
            }
        }
        // 检查是否满足条件
        if (matrix[minRow][mid] < matrix[minRow][mid - 1] && matrix[minRow][ mid] < matrix[minRow][mid + 1])
        {
            return matrix[minRow][mid];
        }
        // 如果不满足则向较小一侧移动
        if (matrix[minRow][mid - 1] > matrix[minRow][mid + 1])
        {
            return MinimumRow(matrix, mid + 1, rowLength / 2 + 1, colStart, colLength);
        }
            else
        {
            return MinimumRow(matrix, rowStart, rowLength / 2 + 1, colStart, colLength);
        }
    }
}

