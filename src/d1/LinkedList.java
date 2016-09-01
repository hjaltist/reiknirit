package d1;

import edu.princeton.cs.algs4.*;

public class LinkedList {

	private Node front;
	private int N;

	private class Node
	{
		String key;
		Node next;
	}

	/**
	 * Constructor
	 */
	public LinkedList()
	{
		N = 0;
		front = null;
	}

	/**
	 * Pushes the item to the back of the list.
	 */
	public void add(String str)
	{
		Node node = new Node();
		node.key = str;
		node.next = front;
		front = node;
	}

	public void print()
	{
		Node iter = front;
		while( iter != null )
		{
			StdOut.print(iter.key);
			iter = iter.next;
			if( iter != null )
			{
				StdOut.print(" ");
			}
		}
		StdOut.println();
	}

	/**
	 * TODO: Implement
	 */

	public void remove(String str)
	{
		remove_helper(str, front);
	}

	private Node remove_helper(String str, Node node)
	{
	    if (node.next != null) {
	        Node nextNode = node.next;

            if (node == front && node.key.equals(str)) {
                front = nextNode;
                return remove_helper(str, front);
            } else if (nextNode.key.equals(str) && nextNode.next != null) {
                node.next = nextNode.next;
                return remove_helper(str, node);
            } else if (nextNode.key.equals(str)) {
                node.next = null;
                return null;
            } else if (!nextNode.key.equals(str)) {
                return remove_helper(str, nextNode);
            }
        } else {
            if (node == front && node.key.equals(str)) {
                front = null;
            }
            return null;
        }

        return null;
	}
}
