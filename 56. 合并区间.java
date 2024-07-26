/* 
    以数组 intervals 表示若干个区间的集合，
    其中单个区间为 intervals[i] = [starti, endi] 。
    请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */

// 方法一：先排序，再合并

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {

        if(intervals.length < 2) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        int[] tmp = intervals[0]; // 临时存储正在合并的区间
        for(int i=1; i<intervals.length; i++){
            if(tmp[1] >= intervals[i][0]){
                tmp[1] = Math.max(tmp[1], intervals[i][1]);
            }
            else{
                res.add(tmp);
                tmp = intervals[i];
            }
        }
        res.add(tmp);
        return res.toArray(new int[0][]); // 固定用法 new int[0][]
    }
}



