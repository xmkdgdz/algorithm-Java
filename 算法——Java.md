# 算法——Java

## 线性数据结构

### 数组（array）

```java
// 初始化
int[] array = new int[5]; // 默认值为 0
// 元素赋值
array[0] = 2;
array[1] = 3;
array[2] = 1;
array[3] = 0;
array[4] = 2;

// 初始化
int[] array = {2, 3, 1, 0, 2};


// 遍历数组

// 通过索引遍历数组
for (int i = 0; i < array.length; i++)
// 直接遍历数组元素
for (int i : array)
```

内存地址连续，可以存储固定大小的相同类型的元素

- **优点：** 随机访问元素效率高。
- **缺点：** 大小固定，插入和删除元素相对较慢。

> 插入和删除需要改变后面的所有元素

### 链表

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

### 列表（Lists）

列表可以基于链表或数组实现

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

### 栈（stack）

先入后出























### 队列（queue）

先入先出