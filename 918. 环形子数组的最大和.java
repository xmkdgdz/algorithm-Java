/* 
给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
环形数组 意味着数组的末端将会与开头相连呈环状。
形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。
形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。

  */

// 单调队列 + 2*n模拟环形数组
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        Deque<Integer> minQ = new LinkedList<>();
        int n = nums.length;
        int[] preSum = new int[2*n+1];
        int res = Integer.MIN_VALUE, l = 0, r = 0;
        preSum[0] = 0;
        for (int i = 1; i <= 2*n; i++) {
            preSum[i] = preSum[i-1] + nums[(i-1) % n];
        }
        while (r < 2*n) {
            while (!minQ.isEmpty() && minQ.peekLast() > preSum[r]) {
                minQ.pollLast();
            }
            minQ.offerLast(preSum[r++]);
            if (r - l > n) {
                if (minQ.peekFirst() == preSum[l++]) {
                    minQ.pollFirst();
                }
            }
            res = Math.max(res, preSum[r] - minQ.peekFirst());
        }
        return res;
    }
}

