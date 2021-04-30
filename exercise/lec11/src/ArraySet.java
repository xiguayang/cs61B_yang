import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static java.util.Set.*;

public class ArraySet<T> implements Iterable<T> {
    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for(int i =0;i<size;i++){
            if(items[i].equals(x)){
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        /*items[i].equals(x). If the value at items[i] is null,
         then we are calling null.equals(x) -> NullPointerException.*/
        if(x ==null){
            throw new IllegalArgumentException("CAN'T ADD NULL");
        }
        if(this.contains(x)){
            return;
        }
        items[size] = x;
        size++;

    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }
    /**returns an iterator (a.k.a. seer) into me*/
    public Iterator<T> iterator(){
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T>{
        private int wizPos;
        public ArraySetIterator(){
            wizPos = 0;
        }
        @Override
        public boolean hasNext() {
            return wizPos<size;
        }

        @Override
        public T next() {
            T returnItem = items[wizPos];
            wizPos++;
            return returnItem;
        }
    }
    /**ArraySet to String*/
    @Override
    public String toString(){
        /*String are slow in java, use StringBuilder instead*/
        StringBuilder returnSB = new StringBuilder("{");
        /*
        for(T t :this){
            returnString += t;
            returnString += ", ";
        }*/

        for(int i = 0;i<size-1;i++){
            returnSB.append(items[i].toString()) ;
            returnSB.append(", ");
        }
        returnSB.append(items[size-1].toString());
        returnSB.append("}");
        return returnSB.toString();
    }
    @Override
    public boolean equals(Object other){
        if (this == other ){
            return true;
        }
        if (other == null){
            return false;
        }
        if(other.getClass() != this.getClass()){
            return false;
        }
        ArraySet<T> o = (ArraySet<T>) other;
        if(o.size !=this.size()){
            return false;
        }
        //o not contain all items in this
        for(T item : this){
            if(!o.contains(item)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Set<Integer> javaset = new HashSet<>();
        javaset.add(5);
        javaset.add(23);
        javaset.add(42);
        //Set<Integer> javaset2 = Set.of(5,23,42);
        //Set<String> imtSet = Set.of("PP", "QQ", "RR");

        //
        for(int i : javaset){
            System.out.println(i);
        }
        //Instead for loop, use iterator inside the set
        //seer: see the inside of the set; next() method returns the value and also move to the next value
        Iterator<Integer> seer= javaset.iterator();
        while(seer.hasNext()){
            int i = seer.next();
            System.out.println(i);
        }
        System.out.println(javaset);

        ArraySet<String> aset = new ArraySet<>();
        //s.add(null);
        aset.add("horse");
        aset.add("fish");
        aset.add("house");
        aset.add("fish");
        System.out.println(aset.contains("horse"));
        System.out.println(aset.size());
        System.out.println(aset);

        ArraySet<String> aset2 = new ArraySet<>();
        aset2.add("horse");
        aset2.add("fish");
        aset2.add("house");
        System.out.println(aset.equals(aset2));

        Iterator<String> aseer = aset.iterator();
        while(aseer.hasNext()){
            String x = aseer.next();
            System.out.println(x);
        }

        //to use the for loop we need make ArraySet implements Iterable
        for (String st : aset){
            System.out.println(st);
        }



    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}

