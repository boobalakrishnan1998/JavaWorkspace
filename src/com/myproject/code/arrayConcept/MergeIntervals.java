package com.myproject.code.arrayConcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        //int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        //sorted array
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        List<List<Integer>> ans = mergeOverlappingIntervals(arr);
        System.out.println(Arrays.toString(Arrays.stream(mergeOverlappingIntervals1(arr)).toArray()));
    }

    private static List<List<Integer>> mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            } else {
                ans.get(ans.size() - 1).set(1,
                        Math.max(ans.get(ans.size() - 1).get(1), intervals[i][1]));
            }

        }
        return ans;
    }

    private static int[][] mergeOverlappingIntervals1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1)[1]) {
                ans.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                ans.get(ans.size() - 1)[1] =
                        Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
            }

        }
        return ans.toArray(new int[ans.size()][]);
    }
}
