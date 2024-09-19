/* 请设计一个机械累加器，计算从 1、2... 一直累加到目标数值 target 的总和。
注意这是一个只能进行加法操作的程序，不具备乘除、if-else、switch-case、for 循环、while 循环，及条件判断语句等高级功能。 */

/* 即把以下代码转换为答案
public int mechanicalAccumulator(int target) {
    if(target == 1) return 1;
    target += mechanicalAccumulator(target - 1);
    return target;
}
 */
class Solution {
    public int mechanicalAccumulator(int target) {
        // x无意义，只是为了避免报错
        boolean x = target > 1 && (target += mechanicalAccumulator(target-1)) > 0;
        return target;
    }
}