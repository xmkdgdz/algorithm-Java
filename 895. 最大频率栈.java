/* 
    设计一个类似堆栈的数据结构，将元素推入堆栈，并从堆栈中弹出出现频率最高的元素。

    实现 FreqStack 类:

    FreqStack() 构造一个空的堆栈。
    void push(int val) 将一个整数 val 压入栈顶。
    int pop() 删除并返回堆栈中出现频率最高的元素。
    如果出现频率最高的元素不只一个，则移除并返回最接近栈顶的元素。
 */

/* 
    思路：

    1、每次 pop 时，必须要知道频率最高的元素是什么。
    2、如果频率最高的元素有多个，还得知道哪个是最近 push 进来的元素是哪个。

    为了实现上述难点，我们要做到以下几点：
    1、肯定要有一个变量 maxFreq 记录当前栈中最高的频率是多少。
    2、我们得知道一个频率 freq 对应的元素有哪些，且这些元素要有时间顺序。
    3、随着 pop 的调用，每个 val 对应的频率会变化，所以还得维持一个映射记录每个 val 对应的 freq。 
 */
class FreqStack {
    // 记录 FreqStack 中每个 val 对应的出现频率
    private Map<Integer, Integer> valFreq;
    // 记录频率 freq 对应的 val 栈，先进后出
    private Map<Integer, Deque<Integer>> freqVals;
    // 记录 FreqStack 中元素的最大频率
    private int maxFreq;

    public FreqStack() {
        valFreq = new HashMap<>();
        freqVals = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int freq = valFreq.getOrDefault(val, 0) + 1;
        maxFreq = Math.max(maxFreq, freq);
        valFreq.put(val, freq);
        freqVals.putIfAbsent(freq, new LinkedList<Integer>());
        freqVals.get(freq).push(val);
    }
    
    public int pop() {
        int val = freqVals.get(maxFreq).pop();
        if (freqVals.get(maxFreq).isEmpty()) {
            maxFreq--;
        }
        valFreq.put(val, valFreq.get(val) - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */