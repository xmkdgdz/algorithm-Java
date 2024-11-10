/* 
    现有一个记作二维矩阵 frame 的珠宝架，其中 frame[i][j] 为该位置珠宝的价值。拿取珠宝的规则为：
    只能从架子的左上角开始拿珠宝
    每次可以移动到右侧或下侧的相邻位置
    到达珠宝架子的右下角时，停止拿取
    注意：珠宝的价值都是大于 0 的。除非这个架子上没有任何珠宝，比如 frame = [[0]]。
 */

// 动态规划
class Solution {
    public int jewelleryValue(int[][] frame) {
        int m = frame.length, n = frame[0].length;
        // 初始化第一行
        for(int i=1; i<n; i++) frame[0][i] += frame[0][i-1];
        // 初始化第一列
        for(int j=1; j<m; j++) frame[j][0] += frame[j-1][0];
        
        for(int j=1; j<m; j++){
            for(int i=1; i<n; i++){
                frame[j][i] += Math.max(frame[j][i-1], frame[j-1][i]);
            }
        }
        return frame[m-1][n-1];
    }
}