public class DynamicVsStaticType {
    public static void main(String[] args) {
        VengefulSLList<Integer> vsl = new VengefulSLList<Integer>(9);
        /*Since VengefulSLList "is-an" SLList,
        it's valid to put an instance of the VengefulSLList class
        inside an SLList "container".*/
        SLList<Integer> sl = vsl;
        sl.addLast(50);//VengefulSLList not override or implement it, so it executed in SLList
        sl.removeLast();//overrides in VengefulSLList, the dynamic tye of sl is VengefulSLList, so call the override method

        //sl.printLosItem();
        //above results in a compile-time error
        //compiler determines is valid or not based on static type of the object
        //sl 's static type is SLList and printLosItem() is the method in VengefulSLList

        //VengefulSLList<Integer> vsl2 = sl;
        //above results in a compiler-time error too
        //sl 's static type is SLList, it will not allow a VengefulSLList container to hold it


    }
}
