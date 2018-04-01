package com.sanchi.tutorial.algorithms;

import java.util.HashSet;

public class UniqueCharacterString {

	public static void main(String[] args) {
		System.out.println("Sanchi has unique character - "+hasUniqueCharacters("Sanchi"));
		System.out.println("Rajat has unique character - "+hasUniqueCharacters("Rajat"));
	}
	
	/*
	 * Ways to solve this problem.
	 * 1. Have a set and upload and compare the char in set with the char in string.
	 * 		Time complexity - O(N)
	 * 		Space complexity - O(1), because it cannot grow more than 256 ASCII characters
	 * 2. Have a boolean array of size 256, compare and alter the value 
	 * 		Time complexity - O(N)
	 * 		Space complexity - O(1), because it cannot grow more than 256 ASCII characters
	 * 3. Brute-Force method - iterate over every element and compare with every element.
	 * 		Time complexity - O(n2)
	 * 		Space complexity - O(1)
	 */
	public static boolean hasUniqueCharacters(String input)
	{
		if(input == null || input.length() <1)
		{
			return false;
		}
		
		/*
		 * no need to compare because there will be at least one
		 * duplicate character.
		 * 
		 */
		if(input.length() > 256)
		{
			return false;
		}
		
		boolean hasUniqueCharacters = true;
		HashSet<Character> characterSet = new HashSet<Character>();
		
		// if upper case and lower case doesn't matter
		String inputIgnoreCase = input.toUpperCase();
		
		for(int i = 0 ; i< inputIgnoreCase.length(); i++)
		{
			char c = inputIgnoreCase.charAt(i);
			if(characterSet.contains(c))
			{
				/*
				 * if the hash set already has this character,
				 * then this is duplicate. 
				 */
				hasUniqueCharacters = false;
				return hasUniqueCharacters;
			}
			else
			{
				/*
				 * if it doesn't contain, then add to hash set
				 * for further lookups.
				 */
				characterSet.add(c);
			}
		}
		
		return hasUniqueCharacters;
	}
}
