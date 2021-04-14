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
