package com.sanchi.tutorial.algorithms;

public class KthLinkedListElement {
	
	// Kth from the end.
	public static void main(String[] args) {

		Node n1 = new Node(5, null);
		Node n2 = new Node(4, n1);
		Node n3 = new Node(3, n2);
		Node n4 = new Node(2, n3);
		Node n5 = new Node(1, n4);

		Node n = get(n5, 2);

		System.out.println("Value - " + n.value);
	}
	
	
	/*
	 * ways to solve this problem 
	 * 1. if we know the length before hand then kth from end is l-k from front
	 * 		so we can find the element by iterating forward.
	 * 		Time complexity - O(n)
	 * 		Space complexity - O(1)
	 * 
	 * 2. we can recursively solve the problem 
	 * 	  while returning, when the counter matches count k, then return that value
	 * 	  Time complexity - O(n)
	 * 	  Space complexity - O(n)
	 * 
	 * 3. use two pointer, current and runner. Increment runner by k position,
	 *    then increment both current and runner, until runner reaches last.
	 *    Now current will be the kth element from the end.
	 * 
	 */
	public static Node get(Node head, int position)
	{
		Node current = head;
		Node runner = head;
		
		while(position != 0)
		{
			if(runner.next == null)
			{
				throw new RuntimeException("No element found");
			}
			
			runner = runner.next;
			position--;
		}
		
		current = current.next;
		
		while(runner.next != null)
		{
			current = current.next;
			runner = runner.next;
		}
	
		return current;
	}
	
	public static class Node
	{
		int value;
		Node next;
		
		Node(int value, Node next)
		{
			this.value = value;
			this.next = next;
		}
		
	}
}
