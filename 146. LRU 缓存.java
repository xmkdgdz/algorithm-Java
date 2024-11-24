/* 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
实现 LRUCache 类：
LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。
如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 */

// LRU：最久未使用的先出

// 方法一：使用自带数据结构（一般要求自己实现）
class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;
    
    public LRUCache(int capacity) {
        // 指定初始容量，负载因子，以及是否按访问顺序排序
        // 默认负载因子是 0.75。
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    // 重写：当容量超过时自动删除第一个元素
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity; 
    }
}


// 方法二：哈希表 + 双向链表（手动实现）
/* map 存储 key 和节点，实现get O(1)
 * 双向链表头部表示最近使用的节点，尾部表示最久未使用的节点，实现快速put O(1)
 */
class LRUCache {
    
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();

    private int capacity;
    // 创建额外的头结点尾节点便于操作
    private DLinkedNode head, tail;

    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int key, int value) {this.key = key; this.value = value;}
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null) return -1;
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node != null){
            node.value = value;
            moveToHead(node);
        }else{
            node = new DLinkedNode(key, value);
            cache.put(key, node);
            addToHead(node);
            if(cache.size() > capacity){
                // 删除尾节点
                cache.remove(tail.prev.key);
                remove(tail.prev);
            }
        }
    }

    // 针对双向链表的操作
    // 已有节点移动到头部
    void moveToHead(DLinkedNode node){
        remove(node);
        addToHead(node);
    }
    // 新节点添加到头部
    void addToHead(DLinkedNode node){
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;
    }
    // 删除节点
    void remove(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}