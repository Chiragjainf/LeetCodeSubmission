class MyCircularQueue {

    int arr[];
    int front;
    int size;
    int capacity;

    public MyCircularQueue(int k) {
        arr = new int[k];
        front = 0;
        size = 0;
        capacity = k;
    }
    
    public boolean enQueue(int value) {
        if(size == capacity) {
            return false;
        }


        int rear = (front + size) % capacity;

        arr[rear] = value;

        size++;

        return true;
    }
    
    public boolean deQueue() {
        if(size == 0) {
            return false;
        }

        front++;

        size--;

        return true;

    }
    
    public int Front() {
        if(size == 0) {
            return -1;
        } 

        return arr[front % capacity];
    }
    
    public int Rear() {
        if(size == 0) {
            return -1;
        } 

        int rear = (front + size - 1) % capacity;

        return arr[rear];
    }
    
    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if(size == capacity) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */