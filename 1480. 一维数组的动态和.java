// class Solution {
//     public int[] runningSum(int[] nums) {
//         int n = nums.length;
//         int[] result = new int[n];
//         for (int i=0; i<n; i++)
//             for(int j=0; j<=i; j++){
//                 result[i] += nums[j];
//             }
//         return result;
//     }
// }

// 最优解
class Solution {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}