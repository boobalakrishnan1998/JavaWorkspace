package com.myproject.code.arrayConcept;

public class CapacityToShipPackagesWithInNDays {
    public static void main(String[] args) {
        int[] weights = new int[]{5, 4, 5, 2, 3, 4, 5, 6};
        int d = 5;
        int n = weights.length;
        int ans = leastCapacityToShip(weights, d, n);
        System.out.println(ans);
    }

    private static int leastCapacityToShip(int[] weights, int d, int n) {
        int low = Integer.MIN_VALUE, high = 0;
        for (int i = 0; i < n; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossibleDays(weights, mid) > d) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int isPossibleDays(int[] weights, int capacity) {
        int shipCapacity = 0;
        int noOfDays = 1;
        for (int i = 0; i < weights.length; i++) {
            if (shipCapacity + weights[i] <= capacity) {
                shipCapacity += weights[i];
            } else {
                shipCapacity = weights[i];
                noOfDays++;
            }
        }
        return noOfDays;
    }
}
