/* 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
请你找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值 target，返回 [-1, -1]。
你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        // 找左边界
        int i = binarySearch(nums, target);
        // 找不到左边界即意味着没有target
        if(i == nums.length || nums[i] != target){
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        res[0] = i;
        // 找右边界
        int j = binarySearch(nums, target+1) - 1;
        res[1] = j;

        return res;
    }
    // 二分查找左边界。最终 i指向最左target或比target大一点，j=i-1。
    int binarySearch(int[] nums, int target){
        int i=0, j=nums.length-1;
        while(i <= j){
            int m = i + (j-i)/2;
            if(nums[m] < target)
                i = m + 1;
            else
                j = m - 1;
        }
        return i;
    }
}