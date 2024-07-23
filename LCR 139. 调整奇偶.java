/* 题目：有整数数组 actions 
需要将所有奇数调整至偶数之前。（顺序无所谓）
请将调整后的训练项目编号以 数组 形式返回。 
*/

class Solution {
    public int[] trainingPlan(int[] actions) {
        int i = 0, j = actions.length - 1, tmp;
        while(i < j) {
            while(i < j && (actions[i] & 1) == 1) i++; // 奇数
            while(i < j && (actions[j] & 1) == 0) j--; // 偶数
            tmp = actions[i];
            actions[i] = actions[j];
            actions[j] = tmp;
        }
        return actions;
    }
}
