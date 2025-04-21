/* 
    给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
    请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */


// 方法一：哈希表
/* 
    对于一个长度为 N 的数组，其中没有出现的最小正整数只能在 [1,N+1] 中。
    如果 [1,N] 都出现了，那么答案是 N+1，否则答案是 [1,N] 中没有出现的最小正整数。
    把nums数组当作哈希表，[1,N] -> [0,N-1]
    若有数在[1,N]范围内，将对应的 nums[i-1] 置为负数。
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        // 为了保留信息，首先将原本小于等于0的数都“清空”，即等于n+1，一个不在考虑范围的正数
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            // 获得原本nums[i]的数值
            int tmp = Math.abs(nums[i]);
            // 记录信息
            if (tmp <= n) {
                nums[tmp - 1] = - Math.abs(nums[tmp - 1]);
            }
        }
        // nums[i] < 0代表 i+1 在nums 中出现过了
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}

// 方法二：置换
/* 
    给数组中的数按正整数顺序排列，应有 [1, 2, ..., N] 的形式，但其中有若干个位置上的数是错误的，每一个错误的位置就代表了一个缺失的正数。
    以例如 [3, 4, -1, 1]，恢复后的数组应当为 [1, -1, 3, 4]，缺失的数为 2。
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            // 如果数在[1, N]且它应该被换去的位置上不是正确的数，则交换位置
            // 用while: 因为交换之后，nums[i]可能也在[1, N]，所以继续交换
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        // 第一个不正确的数所在的idx+1就是缺失的正数
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}