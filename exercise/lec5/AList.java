/** Array based list.
 *  @author YangZ
 */
//              0 1 2  3 4 5 6 7 8
//  items:    [ 6 9 -1 2 0 0 0 0 0...]
//  size :    5
/* Invariants:
    addLast: the next item we want to add, will go into position
    getLast: the item we want to return is in position size-1
    size: the number of items in the list should be size


*/
public class AList<T> {
    private T[] items;
    private int size;
    /** Creates an empty list. */
    public AList() {
      size = 0;
      items = (T[])new Object[100];
    }

    /**Resize the underlying array to the target capacity*/
    private void resize(int capacity){
      //create a new array with large size to add the last item
      T[] a = (T[])new Object[capacity];
      System.arraycopy(items, 0,a,0,size);
      items = a;
    }
    /** Inserts X into the back of the list. */
    public void addLast(T x) {
      if(size == items.length){
        resize(size*2);
      }
      items[size]= x;
      size = size+1;
    }

    /** Returns the item from the back of the list. */
    public T getLast() {
        return items[size-1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public T removeLast() {
        T removedItem = items[size-1];
        items[size-1]=null;//not hurt but not necessary
        size = size -1;
        return removedItem;
    }
}
