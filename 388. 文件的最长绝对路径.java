/* 
    dir
    ⟶ subdir1
    ⟶ ⟶ file1.ext
    ⟶ ⟶ subsubdir1
    ⟶ subdir2
    ⟶ ⟶ subsubdir2
    ⟶ ⟶ ⟶ file2.ext
    如果是代码表示，上面的文件系统可以写为 "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" 。'\n' 和 '\t' 分别是换行符和制表符。

    文件系统中的每个文件和文件夹都有一个唯一的 绝对路径 ，即必须打开才能到达文件/目录所在位置的目录顺序，所有路径用 '/' 连接。上面例子中，指向 file2.ext 的 绝对路径 是 "dir/subdir2/subsubdir2/file2.ext" 。每个目录名由字母、数字和/或空格组成，每个文件名遵循 name.extension 的格式，其中 name 和 extension由字母、数字和/或空格组成。

    给定一个以上述格式表示文件系统的字符串 input ，返回文件系统中 指向 文件 的 最长绝对路径 的长度 。 如果系统中没有文件，返回 0。 

*/

// 栈
class Solution {
    public int lengthLongestPath(String input) {
        Deque<Integer> stk = new ArrayDeque<>();
        int res = 0;
        for (String part : input.split("\n")) {
            int depth = part.lastIndexOf("\t") + 1;
            // 找到父目录
            while (depth < stk.size()) {
                stk.pop();
            }
            int len = stk.isEmpty() 
                ? part.substring(depth).length() 
                : stk.peek() + part.substring(depth).length() + 1;
            stk.push(len);
            if (part.contains(".")) {
                res = Math.max(res, len);
            }
        }
        return res;
    }
}