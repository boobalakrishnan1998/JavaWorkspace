package com.myproject.code.StringConcept;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    // Example usage
    // Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
    // Output:[ "This    is    an", "example  of text", "justification.  "]
    public static void main(String[] args) {
        TextJustification justification = new TextJustification();
        String[] words = new String[]{"Listen","to","many,","speak","to","a","few."};
        int maxWidth = 6;
        List<String> result = justification.justification(words, maxWidth);
        System.out.println(result);  // Output: [
        //"This    is    an",
        //"example  of text",
        //"justification.  "]
    }

    public List<String> justification(String[] words, int maxWidth) {
        List<String> ansArr;
        List<List<String>> rows = buildRow(words, maxWidth);
        ansArr = buildRowWithJustification(rows, maxWidth);
        return ansArr;
    }

    private List<String> buildRowWithJustification(List<List<String>> rows, int maxWidth) {
        List<String> ansRow = new ArrayList<>();
        List<String> lastRowLi = rows.get(rows.size() - 1);
        for (int i = 0; i < rows.size() - 1; i++) {
            List<String> li = rows.get(i);
            int rowLen = 0;
            for (int j = 0; j < li.size(); j++) {
                rowLen = rowLen + li.get(j).length();
            }
            int remainLen = maxWidth - rowLen;
            int numOfSpace = remainLen;
            int extraSpace = 0;
            if (li.size() > 1) {
                numOfSpace = remainLen / (li.size() - 1);
                extraSpace = remainLen % (li.size() - 1);
            } else {
                li.set(0, li.get(0) + generateSpaces(numOfSpace));
            }
            String space = generateSpaces(numOfSpace);
            for (int j = 0; j < li.size() - 1; j++) {
                li.set(j, li.get(j) + space);
            }
            for (int j = 0; extraSpace > 0; j++) {
                li.set(j, li.get(j) + " ");
                extraSpace--;
            }
            String row = String.join("", li);
            ansRow.add(row);
        }
        String lastRow = String.join(" ", lastRowLi);
        String space = generateSpaces(maxWidth - lastRow.length());
        ansRow.add(lastRow + space);
        return ansRow;
    }

    public static String generateSpaces(int numberOfSpaces) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfSpaces; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private List<List<String>> buildRow(String[] words, int maxWidth) {
        List<List<String>> wordsList = new ArrayList<>();
        List<String> wordRow = new ArrayList<>();
        int curLen = 0;
        for (String word : words) {
            curLen = curLen + word.length();
            if (curLen <= maxWidth - wordRow.size() ) {
                wordRow.add(word);
            } else {
                wordsList.add(new ArrayList<>(wordRow));
                curLen = word.length();
                wordRow.clear();
                wordRow.add(word);
            }
        }
        if (!wordRow.isEmpty()) {
            wordsList.add(new ArrayList<>(wordRow));
        }
        return wordsList;
    }
}