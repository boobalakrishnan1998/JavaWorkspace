package com.myproject.code.graph;

import java.util.*;

public class WordLadderOptimize {
    public static void main(String[] args) {
        String startWord = "hit", targetWord = "cog";
        List<String> wordList =
                Arrays.asList("hot", "dog", "dot", "lot", "log", "cog");
        List<List<String>> ans = findSequences(startWord, targetWord, wordList);
        System.out.println(ans);
    }

    private static List<List<String>> findSequences(String startWord, String targetWord, List<String> wordList) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(startWord);
        set.remove(startWord);
        int curLevel = 0;
        ArrayList<String> leList = new ArrayList<>();
        leList.add(startWord);
        map.put(startWord, curLevel);
        while (!queue.isEmpty()) {
            String word = queue.remove();
            ArrayList<String> levelList = new ArrayList<>();
            if (word.equals(targetWord)) {
                break;
            }
            curLevel = map.get(word);
            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char[] charArray = word.toCharArray();
                    charArray[i] = c;
                    String newWord = new String(charArray);
                    if (set.contains(newWord)) {
                        queue.add(newWord);
                        set.remove(newWord);
                        map.put(newWord, curLevel + 1);
                        levelList.add(newWord);
                    }
                }
            }
        }
        if (!map.containsKey(targetWord)) {
            return new ArrayList<>();
        }
        List<List<String>> ans = new ArrayList<>();
        List<String> seq = new ArrayList<>();
        seq.add(targetWord);
        dfsWord(targetWord, startWord, map, seq, ans);
        return ans;
    }

    private static void dfsWord(String word, String startWord, Map<String, Integer> map, List<String> seq, List<List<String>> ans) {
        if (word.equals(startWord)) {
            Collections.reverse(seq);
            ArrayList<String> temp = new ArrayList<>(seq);
            ans.add(temp);
            Collections.reverse(seq);
            return;
        }
        int curLevel = map.get(word);
        for (int i = 0; i < startWord.length(); i++) {
            char[] charArr = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                charArr[i] = c;
                String curStr = String.valueOf(charArr);
                if (map.containsKey(curStr) && map.get(curStr) + 1 == curLevel) {
                    seq.add(curStr);
                    dfsWord(curStr, startWord, map, seq, ans);
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }
}
