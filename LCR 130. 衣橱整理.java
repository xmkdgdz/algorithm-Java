/* 家居整理师将待整理衣橱划分为 m x n 的二维矩阵 grid，其中 grid[i][j] 代表一个需要整理的格子。
整理师自 grid[0][0] 开始 逐行逐列 地整理每个格子。
整理规则为：在整理过程中，可以选择 向右移动一格 或 向下移动一格，但不能移动到衣柜之外。
同时，不需要整理 digit(i) + digit(j) > cnt 的格子，其中 digit(x) 表示数字 x 的各数位之和。
请返回整理师 总共需要整理多少个格子。 */

class Solution {
    int m, n, cnt;
    boolean[][] visited;

    public int wardrobeFinishing(int m, int n, int cnt) {
        this.m = m; this.n = n; this.cnt = cnt;
        visited = new boolean[m][n];
        return dfs(0, 0);
    }

    int dfs(int i, int j){
        if(i >= m || j >= n || digit(i) + digit(j) > cnt || visited[i][j])
            return 0;
        visited[i][j] = true;
        int res = dfs(i+1, j) + dfs(i, j+1) + 1;
        return res;
    }

    int digit(int x){
        int sum = 0;
        while(x != 0){
            sum += x%10;
            x /= 10;
        }
        return sum;
    }
}