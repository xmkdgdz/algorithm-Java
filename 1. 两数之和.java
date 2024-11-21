/* 给定一个整数数组 nums 和一个整数目标值 target，
请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的 数组下标。
你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
你可以按任意顺序返回答案。 */

// 哈希

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 建立哈希表：键为数组元素，值为该元素的下标
        Map<Integer, Integer> map = new HashMap<>();
        // 对于每一个数，查找 target - nums[i]，找到即获得结果
        // 这种遍历方法将 初始化哈希表 与 遍历元素找到另一个元素 的两个过程相结合
        for(int i=0; i<nums.length; i++){
            // 这种 put 顺序不会导致漏，相当于一般的排列组合顺序逆过来
            if(map.containsKey(target-nums[i]))
                return new int[]{i, map.get(target-nums[i])};
            map.put(nums[i], i);
        }
        return new int[2];
    }
}