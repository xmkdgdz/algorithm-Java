/* 给定一个长度为 n 的整数数组 height 。
有 n 条垂线，第 i 条线的高度是 height[i]。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
返回容器可以储存的最大水量。
说明：你不能倾斜容器。 */

// 双指针
/* 指针指向两端
 * 两端高度小的指针向中间移动
 * 因为大的一端移动后的容积一定会变小
 * 小的一端移动后的容积可能会变大
 * 遍历所有可能，得到最大值
 */
class Solution {
    public int maxArea(int[] height) {
        int i=0, j=height.length-1;
        int res = 0;
        while(i<j){
            int area = Math.min(height[i], height[j])*(j-i);
            res = Math.max(res, area);
            if(height[i] < height[j]) i++;
            else j--;
        }
        return res;
    }
}