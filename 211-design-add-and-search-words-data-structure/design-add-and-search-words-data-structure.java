class WordDictionary {
    Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }
    
    public void addWord(String word) {
        trie.insert(word);
    }
    
    public boolean search(String word) {
        return trie.search(word);
    }
}


class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                TrieNode newNode = new TrieNode();
                curr.children.put(c, newNode);
                curr = newNode;
            }
        }
        curr.endOfWord = true;
    
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        return searchHelper(word, curr);
    }
    
    public boolean searchHelper(String word, TrieNode root) {
        //boolean res = false;
        TrieNode curr = root;
        if(curr == null) {
            return false;
        }
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            boolean res = false;
            if(c == '.') {
                for(char ch : curr.children.keySet()) {
                    res = res || searchHelper(word.substring(i + 1), curr.children.get(ch));
                }
                return res;
            } else if(!curr.children.containsKey(c)) {
                return false;
            } else {
                curr = curr.children.get(c);
            }
        }
        return curr.endOfWord == true ? true : false;
    }
}

class TrieNode {
    Map<Character,TrieNode> children;
    boolean endOfWord;

    TrieNode() {
        children = new HashMap<>();
        endOfWord = false;
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */