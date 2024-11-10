/* 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 */

// 方法一：动态规划
// 时间复杂度：O(n) 空间复杂度：O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        // 用nums[i]表示以nums[i]为结尾的子数组的最大和
        for(int i=1; i<nums.length; i++){
            nums[i] = Math.max(nums[i-1] + nums[i],  nums[i]);
            // res保存最大值
            res = Math.max(nums[i], res);
        }
        return res;
    }
}
