package arrays_Problem1_SetMatrixZeroes;

/**
 * Approach:		
 * The steps are the following:
 * 		
 * First, we will use two loops(nested loops) to traverse all the cells of the matrix.
 * If any cell (i,j) contains the value 0, we will mark all cells in row i and column j with -1 except those which contain 0.
 * We will perform step 2 for every cell containing 0.
 * Finally, we will mark all the cells containing -1 with 0.
 * 
 * TIME COMPLEXITY --  APROXIMATELY n3
 * SPACE COMPLEXITY -- O(1)
 * Thus the given matrix will be modified according to the question.
 * 
 */
public class BruteForce {

	public void setZeroes(int[][] matrix) {

		// Brute Force Approach
		bruteForceApproach(matrix);

	}

	public void bruteForceApproach(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					markRow(matrix, matrix.length, matrix[i].length, i);
					markColumn(matrix, matrix.length, matrix[i].length, j);
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == -1) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public void markRow(int[][] matrix, int rowSize, int columnSize, int rowNumber) {
		for (int i = 0; i < columnSize; i++) {
			if (matrix[rowNumber][i] != 0) {
				matrix[rowNumber][i] = -1;
			}
		}
	}

	public void markColumn(int[][] matrix, int rowSize, int columnSize, int columnNumber) {
		for (int i = 0; i < rowSize; i++) {
			if (matrix[i][columnNumber] != 0) {
				matrix[i][columnNumber] = -1;
			}
		}
	}
}
