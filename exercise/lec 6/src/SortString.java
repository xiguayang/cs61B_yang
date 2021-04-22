public class SortString {
    /**Sorts strings destructively*/
    public static void sort(String[] x){
        //selection sort:
        //find the smallest item
        //move it to the front(swap with the front one)
        //selection sort the rest(using recursion?)
        sort(x,0);
    }
    /**helper method: Sort x starting at the position start*/
    public static void sort(String[] x, int start){
        if(start == x.length){
            return;
        }
        int smallestIndex = findSmallest(x,start);
        swap(x,start,smallestIndex);
        sort(x,start+1);
    }
    /**helper method: Swap item a with b.*/
    public static void swap(String[]x,int a, int b){
        String temp = null;
        temp = x[a];
        x[a]=x[b];
        x[b]=temp;
    }
    /**helper method: Return the smallest String's index in x, starting at star*/
    public static int findSmallest(String[] x,int start){
        int smallestIndex = start;
        for(int i =start+1;i<x.length;i+=1){
            int cmp = x[i].compareTo(x[smallestIndex]);
            if(cmp<0){
                smallestIndex=i;
            }
        }
        return smallestIndex;
    }
}
