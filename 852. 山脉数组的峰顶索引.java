/* 给定一个长度为 n 的整数 山脉 数组 arr ，其中的值递增到一个 峰值元素 然后递减。
返回峰值元素的下标。
你必须设计并实现时间复杂度为 O(log(n)) 的解决方案。 */

// 二分查找
// 找到最小的 i, arri > arr(i+1)
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] < arr[m + 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}