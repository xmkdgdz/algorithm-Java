/* 给你一个整数数组 nums 和一个整数 x 。
每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。 */

/* 
    思路：
    从边缘删除和为x的数，剩下的即为和为 sum - x 的子数组。
    要操作数最小，即 子数组长度 最大。
    求子数组长度最值，考虑滑动窗口。
 */
class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        sum -= x;
        // 特殊情况处理
        if (sum < 0) {
            return -1;
        }
        if (sum == 0) {
            return nums.length;
        }
        // 滑动窗口
        int l = 0, r = 0;
        int wsum = 0, len = 0;
        while (r < nums.length) {
            wsum += nums[r];
            r++;
            while (wsum > sum) {
                wsum -= nums[l];
                l++;
            }
            if (wsum == sum) {
                len = Math.max(len, r - l);
            }
        }

        return len == 0 ? -1 : nums.length - len;
    }
}