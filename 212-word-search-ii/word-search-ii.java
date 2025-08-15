class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word : words) {
            trie.insert(word);
        }

        int m = board.length, n = board[0].length;

        boolean vis[][] = new boolean[m][n];

        TrieNode root = trie.root;
        Set<String> res = new HashSet<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(root.children.containsKey(board[i][j])) {
                    findWordsHelper(board, root, i, j, m ,n, "", res, vis);
                }
            }
        }

        //findWordsHelper(board, root.children.get(board[r][c]), r + 1, c, m , n, temp + board[r][c], res);
        return new ArrayList<>(res);

    }

    public void findWordsHelper(char[][] board, TrieNode root, int r , int c , int m, int n, String temp, Set<String> res, boolean vis[][]) {
        
        if(r < 0 || c < 0 || r >= m || c >= n || !root.children.containsKey(board[r][c]) || vis[r][c] == true) {
            return;
        }

        //System.out.println(temp);

        if(root.children.get(board[r][c]).endOfWord == true) {
            res.add(temp + board[r][c]);
        }

        vis[r][c] = true;

        findWordsHelper(board, root.children.get(board[r][c]), r + 1, c, m , n, temp + board[r][c], res, vis);
        findWordsHelper(board, root.children.get(board[r][c]), r - 1, c, m , n, temp + board[r][c], res, vis);
        findWordsHelper(board, root.children.get(board[r][c]), r, c + 1, m , n, temp + board[r][c], res, vis);
        findWordsHelper(board, root.children.get(board[r][c]), r, c - 1, m , n, temp + board[r][c], res, vis);

        vis[r][c] = false;
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
        for(char c : word.toCharArray()) {
            if(!curr.children.containsKey(c)) {
                return false;
            } else {
                curr = curr.children.get(c);
            }
        }
        return curr.endOfWord == true ? true : false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c : prefix.toCharArray()) {
            if(!curr.children.containsKey(c)) {
                return false;
            } else {
                curr = curr.children.get(c);
            }
        }
        return true;
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
