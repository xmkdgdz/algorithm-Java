/* 
    给你一个整数数组 nums，
    有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
    滑动窗口每次只向右移动一位。
    返回 滑动窗口中的最大值 。

    示例：
    滑动窗口的位置                最大值
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
    1 [3  -1  -3] 5  3  6  7       3
    1  3 [-1  -3  5] 3  6  7       5
    1  3  -1 [-3  5  3] 6  7       5
    1  3  -1  -3 [5  3  6] 7       6
    1  3  -1  -3  5 [3  6  7]      7
 */

// 方法一：单调队列（使用双端队列）
/* 定义一个 deque，使其始终是一个滑动窗口中数字的递减序列，
 * 即包含滑动窗口内最大数字及其之后的递减数字
 * 每次滑动，最左端的数字与 deque 最左端比较，依此弹出
 * 每次加入数字时，从右边开始，把比其小的数字全部弹出
 * 保证递减
 */
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        // 先形成第一个窗口
        for(int i=0; i<k; i++){
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.pollLast();
            deque.offerLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        
        for(int i=k; i<nums.length; i++){
            if(deque.peekFirst() == nums[i-k]){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.pollLast();
            deque.offerLast(nums[i]);
            res[i-k+1] = deque.peekFirst();
        }
        return res;
    }
}

// 方法二：分块 + 预处理
/* https://leetcode.cn/problems/sliding-window-maximum/solutions/543426/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m 中的方法三
 * 数组每k个分成一块（不重合）（最后一块可能不是k）
 * 每个滑动窗口的最大值就是 max(左块占的后面几个数的最大值，右块占的前面几个数的最大值)
 * 预计算出每个数字前后缀最大值即可
 */
class Solution {
    public int[] maxAltitude(int[] heights, int limit) {
        int n = heights.length;
        if(n==0 || limit==0) return new int[0];
        int[] res = new int[n-limit+1];
        int[] preMax = new int[n];
        int[] sufMax = new int[n];
        // 计算前缀
        for(int i=0; i<n; i++){
            if(i%limit == 0)
                preMax[i] = heights[i];
            else
                preMax[i] = Math.max(heights[i], preMax[i-1]);
        }
        // 计算后缀
        for(int i=n-1; i>=0; i--){
            if(i%limit == limit-1 || i==n-1)
                sufMax[i] = heights[i];
            else
                sufMax[i] = Math.max(heights[i], sufMax[i+1]);
        }
        
        for(int i=0; i<n-limit+1; i++){
            res[i] = Math.max(sufMax[i], preMax[i+limit-1]);
        }

        return res;
    }
}