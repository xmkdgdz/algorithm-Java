/* 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
返回 你可以获得的最大乘积 。 */

// 方法一：动态规划
// 时间：O(n^2) 空间：O(n)
class Solution {
    public int cuttingBamboo(int bamboo_len) {
        // dp[i]表示正整数i的最大乘积
        int[] dp = new int[bamboo_len+1];
        dp[1] = 1;
        // 对于每个数
        for(int i=2; i<dp.length; i++){
            int iMax = 0;
            // 切出一个 j
            // 分出一个j后对于剩下的i-j有两种可能，切或者不切
            for(int j=1; j<i; j++){
                // 分出j后的最大乘积
                dp[i] = j * Math.max(i-j, dp[i-j]);
                // 记录dp[i]最大乘积
                iMax = Math.max(iMax, dp[i]);
            }
            dp[i] = iMax;
        }
        return dp[bamboo_len];
    }
}

// 方法二：优化的动态规划
// 时间：O(n) 空间：O(n)
/* 太复杂看不懂
 * 参考：https://leetcode.cn/problems/integer-break/solutions/352875/zheng-shu-chai-fen-by-leetcode-solution/ 方法二
 */

// 方法三：贪心
// 时间：O(1) 空间：O(1)
/* 
 * 参考：
 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/lxagkg/
 * https://www.hello-algo.com/chapter_greedy/max_product_cutting_problem/
 * 经各种方法的数学证明可得（求导求极值，或者拆分归纳推理）
 * 拆出因数 1,2,3最好
 * 尽可能多的拆出3最好
 * 其次是2
 * 最差是1, 1(n-1)<n，不如不拆
 */
class Solution {
    public int integerBreak(int n) {
        // 至少拆成两段，对于n<4，特殊计算
        if(n<4) return n-1;

        // 拆出3的个数
        int a = n/3;
        // 余数
        int b = n%3;

        if(b == 0) return (int)Math.pow(3, a);
        // 如果余数是1，1*3 < 2*2，所以把一个3换成 2*2
        if(b == 1) return (int)Math.pow(3, a-1)*4;

        if(b == 2) return (int)Math.pow(3, a)*2;
        // 无意义，方便过编译
        return 0;
    }
}