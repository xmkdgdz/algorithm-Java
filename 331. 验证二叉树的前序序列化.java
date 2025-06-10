/* 序列化二叉树的一种方法是使用 前序遍历 。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 */

// 方法一：栈
/* 如果两个节点都是#，说明它是叶子节点，出栈，也转化为# */
class Solution {
    public boolean isValidSerialization(String preorder) {
        List<String> stk = new ArrayList<>();
        for (String s: preorder.split(",")) {
            stk.add(s);
            while (stk.size() >= 3 
            && stk.get(stk.size() - 1).equals("#")
            && stk.get(stk.size() - 2).equals("#")
            && !stk.get(stk.size() - 3).equals("#")) {
                stk.removeLast();
                stk.removeLast();
                stk.removeLast();
                stk.add("#");
            }
        }
        return stk.size() == 1 && stk.get(stk.size() - 1).equals("#");
    }
}

// 方法二：递归反序列化
class Solution2 {
    public boolean isValidSerialization(String preorder) {
        // 将字符串转化成列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : preorder.split(",")) {
            nodes.addLast(s);
        }
        return deserialize(nodes) && nodes.isEmpty();
    }

    // 改造后的前序遍历反序列化函数
    // 详细解析：https://labuladong.online/algo/data-structure/serialize-and-deserialize-binary-tree/
    boolean deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return false;
        }

        // ***** 前序遍历位置 *****
        // 列表最左侧就是根节点
        String first = nodes.removeFirst();
        if (first.equals("#")) return true;
        // *********************

        return deserialize(nodes) && deserialize(nodes);
    }
}

// 方法三：记录边的规律
class Solution {
    public boolean isValidSerialization(String preorder) {
        // 一条指向根节点的虚拟边
        int edge = 1;
        for (String node : preorder.split(",")) {
            // 任何时候，边数都不能小于 0
            if (node.equals("#")) {
                // 空指针消耗一条空闲边
                edge -= 1;
                if (edge < 0) {
                    return false;
                }
            } else {
                // 非空节点消耗一条空闲边，增加两条空闲边
                edge -= 1;
                if (edge < 0) {
                    return false;
                }
                edge += 2;
            }
        }
        // 最后不应该存在空闲边
        return edge == 0;
    }
}