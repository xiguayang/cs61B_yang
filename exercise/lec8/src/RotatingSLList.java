public class RotatingSLList<T> extends SLList<T>{
    /**Exercise 4.2.1. Define the rotateRight method,
     * which takes in an existing list,
     * and rotates every element one spot to the right,
     * moving the last item to the front of the list.*/
    public void rotateRight(){
        T x = removeLast();
        addFirst(x);
    }

    public static void main(String[] args) {
        RotatingSLList<Integer> rsl = new RotatingSLList<>();
        /*Creates SLList: [10, 11, 12, 13]*/
        rsl.addLast(10);
        rsl.addLast(11);
        rsl.addLast(12);
        rsl.addLast(13);
        /*Should be [13, 10, 11, 12] */
        rsl.rotateRight();
        rsl.print();
    }
}
