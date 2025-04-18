/* 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。 */

// 方法一：使用额外的数组
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[(i + k) % n] = nums[i];
        }
        System.arraycopy(res, 0, nums, 0, n);
    }
}

// 方法二：环状替换
// 原地算法
// https://leetcode.cn/problems/rotate-array/solutions/551039/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
}

// 方法三：数组翻转
// 原地算法
// https://leetcode.cn/problems/rotate-array/solutions/1/tu-jie-yuan-di-zuo-fa-yi-tu-miao-dong-py-ryfv
/* 
    我们把数组分成两部分:它们分别进行平移
    [0, n - k - 1] -> [k, n -1] n-k个数
    [n - k, n - 1] -> [0, k - 1] k个数
    等价于把整体翻转,再以k为分界线分别翻转
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    // 反转 [l, r]
    void reverse(int[] nums, int l, int r) {
        while(l < r) {
            int tmp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = tmp;
        }
    }
}