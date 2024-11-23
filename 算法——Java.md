# 算法——Java

![线性数据结构与非线性数据结构](https://www.hello-algo.com/chapter_data_structure/classification_of_data_structure.assets/classification_logic_structure.png)

## 数组（array）

```java
// 初始化
int[] array = new int[5]; // 默认值为 0
// 元素赋值
array[0] = 2;

// 初始化
int[] array = {2, 3, 1, 0, 2};

// 遍历数组
// 通过索引遍历数组
for (int i = 0; i < array.length; i++)
// 直接遍历数组元素
for (int i : array)
    
// 复制数组
int[] copy = Arrays.copyOf(numbers, numbers.length);  // 复制整个数组
int[] partialCopy = Arrays.copyOfRange(numbers, 1, 4);  // 复制部分数组 [1, 4)

// 填充数组
Arrays.fill(array, 0);  // 用 0 填充整个数组
Arrays.fill(array, 1, 4, 5);  // 从索引 1 到 4（不包括4）填充 5

// 排序数组（直接修改原数组）
Arrays.sort(array);  // 对数组进行升序排序
Arrays.sort(array, Collections.reverseOrder()); // 降序排序
```

内存地址连续，可以存储固定大小的相同类型的元素

- **优点：** 随机访问元素效率高。
- **缺点：** 大小固定，插入和删除元素相对较慢。

> 插入和删除需要改变后面的所有元素

### String 类

> 类似数组

```java
// 创建
String s1 = "Runoob";              // String 直接创建
String s2 = "Runoob";              // String 直接创建
String s3 = s1; 
s1 == s2 == s3;                     // 相同引用
String s4 = new String("Runoob");   // String 对象创建
String s5 = new String("Runoob");   // String 对象创建
s4 != s5;                           // 不同对象

// 连接字符串
string1.concat(string2);
string1 + string2 + "!";

// 格式化字符串
String fs;
fs = String.format("浮点型变量的值为 " +
                   "%f, 整型变量的值为 " +
                   " %d, 字符串变量的值为 " +
                   " %s", floatVar, intVar, stringVar);

// 比较两个字符串的内容是否相同。
boolean equals(Object anObject);
    
// 按字典顺序比较两个字符串
int compareTo(String anotherString); // 正数：当前对象大
int compareToIgnoreCase(String str); // 不考虑大小写
    
// 返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的
String replace(char oldChar, char newChar);

char[] toCharArray();

String substring(int beginIndex)
String substring(int beginIndex, int endIndex) 
    
// 转化为字符串
String str = String.valueOf(number); // 任何基本数据类型或对象
Integer.toString(number); // 整数

```

![img](https://www.runoob.com/wp-content/uploads/2013/12/java-string-1-2020-12-01.png)

**注意:**String 类是不可改变的，所以你一旦创建了 String 对象，那它的值就无法改变了。改变实际上是创建了一个新对象，会增加时间和空间复杂度。

如果需要对字符串做很多修改，那么应该选择使用 [StringBuffer & StringBuilder 类](https://www.runoob.com/java/java-stringbuffer.html)。

* StringBuilder 相较于 StringBuffer 有速度优势
* StringBuilder 的方法不是线程安全的

```java
public class RunoobTest{
    public static void main(String args[]){
        StringBuilder sb = new StringBuilder(10); // 也可以不指定大小
        sb.append("Runoob.."); 
        System.out.println(sb); // Runoob..
        sb.append("!");
        System.out.println(sb); // Runoob..!
        sb.insert(8, "Java");
        System.out.println(sb); // Runoob..Java!
        sb.delete(5,8);
        System.out.println(sb); // RunooJava!
        sb.deleteCharAt(2); // 删除某个
        sb.toString();
    }
}
```

## 链表

```java
/* 链表节点类 */
class ListNode {
    int val;        // 节点值
    ListNode next;  // 指向下一节点的引用
    ListNode(int x) { val = x; }  // 构造函数
}
```

数组与链表的效率对比

|          | 数组                           | 链表           |
| :------- | :----------------------------- | :------------- |
| 存储方式 | 连续内存空间                   | 分散内存空间   |
| 容量扩展 | 长度不可变                     | 可灵活扩展     |
| 内存效率 | 元素占用内存少、但可能浪费空间 | 元素占用内存多 |
| 访问元素 | 𝑂(1)                           | 𝑂(𝑛)           |
| 添加元素 | 𝑂(𝑛)                           | 𝑂(1)           |
| 删除元素 | 𝑂(𝑛)                           | 𝑂(1)           |

**所有数据结构都是基于数组、链表或二者的组合实现的**。

## 列表（Lists）

列表可以基于链表或数组实现

```java
/* List 转换为数组 */
Object[] array = list.toArray();
String[] stringArray = list.toArray(new String[0]);

/* 不能直接转化为 int[]，只能遍历 */
int[] array = new int[list.size()];
// 手动遍历赋值
for (int i = 0; i < list.size(); i++) {
    array[i] = list.get(i);
}
```

**ArrayList:**

```java
List<Integer> nums = new ArrayList<>();

/* 清空列表 */
nums.clear();

/* 在尾部添加元素 */
nums.add(1);

/* 在中间插入元素 */
// 在索引 3 处插入数字 6，后面的内容会后移，不能超出现有索引范围
nums.add(3, 6);  

/* 删除元素 */
nums.remove(3);  // 删除索引 3 处的元素，同上
.remove(Object o) // 删除首次出现的指定元素。

/* 访问元素 */
nums.get(1);  // 访问第二个元素

/* 修改元素 */
.set()	替换 arraylist 中指定索引的元素
    
// 迭代元素
for (Integer i : nums)

/* 排序 */
Collections.sort(nums);

nums.contains(1);	// 判断元素是否在 arraylist
nums.size();
.toArray()	// 将 arraylist 转换为数组
.toString()	// 将 arraylist 转换为字符串
```

- **特点：** 动态数组，可变大小。

> 本质是数组，所以包含数组的性质和插入删除原理

- **优点：** 高效的随机访问和快速尾部插入。
- **缺点：** 中间插入和删除相对较慢。

**LinkedList:**

```java
List<String> sites = new LinkedList<>();

// 向列表末尾添加元素，可以指定索引
sites.add("Google"); 
// 在列表开头添加元素
sites.addFirst("Wiki");
// 在列表结尾添加元素
sites.addLast("Wiki");

sites.remove(); // 删除并返回列表的第一个元素，可以指定索引
.remove(Object o) // 删除首次出现的指定元素。
sites.removeFirst();
sites.removeLast();

get(int index) // 返回指定位置的元素。
sites.getFirst()
sites.getLast()
    
// 迭代元素
for (String i : sites)
    
// res.append(path) ，则是将此 path 对象加入了 res ；后续 path 改变时， res 中的 path 对象也会随之改变，因此无法实现结果记录
// 正确做法
res.add(new LinkedList(path))
```

- **特点：** 双向链表，元素之间通过指针连接。
- **优点：** 插入和删除元素高效，迭代器性能好。
- **缺点：** 随机访问相对较慢。

## 栈（stack）

先入后出

Java标准库提供了`java.util.Stack`类来实现栈，但在实际开发中，我们更推荐使用`java.util.Deque`接口及其实现类`java.util.ArrayDeque`和`java.util.LinkedList`来实现栈。

`ArrayDeque`是一个基于数组的双端队列

`LinkedList`是一个基于链表的双端队列

在大多数情况下，`ArrayDeque`是更好的选择，因为它在内存使用和性能上通常优于`LinkedList`。然而，如果你需要在列表中间频繁插入和删除元素，`LinkedList`可能是一个更好的选择。

```java
// 使用ArrayDeque实现栈
Deque<Integer> stack = new ArrayDeque<>();

// 使用LinkedList实现栈
Deque<Integer> stack2 = new LinkedList<>();
```

|          |                        |
| -------- | ---------------------- |
| `push()` | 元素入栈（添加至栈顶） |
| `pop()`  | 栈顶元素出栈           |
| `peek()` | 访问栈顶元素           |

## 队列（queue）

先入先出

| 抛出异常  | 返回特殊值(用这个) |
| :-------- | ------------------ |
| add(e)    | offer(e)           |
| remove()  | poll()             |
| element() | peek()             |

### 双向队列(Deque)

```java
/* 初始化双向队列 */
Deque<Integer> deque = new LinkedList<>();

/* 元素入队 */
deque.offerLast(2);   // 添加至队尾
deque.offerLast(5);
deque.offerLast(4);
deque.offerFirst(3);  // 添加至队首
deque.offerFirst(1);

/* 访问元素 */
int peekFirst = deque.peekFirst();  // 队首元素
int peekLast = deque.peekLast();    // 队尾元素

/* 元素出队 */
int pollFirst = deque.pollFirst();  // 队首元素出队
int pollLast = deque.pollLast();    // 队尾元素出队

/* 获取双向队列的长度 */
int size = deque.size();

/* 判断双向队列是否为空 */
boolean isEmpty = deque.isEmpty();
```

### 优先队列(Priority Queue)

基于堆（Heap）实现

```java
/* 初始化堆 */
// 初始化小顶堆
Queue<Integer> minHeap = new PriorityQueue<>();
// 初始化大顶堆（使用 lambda 表达式修改 Comparator 即可）
Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

/* 元素入堆 */
maxHeap.offer(1);
maxHeap.offer(3);
maxHeap.offer(2);
maxHeap.offer(5);
maxHeap.offer(4);

/* 获取堆顶元素 */
int peek = maxHeap.peek(); // 5

/* 堆顶元素出堆 */
// 出堆元素会形成一个从大到小的序列
peek = maxHeap.poll(); // 5
peek = maxHeap.poll(); // 4
peek = maxHeap.poll(); // 3
peek = maxHeap.poll(); // 2
peek = maxHeap.poll(); // 1

/* 获取堆大小 */
int size = maxHeap.size();

/* 判断堆是否为空 */
boolean isEmpty = maxHeap.isEmpty();
```

## 哈希集合(Set)

**HashSet:**

- **特点：** 无序集合，基于HashMap实现。
- **优点：** 高效的查找和插入操作。
- **缺点：** 不保证顺序。

**TreeSet:**

- **特点：**TreeSet 是有序集合，底层基于红黑树实现，不允许重复元素。
- **优点：** 提供自动排序功能，适用于需要按顺序存储元素的场景。
- **缺点：** 性能相对较差，不允许插入 null 元素。

```java
Set<String> hashSet = new HashSet<>();
Set<Integer> treeSet = new TreeSet<>(); // 正序

sites.add("Google");
sites.add("Runoob");
sites.add("Runoob");  // 重复的元素不会被添加

sites.remove("Taobao");  // 删除元素，删除成功返回 true，否则为 false

sites.contains("Taobao");

sites.clear();  

for (String i : sites) {
    System.out.println(i);
}

treeSet.first()
treeSet.last()
```

## 哈希表(Map)

```java
/* 初始化哈希表 */
Map<Integer, String> map = new HashMap<>();
Map<Integer, String> map = new TreeMap<>(); // 基于红黑树实现的，自动排序
Map<Integer, String> map = new LinkedHashMap<>(); // 有序哈希表，维护了插入时的顺序
Map<Integer, String> map = new Hashtable<>(); // 线程安全，不允许 null 值

/* 添加操作 */
// 在哈希表中添加键值对 (key, value)
map.put(12836, "小哈");
map.put(15937, "小啰");
map.put(16750, "小算");
map.put(13276, "小法");
map.put(10583, "小鸭");

/* 查询操作 */
// 向哈希表中输入键 key ，得到值 value
String name = map.get(15937); // 不包含返回 null

/* 删除操作 */
// 在哈希表中删除键值对 (key, value)
map.remove(10583);

boolean hasName = map.containsKey(12836);  // 返回 true
boolean hasValue = map.containsValue("小哈");  // 返回 true

/* 遍历哈希表 */
// 遍历键值对 key->value
for (Map.Entry <Integer, String> kv: map.entrySet()) {
    System.out.println(kv.getKey() + " -> " + kv.getValue());
}
// 单独遍历键 key
for (int key: map.keySet()) {
    System.out.println(key);
}
// 单独遍历值 value
for (String val: map.values()) {
    System.out.println(val);
}

map.clear();  // 移除所有的键值对
```

## 树

### 二叉树

```java
/* 二叉树节点类 */
class TreeNode {
    int val;         // 节点值
    TreeNode left;   // 左子节点引用
    TreeNode right;  // 右子节点引用
    TreeNode(int x) { val = x; }
}
```

![完美二叉树](https://www.hello-algo.com/chapter_tree/binary_tree.assets/perfect_binary_tree.png)

![完全二叉树](https://www.hello-algo.com/chapter_tree/binary_tree.assets/complete_binary_tree.png)

![完满二叉树](https://www.hello-algo.com/chapter_tree/binary_tree.assets/full_binary_tree.png)

![平衡二叉树](https://www.hello-algo.com/chapter_tree/binary_tree.assets/balanced_binary_tree.png)

**层序遍历**：从顶部到底部逐层遍历二叉树，并在每一层按照从左到右的顺序访问节点。是广度优先搜索（breadth-first search, BFS）

广度优先遍历通常借助“队列”实现

```java
/* 层序遍历 */
List<Integer> levelOrder(TreeNode root) {
    // 初始化队列，加入根节点
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    // 初始化一个列表，用于保存遍历序列
    List<Integer> list = new ArrayList<>();
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll(); // 队列出队
        list.add(node.val);           // 保存节点值
        if (node.left != null)
            queue.offer(node.left);   // 左子节点入队
        if (node.right != null)
            queue.offer(node.right);  // 右子节点入队
    }
    return list;
}
```

**前序、中序和后序遍历**：绕着整棵二叉树的外围“走”一圈，“先走到尽头，再回溯继续”。是深度优先搜索（depth-first search, DFS）

深度优先搜索通常基于递归实现

```java
/* 前序遍历 */
void preOrder(TreeNode root) {
    if (root == null)
        return;
    // 访问优先级：根节点 -> 左子树 -> 右子树
    list.add(root.val);
    preOrder(root.left);
    preOrder(root.right);
}

/* 中序遍历 */
void inOrder(TreeNode root) {
    if (root == null)
        return;
    // 访问优先级：左子树 -> 根节点 -> 右子树
    inOrder(root.left);
    list.add(root.val);
    inOrder(root.right);
}

/* 后序遍历 */
void postOrder(TreeNode root) {
    if (root == null)
        return;
    // 访问优先级：左子树 -> 右子树 -> 根节点
    postOrder(root.left);
    postOrder(root.right);
    list.add(root.val);
}
```

### 二叉搜索树（binary search tree）

![二叉搜索树](https://www.hello-algo.com/chapter_tree/binary_search_tree.assets/binary_search_tree.png)

1. 对于根节点，左子树中所有节点的值 < 根节点的值 < 右子树中所有节点的值。
2. 任意节点的左、右子树也是二叉搜索树，即同样满足条件 1

```java
/* 查找节点 */
TreeNode search(int num) {
    TreeNode cur = root;
    // 循环查找，越过叶节点后跳出
    while (cur != null) {
        // 目标节点在 cur 的右子树中
        if (cur.val < num)
            cur = cur.right;
        // 目标节点在 cur 的左子树中
        else if (cur.val > num)
            cur = cur.left;
        // 找到目标节点，跳出循环
        else
            break;
    }
    // 返回目标节点
    return cur;
}

/* 插入节点 */
void insert(int num) {
    // 若树为空，则初始化根节点
    if (root == null) {
        root = new TreeNode(num);
        return;
    }
    TreeNode cur = root, pre = null;
    // 循环查找，越过叶节点后跳出
    while (cur != null) {
        // 找到重复节点，直接返回
        if (cur.val == num)
            return;
        pre = cur;
        // 插入位置在 cur 的右子树中
        if (cur.val < num)
            cur = cur.right;
        // 插入位置在 cur 的左子树中
        else
            cur = cur.left;
    }
    // 插入节点
    TreeNode node = new TreeNode(num);
    if (pre.val < num)
        pre.right = node;
    else
        pre.left = node;
}

/* 删除节点 */
void remove(int num) {
    // 若树为空，直接提前返回
    if (root == null)
        return;
    TreeNode cur = root, pre = null;
    // 循环查找，越过叶节点后跳出
    while (cur != null) {
        // 找到待删除节点，跳出循环
        if (cur.val == num)
            break;
        pre = cur;
        // 待删除节点在 cur 的右子树中
        if (cur.val < num)
            cur = cur.right;
        // 待删除节点在 cur 的左子树中
        else
            cur = cur.left;
    }
    // 若无待删除节点，则直接返回
    if (cur == null)
        return;
    // 子节点数量 = 0 or 1
    if (cur.left == null || cur.right == null) {
        // 当子节点数量 = 0 / 1 时， child = null / 该子节点
        TreeNode child = cur.left != null ? cur.left : cur.right;
        // 删除节点 cur
        if (cur != root) {
            if (pre.left == cur)
                pre.left = child;
            else
                pre.right = child;
        } else {
            // 若删除节点为根节点，则重新指定根节点
            root = child;
        }
    }
    // 子节点数量 = 2
    else {
        // 获取中序遍历中 cur 的下一个节点
        TreeNode tmp = cur.right;
        while (tmp.left != null) {
            tmp = tmp.left;
        }
        // 递归删除节点 tmp
        remove(tmp.val);
        // 用 tmp 覆盖 cur
        cur.val = tmp.val;
    }
}
```

**中序遍历有序**

![二叉搜索树的中序遍历序列](https://www.hello-algo.com/chapter_tree/binary_search_tree.assets/bst_inorder_traversal.png)

## 堆

堆（heap）是一种满足特定条件的完全二叉树。

![小顶堆与大顶堆](https://www.hello-algo.com/chapter_heap/heap.assets/min_heap_and_max_heap.png)

- 我们将二叉树的根节点称为“堆顶”，将底层最靠右的节点称为“堆底”。

**堆通常用于实现优先队列**，优先队列见上文。

### 堆的实现

![堆的表示与存储](https://www.hello-algo.com/chapter_heap/heap.assets/representation_of_heap.png)

```java
//  堆的存储与表示

/* 获取左子节点的索引 */
int left(int i) {
    return 2 * i + 1;
}
/* 获取右子节点的索引 */
int right(int i) {
    return 2 * i + 2;
}
/* 获取父节点的索引 */
int parent(int i) {
    return (i - 1) / 2; // 向下整除
}


/* 访问堆顶元素 */
int peek() {
    return maxHeap.get(0);
}


/* 元素入堆 */
void push(int val) {
    // 添加节点
    maxHeap.add(val);
    // 从底至顶堆化
    siftUp(size() - 1);
}
/* 从节点 i 开始，从底至顶堆化 */
void siftUp(int i) {
    while (true) {
        // 获取节点 i 的父节点
        int p = parent(i);
        // 当“越过根节点”或“节点无须修复”时，结束堆化
        if (p < 0 || maxHeap.get(i) <= maxHeap.get(p))
            break;
        // 交换两节点
        swap(i, p);
        // 循环向上堆化
        i = p;
    }
}


/* 元素出堆 */
int pop() {
    // 判空处理
    if (isEmpty())
        throw new IndexOutOfBoundsException();
    // 交换根节点与最右叶节点（交换首元素与尾元素）
    swap(0, size() - 1);
    // 删除节点
    int val = maxHeap.remove(size() - 1);
    // 从顶至底堆化
    siftDown(0);
    // 返回堆顶元素
    return val;
}
/* 从节点 i 开始，从顶至底堆化 */
void siftDown(int i) {
    while (true) {
        // 判断节点 i, l, r 中值最大的节点，记为 ma
        int l = left(i), r = right(i), ma = i;
        if (l < size() && maxHeap.get(l) > maxHeap.get(ma))
            ma = l;
        if (r < size() && maxHeap.get(r) > maxHeap.get(ma))
            ma = r;
        // 若节点 i 最大或索引 l, r 越界，则无须继续堆化，跳出
        if (ma == i)
            break;
        // 交换两节点
        swap(i, ma);
        // 循环向下堆化
        i = ma;
    }
}
```

### 建堆操作

1. 将列表所有元素原封不动地添加到堆中，此时堆的性质尚未得到满足。
2. 倒序遍历堆（层序遍历的倒序），依次对每个非叶节点执行“从顶至底堆化”。

```java
/* 构造方法，根据输入列表建堆 */
MaxHeap(List<Integer> nums) {
    // 将列表元素原封不动添加进堆
    maxHeap = new ArrayList<>(nums);
    // 堆化除叶节点以外的其他所有节点
    for (int i = parent(size() - 1); i >= 0; i--) {
        siftDown(i);
    }
}
```

## 搜索

![多种搜索策略](https://www.hello-algo.com/chapter_searching/searching_algorithm_revisited.assets/searching_algorithms.png)

### 二分查找

```java
/* 二分查找（双闭区间） */
int binarySearch(int[] nums, int target) {
    // 初始化双闭区间 [0, n-1] ，即 i, j 分别指向数组首元素、尾元素
    int i = 0, j = nums.length - 1;
    // 循环，当搜索区间为空时跳出（当 i > j 时为空）
    while (i <= j) {
        int m = i + (j - i) / 2; // 计算中点索引 m，不使用 (i+j)/2 因为 i+j 可能会超出 int 类型的取值范围
        if (nums[m] < target) // 此情况说明 target 在区间 [m+1, j] 中
            i = m + 1;
        else if (nums[m] > target) // 此情况说明 target 在区间 [i, m-1] 中
            j = m - 1;
        else // 找到目标元素，返回其索引
            return m;
    }
    // 未找到目标元素，返回 -1
    return -1;
}
```

### 二分查找插入点

给定一个长度为 n 的有序数组 `nums` 和一个元素 `target` ，数组不存在重复元素。现将 `target` 插入数组 `nums` 中，并保持其有序性。若数组中已存在元素 `target` ，则插入到其左方。请返回插入后 `target` 在数组中的索引。

1. 当数组包含 `target` 时，插入点的索引就是该 `target` 的索引。
2. 当数组不包含 target 时，插入索引为 i 。

```java
/* 二分查找插入点（无重复元素） */
int binarySearchInsertionSimple(int[] nums, int target) {
    int i = 0, j = nums.length - 1; // 初始化双闭区间 [0, n-1]
    while (i <= j) {
        int m = i + (j - i) / 2; // 计算中点索引 m
        if (nums[m] < target) {
            i = m + 1; // target 在区间 [m+1, j] 中
        } else if (nums[m] > target) {
            j = m - 1; // target 在区间 [i, m-1] 中
        } else {
            return m; // 找到 target ，返回插入点 m
        }
    }
    // 未找到 target ，返回插入点 i
    return i;
}
```

数组可能包含重复元素

普通二分查找只能返回其中一个 `target` 的索引，**而无法确定该元素的左边和右边还有多少 `target`**。

- 当 `nums[m] < target` 或 `nums[m] > target` 时，说明还没有找到 `target` ，因此采用普通二分查找的缩小区间操作，**从而使指针 i 和 j 向 `target` 靠近**。
- 当 `nums[m] == target` 时，说明小于 `target` 的元素在区间 [i,m−1] 中，因此采用 j=m−1 来缩小区间，**从而使指针 j 向小于 `target` 的元素靠近**。

循环完成后，i 指向最左边的 `target` ，j 指向首个小于 `target` 的元素，**因此索引 i 就是插入点**。

```java
/* 二分查找插入点（存在重复元素） */
int binarySearchInsertion(int[] nums, int target) {
    int i = 0, j = nums.length - 1; // 初始化双闭区间 [0, n-1]
    while (i <= j) {
        int m = i + (j - i) / 2; // 计算中点索引 m
        if (nums[m] < target) {
            i = m + 1; // target 在区间 [m+1, j] 中
        } else if (nums[m] > target) {
            j = m - 1; // target 在区间 [i, m-1] 中
        } else {
            j = m - 1; // 首个小于 target 的元素在区间 [i, m-1] 中
        }
    }
    // 返回插入点 i
    return i;
}
```

### 二分查找边界

给定一个长度为 n 的有序数组 `nums` ，其中可能包含重复元素。

**查找左边界**

和上一个思路一样

```java
/* 二分查找最左一个 target */
int binarySearchLeftEdge(int[] nums, int target) {
    // 等价于查找 target 的插入点
    int i = binary_search_insertion.binarySearchInsertion(nums, target);
    // 未找到 target ，返回 -1
    if (i == nums.length || nums[i] != target) {
        return -1;
    }
    // 找到 target ，返回索引 i
    return i;
}
```

**查找右边界**

复用查找左边界

```java
/* 二分查找最右一个 target */
int binarySearchRightEdge(int[] nums, int target) {
    // 转化为查找最左一个 target + 1
    int i = binary_search_insertion.binarySearchInsertion(nums, target + 1);
    // j 指向最右一个 target ，i 指向首个大于 target 的元素
    int j = i - 1;
    // 未找到 target ，返回 -1
    if (j == -1 || nums[j] != target) {
        return -1;
    }
    // 找到 target ，返回索引 j
    return j;
}
```

![将查找右边界转化为查找左边界](https://www.hello-algo.com/chapter_searching/binary_search_edge.assets/binary_search_right_edge_by_left_edge.png)

**转化为查找元素**

构造一个数组中不存在的元素，用于查找左右边界。

- 查找最左一个 `target` ：可以转化为查找 `target - 0.5` ，并返回指针 i 。
- 查找最右一个 `target` ：可以转化为查找 `target + 0.5` ，并返回指针 j 。

![将查找边界转化为查找元素](https://www.hello-algo.com/chapter_searching/binary_search_edge.assets/binary_search_edge_by_element.png)

## 排序

理想的排序算法具有以下特性：

- **稳定性**：稳定排序在完成排序后，相等元素在数组中的相对顺序不发生改变。

```yaml
# 输入数据是按照姓名排序好的
# (name, age)
  ('A', 19)
  ('B', 18)
  ('C', 21)
  ('D', 19)
  ('E', 23)

# 假设使用非稳定排序算法按年龄排序列表，
# 结果中 ('D', 19) 和 ('A', 19) 的相对位置改变，
# 输入数据按姓名排序的性质丢失
  ('B', 18)
  ('D', 19)
  ('A', 19)
  ('C', 21)
  ('E', 23)
```

- **就地性**：无须借助额外的辅助数组，从而节省内存。通常情况下，原地排序的数据搬运操作较少，运行速度也更快。
- **自适应性**：能够利用输入数据已有的顺序信息来减少计算量，达到更优的时间效率。自适应排序算法的最佳时间复杂度通常优于平均
- **是否基于比较**：基于比较的排序依赖比较运算符（<、=、>）来判断元素的相对顺序，从而排序整个数组，理论最优时间复杂度为 O(nlog⁡n) 。而非比较排序不使用比较运算符，时间复杂度可达 O(n) ，但其通用性相对较差。

![Picture2.png](https://pic.leetcode-cn.com/1629483637-tmENTT-Picture2.png)

### 冒泡排序（bubble sort）

从数组最左端开始向右遍历，依次比较相邻元素大小，如果“左元素 > 右元素”就交换二者。遍历完成后，最大的元素会被移动到数组的最右端。每次都成功排好一个元素，所以需要循环n-1轮，每轮比较n-i个数。

```java
/* 冒泡排序 */
void bubbleSort(int[] nums) {
    // 外循环：未排序区间为 [0, i]
    for (int i = nums.length - 1; i > 0; i--) {
        // 内循环：将未排序区间 [0, i] 中的最大元素交换至该区间的最右端
        for (int j = 0; j < i; j++) {
            if (nums[j] > nums[j + 1]) {
                // 交换 nums[j] 与 nums[j + 1]
                int tmp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = tmp;
            }
        }
    }
}
```

**效率优化**：如果某轮“冒泡”中没有执行任何交换操作，说明数组已经完成排序，可直接返回结果。因此，可以增加一个标志位 `flag` 来监测这种情况，一旦出现就立即返回。

### 快速排序（quick sort）

基于分治策略。

快速排序的核心操作是“哨兵划分”，其目标是：选择数组中的某个元素作为“基准数”，将所有小于基准数的元素移到其左侧，而大于基准数的元素移到其右侧。

1. 选取数组最左端元素作为基准数，初始化两个指针 `i` 和 `j` 分别指向数组的两端。
2. 设置一个循环，在每轮中使用 `i`（`j`）分别寻找第一个比基准数大（小）的元素，然后交换这两个元素。
3. 循环执行步骤 `2.` ，直到 `i` 和 `j` 相遇时停止，最后将基准数交换至两个子数组的分界线。（分界线的数一定小于基准数）

哨兵划分完成后，原数组被划分成三部分：左子数组、基准数、右子数组，且满足“左子数组任意元素 ≤ 基准数 ≤ 右子数组任意元素”。因此，我们接下来只需对这两个子数组进行排序。

> 哨兵划分的实质是将一个较长数组的排序问题简化为两个较短数组的排序问题。

```java
/* 元素交换 */
void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}

/* 哨兵划分 */
int partition(int[] nums, int left, int right) {
    // 以 nums[left] 为基准数
    int i = left, j = right;
    while (i < j) {
        while (i < j && nums[j] >= nums[left])
            j--;          // 从右向左找首个小于基准数的元素
        while (i < j && nums[i] <= nums[left])
            i++;          // 从左向右找首个大于基准数的元素
        swap(nums, i, j); // 交换这两个元素
    }
    swap(nums, i, left);  // 将基准数交换至两子数组的分界线
    return i;             // 返回基准数的索引
}

/* 快速排序 */
void quickSort(int[] nums, int left, int right) {
    // 子数组长度为 1 时终止递归
    if (left >= right)
        return;
    // 哨兵划分
    int pivot = partition(nums, left, right);
    // 递归左子数组、右子数组
    quickSort(nums, left, pivot - 1);
    quickSort(nums, pivot + 1, right);
}
```

**基准数优化**:随机选取一个元素作为基准数。或者为了进一步改进，我们可以在数组中选取三个候选元素（通常为数组的首、尾、中点元素），并将这三个候选元素的**中位数**作为基准数。

```java
/* 选取三个候选元素的中位数 */
int medianThree(int[] nums, int left, int mid, int right) {
    int l = nums[left], m = nums[mid], r = nums[right];
    if ((l <= m && m <= r) || (r <= m && m <= l))
        return mid; // m 在 l 和 r 之间
    if ((m <= l && l <= r) || (r <= l && l <= m))
        return left; // l 在 m 和 r 之间
    return right;
}

/* 哨兵划分（三数取中值） */
int partition(int[] nums, int left, int right) {
    // 选取三个候选元素的中位数
    int med = medianThree(nums, left, (left + right) / 2, right);
    // 将中位数交换至数组最左端
    swap(nums, left, med);
    ...
}
```

**尾递归优化**：在某些输入下，快速排序可能占用空间较多。例如在输入数组完全倒序时，递归深度会达到 N，即 最差空间复杂度 为 O(N)。我们可以在每轮哨兵排序完成后，比较两个子数组的长度，**仅对较短的子数组进行递归**。由于较短子数组的长度不会超过 n/2 ，因此这种方法能确保递归深度不超过 log⁡n ，从而将最差空间复杂度优化至 O(log⁡n) 。

```java
/* 快速排序（尾递归优化） */
void quickSort(int[] nums, int left, int right) {
    // 子数组长度为 1 时终止
    while (left < right) {
        // 哨兵划分操作
        int pivot = partition(nums, left, right);
        // 对两个子数组中较短的那个执行快速排序
        if (pivot - left < right - pivot) {
            quickSort(nums, left, pivot - 1); // 递归排序左子数组
            left = pivot + 1; // 剩余未排序区间为 [pivot + 1, right]
        } else {
            quickSort(nums, pivot + 1, right); // 递归排序右子数组
            right = pivot - 1; // 剩余未排序区间为 [left, pivot - 1]
        }
    }
}
```

### 归并排序（merge sort）

是一种基于分治策略的排序算法。

1. **划分阶段**：通过递归不断地将数组从中点处分开，将长数组的排序问题转换为短数组的排序问题。
2. **合并阶段**：当子数组长度为 1 时终止划分，开始合并，持续地将左右两个较短的有序数组合并为一个较长的有序数组，直至结束。

![归并排序的划分与合并阶段](https://www.hello-algo.com/chapter_sorting/merge_sort.assets/merge_sort_overview.png)

```java
/* 合并左子数组和右子数组 */
void merge(int[] nums, int left, int mid, int right) {
    // 左子数组区间为 [left, mid], 右子数组区间为 [mid+1, right]
    // 创建一个临时数组 tmp ，用于存放合并后的结果
    int[] tmp = new int[right - left + 1];
    // 初始化左子数组和右子数组的起始索引
    int i = left, j = mid + 1, k = 0;
    // 当左右子数组都还有元素时，进行比较并将较小的元素复制到临时数组中
    while (i <= mid && j <= right) {
        if (nums[i] <= nums[j])
            tmp[k++] = nums[i++];
        else
            tmp[k++] = nums[j++];
    }
    // 将左子数组和右子数组的剩余元素复制到临时数组中
    while (i <= mid) {
        tmp[k++] = nums[i++];
    }
    while (j <= right) {
        tmp[k++] = nums[j++];
    }
    // 将临时数组 tmp 中的元素复制回原数组 nums 的对应区间
    for (k = 0; k < tmp.length; k++) {
        nums[left + k] = tmp[k];
    }
}

/* 归并排序 */
void mergeSort(int[] nums, int left, int right) {
    // 终止条件
    if (left >= right)
        return; // 当子数组长度为 1 时终止递归
    // 划分阶段
    int mid = left + (right - left) / 2; // 计算中点
    mergeSort(nums, left, mid); // 递归左子数组
    mergeSort(nums, mid + 1, right); // 递归右子数组
    // 合并阶段
    merge(nums, left, mid, right);
}
```

对于链表，归并排序相较于其他排序算法具有显著优势，**可以将链表排序任务的空间复杂度优化至 O(1)** 。

- **划分阶段**：可以使用“迭代”替代“递归”来实现链表划分工作，从而省去递归使用的栈帧空间。
- **合并阶段**：在链表中，节点增删操作仅需改变引用（指针）即可实现，因此合并阶段（将两个短有序链表合并为一个长有序链表）无须创建额外链表。

## 回溯

度优先搜索算法

尝试、回退、剪枝

`state` 表示问题的当前状态，`choices` 表示当前状态下可以做出的选择：

```java
/* 回溯算法框架 */
void backtrack(State state, List<Choice> choices, List<State> res) {
    // 判断是否为解
    if (isSolution(state)) {
        // 记录解
        recordSolution(state, res);
        // 不再继续搜索
        return;
    }
    // 遍历所有选择
    for (Choice choice : choices) {
        // 剪枝：判断选择是否合法
        if (isValid(state, choice)) {
            // 尝试：做出选择，更新状态
            makeChoice(state, choice);
            backtrack(state, choices, res);
            // 回退：撤销选择，恢复到之前的状态
            undoChoice(state, choice);
        }
    }
}
```

> 多注意回退

## 分治

分治通常基于递归实现，包括“分”和“治”两个步骤。

1. **分（划分阶段）**：递归地将原问题分解为两个或多个子问题，直至到达最小子问题时终止。
2. **治（合并阶段）**：从已知解的最小子问题开始，从底至顶地将子问题的解进行合并，从而构建出原问题的解。

常见算法：二分查找、归并排序、快速排序、桶排序、树、堆、哈希表

判断是否是分治算法问题的依据包括：问题能否分解、子问题是否独立、子问题能否合并。

## 动态规划

适用于可以穷举解决，状态之间有关联，求的是最优而不是全部方案。

特点：

1. **重叠子问题**
2. **最优子结构**：原问题的最优解是从子问题的最优解构建得来的。
3. **无后效性**：给定一个确定的状态，它的未来发展只与当前状态有关，而与过去经历的所有状态无关。

求解步骤：

1. 思考每轮的决策，定义状态，从而得到 dp 表
2. 找出最优子结构，进而推导出状态转移方程
3. 确定边界条件和状态转移顺序

## 贪心

在问题的每个决策阶段，都选择当前看起来最优的选择，即贪心地做出局部最优的决策，以期获得全局最优解。

- **贪心选择性质**：只有当局部最优选择始终可以导致全局最优解时，贪心算法才能保证得到最优解。
- **最优子结构**：原问题的最优解包含子问题的最优解。
