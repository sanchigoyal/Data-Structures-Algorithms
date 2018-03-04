package com.sanchi.tutorial.algorithms;

/**
 * HashMap implementation.
 * 
 * @author Sanchi
 *
 */
public class HashMap{
	
	Node[] buckets;
	
	public HashMap()
	{
		buckets = new Node[16];
	}
	
	public void put(String key, String value)
	{
		if(key==null){
			return;
		}
		
		long hashCode = key.hashCode();
		hashCode = hashCode<0?-hashCode:hashCode;
		
		int arrayLocation = (int) hashCode%16;
		
		Node newElement = new Node(hashCode, key, value);
		
		if(buckets[arrayLocation] == null)
		{
			buckets[arrayLocation] = newElement;
		}
		else
		{
			Node first = buckets[arrayLocation];
			while(first.next != null){first = first.next;}
			first.next = newElement;
		}
	}
	
	public String get(String key)
	{
		if(key == null){
			return null;
		}
		
		long hashCode = key.hashCode();
		hashCode = hashCode<0?-hashCode:hashCode;
		
		int arrayLocation = (int) hashCode%16;
		Node first = buckets[arrayLocation];
		
		if(first == null)
		{
			return null;
		}
		else if(first.next == null)
		{
			return first.value;
		}
		else
		{
			while(first != null)
			{
				if(first.hashCode == hashCode &&
						first.key.equals(key))
				{
					return first.value;
				}
				first = first.next;
			}
		}
		
		return null;
	}
	
	class Node
	{
		private long hashCode;
		private String key;
		private String value;
		private Node next;
		
		public Node(long hashCode, String key, String value)
		{
			this.hashCode = hashCode;
			this.key = key;
			this.value = value;
		}
	}
	
	
}
