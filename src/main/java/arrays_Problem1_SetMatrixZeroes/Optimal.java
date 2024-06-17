package arrays_Problem1_SetMatrixZeroes;

/**
 * 
 * How It Works
 * 
 * Marking Step:
 * We use the first row and first column to mark which rows and columns should be zeroed.
 * We handle the special case of the first column separately with col0.
 * 
 * Applying Step:
 * Using the marks, we set the appropriate cells to zero, ignoring the first row and column for now.
 * Zeroing the First Row and Column:
 * 
 * Finally, based on our initial marks, we set the first row and first column to zero if needed.
 * 
 * Why This Approach?
 * Space Efficiency: We use the matrix itself for marking instead of using extra space.
 * Order of Operations: We handle the first row and first column last to avoid overwriting our marks prematurely.
 * 
 * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * Step-by-Step Approach
 * 
 * Step 1: Mark Rows and Columns that Need to be Zeroed
 * 
 * Goal:
 * Mark the first row and first column of the grid to remember which rows and columns should be set to zero. Use a variable col0 to remember if the first column itself needs to be zeroed.
 * 
 * Steps:
 * 
 * Initialize col0 as 1 (this will help us keep track if the first column needs to be zero).
 * Loop through each cell in the grid.
 * If a cell contains 0, mark the start of its row and column by setting matrix[i][0] and matrix[0][j] to 0.
 * If the cell is in the first column (j=0), set col0 to 0.
 * 
 * Step 2: Apply Zeroes to the Marked Rows and Columns
 * 
 * Goal:
 * Using the marks in the first row and first column, set the corresponding rows and columns to zero, except for the first row and column themselves.
 * 
 * Steps:
 * Loop through the grid again, starting from the second row and second column (i=1, j=1).
 * For each cell, if the mark in its row (matrix[i][0]) or column (matrix[0][j]) is 0, set the cell to 0.
 * 
 * Step 3: Zero the First Row and First Column if Needed
 * 
 * Goal:
 * Set the first row and the first column to zero if they were marked to be zeroed earlier.
 * 
 * Steps:
 * 
 * Check the first cell of the grid (matrix[0][0]).
 * If it's 0, set the entire first column to 0.
 * If col0 is 0, set the entire first row to 0.
 * 
 */
public class Optimal {
	
	public void setZeroes(int[][] matrix) {

        //Better Approach
        optimalApproach(matrix);
        
    }

	
    public void optimalApproach (int[][] matrix) {
    	int col0 = 1;
    	
    	/*
    	 * This for loop will mark the first column and first row with 0.
    	 * We have a specific variable as col0 which will be marked 0 if the j=0
    	 * 
    	 * @param matrix
    	 */
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                	matrix[i][0] = 0;
                	if(j==0) {
                		col0 = 0;
                	} else {
                		matrix[0][j] = 0;
                	}
                }
            }
        }
        
        
        /*
         * This for loop will convert all the elements to 0 except the first row and first column
         * therefore we start the iteration from 1
         * 
         */
        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j<matrix[i].length; j++) {
            	if(matrix[i][j] != 0) {
            		if(matrix[i][0] == 0 || matrix[0][j] == 0) {
            			matrix[i][j] = 0;
            		}
            	}
                
            }
        }
        
        /*
         * Now we will mark the first column
         * This is important step. We need to follow this order.
         * 
         */
        if(matrix[0][0] == 0) {
        	for(int i=0; i<matrix[0].length; i++) {
        		matrix[0][i] = 0;
        	}
        }
        
        /*
         * Now we will check the col0 and mark the row
         * 
         */
        if(col0 == 0) {
        	for(int i=0; i<matrix.length; i++) {
        		matrix[i][0] = 0;
        	}
        }
    }
}
