package com.sanchi.tutorial.algorithms;
import java.util.HashMap;

public class StringAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * ways to solve this problem.
	 * 1. Have a hash map to maintain the count of characters
	 * 	  First increment the count while iterating over input1
	 * 	  Second decrement the count while iterating over input2
	 * 	  Third verify the count in hashMap is 0
	 * 	  Time complexity - O(N + M + 256), where N = length of input1
	 * 	  Space complexity - O(1), cannot be greater than 256
	 * 
	 * 2. Sort both the character array and then compare if they are same.
	 * 	   
	 */
	public static boolean isAnagram(String input1, String input2)
	{
		
		if(input1 == null || input2 == null)
		{
			return false;
		}
		
		/*
		 * if the length doesn't match no point 
		 * comparing.
		 */
		if(input1.length() != input2.length())
		{
			return false;
		}
		
		HashMap<Character, Integer> characterCount = new HashMap<Character, Integer>();
		
		for(int i = 0; i <input1.length(); i++)
		{	
			Integer charCount = characterCount.get(input1.charAt(i));
			//keep increment the count
			if( charCount == null)
			{
				charCount = 0;
			}
			charCount ++;
			characterCount.put(input1.charAt(i), charCount);
		}
		
		for(int i = 0; i<input2.length(); i++)
		{
			// keep decrementing the count
			Integer charCount = characterCount.get(input2.charAt(i));
			//keep increment the count
			if(charCount == null)
			{
				return false;
			}
			
			if(charCount == 0)
			{
				return false;
			}
			
			charCount --;
			characterCount.put(input2.charAt(i), charCount);

		}
		
		for(Character c : characterCount.keySet())
		{
			if(characterCount.get(c) != 0)
			{
				return false;
			}
		}
		return true;
	}
}
