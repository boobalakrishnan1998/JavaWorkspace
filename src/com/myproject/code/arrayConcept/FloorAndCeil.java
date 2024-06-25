package com.myproject.code.arrayConcept;

public class FloorAndCeil {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int n = 10, x = 55;
        int floor = findFloor(arr, n, x);
        System.out.println("The floor is the index: " + floor);
        int ceil = findCeil(arr, n, x);
        System.out.println("The ceil is the index: " + ceil);
    }

    private static int findFloor(int[] arr, int n, int x) {

        int low = 0, high = n - 1, ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private static int findCeil(int[] arr, int n, int x) {
        int low = 0, high = n - 1, ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
