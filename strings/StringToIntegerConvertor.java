package com.sanchi.tutorial.algorithms;

/**
 * Class to convert String to Integer (atoi)
 * @author Sanchi
 *
 */
public class StringToIntegerConvertor {

	public static void main(String[] args) {
		String[] inputs = {"+123456789999999", "+1234", "-1234", "", null, "  -1234"};
		for(String string : inputs)
		{
			System.out.println("String input - " + string + ", integer output - " + toInteger(string));
		}
	}
	
	/**
	 * Method to convert String to Integer (atoi)
	 * @param input
	 * @return
	 */
	public static int toInteger(String input)
	{
		double value = 0;
		/*
		 * case 1: when input is null or empty
		 */
		if(input == null || input.length()<1)
		{
			return 0;
		}
		
		int idx = 0;
		// remove white spaces if any.
		input = input.trim();
		
		// check if its a negative number
		boolean negative = input.charAt(idx)=='-'? true:false;
		idx++;
		
		for(; idx < input.length(); idx++)
		{
			char digit = input.charAt(idx);
			int number = digit - '0';
			if(number>=0 || number<=9)
			{
				value = (value * 10) + number;
			}
			else
			{
				break;
			}
		}
		
		// if the indicator was negative  
		value = negative?-value:value;
		
		// handle MIN and MAX
		if(value>Integer.MAX_VALUE)
		{
			return Integer.MAX_VALUE;
		}
		
		if(value<Integer.MIN_VALUE)
		{
			return Integer.MIN_VALUE;
		}
		
		return (int) value;
		
	}

}
