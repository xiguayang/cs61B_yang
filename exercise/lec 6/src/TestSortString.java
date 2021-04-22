import org.junit.Test;
import static org.junit.Assert.*;
/**Tests the sortString class*/
public class TestSortString {
    /**Test SortString.sort method*/
    @Test
    public void testSort(){
        String[] input = {"i","have","an","egg"};
        String[] expected = {"an","egg","have","i"};

        SortString.sort(input);

        //Junit help test
        assertArrayEquals(expected,input);
        /**
        for(int i =0;i<input.length;i++){
            if(!input[i].equals(expected[i])){
                System.out.println("Mismatch in position "+i+", expected: "+expected[i]+", but got: "+input[i]);
            }
            break;
        }


         * if(!java.util.Arrays.equals(input,expected)){
         *  System.out.println("Error! There seems to be a problem with StringSort.sort");
         *  }
         */
    }
    /**Test the StringSort.findSmallest method*/
    @Test
    public void testFindSmallest(){
        String[] input = {"i","have","an","egg"};
        int expected = 2;
        int actual = SortString.findSmallest(input,0);
        assertEquals(expected,actual);
        String[] input2 = {"there","are","many","pigs"};
        int expected2 = 2;
        int actual2 = SortString.findSmallest(input2,2);
        assertEquals(expected2,actual2);
    }
    /**Test the SortString.swap method*/
    @Test
    public void testSwap(){
        String[] input = {"i","have","an","egg"};
        int a = 0;
        int b =2;
        String[] expected = {"an","have","i","egg"};
        SortString.swap(input,a,b);
        assertArrayEquals(expected,input);
    }

}
