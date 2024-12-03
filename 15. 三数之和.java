/* 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 
满足 i != j、i != k 且 j != k ，
同时还满足 nums[i] + nums[j] + nums[k] == 0 。
注意：答案中不可以包含重复的三元组。 */

// 方法一：排序 + 双指针
// 时间复杂度：O(N^2)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // 固定第一个数
        for(int i=0; i<n-2; i++){
            // 为了防止出现重复，每个位置上的数只能出现一次
            if(i > 0 && nums[i] == nums[i-1]) continue;
            /* 对于后两个数双指针
             * j从i+1开始，k从n-1开始
             * k-- 直到找到合适的数
             * 接下来j增大，k一定得比原来小
             */
            int k = n-1;
            int sum = 0 - nums[i];
            for(int j=i+1; j<k; j++){
                // 对于第二个数同样去重
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                // 第三个数不需要去重，因为j一定不一样，所以k一定不一样
                while(j<k && nums[j]+nums[k]>sum) k--;
                // 不可能再有其他组合
                if(j >= k) break;
                if(nums[j]+nums[k]==sum){
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    res.add(tmp);
                }
            }
        }
        return res;
    }
}