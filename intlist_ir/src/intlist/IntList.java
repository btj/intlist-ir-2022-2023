package intlist;

import java.util.Arrays;

/**
 * Each instance of this class stores a sequence of int values.
 * 
 * @invar | getElements() != null
 * @invar | getLength() == getElements().length
 */
public class IntList {
	
	/**
	 * @creates | result
	 */
	public int[] getElements() { throw new RuntimeException("Not yet implemented"); }
	
	public int getLength() { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * @pre | 0 <= index && index < getLength()
	 * @post | result == getElements()[index]
	 */
	public int getElementAt(int index) { throw new RuntimeException("Not yet implemented"); }

	/**
	 * @post | getLength() == 0
	 */
	public IntList() { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * @mutates | this
	 * @post | getLength() == old(getLength()) + 1
	 * @post | Arrays.equals(getElements(), 0, old(getLength()), old(getElements()), 0, old(getLength()))
	 * @post | getElements()[old(getLength())] == element
	 */
	public void add(int element) { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * @pre | getLength() > 0
	 * @mutates | this
	 * @post | Arrays.equals(getElements(), 0, getLength(), old(getElements()), 0, getLength())
	 */
	public void removeLast() { throw new RuntimeException("Not yet implemented"); }
}
