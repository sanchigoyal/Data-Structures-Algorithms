package com.sanchi.tutorial.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Class to validate parentheses order.
 * @author Sanchi
 *
 */
public class ParenthesesValidator {

	public static void main(String[] args) {
		
		String[] parenthesesStrings = {"}[{([]{})}]", "[{([]{})}]", "[{([]{})}]{", ""};
		
		for(String string : parenthesesStrings)
		{
			System.out.println("Parentheses input - " + string + " is valid " + isValidParentheses(string));
		}
		
	}
	
	/**
	 * Method to validate parentheses order.
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isValidParentheses(String input)
	{
		/*
		 * case 1: if the input is null,
		 * return false. 
		 */
		if(input == null)
		{
			return false;
		}
		
		/*
		 * case 2: if the input is empty,
		 * return true. 
		 */
		if(input.isEmpty())
		{
			return true;
		}
		
		// prepare the parentheses set
		Map<Character, Character> parenthesesSet = new HashMap<Character, Character>();
		parenthesesSet.put('{', '}');
		parenthesesSet.put('[', ']');
		parenthesesSet.put('(', ')');
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i< input.length(); i++)
		{
			char c = input.charAt(i);
			// if opening parentheses add to stack
			if(parenthesesSet.keySet().contains(c))
			{
				stack.push(c);
			}
			else 
				/* 
				 * if closing parentheses,
				 * 1. check if the stack is not empty.
				 * 2. match with the latest in stack
				 */
				if(parenthesesSet.values().contains(c))
				{
					if(!stack.isEmpty() && parenthesesSet.get(stack.peek()) == c)
					{
						stack.pop();
					}
					else
					{
						return false;
					}
				}
		}
		
		return stack.empty();
	}

}
