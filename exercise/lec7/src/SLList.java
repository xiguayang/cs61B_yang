/** An SLList is a list of T items, which hides the
* terrible truch of the nakedness within.*/
public class SLList<T> implements List61B<T>{

  private static class TNode<T> {
    public T item;
    public TNode next;

    public TNode(T i, TNode n) {
      item = i;
      next = n;
    }
  }

  /**The first item (if it exists) is at sentinel.next*/
  private TNode sentinel;
  private int size;
  /**Creates an empty SLList*/
  public SLList(){
    sentinel  = new TNode(null,null);
    size = 0;
  }

  public SLList(T x ){
    sentinel = new TNode(null,null);
    sentinel.next = new TNode(x,null);
    size = 1;
  }
  /**A constructor that takes in an array of integers*/
  public SLList(int[] arr ){
    sentinel = new TNode(null,null);
    for(int i = arr.length -1;i>=0;i--){
      sentinel.next = new TNode(arr[i],null);
      size = size+1;
    }
  }

  /**Adds x to the front of the list*/
  @Override
  public void addFirst(T x ){
    sentinel.next = new TNode(x,sentinel.next);
    size+=1;
  }
  @Override
  /**Returns the first item of the list*/
  public T getFirst(){
    TNode first = sentinel.next;
    return (T) first.item;
  }
  /**A helper method that returns the back node of the list*/
  private TNode getLastNode(){
    TNode p = sentinel;
    /*Move p until it reaches the end*/
    while(p.next!=null){
      p = p.next;
    }
    return p;
  }
  @Override
  /**Returns the last item of the list*/
  public T getLast() {
    TNode back = getLastNode();
    return (T)back.item;
  }

  /**Adds x to the end of the list*/
  @Override
  public void addLast(T x){
    size+=1;
    /**One solution to fix the bug addLast for an empty list*/
    /*
    if(first == null){
      first = new IntNode(x,null);
      return;
    }
    */
    TNode p = sentinel;
    /*Move p until it reaches the end of  the list*/
    while(p.next !=null){
      p = p.next;
    }
    p.next = new TNode(x,null);

  }

  /**Returns the size of the list*/
  @Override
  public int size(){
    return size;
  }

  /**deleteFirst which deletes the first elements from the list*/
  public void deleteFirst(){
    size = size -1;
    sentinel.next = sentinel.next.next;
  }

  /**Remove the last element of the list and return it*/
  @Override
  public T removeLast() {
    TNode back = getLastNode();
    /*Empty List*/
    if(back ==sentinel){
      return null;
    }
    TNode p = sentinel;
    /*Move the p to the second last Node*/
    while(p.next!=back){
      p=p.next;
    }
    p.next = null;
    return (T) back.item;
  }

  @Override
  public T get(int position) {
    if(position == 0 ){
      return getFirst();
    }
    /*currentNode in the position 1*/
    TNode currentNode = sentinel.next.next;
    while(position >1 && currentNode.next!=null){
      position = position -1;
      currentNode = currentNode.next;
    }
    return (T)currentNode.item;
  }

  /**DISC03 EXERCISE1.1
  *Implement SLList.insert which takes in an integer x and an integer position.
  *It inserts x at the given position.
  *If position is after the end of the list, insert the new node at the end.
  *For example, if the SLList is 5 → 6 → 2, insert(10, 1) results in 5 → 10 → 6 → 2
  *and if the SLList is 5 → 6 → 2, insert(10, 7) results in 5 → 6 → 2 → 10.
  *Additionally, for this problem assume that position is a non-negative integer.*/
  @Override
  public void insert(T x, int position){
    //if the list is empty or add the item in the first position
    if(sentinel.next ==null || position == 0){
      addFirst(x);
      return;
    }
    //use the currentP to track the position to add
    TNode currentP = sentinel.next;
    while(position>1 && currentP.next!=null){
      currentP = currentP.next;
      position = position -1;
    }
    TNode newNode = new TNode(x,currentP.next);
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
    TNode first = sentinel.next;
    TNode ptr = first.next;
    //the first node point to null, turned to be the last node
    first.next =null;
    //ptr move from the left to the right until the last one
    while(ptr!=null){
      //temp used to temperaturelly store the next node after ptr
      TNode temp = ptr.next;
      //ptr is the node which needs to reverse its pointer to the previous node
      ptr.next = first;
      //the sentinel point to the ptr
      first = ptr;
      //move to the next node
      ptr = temp;
    }
  }

  /**TODO: Add a print method that overrides list61b's inefficient print method*/
  @Override
  public void print(){
    System.out.println("A efficient print method in SLList overriding list61b");
    for(TNode p = sentinel.next;p!=null;p=p.next){
      System.out.print(p.item+" ");
    }
    System.out.println();
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
