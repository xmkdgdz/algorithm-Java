/* 设计一个算法收集某些股票的每日报价，并返回该股票当日价格的 跨度 。

当日股票价格的 跨度 被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。

例如，如果未来 7 天股票的价格是 [100,80,60,70,60,75,85]，那么股票跨度将是 [1,1,1,2,1,4,6] 。

实现 StockSpanner 类：

StockSpanner() 初始化类对象。
int next(int price) 给出今天的股价 price ，返回该股票当日价格的 跨度 。 */

/* 
    思路：单调栈
    消除掉小于等于自己的price，但是这样如果后面有比自己大的，会漏掉这些小的
    所以记录权重，即消除了几个，即days
 */
class StockSpanner {

    Deque<int[]> s = new ArrayDeque<>();

    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int days = 1;
        while (!s.isEmpty() && s.peek()[0] <= price) {
            days += s.pop()[1];
        }
        s.push(new int[]{price, days});
        return days;
    }
}