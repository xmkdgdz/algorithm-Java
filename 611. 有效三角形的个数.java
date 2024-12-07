/* 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。 */

// 排序 + 双指针
/* 先排序
 * 然后固定最长边
 * 对剩下两边用双指针
 */
class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for (int c = n-1;c >= 2; c--){
            int b=c-1, a=0;
            while(a < b){
                if(nums[a]+nums[b] > nums[c]){
                    res += b-a;
                    b--;
                }else{
                    a++;
                }
            }
        }
        return res;
    }
}