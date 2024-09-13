/* 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。
该矩阵具有以下特性：
每行的元素从左到右升序排列。
每列的元素从上到下升序排列。 */

// 方法二：二分查找
// 时间复杂度：O(mlogn)。对每一行二分查找
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index = search(row, target);
            if (index >= 0) {
                return true;
            }
        }
        return false;
    }
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

// 方法三：Z 字形查找
// 时间复杂度：O(m+n)。
/* 从右上角开始（左下角也行）
 * 对于某个坐标(x, y)，行一定小于x，列一定大于y
 * 将矩阵逐渐缩小
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix[0].length - 1, j = 0;
        while(i>=0 && j<matrix.length){
            if(matrix[j][i] > target) // 一定不在i列
                i--;
            else if(matrix[j][i] < target) // 一定不在j行
                j++;
            else
                return true;
        }
        return false;
    }
}