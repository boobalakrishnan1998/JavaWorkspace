package com.myproject.code.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AliansDictionary {
    public static void main(String[] args) {
        int N = 5, K = 4;
        List<Integer>[] adj = new ArrayList[N];
        for (int i = 0; i < 4; i++) {
            adj[i] = new ArrayList<>();
        }
        String[] dict = {
                "baa", "abcd", "abca", "cab", "cad"
        };
        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int minLen = Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < minLen; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj[s1.charAt(ptr) - 'a'].add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }
        List<Integer> topo = topoSort(K, adj);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < K; i++) {
            // Add the letter to the result
            ans.append((char) ('a' + topo.get(i)));
            ans.append(' ');
        }
        System.out.println(ans.toString());
    }

    private static List<Integer> topoSort(int n, List<Integer>[] adj) {
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int node : adj[i]) {
                inDegree[node]++;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                que.add(i);
            }

        }
        List<Integer> ans = bfsCheck(que, adj, inDegree);
        return ans;
    }

    private static List<Integer> bfsCheck(Queue<Integer> que, List<Integer>[] adj, int[] inDegree) {
        List<Integer> ans = new ArrayList<>();
        while (!que.isEmpty()) {
            int node = que.remove();
            ans.add(node);
            for (int adjNode : adj[node]) {
                inDegree[adjNode]--;
                if (inDegree[adjNode] == 0) {
                    que.add(adjNode);
                }
            }
        }
        return ans;
    }
}