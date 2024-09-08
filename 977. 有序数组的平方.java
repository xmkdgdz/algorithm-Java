/* 
    给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
    输入：nums = [-4,-1,0,3,10]
    输出：[0,1,9,16,100]
 */

// 方法一：直接排序
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }
}

// 方法二：双指针
// 最优
/* 原数组平方后一定是 降序 + 升序 的两个子数组 */
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int i=0, j=nums.length-1, pos=nums.length-1;
        while(i<=j){
            if(nums[i]*nums[i] > nums[j]*nums[j]){
                res[pos--] = nums[i]*nums[i];
                i++;
            }
            else{
                res[pos--] = nums[j]*nums[j];
                j--;
            }
        }
        return res;
    }
}