/* 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，
但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，
这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。
你可以按 任何 顺序返回答案。 */

// 回溯
class Solution {
    List<String> res = new ArrayList<String>();
    String s;
    String[] tmp = new String[4];

    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        dfs(0, 0);
        return res;
    }
    // cnt：第几段  start：该段起始位置
    void dfs(int cnt, int start) {
        // 此时4段已找到且正好到了字符串末尾，说明是正确的 IP 地址
        if (cnt == 4 && start == s.length()) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 3; i++) {
                sb.append(tmp[i]);
                sb.append(".");
            }
            sb.append(tmp[3]);
            res.add(sb.toString());
            return;
        }
        // 不是正确的 IP 地址
        if (cnt == 4 || start == s.length()) return;
        // 第一个字是0，则这段只能是0
        if (s.charAt(start) == '0') {
            tmp[cnt] = "0";
            dfs(cnt + 1, start + 1);
            return;
        }
        // 遍历每种正常情况
        int ip = 0;
        for (int i = start; i < s.length(); i++) {
            // 一个个数加入 IP
            ip = ip * 10 + (s.charAt(i) - '0');
            if (ip > 255) break;
            tmp[cnt] = Integer.toString(ip);
            dfs(cnt + 1, i + 1);
        }
        return;
    }
}