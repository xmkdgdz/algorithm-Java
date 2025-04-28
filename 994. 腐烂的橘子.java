/* 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。 */

// BFS
/* 因为时间是一圈一圈计算，所以想到BFS */
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> que = new LinkedList<>();
        int cnt = 0; // 一共多少个新鲜橘子
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    ++cnt;
                }
                // 腐烂橘子先入队，初始化
                else if (grid[i][j] == 2) {
                    que.offer(new int[]{i, j});
                }
            }
        }
        int min = 0;
        // 判断 cnt > 0，因为最后一层可能出现，没有橘子再加入下一层，但是已经加了一分钟
        while (cnt > 0 && !que.isEmpty()) {
            // 按层遍历
            ++min;
            int size = que.size();
            for (int k = 0; k < size; ++k) {
                int[] node = que.poll();
                int i = node[0];
                int j = node[1];
                // 周围的橘子加入下一层
                if (i-1 >= 0 && grid[i-1][j] == 1) {
                    que.offer(new int[]{i-1, j});
                    grid[i-1][j] = 2;
                    --cnt;
                }
                if (i+1 < m && grid[i+1][j] == 1) {
                    que.offer(new int[]{i+1, j});
                    grid[i+1][j] = 2;
                    --cnt;
                }
                if (j-1 >= 0 && grid[i][j-1] == 1) {
                    que.offer(new int[]{i, j-1});
                    grid[i][j-1] = 2;
                    --cnt;
                }
                if (j+1 < n && grid[i][j+1] == 1) {
                    que.offer(new int[]{i, j+1});
                    grid[i][j+1] = 2;
                    --cnt;
                }
            }
        }
        // cnt > 0 说明有孤立的新鲜橘子，不能全部腐烂
        if (cnt > 0) {
            return -1;
        }
        return min;
    }
}