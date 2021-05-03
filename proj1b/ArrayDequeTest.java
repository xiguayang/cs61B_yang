/** Performs some basic linked list tests. */
public class ArrayDequeTest {
	
	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");
		//System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

		ArrayDeque<Integer> ad1 = new ArrayDeque<>();

		boolean passed = checkEmpty(true, ad1.isEmpty());

		ad1.addFirst(1);
		
		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, ad1.size()) && passed;
		passed = checkEmpty(false, ad1.isEmpty()) && passed;
		ad1.addFirst(2);
		ad1.addLast(3);
		passed = checkSize(3, ad1.size()) && passed;
		ad1.addLast(4);
		passed = checkSize(4, ad1.size()) && passed;
		ad1.addLast(5);
		ad1.addFirst(6);
		ad1.addFirst(7);
		ad1.addLast(8);
		passed = checkSize(8, ad1.size()) && passed;
		ad1.addLast(9);
		passed = checkSize(8, ad1.size()) && passed;
		System.out.println("Printing out deque: ");
		ad1.printDeque();

		printTestStatus(passed);

	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("Running add/remove test.");

		//System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

		ArrayDeque<Integer> ad1 = new ArrayDeque<>();

		boolean passed = checkEmpty(true, ad1.isEmpty());

		ad1.addFirst(1);
		ad1.addFirst(2);
		ad1.addLast(3);
		ad1.addLast(4);
		ad1.addLast(5);
		ad1.addFirst(6);
		ad1.addFirst(7);
		ad1.addLast(8);
		passed = checkSize(8, ad1.size()) && passed;
		ad1.addLast(9);
		passed = checkSize(9, ad1.size()) && passed;
		ad1.addFirst(10);
		ad1.addFirst(11);
		ad1.addLast(12);
		ad1.addLast(13);
		ad1.addLast(14);
		ad1.addFirst(15);
		ad1.addFirst(16);
		ad1.addLast(17);
		passed = checkSize(17, ad1.size()) && passed;
		passed = checkSize(32, ad1.getCapacity()) && passed;
		ad1.removeFirst();
		ad1.removeFirst();
		ad1.removeLast();
		ad1.removeFirst();
		ad1.removeFirst();
		ad1.removeLast();
		ad1.removeFirst();
		ad1.removeFirst();
		ad1.removeFirst();
		ad1.removeLast();
		ad1.removeFirst();
		ad1.removeFirst();
		ad1.removeLast();
		ad1.removeLast();
		passed = checkSize(3, ad1.size()) && passed;
		passed = checkSize(8, ad1.getCapacity()) && passed;

		// should not be empty 
		passed = checkEmpty(false, ad1.isEmpty()) && passed;

		ad1.removeFirst();
		ad1.removeLast();
		ad1.removeLast();
		// should be empty 
		passed = checkEmpty(true, ad1.isEmpty()) && passed;

		printTestStatus(passed);

	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
	}
} 