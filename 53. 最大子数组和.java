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

// 方法二：分治
// 时间复杂度: O(n) 空间复杂度: O(logn)
// 对比方法一，可以求出任意子区间的最大和，全部存储后是一棵线段树
class Solution {
    // SubArray：子区间 [l, r]
    class SubArray {
        int lSum, rSum, mSum, iSum;
        SubArray (int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum; // 以 l 为左端点的最大子段和
            this.rSum = rSum; // 以 r 为右端点的最大子段和
            this.mSum = mSum; // 最大子段和
            this.iSum = iSum; // 整个子区间和
        }
    }

    public int maxSubArray(int[] nums) {
        return getSubArray(nums, 0, nums.length - 1).mSum;
    }

    // 获得子区间 [l, r] 的相关信息
    SubArray getSubArray(int[] arr, int l, int r) {
        // 处理最小子问题
        if (l == r) {
            return new SubArray(arr[l], arr[l], arr[l], arr[l]);
        }
        // 分为 [l, m], [m+1, r]
        int m = l + (r - l) / 2;
        // merge: 合并
        return merge(getSubArray(arr, l, m), getSubArray(arr, m + 1, r));
    }

    // 合并为大区间，并计算各种信息
    SubArray merge(SubArray l, SubArray r) {
        int iSum = l.iSum + r.iSum;
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        return new SubArray(lSum, rSum, mSum, iSum);
    }
}