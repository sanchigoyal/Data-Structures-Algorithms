package com.sanchi.tutorial.algorithms;

public class MatrixManipulation {

	public static void main(String[] args) {
		int matrix[][] = {{1, 2, 0, 4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
		
		for(int i = 0; i <matrix.length; i++)
		{
			for(int j=0; j<matrix.length; j++)
			{
				System.out.print("" + matrix[i][j] + " ");
			}
			
			System.out.println("\n");
		}
		System.out.println("---------------------");
		
		int[][] manipulatedMatrix = replaceColumnAndRowWithZeros(matrix);
		for(int i = 0; i <manipulatedMatrix.length; i++)
		{
			for(int j=0; j<manipulatedMatrix.length; j++)
			{
				System.out.print("" + manipulatedMatrix[i][j] + " ");
			}
			
			System.out.println("\n");
		}

	}

	/**
	 * Write an algorithm such that if an element in an M*N matrix is 0, then
	 * entire row and column is set to zero.
	 * 
	 * Solution 1 - At the first glance the problem looks simple, we can iterate
	 * over the entire matrix, find the cell with value 0 and then set all cells
	 * in that row and column to zero. However, this will not solve the problem
	 * as eventually we will end up setting all cells to 0. Therefore we need to
	 * maintain the knowledge of the zero cell and in second iteration set all
	 * cells in that column and row as zero. 
	 * Time complexity - O(2M*N) - > O(M*N) 
	 * Space complexity - O(M*N)
	 * 
	 * Solution 2 - Do we need to store the column of each cell ? Is the column
	 * index and row index not enough? i.e. if we know that a column has zero,
	 * we can set all cells in that column to zero.
	 * Time complexity - O(2M*N) - > O(M*N) 
	 * Space complexity - O(M+N)
	 * 
	 * @param matrix
	 * @return
	 */
	public static int[][] replaceColumnAndRowWithZeros(int[][] matrix) {
		
		if(matrix == null)
		{
			return matrix;
		}
		
		// lets maintain two lookups, one for each row and column
		boolean [] rowHasZeros = new boolean[matrix.length];
		boolean [] columnHasZeros = new boolean[matrix[0].length];
		
		for(int i = 0 ; i<matrix.length; i++)
		{
			for(int j=0; j<matrix[0].length; j++)
			{
				if(matrix[i][j] == 0)
				{
					rowHasZeros[i] = true;
					columnHasZeros[j] = true;
				}
			}
		}
		
		for(int i = 0 ; i<matrix.length; i++)
		{
			for(int j=0; j<matrix[0].length; j++)
			{
				if(rowHasZeros[i] || columnHasZeros[j])
				{
					matrix[i][j] = 0;
				}
			}
		}
		
		return matrix;
	}

}
