/* 
    F(0) = 0，F(1) = 1
    F(n) = F(n - 1) + F(n - 2)，其中 n > 1
    给定 n ，请计算 F(n) 。
    答案需要取模 1e9+7(1000000007) ，如计算初始结果为：1000000008，请返回 1。
 */

// 动态规划
 class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) return n;
        int[] dp = new int[]{0, 1};
        // F(n) = F(n - 1) + F(n - 2) 只需要保存两个数
        for(int i=2; i<=n; i++){
            int tmp = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = tmp % 1000000007;
        }
        return dp[1];
    }
}