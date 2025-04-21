/* 
    给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
    题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
    请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */

// 方法一：左右乘积列表
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        int[] suffix = new int[n];
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
           ans[i] = prefix[i] * suffix[i];
        }
        return ans;
    }
}

// 方法二：优化方法一，空间复杂度 O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // 输出数组不算在空间复杂度内,利用ans数组计算前缀积
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        // 使用一个int存储后缀积
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= suffix;
            suffix *= nums[i];
        }  
        return ans;
    }
}
