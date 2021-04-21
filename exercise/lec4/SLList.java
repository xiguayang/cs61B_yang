/** An SLList is a list of integers, which hides the
* terrible truch of the nakedness within.*/
public class SLList{

  private static class IntNode{
    public int item;
    public IntNode next;

    public IntNode(int i, IntNode n){
      item = i;
      next = n;
    }
  }

  /**The first item (if it exists) is at sentinel.next*/
  private IntNode sentinel;
  private int size;
  /**Creates an empty SLList*/
  public SLList(){
    sentinel  = new IntNode(63,null);
    size = 0;
  }

  public SLList(int x ){
    sentinel = new IntNode(63,null);
    sentinel.next = new IntNode(x,null);
    size = 1;
  }
  /**A constructor that takes in an array of integers*/
  public SLList(int[] arr ){
    sentinel = new IntNode(63,null);
    for(int i = arr.length -1;i>=0;i--){
      sentinel.next = new IntNode(arr[i],null);
      size = size+1;
    }
  }

  /**Adds x to the front of the list*/
  public void addFirst(int x ){
    sentinel.next = new IntNode(x,sentinel.next);
    size+=1;
  }

  /**Returns the first item of the list*/
  public int getFirst(){
    return sentinel.next.item;
  }

  /**Adds x to the end of the list*/
  public void addLast(int x){
    size+=1;
    /**One solution to fix the bug addLast for an empty list*/
    /*
    if(first == null){
      first = new IntNode(x,null);
      return;
    }
    */
    IntNode p = sentinel;
    /*Move p until it reaches the end of  the list*/
    while(p.next !=null){
      p = p.next;
    }
    p.next = new IntNode(x,null);

  }

  /**Returns the size of the list
   * this is slow and inefficient
  private static int size(IntNode p){
    if(p.next == null){
      return 1;
    }
    return 1 + size(p.next);
  }

  public int size(){
    return size(first);
  }*/

  /** which is method by yang
  public int size(){
    int size = 0;
    IntNode p = first;
    while(p.next!=null){
      p = p.next;
      size= size+1;
    }
    size+=1;
    return size;
  }
  */
  /**Returns the size of the list*/
  public int size(){
    return size;
  }

  /**deleteFirst which deletes the first elements from the list*/
  public void deleteFirst(){
    size = size -1;
    sentinel.next = sentinel.next.next;
  }

  /**DISC03 EXERCISE1.1
  *Implement SLList.insert which takes in an integer x and an integer position.
  *It inserts x at the given position.
  *If position is after the end of the list, insert the new node at the end.
  *For example, if the SLList is 5 → 6 → 2, insert(10, 1) results in 5 → 10 → 6 → 2
  *and if the SLList is 5 → 6 → 2, insert(10, 7) results in 5 → 6 → 2 → 10.
  *Additionally, for this problem assume that position is a non-negative integer.*/
  public void insert(int x, int position){
    //if the list is empty or add the item in the first position
    if(sentinel.next ==null || position == 0){
      addFirst(x);
      return;
    }
    //use the currentP to track the position to add
    IntNode currentP = sentinel.next;
    while(position>1 && currentP.next!=null){
      currentP = currentP.next;
      position = position -1;
    }
    IntNode newNode = new IntNode(x,currentP.next);
    currentP.next = newNode;
  }

  /**DISC03 EXERCISE1.2
  *Add another method to the SLList class that reverses the elements.
  *Do this using the existing IntNode objects (you should not use new).*/
  public void reverse(){
    //if it is empty list or only one node
    if(sentinel.next == null ||size()==1){
      return;
    }
    //actually reverse all the pointers between nodes
    IntNode first = sentinel.next;
    IntNode ptr = first.next;
    //the first node point to null, turned to be the last node
    first.next =null;
    //ptr move from the left to the right until the last one
    while(ptr!=null){
      //temp used to temperaturelly store the next node after ptr
      IntNode temp = ptr.next;
      //ptr is the node which needs to reverse its pointer to the previous node
      ptr.next = first;
      //the sentinel point to the ptr
      first = ptr;
      //move to the next node
      ptr = temp;
    }
  }


  public static void main(String[] args) {
    /*Creates a list of one integer, namely 10*/
    SLList L = new SLList(10);
    L.addFirst(15);
    L.addFirst(5);
    L.addLast(18);
    System.out.println(L.getFirst());
    System.out.println(L.size());
    L.deleteFirst();
    System.out.println(L.getFirst());
    System.out.println(L.size());
    SLList L2 = new SLList();
    L2.addLast(100);
    System.out.println(L2.getFirst());
    System.out.println(L2.size());

    int abc[] = {7,4,22,11};
    SLList L3 = new SLList(abc);
    System.out.println(L3.getFirst());
    System.out.println(L3.size());
  }
}
