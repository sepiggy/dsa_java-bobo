import java.util.TreeMap;

class Trie {

    private class Node {

        public boolean isWord;

        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
        }

        public Node() {
            this(false);
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {

        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.next.get(ch) != null) {
                cur = cur.next.get(ch);
            } else {
                cur.next.put(ch, new Node());
                cur = cur.next.get(ch);
            }
        }

        if (!cur.isWord) {
            cur.isWord = true;
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.next.get(ch) == null) {
                return false;
            }
            cur = cur.next.get(ch);
        }

        return cur.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {

        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (cur.next.get(ch) == null) {
                return false;
            }
            cur = cur.next.get(ch);
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