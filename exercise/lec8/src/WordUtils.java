import javax.net.ssl.SSLContext;
import java.util.List;

public class WordUtils{
    /**Returns the longest string in the list*/
    public static String longest(List61B<String> list){
        int maxDex = 0;
        for(int i =0; i<list.size();i+=1){
            String longestString = list.get(maxDex);
            String thisString = list.get(i);
            if(thisString.length() > longestString.length()){
                maxDex = i;
            }
        }
        return list.get(maxDex);
    }
    public static void main(String[] args) {
        //List61B<String> someList = new SLList<>();
        SLList<String> someList = new SLList<>();
        List61B<String> anotherList = new AList<>();
        someList.addLast("elk");
        someList.addLast("are");
        someList.addLast("watching");
        System.out.println(longest(someList));
        someList.print();
    }
}