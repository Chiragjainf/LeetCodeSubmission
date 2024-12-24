class TrieNode {
    HashMap<Character, TrieNode> childrens;
    boolean endOfWord = false;
    TrieNode(HashMap<Character, TrieNode> children, boolean endOfWord) {
        this.childrens = children;
        this.endOfWord = endOfWord;
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode(new HashMap<>(), false);
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            if(!curr.childrens.containsKey(c)) {
                TrieNode node = new TrieNode(new HashMap<>(), false);
                curr.childrens.put(c, node);
            }
            curr = curr.childrens.get(c);
        }
        curr.endOfWord = true;
        
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            if(!curr.childrens.containsKey(c)) {
                return false;
            }
            curr = curr.childrens.get(c);
        }
        return curr.endOfWord == true ? true : false;
    }
    
    public boolean startsWith(String prefix) {

        TrieNode curr = root;
        for(char c: prefix.toCharArray()) {
            if(!curr.childrens.containsKey(c)) {
                return false;
            }
            curr = curr.childrens.get(c);
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