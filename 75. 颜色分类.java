/* 
    给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
    我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
    必须在不使用库内置的 sort 函数的情况下解决这个问题。
 */

// 思路：0都移到左边，2都移到右边，中间用1填满
class Solution {
    public void sortColors(int[] nums) {
        // 注意区间的开闭，初始化时区间内应该没有元素
        // 所以我们定义 [0，p0) 是元素 0 的区间，(p2, nums.length - 1] 是 2 的区间
        int p0 = 0, p2 = nums.length - 1;
        int p = 0;
        // 考虑p什么时候前进
        // 由于 p2 是开区间，所以 p <= p2
        while (p <= p2) {
            if (nums[p] == 0) {
                swap(nums, p0, p);
                p0++;
            } else if (nums[p] == 2) {
                swap(nums, p2, p);
                p2--;
            } else if (nums[p] == 1) {
                p++;
            }

            // 因为小于 p0 都是 0，所以 p 不要小于 p0
            if (p < p0) {
                p = p0;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}