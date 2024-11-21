/* 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 */

// 方法一：数组
// 时间复杂度：O(nlogn) 空间复杂度：O(1)
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int res = 1;
        // 数组排序
        Arrays.sort(nums);
        int i=0, j=1;
        while(i < nums.length){
            int tmp = 1;
            while(j < nums.length){
                // 重复的数字跳过
                if(nums[j] == nums[j-1]) j++;
                // 连续的数字
                else if(nums[j] == nums[j-1]+1){
                    tmp++;
                    j++;
                // 不连续的数字
                }else{
                    // 新的起点肯定在不连续的数字后面
                    i = j;
                    j++;
                    break;
                }
            }
            res = Math.max(res, tmp);
            // 已经遍历完了
            if(j == nums.length) break;
        }
        return res;
    }
}

// 方法二：哈希
// 时间复杂度：O(n) 空间复杂度：O(n)
class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        /* 对于 num 如果是起点，进入循环
         * 不是起点，不进入循环，直接跳过
         * 所以内外两层循环加起来复杂度为O(n)
         */
        for(Integer num: set){
            // 当前数字是起点，进行计算
            if(!set.contains(num-1)){
                int tmp = 1;
                while(set.contains(++num)) tmp++;
                res = Math.max(res, tmp);
            }
        }
        return res;
    }
}