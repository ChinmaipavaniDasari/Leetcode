import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int top = 0;                  // starting row
        int bottom = matrix.length - 1; // ending row
        int left = 0;                 // starting column
        int right = matrix[0].length - 1; // ending column

        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;

            // Traverse from top to bottom
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;

            // Traverse from right to left (only if rows remain)
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }

            // Traverse from bottom to top (only if columns remain)
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }

        return result;
    }
}