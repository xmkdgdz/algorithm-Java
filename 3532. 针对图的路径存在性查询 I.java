/* 给你一个整数 n，表示图中的节点数量，这些节点按从 0 到 n - 1 编号。

同时给你一个长度为 n 的整数数组 nums，该数组按 非递减 顺序排序，以及一个整数 maxDiff。

如果满足 |nums[i] - nums[j]| <= maxDiff（即 nums[i] 和 nums[j] 的 绝对差 至多为 maxDiff），则节点 i 和节点 j 之间存在一条 无向边 。

此外，给你一个二维整数数组 queries。对于每个 queries[i] = [ui, vi]，需要判断节点 ui 和 vi 之间是否存在路径。

返回一个布尔数组 answer，其中 answer[i] 等于 true 表示在第 i 个查询中节点 ui 和 vi 之间存在路径，否则为 false。

  */

/* 记录根父节点 */
class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int[] parent = new int[n];
        for (int i = 0; i < n; ) {
            parent[i] = i;
            int j = i + 1;
            while (j < n && nums[j] - nums[j - 1] <= maxDiff) {
                parent[j] = parent[j - 1]; 
                ++j;
            }
            i = j;
        }
        
        for (int i = 0; i < queries.length; ++i) {
            ans[i] = parent[queries[i][0]] == parent[queries[i][1]];
        } 
            
        return ans;
    }
}