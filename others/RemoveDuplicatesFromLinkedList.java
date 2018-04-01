package com.sanchi.tutorial.algorithms;

import java.util.HashSet;

public class RemoveDuplicatesFromLinkedList {

	public static void main(String[] args) {

		Node n1 = new Node(6, null);
		Node n2 = new Node(4, n1);
		Node n3 = new Node(6, n2);
		Node n4 = new Node(4, n3);
		Node n5 = new Node(1, n4);

		removeDuplicates(n5);

		while (n5 !=null) {
			System.out.println("Value - " + n5.value);
			n5 = n5.next;
		}

	}
	
	/*
	 * ways to solve this problem 
	 * 1. Maintain a table buffer to check if duplicate
	 * 	Time complexity - O(N)
	 * 	Space complexity - O(N)
	 * 
	 * 2. Iterate over the entire list for each element
	 * 	Time complexity - O(N2)
	 * 	Space complexity - O(1)
	 */
	public static void removeDuplicates(Node node) {
		HashSet<Integer> valueSet = new HashSet<Integer>();

		/*
		 * if current is null then return
		 */
		if (node == null) {
			return;
		}

		Node previous = null;

		while (node != null) {
			if (valueSet.contains(node.value)) {
				// so this is duplicate
				previous.next = node.next;
			} else {
				// this is first of its kind
				valueSet.add(node.value);
				previous = node;
			}

			node = node.next;
		}

	}

	/*
	 * Implementation of a node in linked list.
	 */
	public static class Node {
		int value;
		Node next;

		Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}

}
