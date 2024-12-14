/* 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
子数组是数组中元素的连续非空序列。 */

// 方法一：枚举
// 时间复杂度：O(N^2) 空间复杂度：O(1)
/* 固定左边界，遍历右边界 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) res++;
            }
        }
        return res;
    }
}

// 方法二：前缀和 + 哈希表优化
// 时间复杂度：O(N) 空间复杂度：O(N)
/* sum 记录前缀和（nums[0]~nums[i]的和）
 * map 记录每个前缀和的出现次数
 * 子数组(i, j] 的和即为 pre[j] - pre[i]
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // 使能检测到 (0, i] 的和
        map.put(0, 1);
        // 类似 1.两数之和 的思路
        // 同时找元素和加入数据（正常做法的逆向）
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}