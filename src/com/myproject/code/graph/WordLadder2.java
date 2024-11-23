package com.myproject.code.graph;

import java.util.*;

public class WordLadder2 {
    public static void main(String[] args) {
        String startWord = "bat", targetWord = "coz";
        List<String> wordList =
                Arrays.asList("pat", "bot", "pot", "poz", "coz");
        List<List<String>> ans = findSequences(startWord, targetWord, wordList);
        System.out.println(ans);
    }
    //by using extra for loop to remove usedword
   static public List<List<String>> findSequences(String beginWord, String endWord,
                                            List<String> wordList) {
        // To store the answer
        List<List<String>> ans = new ArrayList<>();

        // Queue data structure to store
        // the sequence of transformations
        Queue<List<String>> q = new LinkedList<>();

        // Add all the words to a hashset
        Set<String> st = new HashSet<>(wordList);

        // Add the sequence containing starting word to queue
        q.add(new ArrayList<>(Arrays.asList(beginWord)));

        // Erase starting word from set if it exists
        st.remove(beginWord);

        // Set to store the words that must be deleted
        // after traversal of a level is complete
        Set<String> toErase = new HashSet<>();

        // Until the queue is empty
        while (!q.isEmpty()) {

            // Size of queue
            int size = q.size();

            // Traversing all words in current level
            for (int i = 0; i < size; i++) {

                // Sequence
                List<String> seq = q.poll();

                // Last added word in sequence
                String word = seq.get(seq.size() - 1);

                // If the last word same as end word
                if (word.equals(endWord)) {
                    // Add the sequence to the answer
                    if (ans.isEmpty()) {
                        ans.add(new ArrayList<>(seq));
                    }
                    else if (ans.get(ans.size() - 1).size() ==
                            seq.size()) {
                        ans.add(new ArrayList<>(seq));
                    }
                }

                // Iterate on every character
                for (int pos = 0; pos < word.length(); pos++) {

                    // Original letter
                    char original = word.charAt(pos);

                    // Replacing current character with
                    // letters from 'a' to 'z' to match
                    // any possible word from set
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char[] wordArray = word.toCharArray();
                        wordArray[pos] = ch;
                        String newWord = new String(wordArray);

                        // Check if it exists in the set
                        if (st.contains(newWord)) {
                            // Update the sequence
                            seq.add(newWord);

                            // Push in the queue
                            q.add(new ArrayList<>(seq));

                            // Add the word to erase map
                            toErase.add(newWord);

                            // Backtracking step
                            seq.remove(seq.size() - 1);
                        }
                    }

                    // Update the original letter back
                    String beforePos = word.substring(0, pos);
                    String afterPos = word.substring(pos + 1);
                    word = beforePos + original + afterPos;
                }
            }

            // Erase all the words in set after
            // traversal of a level is completed
            for (String it : toErase) st.remove(it);
            toErase.clear();

            // If answer is found, break
            if (!ans.isEmpty()) break;
        }

        // Return the result found
        return ans;
    }

    // this difficult to understand
    private static ArrayList<ArrayList<String>> wordLadderLength(String startWord, String targetWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<ArrayList<String>> que = new LinkedList<>();
        ArrayList<String> li = new ArrayList<>();
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        ArrayList<String> usedWord = new ArrayList<>();
        li.add(startWord);
        usedWord.add(startWord);
        que.add(li);
        int level = 0;
        while (!que.isEmpty()) {
            ArrayList<String> curList = que.remove();
            String curWord = curList.get(curList.size() - 1);
            //TOdo Implement used word removal
            if (curList.size() > level) {
                level++;
                for (String word : usedWord) {
                    wordSet.remove(word);
                }
                usedWord.clear();
            }
            if (curWord.equals(targetWord)) {
                if (ans.isEmpty()) {
                    ans.add(curList);
                } else if (ans.get(0).size() == curList.size()) {
                    ans.add(curList);
                }
            }
            for (int i = 0; i < startWord.length(); i++) {
                char[] charArr = curWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    charArr[i] = c;
                    String curStr = String.valueOf(charArr);
                    if (wordSet.contains(curStr)) {
                        curList.add(curStr);
                        ArrayList<String> temp = new ArrayList<>(curList);
                        que.add(temp);
                        usedWord.add(curStr);
                        curList.remove(curList.size() - 1);
                    }
                }
            }
        }
        return ans;
    }
}
