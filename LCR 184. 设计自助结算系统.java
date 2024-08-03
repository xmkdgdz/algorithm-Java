/* 
    请设计一个自助结账系统，该系统需要通过一个队列来模拟顾客通过购物车的结算过程，需要实现的功能有：
    get_max()：获取结算商品中的最高价格，如果队列为空，则返回 -1
    add(value)：将价格为 value 的商品加入待结算商品队列的尾部
    remove()：移除第一个待结算的商品价格，如果队列为空，则返回 -1
    注意，为保证该系统运转高效性，以上函数的均摊时间复杂度均为 O(1)
 */

// 方法一：辅助队列

import java.util.Deque;
import java.util.LinkedList;

class Checkout {

    Deque<Integer> queue, maxDeque;

    public Checkout() {
        queue = new LinkedList<>();
        maxDeque = new LinkedList<>();
    }
    
    public int get_max() {
        return maxDeque.isEmpty() ? -1 : maxDeque.peekFirst();
    }
    
    public void add(int value) {
        queue.offer(value);
        while(!maxDeque.isEmpty() && value > maxDeque.peekLast())
            maxDeque.pollLast();
        maxDeque.offerLast(value);
    }
    
    public int remove() {
        if(queue.isEmpty()) return -1;
        if(queue.peek().equals(maxDeque.peekFirst())) maxDeque.pollFirst(); // 不使用 equals 有时会有问题有时没有
        return queue.poll();
    }
}

