package com.myproject.code.arrayConcept;

public class MinimumElementInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {12, 13, 15, 20,0, 3, 5, 7, 9, 10,};
        int ans = findMinElement(arr);
        System.out.println(ans);
        //SearchRotatedSortedArrayWithDuplicates
        int[] arr1 = {3,3,0,1,2,3,3,3,3,3,3,3};
        int ans1 = findMinElementWitDuplicates(arr1);
        System.out.println(ans1);
    }

    private static int findMinElement(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans=Integer.MAX_VALUE;

        while (low <= high) {
            //the minimum in that search space:
            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    ans = arr[low];
                }
                break;
            }
            int mid = (low + high) / 2;
            if (arr[low] <= arr[mid]) {
               ans= Math.min(ans,arr[low]);
               low=mid+1;
            } else {
                ans= Math.min(ans,arr[mid]);
                high=mid-1;
            }
        }
        return ans;
    }

    private static int findMinElementWitDuplicates(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans=Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }
            if (arr[low] <= arr[mid]) {
                ans= Math.min(ans,arr[low]);
                low=mid+1;
            } else {
                ans= Math.min(ans,arr[mid]);
                high=mid-1;
            }
        }
        return ans;
    }
}
