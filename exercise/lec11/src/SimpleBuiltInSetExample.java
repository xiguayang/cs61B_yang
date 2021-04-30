import java.util.HashSet;
import java.util.Set;

public class SimpleBuiltInSetExample {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();

        s.add("Tokyo");
        s.add("Lagos");
        System.out.println(s.contains("Tokyo")); // true
        //Set<String> imtSet = Set.of("PP", "QQ", "RR");
    }



}
