class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) return s; // Handle edge case
        
        // Initialize a 2D array for the zigzag pattern
        String[][] all = new String[numRows][s.length()];

        int row = 0;
        int col = 0;
        int cur = 0;

        while (cur < s.length()) {
            // Move downwards in the current column
            while (row < numRows && cur < s.length()) {
                all[row++][col] = String.valueOf(s.charAt(cur++));
            }
            
            // Adjust row index to go upwards in the next column
            row = Math.max(0, row - 2);
            
            // Move diagonally upwards in the zigzag pattern
            while (row > 0 && cur < s.length()) {
                all[row--][++col] = String.valueOf(s.charAt(cur++));
            }
            col++; // Move to the next column
        }

        // Create the final result string
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (all[i][j] != null) { // Skip empty positions in the 2D array
                    ans.append(all[i][j]);
                }
            }
        }

        return ans.toString();
    }
}