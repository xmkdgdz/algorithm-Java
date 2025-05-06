/* 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 
返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 
 */

// 方法一：双指针
 class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; ++j) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return nums.length == 0 ? 0 : i + 1;
    }
}