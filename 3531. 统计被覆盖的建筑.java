/* 
    给你一个正整数 n，表示一个 n x n 的城市，同时给定一个二维数组 buildings，其中 buildings[i] = [x, y] 表示位于坐标 [x, y] 的一个 唯一 建筑。
    如果一个建筑在四个方向（左、右、上、下）中每个方向上都至少存在一个建筑，则称该建筑 被覆盖 。
    返回 被覆盖 的建筑数量。
 */

// O(m) O(n+m)
/* 记录每行/列上的最大值和最小值，如果建筑坐标在二者之间则覆盖 */
class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int res = 0;
        int[] rowMin = new int[n + 1], rowMax = new int[n + 1];
        int[] colMin = new int[n + 1], colMax = new int[n + 1];
        for (int[] b: buildings) {
            int x = b[0], y = b[1];
            rowMin[x] = rowMin[x] == 0 ? y : Math.min(rowMin[x], y);
            rowMax[x] = rowMax[x] == 0 ? y : Math.max(rowMax[x], y);
            colMin[y] = colMin[y] == 0 ? x : Math.min(colMin[y], x);
            colMax[y] = colMax[y] == 0 ? x : Math.max(colMax[y], x);
        }
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            if (y > rowMin[x] && y < rowMax[x] && x > colMin[y] && x < colMax[y]) {
                res++;
            }
        }
        return res;
    }
}