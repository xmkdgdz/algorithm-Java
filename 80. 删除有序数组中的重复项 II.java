class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int fast = 0, slow = 0;
        int cnt = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                cnt = 1;
                slow++;
                nums[slow] = nums[fast];
            } else if (slow < fast){
                cnt++;
                if (cnt <= 2) {
                    slow++;
                    nums[slow] = nums[fast];
                }
            }
            fast++;
        }
        return slow + 1;
    }
}