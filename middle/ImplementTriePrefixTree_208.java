package middle;

public class ImplementTriePrefixTree_208 {
    static void main() {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("appl"));
    }
}
class Trie {
    Trie[] next = new Trie[27];

    public Trie() {

    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            if (node.next[word.charAt(i) - 'a'] == null) {
                node.next[word.charAt(i) - 'a'] = new Trie();
            }
            node = node.next[word.charAt(i) - 'a'];
        }
        node.next[26] = new Trie();
    }

    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            if (node.next[word.charAt(i) - 'a'] == null) {
                return false;
            }
            node = node.next[word.charAt(i) - 'a'];
        }

        return node.next[26]!=null;
    }

    public boolean startsWith(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.next[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            node = node.next[prefix.charAt(i) - 'a'];
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
