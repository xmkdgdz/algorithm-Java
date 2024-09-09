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

// 排序数组
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
int compareTo(String anotherString);
int compareToIgnoreCase(String str); // 不考虑大小写
    
// 返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的
String replace(char oldChar, char newChar);

char[] toCharArray();
```

![img](https://www.runoob.com/wp-content/uploads/2013/12/java-string-1-2020-12-01.png)

**注意:**String 类是不可改变的，所以你一旦创建了 String 对象，那它的值就无法改变了。改变实际上是创建了一个新对象，会增加时间和空间复杂度。

如果需要对字符串做很多修改，那么应该选择使用 [StringBuffer & StringBuilder 类](https://www.runoob.com/java/java-stringbuffer.html)。

* StringBuilder 相较于 StringBuffer 有速度优势
* StringBuilder 的方法不是线程安全的

```java
public class RunoobTest{
    public static void main(String args[]){
        StringBuilder sb = new StringBuilder(10);
        sb.append("Runoob.."); 
        System.out.println(sb); // Runoob..
        sb.append("!");
        System.out.println(sb); // Runoob..!
        sb.insert(8, "Java");
        System.out.println(sb); // Runoob..Java!
        sb.delete(5,8);
        System.out.println(sb); // RunooJava!
        sb.deleteCharAt(2); // 删除某个
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

## 哈希表

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



