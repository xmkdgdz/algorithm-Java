/* 
    给定一个 n × n 的二维矩阵 matrix 
    请你将矩阵顺时针旋转 90 度。
    你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。
    请不要使用另一个矩阵来旋转图像。
 */


class Solution {
    public void rotate(int[][] matrix) {
        // 先沿对角线交换
        for(int i=0; i<matrix.length; i++)
            for(int j=0; j<=i; j++){
                if(i == j)
                    continue;
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        // 再左右翻转
        for(int i=0; i<matrix.length; i++)
            for(int j=0; j<matrix.length/2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1] = tmp;
            }
    }
}