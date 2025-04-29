/* 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。

例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 */

/* 实际上是一个拓扑排序类题目：针对有向无环图，以什么样的顺序能遍历所有节点（答案不唯一） */

// 方法一：BFS
// 时间复杂度: O(n+m)，空间复杂度: O(n+m)
/* 先访问入度为0的节点，然后改变其后继节点，就有了新的入度为0的节点，继续访问。如果最后还有入度不为0的，则有环 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>(); // 图的邻接表
        int[] indeg = new int[numCourses]; // 入度数组
        // 初始化图和入度
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        for (int[] edge: prerequisites) {
            edges.get(edge[1]).add(edge[0]);
            ++indeg[edge[0]];
        }
        // 初始化队列,第一批入度为0的节点
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                que.offer(i);
            }
        }

        while (!que.isEmpty()) {
            --numCourses;
            int course = que.poll();
            for (int x: edges.get(course)) {
                --indeg[x];
                if (indeg[x] == 0) {
                    que.offer(x);
                }
            }
        }
        // 访问结束后还有课程没访问到,有环
        return numCourses == 0;
    }
}

// 方法二：DFS
/* 
    思路：https://leetcode.cn/problems/course-schedule/solutions/359392/ke-cheng-biao-by-leetcode-solution
 */
class Solution {
    List<List<Integer>> edges;
    int[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 初始化图
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        for (int[] edge: prerequisites) {
            edges.get(edge[1]).add(edge[0]);
        }
        // 
        /* 
            记录访问状态：
            0 未搜索：还没访问过
            1 搜索中：子节点还没搜索完
            2 已完成：所有子节点都搜索完并且记录了，该节点此时一定在所有后继节点之前
        */
        visited = new int[numCourses];

        for (int i = 0; i < numCourses; ++i) {
            // 从一个未搜索节点开始DFS
            if (visited[i] == 0) {
                if (!dfs(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean dfs(int u) {
        // 0 -> 1
        visited[u] = 1;
        // u是第一次被搜索到，正常来讲所有后继节点要么第一次被搜索到为0，要么曾经dfs过所以应该为2
        for (int v: edges.get(u)) {
            // 如果v是1，说明u是被v搜索一圈之后访问到的，存在环
            if (visited[v] == 1) {
                return false;
            }
            if (visited[v] == 0) {
                if (!dfs(v)) {
                    return false;
                }
            }
        }
        // 没有false过，说明子节点全成功搜索
        visited[u] = 2;
        return true;
    }
}