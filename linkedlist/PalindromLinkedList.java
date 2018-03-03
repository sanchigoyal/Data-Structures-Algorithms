package com.sanchi.tutorial.algorithms;

import java.util.Stack;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * @author Sanchi
 *
 */
public class PalindromeLinkedList {

	public static void main(String[] args) {
	
		Node oNode1 = new Node(1, null);// last
		Node oNode2 = new Node(2, oNode1);
		Node oNode3 = new Node(3, oNode2);
		Node oNode4 = new Node(2, oNode3);
		Node oNode5 = new Node(1, oNode4);//first
		
		
		Node node1 = new Node(1, null);// last
		Node node2 = new Node(2, node1);
		Node node3 = new Node(3, node2);
		Node node4 = new Node(3, node3);
		Node node5 = new Node(2, node4);
		Node node6 = new Node(1, node5);//first
		
		boolean isPalindrom = isPalindrom(node6);
		
		System.out.println("Is palindrom - " + isPalindrom);
	}

	/**
	 * Method to determine if a linked list is 
	 * a palindrome.
	 * 
	 * @param node
	 * @return
	 */
	private static boolean isPalindrom(Node node) {
		
		Node current = node;
		Node runner = node;
		
		Stack<Integer> stack = new Stack<Integer>();
		// Reach the center
		// if even then runner=null
		// if odd then runner.next=null
		while(runner!=null && runner.next!=null)
		{
			stack.push(current.value);
			current = current.next;
			runner = runner.next.next;
		}
		
		// for odd case, move to the other side first
		if(runner!=null && runner.next==null)
		{
			current = current.next;
		}
		
		while(current!=null)
		{
			int stackValue = stack.pop();
			if(stackValue!=current.value){
				return false;
			}
			current = current.next;
		}
		
		return true;
	}

	
}


/**
 * Node class.
 * 
 * @author Sanchi
 *
 */
class Node{
	int value;
	Node next;
	Node(int value, Node n)
	{
		this.value = value;
		this.next = n;
	}
}
