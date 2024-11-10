/* 
    给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
    你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
    设计一个算法来计算你所能获取的最大利润。
    如果你不能获取任何利润，返回 0 。
 */

// 动态规划
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        // 最大利润
        int res = 0;
        for(int i=1; i<prices.length; i++){
            // 前 i-1 天的最小值
            min = Math.min(min, prices[i-1]);
            //  prices[i] - min 第 i 天卖出的最大利润
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}