package com.myproject.code.graph;

import java.util.*;

public class WordLadder1 {
    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        List<String> wordList =
                Arrays.asList("des", "der", "dfr", "dgt", "dfs");
        int ans = wordLadderLength(startWord, targetWord, wordList);
        System.out.println(ans);
    }

    private static int wordLadderLength(String startWord, String targetWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(startWord, 1));
        wordSet.remove(startWord);
        while (!que.isEmpty()) {
            Pair pair = que.poll();
            String word = pair.str;
            int curLevel = pair.second;
            if (word.equals(targetWord))
                return curLevel;
            for (int i = 0; i < startWord.length(); i++) {
                // Store the original letter
                char original = word.charAt(i);
                /* Replacing current character with
                letters from 'a' to 'z' to match
                any possible word from set */
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] wordArray = word.toCharArray();
                    wordArray[i] = ch;
                    String newWord = new String(wordArray);
                    // Check if it exists in the set
                    if (wordSet.contains(newWord)) {
                        // Erase the word from set
                        wordSet.remove(newWord);
                        // Add the transition to the queue
                        que.add(new Pair(newWord, curLevel + 1));
                    }
                }
                // Update the original letter back
                word = word.substring(0, i) + original +
                        word.substring(i + 1);
            }

        }
        return 0;
    }
}
