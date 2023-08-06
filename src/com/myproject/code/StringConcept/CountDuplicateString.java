package com.myproject.code.StringConcept;


import java.util.*;
import java.util.stream.Collectors;

public class CountDuplicateString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //  String inputStr=sc.nextLine();
        String inputStr = "boobalakrishnankannan";
        inputStr = inputStr.toLowerCase();
        if (inputStr.isEmpty())
            throw new NullPointerException("Input string must not be a empty");
        countDuplicateNormal(inputStr);
        countDuplicateHashMap(inputStr);
        countDuplicateJava8Set(inputStr);
        countDuplicateJava8groupingBy(inputStr);
    }

    private static void countDuplicateJava8groupingBy(String inputStr) {
        Map<Character, Long> result = inputStr.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        for (Map.Entry entry : result.entrySet()) {
            System.out.println("the String '" + entry.getKey() + "' Occurred in " + entry.getValue() + " times ");
        }
    }

    private static void countDuplicateJava8Set(String inputStr) {
        Set<String> characterSet = new HashSet<>();
        Set<String> characterSetTemp = new HashSet<>();
        characterSetTemp = Arrays.asList(inputStr.split("")).stream().filter(c -> !characterSet.add(c)).collect(Collectors.toSet());
        System.out.println("the String " + characterSetTemp.toString() + " are duplicate");
    }

    private static void countDuplicateHashMap(String inputStr) {
        char[] charArrayStr = inputStr.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : charArrayStr) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        System.out.println();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println("the String '" + entry.getKey() + "' Occured in " + entry.getValue() + " times ");
        }
        map.forEach((K,V)->{

        });
    }

    private static void countDuplicateNormal(String inputStr) {
        int inputStrLength = inputStr.length();
        char[] charArrayStr = inputStr.toCharArray();
        for (int i = 0; i < inputStrLength; i++) {
            if (charArrayStr[i] == '0')
                continue;
            int count = 1;
            for (int j = i + 1; j < inputStrLength; j++) {
                if (charArrayStr[i] == charArrayStr[j]) {
                    charArrayStr[j] = '0';
                    count++;
                }
            }
            System.out.println("the String '" + inputStr.charAt(i) + "' Occured in " + count + " times ");
        }
    }


}
