/* 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
如果不存在满足条件的子数组，则返回 0 。 */

// 单调队列
/* 返回最长连续子数组的长度，可知是滑动窗口题
 * 任意两个元素之间的绝对差必须小于或者等于 limit，即窗口中 max - min
 * 需要维护窗口 min, max，考虑单调队列，需要 minQ 和 maxQ
 */
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int l = 0, r = 0;
        Deque<Integer> minQ = new LinkedList<>();
        Deque<Integer> maxQ = new LinkedList<>();
        int res = 0;
        while (r < nums.length) {
            while (!minQ.isEmpty() && minQ.peekLast() > nums[r]) {
                minQ.pollLast();
            }
            minQ.offerLast(nums[r]);
            while (!maxQ.isEmpty() && maxQ.peekLast() < nums[r]) {
                maxQ.pollLast();
            }
            maxQ.offerLast(nums[r]);
            r++;
            while (l < r && maxQ.peekFirst() - minQ.peekFirst() > limit) {
                if (nums[l] == maxQ.peekFirst()) {
                    maxQ.pollFirst();
                }
                if (nums[l] == minQ.peekFirst()) {
                    minQ.pollFirst();
                }
                l++;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}