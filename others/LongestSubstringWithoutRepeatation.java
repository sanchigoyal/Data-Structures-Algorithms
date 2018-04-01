package com.sanchi.tutorial.algorithms;

/*
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. 
 * 
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatation {

	public static void main(String[] args) {
		
		System.out.println("abcabcbb - "+longestSubstring("abcabcbb"));
		System.out.println("bbbbb - "+longestSubstring("bbbbb"));
		System.out.println("pwwkew - "+longestSubstring("pwwkew"));

	}
	
	public static String longestSubstring(String input)
	{
		Set<Character> set = new HashSet<Character>();
		HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		int start = 0, end = 0;
		
		for(int i=0; i<input.length(); i++)
		{
			if(set.contains(input.charAt(i)))
			{
				//System.out.println(input.charAt(i));
				// first store the current state and then reset
				indexMap.put(start, end);
				start = i;
				end = i;
				// clear the hash map
				set.clear();
			}
			else
			{
				set.add(input.charAt(i));
				end ++;
			}
		}
		indexMap.put(start, end);
		
		int startMax = 0,endMax = 0;
		
		for(Integer idx : indexMap.keySet())
		{
			if((indexMap.get(idx)- idx)>(endMax-startMax))
			{
				startMax = idx;
				endMax = indexMap.get(idx);
			}
		}
		
		return input.substring(startMax, endMax);
	}
}

