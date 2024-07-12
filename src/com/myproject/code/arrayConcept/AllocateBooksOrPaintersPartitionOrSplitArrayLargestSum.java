package com.myproject.code.arrayConcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AllocateBooksOrPaintersPartitionOrSplitArrayLargestSum {
    public static void main(String[] args) {
        ArrayList<Integer> books = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int n = books.size();
        int student = 2;
        int ans = findPages(books, n, student);
        System.out.println(ans);
    }

    private static int findPages(ArrayList<Integer> list, int n, int student) {
        if (n < student) {
            return -1;
        }
        int low = Collections.max(list);
        int high = list.stream().mapToInt(Integer::intValue).sum();
        while (low <= high) {
            int mid = (low + high) / 2;
            if (countPages(list, mid) > student) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int countPages(ArrayList<Integer> list, int pages) {
        int student = 1;
        int studentPage = 0;
        for (int i = 0; i < list.size(); i++) {
            if (studentPage + list.get(i) <= pages) {
                studentPage += list.get(i);
            } else {
                student++;
                studentPage = list.get(i);
            }
        }
        return student;
    }
}
