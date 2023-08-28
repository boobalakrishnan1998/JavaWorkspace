package com.myproject.code.java8Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Test {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 4, 10, 12, 87, 33, 75);

        int sum =numbers.stream().mapToInt(Integer::intValue).sum();
         System.out.println(sum);

         Random random=new Random();
         //random.ints().limit(10).forEach(System.out::println);

        List<Integer> number= Arrays.asList(3, 2, 2, 3, 7, 3, 5);

       IntSummaryStatistics su= number.stream().mapToInt(Integer::intValue).summaryStatistics();

       int[] arr={1,2,3,4,5,};
        int[] arr1={6,7,8,9,10};
       // Stream.of(arr,arr1).map(Integer::intValue).forEach(System.out::print);
          List<int[]>  li= Stream.of(Arrays.asList(arr),Arrays.asList(arr1)).flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(li);

    }

}
