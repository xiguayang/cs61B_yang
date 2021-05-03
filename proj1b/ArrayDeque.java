public class ArrayDeque<T> implements Deque<T>{
    private int size;
    private T[] items;
    private int head;
    private int tail;
    private int capacity = 8;
    private static final int FACTOR=2;
    private static final int MCAPACITY = 16; // The minimum capacity for contraction resizing
    private static final double MRATIO = 0.25; // The minimum usage ratio before contraction

    /**Create an empty array deque*/
    public ArrayDeque(){
        size = 0;
        items = (T[])new Object[8];
        head = 0;
        tail = 0;
    }

    /**Create an deep copy of other
     * @Rule: Creating a deep copy means that you create an entirely new ArrayDeque,
     * with the exact same items as other.
     * However, they should be different objects,
     * i.e. if you change other,
     * the new ArrayDeque you created should not change as well*/
    public ArrayDeque(ArrayDeque other){
        System.arraycopy(other,0,this.items,0,size);
    }

    public int getCapacity(){
        return capacity;
    }
    /** Returns the number of items in the deque
     * @Rule: Must take constant time;
     */
    @Override
    public int size(){
        return size;
    }

    /**A helper method for addLast: tail move one step to the right
     * if reaches the end of the right, take a loop to the left*/
    private int onePlus(int index){
        return (index+1) % capacity;
    }

    /**Add one item at he right of the tail
     * @Rule: must take constant time, except during resizing operation*/
    @Override
    public void addLast(T x){

        // head and tail are both at position 0 if size = 0
        // no matter addFirst or addLast, add the first item just change items[0], don't move head or tail
        //--empty array--
        //[], [], [], []
        //h/t
        //---with one element
        //[x], [], [], []
        //h/t
        if(isEmpty()){
            items[0]=x;
            size++;
        }else {
            //the array is full, then need resize
            if(size == capacity) {
                expandSize(capacity * FACTOR);
            }
            tail = onePlus(tail);//move the tail pointer to the next one and add x at the new postion
            items[tail] = x;
            size++;
        }
    }

    /**A helper method that expand the size when the ArrayDeque is full
     * expandSize: actually rearrange the array:
     * from head position to the right =>the new array's left (start from 0),so the head is at 0 again
     * other elements to tail=> the new array's right, so the tail is at then end of original array
     */
    private void expandSize(int newCap){
        T[] copy = (T[])new Object[newCap];
        // copy array into new array
        //move the items at head position and items right of head
        //to the left of the new array
        int sizeOfCopytoLeft = items.length - head;
        System.arraycopy(items, head, copy, 0,sizeOfCopytoLeft );
        //the remaining items copy to right
        System.arraycopy(items,0,copy,sizeOfCopytoLeft,size-sizeOfCopytoLeft);
        items = copy;
        capacity=newCap;
        head = 0;
        tail = size-1;
    }
    /**A helper method for addLast: head move one step to the left
     * if reaches the end of the left, take a loop to the right*/
    private int oneMinus(int index){
        return (capacity+index-1) % capacity;
    }
    /**Add one item at he left of the head
     * @Rule: must take constant time, except during resizing operation*/
    @Override
    public void addFirst(T x){
        if(isEmpty()){
            items[0]=x;
            size++;
        }else {
            //the array is full, then need resize
            if(size == capacity) {
                expandSize(capacity * FACTOR);
            }
            head=oneMinus(head);//move the head pointer to the next one
            items[head]=x;
            size++;
        }

    }

    /** Returns the item of the ArrayDeque at the given index i
     * @Rule: Must take constant time;
     */
    @Override
    public T get(int i){
        if(isEmpty()){
            return null;
        }
        //the first element is at the head, i =0
        return items[(head+i)%capacity];
    }

    /**A helper method that helps the array contract while it's ration <0.25 and length >=16*/
    private void downSize(int newCap){
        T[] copy = (T[])new Object[newCap];
        int sizeOfCopytoLeft = tail- head+1;
        System.arraycopy(items, head, copy, 0,sizeOfCopytoLeft );
        //System.arraycopy(items,0,copy,sizeOfCopytoLeft,size-sizeOfCopytoLeft);
        items = copy;
        capacity=newCap;
        head = 0;
        tail = capacity-1-size()-1;
    }
    /** Returns the removed item of the ArrayDeque from First
     * @Rule: Must take constant time except downsize
     */
    @Override
    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        T removedItem = items[head];
        head = onePlus(head);
        size--;
        double rate = (double)size/capacity;
        if( rate<MRATIO & capacity>=MCAPACITY ){
            downSize(capacity/2);
        }
        return removedItem;
    }
    /** Returns the removed item of the ArrayDeque from Last
     * @Rule: Must take constant time except downsize
     */
    @Override
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        T removedItem = items[tail];
        tail = oneMinus(tail);
        size--;
        double rate = (double)size/capacity;
        if( rate<MRATIO & capacity>=MCAPACITY ){
            downSize(capacity/2);
        }
        return removedItem;
    }



    @Override
    public T getRecursive(int index) {
        return null;
    }
}
