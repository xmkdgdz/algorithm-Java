/* 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。 */

// 方法一：使用两个标记变量
/* 用 第一行/第一列 记录该 列/行 是否存在0，存在0则置为0，用两个标记量记录 第一行/第一列 本身是否存在0 */
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        // 第一行/第一列 本身是否存在0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }
        // 该 列/行 是否存在0，标记位置为0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 标记位是0的置为0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 处理第一行/第一列
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}

// 方法二：优化，使用一个标记变量
/* A[0][0] 标记第一行是否存在0，只需要一个变量记录第一列是否存在0 */
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean a = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            // 第一列是否存在0
            if (matrix[i][0] == 0) {
                a = true;
            }
            // 顺便给其他位置也记录了
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 倒着来最后也能操作第一行
        for (int i = m - 1; i >= 0; i--) {
            // 普通位置
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            // 最后操作该行的第一列
            if (a) {
                matrix[i][0] = 0;
            }
        }
    }
}