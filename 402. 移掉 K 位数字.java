/* 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。 */

// 单调栈
/* 若要使得剩下的数字最小，需要保证靠前的数字尽可能小。
 * 则每次从头开始，删去开始递减的部分
 * 可以使用单调栈
 * 全部结束之后，对于递增的数字串，从末尾开始删除即可
 */
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stk = new ArrayDeque<>();
        for (char c: num.toCharArray()) {
            while (k > 0 && !stk.isEmpty() && stk.peek() > c) {
                stk.pop();
                k--;
            }
            // 防止 0 作为数字的开头。前导0输出时会自动消失，所以不需要消耗k
            if (stk.isEmpty() && c == '0') {
                continue;
            }
            stk.push(c);
        }
        // 此时栈中元素单调递增，若 k 还没用完的话删掉栈顶元素
        while (k > 0 && !stk.isEmpty()) {
            stk.pop();
            k--;
        }
        // 若最后没剩下数字，输出 “0”
        if (stk.isEmpty()) {
            return "0";
        }
        // 将栈中字符转化成字符串
        StringBuilder  sb = new StringBuilder ();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        // 出栈顺序和字符串顺序是反的
        return sb.reverse().toString();
    }
}