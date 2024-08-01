/* 
    给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，
    只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；
    否则，返回 false 。

    示例 1：
    输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
    输出：true
    push(1), push(2), push(3), push(4), pop() -> 4,
    push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

    示例 2：
    输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
    输出：false
    1 不能在 2 之前弹出。
 */

// 方法一：
/* 针对每个 pop 遍历 push
 * pop == push 比较下一个
 * pop != push 比较是不是在栈顶
 * 如果都不在，那一定在后面 push
 * 
 * 全部 push 完毕后，剩下的 pop 一定就是栈的顺序，否则出错
 */
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i=0, j=0;
        while(i < pushed.length){
            if(!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
            else if(popped[j] == pushed[i]){
                i++; j++;
            }
            else{
                stack.push(pushed[i]);
                i++;
            }
        }
        while(j < popped.length){
            if(stack.pop() == popped[j]) j++;
            else return false;
        }
        return true;
    }
}

// 方法二：
/* 按照 push 顺序 push
 * 如果栈顶 == pop 则 pop 直到无法 pop
 * push 完全部且 pop 完栈应当为空
 */
class Solution {
    public boolean validateBookSequences(int[] putIn, int[] takeOut) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        for(int elem: putIn){
            stack.push(elem);
            while(!stack.isEmpty() && stack.peek() == takeOut[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}

// 也可以用数组，不过意义不大