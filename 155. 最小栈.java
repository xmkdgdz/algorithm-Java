/* 
    设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

    实现 MinStack 类:
    MinStack() 初始化堆栈对象。
    void push(int val) 将元素val推入堆栈。
    void pop() 删除堆栈顶部的元素。
    int top() 获取堆栈顶部的元素。
    int getMin() 获取堆栈中的最小元素。
 */

// 方法一：使用辅助栈记录最小值
import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {
    Deque<Integer> stack, minStack;
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    // 辅助栈可能不包含全部 stack 中的元素
    public void push(int x) {
        stack.push(x);
        // minStack 遇到更小的才保存，确保栈首是最小
        if(minStack.isEmpty() || x <= minStack.peek()) 
            minStack.push(x);
    }
    
    // stack 出栈是按顺序出的，所以 minStack 顶是该元素则出，不是就说明比最小的大，根本没存
    public void pop() {
        int x = stack.pop();
        if(x == minStack.peek()) minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

// 方法二：不使用额外空间
// 入栈时保存 元素的值、此时栈内最小值
class MinStack {
    Deque<int[]> stack;
    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty())
            stack.push(new int[]{val, val});
        else{
            stack.push(new int[]{val, Math.min(val, stack.peek()[1])});
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}