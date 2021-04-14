public class IntList{
  public int first;
  public IntList rest;

  public IntList(int f, IntList r){
    first = f;
    rest = r;
  }

  /**Return the size of the list using ...recursion*/
  public int size(){
    if(rest == null){
      return 1;
    }
    return 1 + this.rest.size();
  }

  /**Return the size of the list using no recursion*/
  public int iterativeSize(){
    IntList p = this;
    int totalSize = 0;
    while(p!=null){
      totalSize +=1;
      p = p.rest;
    }
    return totalSize;
  }

  /**Returns the ith item of this IntList*/
  public int get(int i){
    if(i==0){
      return first;
    }
    return rest.get(i-1);
  }
  /**Exercise 2.2.1: Write an addFirst method to the IntList class.
  * You'll find that the resulting method is tricky as well as inefficient.*/
  public IntList addFirst(int x ){
     return new IntList(x,this);
  }
  /**2.2guide A level question
  * We want to add a method to IntList so that
  * if 2 numbers in a row are the same,
  * we add them together and make one large node. For example:
  * 1 → 1 → 2 → 3 becomes 2 → 2 → 3 which becomes 4 → 3*/
  public void addAdjacent(){
    IntList p = this;
    if(p.rest == null){
      return;
    }
    while(p!=null){
      if(p.rest == null){
        return;
      }
      if(p.first == p.rest.first){
        p.first = p.first + p.first;
        p.rest = p.rest.rest;
      }else{
        p=p.rest;
      }
    }
  }
/**2.2guide A level question2: Square Insertion
  *Modify the IntList class so that every time you add a value you “square” the IntList.
  *For example, upon the insertion of 5, the below IntList would transform from:
  *1 => 2 to 1 => 1 => 2 => 4 => 5
  *and if 7 was added to the latter IntList, it would become
  *1 => 1 => 1 => 1 => 2 => 4 => 4 => 16 => 5 => 25 => 7
  *Additionally, you are provided the constraint that
  *you can only access the size() function one time
  *during the entire process of adding a node*/
  public void addSquareLast(int x){
    IntList p = this;
    /*add square of every element*/
    while(p.rest!=null){
      IntList squareNode = new IntList(p.first * p.first,p.rest);
      p.rest = squareNode;
      p = p.rest.rest;
    }
    /*add the x Node*/
    IntList lastNode = new IntList(x,null);
    /*square the last one*/
    IntList squareNode = new IntList(p.first*p.first,lastNode);
    p.rest =squareNode;
  }

  public static void main(String[] args) {
    IntList L = new IntList(3, null);
    L = new IntList(3,L);
    L = new IntList(2,L);
    L = new IntList(1,L);
    System.out.println(L.size());
    System.out.println(L.iterativeSize());
    System.out.println(L.get(2));
    L = L.addFirst(1);
    System.out.println(L.get(2));
    L.addSquareLast(6);
    L.addAdjacent();
  }
}
