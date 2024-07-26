/* 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 */

/* 用第0行和第0列作为标记数组，记录该列或行是否有0
 * 但第0行和第0列如果有0将无法辨认
 * 所以引入布尔变量记录
 * 因为第0列第0行可以当作记录了第0行是否有0
 * 所以引入记录第0列的布尔变量即可
 */
// 时间复杂度：O(mn)，空间复杂度：O(1)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 记录第0列是否有0
        boolean flagCol0 = false;
        
        for (int i = 0; i < m; i++) {
            // 记录第0列是否有0
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            // 记录剩下的0，并写入第0行和第0列
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        // 倒着遍历行，这样可以最后把第0行置0
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            // 最后动第0列
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
    }
}