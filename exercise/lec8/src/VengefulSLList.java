import sun.jvm.hotspot.opto.MachNode;

/**SLList with additional operation printLostItems() which prints all items
 * that have ever been deleted*/

public class VengefulSLList<T> extends SLList<T> {
    private SLList<T> deleteItems;
    public VengefulSLList(){
        super();
        deleteItems = new SLList<>();
    }
    public VengefulSLList(T x){
        super(x);//if not call super(x),will have error because Java call default constructor super() not the specific one
        deleteItems = new SLList<>();
    }
    @Override
    public T removeLast(){
        T removed = super.removeLast();
        deleteItems.addLast(removed);
        return removed;
    }

    /**prints all deleted items.*/
    public void printLostItems() {
        deleteItems.print();
    }
    public static void main(String[] args) {
        VengefulSLList<Integer> vsl = new VengefulSLList<>();
        vsl.addLast(1);
        vsl.addLast(5);
        vsl.addLast(10);
        vsl.addLast(13);
        //vsl is now [1,5,10,13]
        vsl.removeLast();
        vsl.removeLast();
        //after deletion vsl is [1,5]

        System.out.print("The fallen are; ");
        vsl.printLostItems();
    }


}
