class LRUCache {

    Map<Integer, Node> mp;
    int capacity;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        mp = new HashMap<>();
        this.capacity = capacity;
        left = new Node(0,0);
        right = new Node(0,0);
        left.next = right;
        right.prev = left;
    }

    public void remove(Node node) {

        Node prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void addLast(Node node) {

        Node prev = right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
    }




    public int get(int key) {

        if(mp.containsKey(key)) {

            Node node = mp.get(key);
            //remove from list
            remove(node);
            //add it to last
            addLast(node);
            return mp.get(key).value;

        }

        return -1;
        
    }
    
    public void put(int key, int value) {

        if(mp.containsKey(key)) {
            remove(mp.get(key));
        }

        Node node = new Node(key, value);
        mp.put(key, node);
        //add it to last
        addLast(node);

        if(mp.size() > capacity) {
            //System.out.println(key);
            //System.out.println(left.next.key);
            mp.remove(left.next.key);
            remove(left.next);
            //System.out.println(left.next.key);

        }
        
    }
}



class Node {
    int key;
    int value;
    Node prev = null;
    Node next = null;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */