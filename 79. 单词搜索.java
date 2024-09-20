/* 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
如果 word 存在于网格中，返回 true ；否则，返回 false 。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
同一个单元格内的字母不允许被重复使用。 */

class Solution {

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();

        for(int i=0; i<board.length; i++)
            for(int j=0; j<board[0].length; j++)
                if(find(board, words, i, j, 0)) return true;

        return false;
    }

    boolean find(char[][] board, char[] words, int i, int j, int k){
        // 出界
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return false;
        // 不相等
        if(board[i][j] != words[k]) return false;
        // 已找到
        if(k == words.length-1) return true;
        // 该字符相等但还没到结尾
        // 标记已被访问
        board[i][j] = ' ';
        // 向四周继续找
        boolean res = find(board, words, i+1, j, k+1) 
        || find(board, words, i, j+1, k+1)
        || find(board, words, i-1, j, k+1)
        || find(board, words, i, j-1, k+1);
        // 如果 false 需要重新开始，所以要复原
        board[i][j] = words[k];
        return res;
    }
}