/* 题目：
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * 丑数 就是质因子只包含 2、3 和 5 的正整数。
 * 1 是丑数
 */

// 动态规划
/* 丑数由丑数 *2 *3 *5 得到 */
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        // 代表最后一个需要 *2 *3 *5 的数
        int a=0, b=0, c=0;
        for(int i=1; i<n; i++){
            dp[i] = Math.min(Math.min(dp[a]*2, dp[b]*3), dp[c]*5);
            // 可能存在 *2 == *3 类似的情况，乘之后的数相同，需要跳过索引
            if(dp[i] == dp[a]*2) a++;
            if(dp[i] == dp[b]*3) b++;
            if(dp[i] == dp[c]*5) c++;
        }
        return dp[n-1];
    }
}