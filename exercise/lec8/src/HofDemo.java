
public class HofDemo {
    public static int do_twice(IntUnaryFunction f, int x){
        return f.apply(f.apply(x));
    }

    public static void main(String[] args) {
        System.out.print(do_twice(new TenX(),10));

    }
}
