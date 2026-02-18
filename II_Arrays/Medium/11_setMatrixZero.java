package II_Arrays.Medium;

//Brute
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Step 1: Mark rows and columns with -1
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    
                    // mark row
                    for(int k = 0; k < n; k++) {
                        if(matrix[i][k] != 0)
                            matrix[i][k] = -1;
                    }

                    // mark column
                    for(int k = 0; k < m; k++) {
                        if(matrix[k][j] != 0)
                            matrix[k][j] = -1;
                    }
                }
            }
        }

        // Step 2: Convert -1 to 0
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == -1)
                    matrix[i][j] = 0;
            }
        }
    }
}
//TC - O(m × n × (m + n))
//SC - O(1)




//Better
/* class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        if (matrix.length == 0) {
            return;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] == true || cols[j] == true) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
} */
//TC - O(m × n)
//SC - O(m + n) (row + col arrays)




//Optimal
/* class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstColZero = false;

        // Step 1: Use first row & column as markers
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0)
                firstColZero = true;

            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 2: Set zeroes (ignore first row & column)
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 3: Handle first row
        if (matrix[0][0] == 0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 4: Handle first column
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
} */
//TC - O(m × n)
//SC - O(1) (only one extra boolean)
