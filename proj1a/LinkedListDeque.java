import java.lang.reflect.AnnotatedType;

public class LinkedListDeque <T>{

    /*TNode with two sides links*/
    private  class TNode{
        public TNode prev;
        public T item;
        public TNode next;
        public TNode(TNode x, T i, TNode y){
            prev = x;
            item = i;
            next = y;
        }
    }

    private TNode sentinel;
    private int size;

    /**Creates an empty LinkedListDeque*/
    public LinkedListDeque(){
        sentinel  = new TNode(null,null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /*Creates a deep copy of other.
     *Creating a deep copy means that
     * you create an entirely new LinkedListDeque,
     *  with the exact same items as other.
     *  However, they should be different objects,
     * i.e. if you change other, the new LinkedListDeque you created should not change as well.
     * (Edit 2/6/2018: A walkthrough that provides a solution
     * for this copy constructor is available at https://www.youtube.com/watch?v=JNroRiEG7U4)*/
    public LinkedListDeque(LinkedListDeque other){
        sentinel = new TNode(null,null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
        for(int i = 0;i<other.size;i++) {
            addFirst((T)other.get(i));
        }
    }

    /**Adds an item of type T to the front of the deque.*/
    public void addFirst(T item){
        size+=1;
        TNode newNode = new TNode(sentinel,item,sentinel.next);
        sentinel.next = newNode;
        sentinel.next.next.prev = newNode;
    }
    /**Adds an item of type T to the back of the deque.*/
    public void addLast(T item){
        size+=1;
        TNode newNode = new TNode(sentinel.prev,item,sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
    }
    /**Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty(){
        if(sentinel.next ==sentinel && sentinel.prev == sentinel && size ==0){
            return true;
        }
        else
            return false;
    }
    /**Returns the number of items in the deque.*/
    public int size(){
        return this.size;
    }

    /**Prints the items in the deque from first to last,
     * separated by a space. Once all the items have been printed,
     * print out a new line.
     */
    public void printDeque(){
        if(!this.isEmpty()){
            for(int i =0;i<size();i++) {
                System.out.print(this.get(i)+" ");
            }
            System.out.println();
        }else{
            System.out.println("This linked list is empty");
        }
    }

    /**Removes and returns the item at the front of the deque.
     * If no such item exists, returns null*/
    public T removeFirst(){
        if(!isEmpty()){
            TNode firstNode = sentinel.next;
            sentinel.next =firstNode.next;
            firstNode.next.prev= sentinel;
            size = size-1;
            return firstNode.item;
        }
        else
            return null;
    }
    /**Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.*/
    public T removeLast(){
        if(!isEmpty()){
            TNode lastNode = sentinel.prev;
            sentinel.prev =lastNode.prev;
            lastNode.prev.next = sentinel;
            size = size -1;
            return lastNode.item;
        }
        else
            return null;
    }
    /**Gets the item at the given index,
     * where 0 is the front, 1 is the next item,and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     */
    public T get(int index){
        //out of the size
        if(index >=size){
            return null;
        }else{
            TNode p = sentinel.next;//the first node
            while(p!=sentinel && index >0){
                p=p.next;
                index =index-1;
            }
            return p.item;
        }
    }

    private T getRecursiveHelper(TNode currentNode,int index){
        if(index == 0){
            return currentNode.item;
        }
        return getRecursiveHelper(currentNode.next,index-1);
    }
    /**Same as get, but uses recursion.
     * @Rule: not alter the deque !
     * @Rule: Must use recursion !*/
    public T getRecursive(int index){
        if(index >= size){
            return null;
        }else{
            return getRecursiveHelper(sentinel.next,index);
        }
    }




}
