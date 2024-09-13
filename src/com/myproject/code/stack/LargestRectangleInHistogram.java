package com.myproject.code.stack;

import java.util.Stack;


/*
* Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.*/
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] input = new int[]{2, 1, 5, 6, 2, 3};
        int ans = largestRectangleArea(input);
        System.out.println(ans);

    }

    public static int largestRectangleArea(int[] heights) {

        int n = heights.length; // Size of array

        // Stack
        Stack<Integer> st = new Stack<>();

        // To store largest area
        int largestArea = 0;

        // To store current area
        int area;

        /* To store the indices of next
        and previous smaller elements */
        int nse, pse;

        // Traverse on the array
        for (int i = 0; i < n; i++) {

            /* Pop the elements in the stack until
            the stack is not empty and the top
            elements is not the smaller element */
            while (!st.isEmpty() &&
                    heights[st.peek()] >= heights[i]) {

                // Get the index of top of stack
                int ind = st.pop();

                /* Update the index of
                previous smaller element */
                pse = st.isEmpty() ? -1 : st.peek();

                /* Next smaller element index for
                the popped element is current index */
                nse = i;

                // Calculate the area of the popped element
                area = heights[ind] * (nse - pse - 1);

                // Update the maximum area
                largestArea = Math.max(largestArea, area);
            }

            // Push the current index in stack
            st.push(i);
        }

        // For elements that are not popped from stack
        while (!st.isEmpty()) {

            // NSE for such elements is size of array
            nse = n;

            // Get the index of top of stack
            int ind = st.pop();

            // Update the previous smaller element
            pse = st.isEmpty() ? -1 : st.peek();

            // Calculate the area of the popped element
            area = heights[ind] * (nse - pse - 1);

            // Update the maximum area
            largestArea = Math.max(largestArea, area);
        }

        // Return largest area found
        return largestArea;
    }
}
