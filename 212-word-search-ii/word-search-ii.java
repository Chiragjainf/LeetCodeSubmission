class Solution {

    TrieNode root;
    Set<String> res;
    public Solution() {
        res = new HashSet<>();
        root = new TrieNode(new HashMap<>(), false);
    }
    


    public List<String> findWords(char[][] board, String[] words) {

        for(String word: words) {
            insert(word);
        }


        int m = board.length, n = board[0].length;
        boolean vis[][] = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                search(board, i, j, m, n, root, vis, "");
            }
        }    
        return new ArrayList<>(res);
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

    public void search(char[][] board, int r, int c, int m, int n, TrieNode root, boolean vis[][], String temp) {


        if(r < 0 || c < 0 || r >= m || c >= n || vis[r][c] == true || !root.childrens.containsKey(board[r][c])) {
            return;
        }
        TrieNode curr = root;
        char ch = board[r][c];
        vis[r][c] = true;
        curr = curr.childrens.get(ch);
        
        if(curr.endOfWord == true) {
            res.add(temp + ch);
        }

        search(board, r + 1, c, m, n, curr, vis, temp + ch);
        search(board, r - 1, c, m, n, curr, vis, temp + ch);
        search(board, r , c  + 1, m, n, curr, vis, temp + ch);
        search(board, r , c - 1, m, n, curr, vis, temp + ch);
        vis[r][c] = false; 

    }
    
    // public boolean search(String word) {
    //     TrieNode curr = root;
    //     for(char c: word.toCharArray()) {
    //         if(!curr.childrens.containsKey(c)) {
    //             return false;
    //         }
    //         curr = curr.childrens.get(c);
    //     }
    //     return curr.endOfWord == true ? true : false;
    // }
    
}


class TrieNode {
    HashMap<Character, TrieNode> childrens;
    boolean endOfWord = false;
    TrieNode(HashMap<Character, TrieNode> children, boolean endOfWord) {
        this.childrens = children;
        this.endOfWord = endOfWord;
    }
}