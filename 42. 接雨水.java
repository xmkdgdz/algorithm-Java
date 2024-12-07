/* 
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */

// 双指针
/* 
 * i处能接的水 = min(leftMaxi, rightMaxi) - height[i]  （就是i所在的竖水柱高度）
 * 采用双指针，分别从最左和最右开始找leftMax和rightMax
 * 如果 leftMax < rightMax
 * leftMax 一定是 left 的leftMaxi，且一定小于 rightMaxi（rightMaxi>=rightMax）
 * 可以求出left处能接的水
 * 如果 leftMax >= rightMax
 * 同理，可以求出right处能接的水
 */
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left=0, right=n-1, leftMax=0, rightMax=0;
        int res = 0;
        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(leftMax < rightMax){
                res += leftMax - height[left];
                left++;
            }else{
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}