public class Maxmizer {
    public static Comparable max(Comparable[] items){
        int maxDex = 0;
        for(int i = 1;i<items.length;i++){
            int cmp = items[i].compareTo(items[maxDex]);
            if(cmp>0){
                maxDex =i;
            }
        }
        return items[maxDex];
    }

}
