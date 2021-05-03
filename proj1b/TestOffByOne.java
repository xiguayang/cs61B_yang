import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    /** This interface defines a method for determining equality of characters. */
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.**/
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars(){
        assertTrue(offByOne.equalChars('a','b'));
        assertTrue(offByOne.equalChars('r','q'));
        assertTrue(offByOne.equalChars('&', '%'));
        assertFalse(offByOne.equalChars('a', 'e'));
        assertFalse(offByOne.equalChars('z', 'a'));
        assertFalse(offByOne.equalChars('a', 'a'));
        assertFalse(offByOne.equalChars('B', 'b'));
    }
}
