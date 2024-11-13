/* 题目：
 * 你选择掷出 num 个色子，请返回所有点数总和的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 num 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 */

// 动态规划
/* 设dp[n]为掷出 num 个色子的结果
 * 增加一个色子，对每个dp[n-1][i]点数 增加 1-6
 * dp[n]可以只由dp[n-1]得出
 * 倒推（遍历dp[n]的每种可能得到结果）比较麻烦
 * 所以正推（遍历dp[n-1]的每种可能得到dp[n]结果）
 */
class Solution {
    public double[] statisticsProbability(int num) {
        // 只和dp[n-1]有关，不需要二维数组，用一维数组代替
        // 初始化dp[1]
        double[] res = new double[6];
        Arrays.fill(res, 1.0 / 6.0);

        for(int i=2; i<=num; i++){
            // dp[n] 的点数为 [n,6n] 即 6n-n+1
            double[] tmp = new double[5*i+1];

            for(int j=0; j<res.length; j++){
                // dp[n-1][j] 对应 dp[n][j ~ j+5] （数字大小上是 +1 ~ +6，但没有 +0，所以下标从+1开始）
                for(int k=j; k<j+6; k++){
                    tmp[k] += res[j]/6; // *1/6
                }
            }
            res = tmp;
        }
        return res;
    }
}