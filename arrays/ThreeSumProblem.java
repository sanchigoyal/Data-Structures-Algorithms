package com.sanchi.tutorial.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array S of n integers, are there elements a, b, c in S
 * such that a + b + c = 0? Find all unique triplets in the array
 * which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * 	[-1, 0, 1],
 * 	[-1, -1, 2]
 * ]
 * @author Sanchi
 *
 */
public class ThreeSumProblem {

	public static void main(String[] args)
	{
		int[] input = {1, -1, -1, 0, 2, 4};
		
		ArrayList<int[]> result = threeSum(input);
		
		for(int[] arr : result)
		{
			System.out.println("Result - "+Arrays.toString(arr));
		}
	}

	/**
	 * Method to find correct combination for 3sum problem
	 * with no duplicates.
	 * 
	 * @param arr
	 * @return
	 */
	private static ArrayList<int[]> threeSum(int[] arr) {
		
		ArrayList<int[]> result = new ArrayList<int[]>();
		
		// case 1: handle null and empty scenario.
		if(arr == null || arr.length<1)
		{
			return result;
		}
		
		
		/*
		 * Sort the array.
		 * Reason 1 - Helps to avoid duplicates
		 * Reason 2 - Helps to increment and decrement the pointer to find complement.
		 * Reason 3 - Reduces time complexity from O(n3) to O(n2)
		 */
		Arrays.sort(arr);
		
		for(int i=0; i<arr.length-3; i++)
		{
			// avoid duplicates while moving forward.
			
			if(i==0 || arr[i]>arr[i-1])
			{
				int start = i+1;
				int end = arr.length -1;
				
				// sum rest of the element and compare for compliment.
				while(start<end)
				{
					if(arr[i] + arr[start] + arr[end] == 0)
					{
						result.add(new int[]{arr[i], arr[start], arr[end]});
					}
					
					if((arr[i] + arr[start] + arr[end])<0)
					{
						// sum is less than 0 then move right.
						int currentStart = start;
						// skip duplicate element on the way.
						while(arr[start]==arr[currentStart] && start<end)
						{
							start ++;
						}
					}
					else
					{
						// sum is greater than 0 then move left.
						int currentEnd = end;
						//skip duplicate elements on the way.
						while(arr[end]==arr[currentEnd] && start<end)
						{
							end--;
						}
					}
				}
			}
		}
		return result;
	}
}
