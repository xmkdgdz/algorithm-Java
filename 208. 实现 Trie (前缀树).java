/* 
    前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补全和拼写检查。
    请你实现 Trie 类
    本题字符串均为小写字母
  */

class Trie {

    private Trie[] children; // 长度26的树数组，如果不为空，代表有字符串包含这个字母
    private boolean isEnd; // 是否为某个字符串的结尾，这样才能search

    // 初始化前缀树对象
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    // 向前缀树中插入字符串 word 
    public void insert(String word) {
        Trie t = this;
        for (char c: word.toCharArray()) {
            int i = c - 'a';
            if (t.children[i] == null) {
                t.children[i] = new Trie();
            }
            t = t.children[i];
        }
        t.isEnd = true;
    }
    
    // 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false
    public boolean search(String word) {
        Trie t = this;
        for (char c: word.toCharArray()) {
            int i = c - 'a';
            if (t.children[i] == null) {
                return false;
            }
            t = t.children[i];
        }
        return t.isEnd;
    }
    
    // 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false
    public boolean startsWith(String prefix) {
        Trie t = this;
        for (char c: prefix.toCharArray()) {
            int i = c - 'a';
            if (t.children[i] == null) {
                return false;
            }
            t = t.children[i];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */