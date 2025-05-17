package com.myproject.code.arrayConcept;

public class ZigzagConversion {
    // Example usage
    public static void main(String[] args) {
        ZigzagConversion converter = new ZigzagConversion();
        String input = "PAYPALISHIRING";
        int numRows = 3;
        String result = converter.convert(input, numRows);
        System.out.println(result);  // Output: "PAHNAPLSIIGYIR"
    }

 /* row1 PAHN
    row2 APLSIIG
    row3 YIR      */
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() < numRows) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int currentRow = 0;
        boolean isDown = false;
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            if (currentRow == 0 || currentRow == (numRows - 1)) {
                isDown = !isDown;
            }
            if (isDown) {
                currentRow++;
            } else {
                currentRow--;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            res.append(rows[i]);
        }
        return res.toString();
    }
}