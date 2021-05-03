public interface Deque<T> {

    default public boolean isEmpty(){
        if(size() == 0 ){
            return true;
        }else{
            return false;
        }
    }

    public int size();
    public void addFirst(T item);
    public T removeFirst();
    public void addLast(T item);
    public T removeLast();

    public T get(int index);
    public T getRecursive(int index);

    default public void printDeque(){
        if(!this.isEmpty()){
            for(int i =0;i<size();i++) {
                System.out.print(this.get(i)+" ");
            }
            System.out.println();
        }else{
            System.out.println("This deque is empty");
        }
    }
}
