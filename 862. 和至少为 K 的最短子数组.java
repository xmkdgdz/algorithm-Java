/* 给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 -1 。

子数组 是数组中 连续 的一部分。 */

// 单调队列 + 前缀和
/* 首先计算一个前缀和数组
 * 遍历每个前缀和，减去前面最小的前缀和，得到以该点为结尾的子区间的最大和
 */
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int l = 0, r = 0;
        int res = Integer.MAX_VALUE;
        int n = nums.length;

        long[] preSum = new long[n+1];
        preSum[0] = 0L;
        for (int i = 1; i <= n; i++) {
            preSum[i] = nums[i-1] + preSum[i-1];
        }

        Deque<Long> minQ = new LinkedList<>();
        while (r < n) {
            while (!minQ.isEmpty() && minQ.peekLast() > preSum[r]) {
                minQ.pollLast();
            }
            minQ.offerLast(preSum[r++]);
            while (l < r && preSum[r] - minQ.peekFirst() >= k) {
                res = Math.min(res, r - l);
                if (minQ.peekFirst() == preSum[l++]) {
                    minQ.pollFirst();
                }
            } 
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}