import java.util.Comparator;

public class Dog implements Comparable<Dog>{
    private String name;
    private int size;
    public Dog(String n, int s){
        name = n;
        size = s;
    }

    /**if return is negative, this < o and so on*/
    public int compareTo(Dog o){
        Dog oddaDog = (Dog)o;
        return(this.size-oddaDog.size);
        /**
        if(this.size <oddaDog.size ){
            return -1;
        }else if(this.size == oddaDog.size){
            return 0;
        }else{
            return 1;
        }*/
    }

    /**
    public static class NameComparator implements Comparator<Dog>{
        public int compare(Dog a, Dog b){
            return a.name.compareTo(b.name);
        }
    }
    */

    private static class NameComparator implements Comparator<Dog>{
        public int compare(Dog a, Dog b){
            return a.name.compareTo(b.name);
        }
    }
    public static Comparator<Dog> getNameComparator(){
        return new NameComparator();
    }

    public void bark(){
        System.out.println(name + " says : Bark");
    }

}
