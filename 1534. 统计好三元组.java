/* 
    534. 统计好三元组

    给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。

    如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。

    0 <= i < j < k < arr.length
    |arr[i] - arr[j]| <= a
    |arr[j] - arr[k]| <= b
    |arr[i] - arr[k]| <= c
    其中 |x| 表示 x 的绝对值。

    返回 好三元组的数量 。

  */

// 题解：https://leetcode.cn/problems/count-good-triplets/solutions/1/liang-chong-fang-fa-bao-li-mei-ju-qian-z-apcv
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        // 按大小排序 arr，值是索引
        Integer[] idx = new Integer[arr.length];
        Arrays.setAll(idx, i -> i);
        Arrays.sort(idx, (i, j) -> arr[i] - arr[j]);

        int res = 0;
        // 给定一个 j
        for (int j: idx) {
            int y = arr[j];
            // 计算符合条件的Ai（按大小顺序）
            List<Integer> left = new ArrayList<>();
            for (int i : idx) {
                if (i < j && Math.abs(arr[i] - y) <= a) {
                    left.add(arr[i]);
                }
            }
            // 计算符合条件的Ak（按大小顺序）
            List<Integer> right = new ArrayList<>();
            for (int k : idx) {
                if (k > j && Math.abs(arr[k] - y) <= b) {
                    right.add(arr[k]);
                }
            }
            /* 
                现在我们有了符合以下条件的 i, j, k：
                |arr[i] - arr[j]| <= a
                |arr[j] - arr[k]| <= b
                只需要找到符合 |Ai - Ak| <= c 的组合数量即可
                给定一个 Ai:
                Ai - c <= Aj <= Ai + c
                即找到范围内Aj数量
                利用指针
             */
            int k1 = 0;
            int k2 = 0;
            for (int x: left) {
                // x++定然更大，范围只会右移，所以继续向右找即可
                while (k2 < right.size() && right.get(k2) <= x + c) k2++;
                while (k1 < k2 && right.get(k1) < x - c) k1++;
                res += k2 - k1;
            }
        }
        return res;
    }
}