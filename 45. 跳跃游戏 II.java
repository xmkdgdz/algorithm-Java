/* 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
0 <= j <= nums[i] 
i + j < n
返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。 */

/* 思路：
 * 贪心 地进行正向查找，每次找到可到达的最远位置
 * 例如，对于数组 [2,3,1,2,4,2,3]，初始位置是下标 0，
 * 在下标 0 可到达的位置中，下标 1 的值是 3，可到达1+3=4
 * 下标 2 的值是 1，可到达2+1=3
 * 所以，从下标 1 出发可以达到更远的位置
 * 因此第一步到达下标 1。
 */

// 方法一（方法二有优化）
 class Solution {
    public int jump(int[] nums) {
        int step = 0;
        int i = 0;
        while(i<nums.length-1){
            if(i+nums[i] >= nums.length-1){
                step++;
                break;
            }
            int next = 0, end = 0;
            for(int j=1; j<=nums[i]; j++){
                if(j+nums[i+j] > end){
                    end = j+nums[i+j];
                    next = j;
                }
            }
            i += next;
            step ++;
        }
        return step;
    }
}

// 方法二：优化后
/* 把两个遍历合为一个 */
class Solution {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0; 
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            // 最远可到达的位置
            maxPosition = Math.max(maxPosition, i + nums[i]);
            // 到达nums[i]的边界，说明遍历完了i~ i+nums[i]
            if (i == end) {
                // 在 i~i+nums[i] 中，可从其中某个点最远跳到 maxPosition
                end = maxPosition;
                // 跳到 i~i+nums[i] 中某个点，但是注意 i 没变
                steps++;
            }
            // 假如 end >= length-1，说明已其实已跳到
            // 但反正继续循环 i < length - 1 也不会出现 i == end，等待循环自动结束即可
        }
        return steps;
    }
}