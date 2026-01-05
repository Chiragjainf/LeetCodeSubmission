class MyHashSet {

    Map<Integer, Integer> hm;

    public MyHashSet() {
        hm = new HashMap<>();
    }
    
    public void add(int key) {
        if(contains(key)) {
            return;
        }
        hm.put(key , 1);
    }
    
    public void remove(int key) {
        if(!contains(key)) {
            return;
        }
        hm.remove(key);
    }
    
    public boolean contains(int key) {
        if(hm.containsKey(key)) {
            return true;
        }

        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */