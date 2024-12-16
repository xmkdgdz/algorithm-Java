/* 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
给你一个整数数组 nums ，找出 nums 的下一个排列。

必须 原地 修改，只允许使用额外常数空间。 */

// 示例：[4,5,2,6,3,1]
/* 方法：写一个稍微复杂的示例，一步步思考，将思考转化为代码，最后优化 */

class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        // 从后往前找到第一个开始变小的，[i, nums.length) 是一个递减序列
        // nums[i-1] < nums[i]
        while (i > 0 && nums[i] <= nums[i-1]) i--;
        // 说明整个数组都是递减的，已经是最大的排列，下一个排列是最小的，即它的反转
        if (i == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        // j 指向从后往前第一个小的
        // j 需要和后面比它大 一点 的交换
        int j = i - 1;
        // 得到 i-1 是比j大 一点的
        while (i < nums.length && nums[j] < nums[i]) i++;
        swap(nums, i-1, j);
        // 此时 [j+1, nums.length) 是一个递减序列
        // 需要反转 [j+1, nums.length)
        reverse(nums, j + 1, nums.length - 1);
        return;
    }
    // 反转[i, j]
    void reverse(int[] nums, int i, int j) {
        while (i <= j) {
            swap(nums, i++, j--);
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}