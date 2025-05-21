/* 矩阵对角线 是一条从矩阵最上面行或者最左侧列中的某个元素开始的对角线，沿右下方向一直到矩阵末尾的元素。例如，矩阵 mat 有 6 行 3 列，从 mat[2][0] 开始的 矩阵对角线 将会经过 mat[2][0]、mat[3][1] 和 mat[4][2] 。

给你一个 m * n 的整数矩阵 mat ，请你将同一条 矩阵对角线 上的元素按升序排序后，返回排好序的矩阵。 */

class Solution {

    int[][] mat;
    int m;
    int n;
    int[][] res;

    public int[][] diagonalSort(int[][] mat) {
        this.mat = mat;
        m = mat.length;
        n = mat[0].length;
        res = new int[m][n];
        // 易知每条对角线的起点
        for (int i = 0; i < m; i++) {
            sort(i, 0);
        }
        for (int i = 1; i < n; i++) {
            sort(0, i);
        }
        return res;
    }

    // 针对每条对角线排序
    void sort(int a, int b) {
        List<Integer> diag = new ArrayList<>();
        int i = a, j = b;
        // 对角线就是 mat[i+1][j+1]
        while (i < m && j < n) {
            diag.add(mat[i][j]);
            i++;
            j++;
        }
        // 排序
        Collections.sort(diag);
        // 排序后填入结果矩阵
        i = a;
        j = b;
        for (Integer num: diag) {
            res[i][j] = num;
            i++;
            j++; 
        }
    }

}