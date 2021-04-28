public class D {
    public static void main(String[] args) {
        //B a0 = new A();//cannot compile, because A cannot cast to B
        //a0.m1();
        //a0.m2(16);
        A b0 = new B();
        System.out.println(b0.x);//5
        b0.m1();//Am1-> 5
        b0.m2();//Bm2-> 5
        //b0.m2(61);//cannot compile
        B b1 = new B();
        b1.m2(61);//Bm2y->61
        b1.m3();//Bm3->called
        A c0 = new C();
        c0.m2();//Cm2->5
        //C c1 = (A) new C();
        A a1 = (A) c0;
        C c2 = (C) a1;
        c2.m3();//Bm3->called
        c2.m4();//Cm4->5
        c2.m5();//Cm5->6
        ((C) c0).m3();//Bm3->called
        //(C) c0.m3();//cannot compile, A has no m3()
        b0.update();//x=99
        b0.m1();//Am1->99


    }
}
