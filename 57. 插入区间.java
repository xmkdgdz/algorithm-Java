/* 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，
其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。
同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
返回插入之后的 intervals。
注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new LinkedList<>();
        boolean isMerge = false;
        
        for (int[] interval: intervals) {
            if (interval[1] < newInterval[0]) {
                res.add(interval);
            } else if (interval[0] > newInterval[1]){
                /* 什么时候加入新区间:
                 * 新区间也要符合左端点升序
                 * 所以当第一次，interval 在 newInterval 右边时，加入 newInterval
                 */
                if (!isMerge) {
                    res.add(newInterval);
                    isMerge = true;
                }
                res.add(interval);
            } else {
                int l = Math.min(interval[0], newInterval[0]);
                int r = Math.max(interval[1], newInterval[1]);
                newInterval = new int[]{l, r};
            }
        }

        if (!isMerge) {
            res.add(newInterval);
        }

        return res.toArray(new int[res.size()][2]);
    }
}
