/* 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 */

import java.util.ArrayList;
import java.util.List;

// 当边界重合时结束
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int up = 0, down = 0, left = 0, right = 0;
        List<Integer> res = new ArrayList<>();
        while(true){
            // 左->右
            for(int i=left; i<matrix[0].length-right; i++)
                res.add(matrix[up][i]);
            if(++up + down >= matrix.length) break;       
            // 上->下
            for(int i=up; i<matrix.length-down; i++)
                res.add(matrix[i][matrix[0].length-right-1]);
            if(++right + left >= matrix[0].length ) break;
            // 右->左
            for(int i= matrix[0].length-right-1; i>=left; i--)
                res.add(matrix[matrix.length-down-1][i]);
            if(up + ++down >= matrix.length) break;
            // 下->上
            for(int i=matrix.length-down-1; i>=up; i--)
                res.add(matrix[i][left]);  
            if(right + ++left >= matrix[0].length ) break;
        }
        return res;
    }
}

class Solution {
    public int[] spiralArray(int[][] array) {
        if(array.length == 0) return new int[0];
        int l=0, r=array[0].length-1, t=0, b=array.length-1;
        int[] res = new int[array[0].length*array.length];
        int x=0;
        while(true){
            for(int i=l; i<=r; i++) res[x++]=array[t][i];
            if(++t > b) break;

            for(int i=t; i<=b; i++) res[x++]=array[i][r];
            if(l > --r) break;

            for(int i=r; i>=l; i--) res[x++]=array[b][i];
            if(t > --b) break;

            for(int i=b; i>=t; i--) res[x++]=array[i][l];
            if(++l > r) break;
        }
        return res;
    }
}