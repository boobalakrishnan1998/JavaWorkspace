package com.myproject.code.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinMultiplicationsToReachEnd {
    public static void main(String[] args) {
        int[] arr = {2, 5, 7};
        int st = 3;
        int end = 84;
        int ans = findMinMultiple(st, end, arr);
        System.out.println(ans);
    }

    private static int findMinMultiple(int st, int end, int[] arr) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(st, 0));
        int[] minStep = new int[99999];
        minStep[st] = 0;
        Arrays.fill(minStep,Integer.MAX_VALUE);
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int curStart = pair.first;
            int curStep = pair.second;
            for (int i = 0; i < arr.length; i++) {
                int dis = curStart * arr[i];
                if (dis > 99999) {
                    dis = dis % 100000;
                }
                if (dis == end) {
                    return curStep + 1;
                }
                if (minStep[dis] > curStep + 1) {
                    minStep[dis] = curStep + 1;
                    queue.add(new Pair(dis, curStep + 1));
                }
            }
        }
        return -1;
    }
}
