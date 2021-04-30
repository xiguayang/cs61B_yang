import java.util.LinkedList;
import java.util.Queue;

class MyCircularQueue {
    private int[] items;
    private int head;
    private int tail;
    private int size;
    private int capacity;
    public MyCircularQueue(int k) {
        items = new int[k];
        head = 0;
        tail = 0;
        size =0;
        capacity=k;
    }

    public boolean enQueue(int value) {
        if(isEmpty()){
            tail=0;
            head=0;
            items[0]=value;
            size++;
            return true;
        }
        if(isFull()){
            return false;
        }else{
            tail= (tail+1) % capacity;
            items[tail] = value;
            size++;
            return true;
        }
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }else{
            head =(head+1) % capacity;
            size--;
            return true;
        }
    }

    public int Front() {
        if(!isEmpty()){
            return items[head];
        }
        return -1;
    }

    public int Rear() {
        if(!isEmpty()){
            return items[tail];
        }
        return -1;
    }

    public boolean isEmpty() {
        if (size ==0){
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if(size ==capacity){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1); // return True
        myCircularQueue.enQueue(2); // return True
        myCircularQueue.enQueue(3); // return True
        myCircularQueue.enQueue(4); // return False
        myCircularQueue.Rear();     // return 3
        myCircularQueue.isFull();   // return True
        myCircularQueue.deQueue();  // return True
        myCircularQueue.enQueue(4); // return True
        myCircularQueue.Rear();     // return 4

        // 1. Initialize a queue.
        Queue<Integer> q = new LinkedList();
        // 2. Get the first element - return null if queue is empty.
        System.out.println("The first element is: " + q.peek());
        // 3. Push new element.
        q.offer(5);
        q.offer(13);
        q.offer(8);
        q.offer(6);
        // 4. Pop an element.
        q.poll();
        // 5. Get the first element.
        System.out.println("The first element is: " + q.peek());
        // 7. Get the size of the queue.
        System.out.println("The size is: " + q.size());
    }
}
