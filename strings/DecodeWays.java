package com.sanchi.tutorial.algorithms;

/**
 * A message containing letters from A-Z is being encoded 
 * to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine 
 * the total number of ways to decode it.
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.

 * @author Sanchi
 *
 */
public class DecodeWays {

	public static void main(String[] args)
	{
		String[] inputs = {"123456", "122056", "123056"};
		
		for(String input : inputs)
		{
			System.out.println("Count for ("+input+") is "+getNumberofWays(input));
		}
		
	}
	
	public static int getNumberofWays(String encodedValue)
	{
		if(encodedValue == null || encodedValue.length()<1)
		{
			return 0;
		}

		/*
		 * We can solve this by using dynamic programming. 
		 * Here I will be using an array of size n+1, where n
		 * is length of string.
		 * 
		 * Note - If any element is '0' it will ignore the previous
		 * element processing. Because '0' cannot be decoded without 
		 * another element in front of it.
		 */
		int length = encodedValue.length();
		int[] dp = new int[length+1];
		
		/*
		 * if it has passed above checks, there will be atleast one
		 * way to decode.
		 */
	
		dp[0] = 1;
		
		// look at the notes above.
		dp[1] = encodedValue.charAt(0)!='0'? 1:0;
		
		for(int i=2; i<=length; i++)
		{
			int single = Integer.valueOf(encodedValue.substring(i-1, i));
			int pair = Integer.valueOf(encodedValue.substring(i-2, i));
			
			System.out.println("i - "+i+", single  - "+ single + ", double - "+pair);
			
			// can I decode it individually ?
			if(single >=1 && single <=9)
			{
				dp[i] += dp[i-1];
			}
			
			// can I also decode it as a pair ?
			if(pair >=10 && pair <=26)
			{
				dp[i] += dp[i-2];
			}
		}
		
		return dp[length];
	}
}
