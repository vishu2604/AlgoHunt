package arrays_Problem1_SetMatrixZeroes;


/**
 * Approach
 * 
 * The Steps are following:
 * 
 * First, we will declare two arrays: a row array of size N and a col array of size M and both are initialized with 0.
 * Then, we will use two loops(nested loops) to traverse all the cells of the matrix.
 * If any cell (i,j) contains the value 0, we will mark ith index of row array i.e. row[i] and jth index of col array col[j] as 1. It signifies that all the elements in the ith row and jth column will be 0 in the final matrix.
 * We will perform step 3 for every cell containing 0.
 * Fially, we will again traverse the entire matrix and we will put 0 into all the cells (i, j) for which either row[i] or col[j] is marked as 1.
 * Thus we will get our final matrix.
 * 
 * TIME COMPLEXITY -- 2*(N*M) 
 * SPACE COMPLEXITY -- O(N) + O(M) -- N rows: M columns
 * 
 */
public class Better {
	
	public void setZeroes(int[][] matrix) {

        //Better Approach
        betterApproach(matrix);
        
    }

    public void betterApproach (int[][] matrix) {
        int[] rowsToBeMarked = new int[matrix.length];
        int[] columnsToBeMarked = new int[matrix[0].length];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    rowsToBeMarked[i] = 1;
                    columnsToBeMarked[j] = 1;
                }
            }
        }

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(rowsToBeMarked[i] == 1) {
                     matrix[i][j] = 0;
                }
                if(columnsToBeMarked[j] == 1) {
                     matrix[i][j] = 0;
                }
            }
        }
    }

}
