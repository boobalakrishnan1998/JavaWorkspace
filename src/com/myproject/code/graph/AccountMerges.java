package com.myproject.code.graph;

import java.util.*;

public class AccountMerges {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> accounts = Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com")
        );

        // Function call to merge the accounts
        List<List<String>> ans = accountsMerge(n, accounts);

        // Output
        System.out.println("The merged accounts are:");
        for (List<String> account : ans) {
            System.out.println(String.join(" ", account));
        }
    }

    private static List<List<String>> accountsMerge(int n, List<List<String>> accounts) {
        Map<String, Integer> mapMail = new HashMap<>();
        DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!mapMail.containsKey(mail)) {
                    mapMail.put(mail, i);
                } else {
                    ds.unionBySize(i, mapMail.get(mail));
                }
            }
        }
        List<List<String>> mergedMail = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            mergedMail.add(new ArrayList<>());
        }
        for (Map.Entry<String, Integer> mail : mapMail.entrySet()) {
            String email = mail.getKey();
            int node = mail.getValue();
            int pn = ds.findUPar(node);
            mergedMail.get(pn).add(email);
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!mergedMail.get(i).isEmpty()) {
                Collections.sort(mergedMail.get(i));
                ans.add(mergedMail.get(i));
            }
        }
        return ans;
    }

}
