package intlist;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this class stores a sequence of int values.
 * 
 * @invar | getElements() != null
 * @invar | getLength() == getElements().length
 */
public class IntList {
	
	private class Node {
		private int value;
		private Node next;
	}
	
	/**
	 * @invar | 0 <= size
	 * @invar | IntStream.range(0, size + 1).allMatch(i -> (getNodes()[i] == null) == (i == size))
	 */
	private Node head;
	private int size;
	
	/**
	 * @representationObjects
	 */
	private Node[] getNodes() {
		Node[] nodes = new Node[size + 1];
		int i = 0;
		Node n = head;
		for (;;) {
			nodes[i++] = n;
			if (i == size + 1)
				break;
			n = n.next;
		}
		return nodes;
	}
	
	/**
	 * @creates | result
	 */
	public int[] getElements() {
		int[] result = new int[size];
		Node n = head;
		for (int i = 0; i < size; i++) {
			result[i] = n.value;
			n = n.next;
		}
		return result;
	}
	
	public int getLength() {
		return size;
	}
	
	/**
	 * @pre | 0 <= index && index < getLength()
	 * @post | result == getElements()[index]
	 */
	public int getElementAt(int index) {
		Node n = head;
		for (int i = 0; i < index; i++)
			n = n.next;
		return n.value;
	}

	/**
	 * @post | getLength() == 0
	 */
	public IntList() {}
	
	/**
	 * @mutates | this
	 * @post | getLength() == old(getLength()) + 1
	 * @post | Arrays.equals(getElements(), 0, old(getLength()), old(getElements()), 0, old(getLength()))
	 * @post | getElements()[old(getLength())] == element
	 */
	public void add(int element) {
		if (head == null) {
			head = new Node();
			head.value = element;
		} else {
			Node n = head;
			while (n.next != null)
				n = n.next;
			n.next = new Node();
			n.next.value = element;
		}
		size++;
	}
	
	/**
	 * @pre | getLength() > 0
	 * @mutates | this
	 * @post | Arrays.equals(getElements(), 0, getLength(), old(getElements()), 0, getLength())
	 */
	public void removeLast() {
		if (head.next == null) {
			head = null;
		} else {
			Node n = head;
			while (n.next.next != null)
				n = n.next;
			n.next = null;
		}
		size--;
	}
}
