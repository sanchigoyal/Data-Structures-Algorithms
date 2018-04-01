package com.sanchi.tutorial.algorithms;

public class StringCompressor {

	public static void main(String[] args) {

		System.out.println("aabccceeeedd compressed to " + compress("aabccceeeedd"));
		System.out.println("abcde compressed to " + compress("abcde"));
	}

	/*
	 * ways to solve this problem. 
	 * 1. String concatenation Time Complexity = N + K2, 
	 * where N is number of sequence and K is number of character. 
	 * 2. Builder usage  - Time Complexity = N Space Complexity = 2N (worst case)
	 */
	public static String compress(String original) {
		if (original == null || original.length() < 1) {
			return original;
		}

		char last = original.charAt(0);
		int count = 1;

		StringBuilder builder = new StringBuilder();
		for (int i = 1; i < original.length(); i++) {
			if (last == original.charAt(i)) {
				// if next is same as last, keep incrementing the count.
				count++;
			} else {
				// if next is not same as last.
				// save last to builder,
				// save count to builder,
				// reset counter to 1
				// reset last to current
				builder.append(last);
				builder.append(count);
				count = 1;
				last = original.charAt(i);
			}
		}

		/*
		 * update the builder with the last set
		 */
		builder.append(last);
		builder.append(count);

		String compressed = builder.toString();

		/*
		 * if original is small then compressed then return original.
		 */
		if (original.length() < compressed.length()) {
			return original;
		}

		return compressed;
	}
}
