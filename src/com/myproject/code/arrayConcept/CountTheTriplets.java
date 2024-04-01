package com.myproject.code.arrayConcept;

import java.util.Arrays;

public class CountTheTriplets {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2};
        //{1, 2, 3, 5}
        System.out.println(countTriplets(arr));
    }

    public static int countTriplets(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        //{1, 2, 3, 5}
        for (int i = arr.length - 1; i > 1; i--) {
            int low = 0;
            int high = i - 1;
            while (low < high) {
                int sum = arr[low] + arr[high];
                if (sum == arr[i]) {
                    count++;low++;high--;
                } else if (sum < arr[i]) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return count;
    }
}
