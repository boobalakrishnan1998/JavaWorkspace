package com.myproject.code.StringConcept;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        sort0and1Array();
       int len= lengthOfLongestSubstring("pwwkew");
        // System.out.println(len);
        int number= 17;
        Predicate<Integer> Isprime =num-> IntStream.range(2,num/2).noneMatch(n->num%n==0);
        List<Integer> listInt=IntStream.range(0,100).boxed().filter(x->(x!=0&&x!=1)).filter(Isprime).collect(Collectors.toList());
        System.out.println(listInt);
    }
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int logestSubStr = 0;
        int startPoint = 0;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                logestSubStr = Math.max(map.size(),logestSubStr);
                map.clear();
                i = ++startPoint;
            } else {
                map.put(s.charAt(i), i);
            }
        }
        return logestSubStr;
    }
    public static void sort0and1Array() {

         //int[] arr=new int[]{0,1,0,0,1,1,1,0,1,0,1};
        int[] inputArray=new int[]{0,1,0,0,1,1,1,0,1,0,1};

        int left = 0;

        int right = inputArray.length-1;
        while (left < right)
        {
            if (inputArray[left] == 1)
            {
                //Swapping

                inputArray[right] = inputArray[right] + inputArray[left];
                inputArray[left] = inputArray[right] - inputArray[left];
                inputArray[right] = inputArray[right] - inputArray[left];

                right--;
            }
            else
            {
                left++;
            }
        }


        int[] arr=new int[]{0,1,0,0,1,1,1,0,1,0,1};

         int end=arr.length;
         int i=0;
         while(i<end){
            if(arr[i]==1){
                arr[i]=arr[i]+arr[end-1];
                arr[end-1]=arr[i]-arr[end-1];
                arr[i]=arr[i]-arr[end-1];
                end--;
            }else{
                i++;
            }
         }
        Arrays.stream(arr).forEach(System.out::print);
    }

}
// Java Interview Find Prime Numbers in List Use Only Java 8 Streams
