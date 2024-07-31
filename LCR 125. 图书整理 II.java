/* 
    读者来到图书馆排队借还书，图书管理员使用两个书车来完成整理借还书的任务。
    书车中的书从下往上叠加存放，图书管理员每次只能拿取书车顶部的书。排队的读者会有两种操作：
    push(bookID)：把借阅的书籍还到图书馆。
    pop()：从图书馆中借出书籍。
    为了保持图书的顺序，图书管理员每次取出供读者借阅的书籍是 最早 归还到图书馆的书籍。你需要返回 每次读者借出书的值 。
    如果没有归还的书可以取出，返回 -1 。
 */

// 翻译：使用两个栈实现队列（先入先出）

import java.util.ArrayDeque;
import java.util.Deque;

class CQueue {
    Deque<Integer> stackA, stackB;
    public CQueue() {
        stackA = new ArrayDeque<>(); 
        stackB = new ArrayDeque<>(); 
    }
    
    public void appendTail(int value) {
        stackA.push(value);
    }

    // AB不每次都归位也没关系
    public int deleteHead() {
        // 如果A翻转进B以后又加入新元素
        if(!stackB.isEmpty()) return stackB.pop(); // B的最顶依旧是最早进入的
        // B空了自不必说，进行A的翻转进B操作即可
        if(stackA.isEmpty()) return -1; 
        while(!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
        return stackB.pop();
    }
}