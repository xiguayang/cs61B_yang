public interface List61B <T>{
    /** add the last item of the list*/
    public void addLast(T x) ;

    /** Returns the item from the back of the list. */
    public T getLast() ;

    /**add the first item of the list*/
    public void addFirst(T x) ;

    /** Returns the item from the front of the list. */
    public T getFirst() ;

    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) ;

    /** Returns the number of items in the list. */
    public int size() ;

    /** Remove the last item of the list and return it*/
    public T removeLast();

    /** Insert the item at the position*/
    public void insert(T x, int position);

    /**Pirnt out the entire list*/
    default public void print(){
        for(int i = 0;i <size();i++){
            System.out.print(get(i)+" ");
        }
        System.out.println();
    }
}
