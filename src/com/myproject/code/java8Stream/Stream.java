package com.myproject.code.java8Stream;

import com.myproject.java8.Stream.Student;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Stream {

    public static void main(String[] args) {
        Integer[] arrInt=new Integer[]{20,22,12,54,12,111,2,22,22,1,2,33,90,122,92,9,98,43,2,345,43,44,33,3,88};
        List<Integer> listInt= Arrays.asList(arrInt);
        //List<Integer> listInt= Arrays.asList(9,11,22,43,3,1,1,1,2,3,3,2,44,191,01,100,2,11,44);
        String inputStr="aava is Alive Awesome";

        List<Student> studentList=  getStudentObj();

        // findEvenNumber(arrInt);//find the duplicate element
         //findNumberStartswith(listInt);
        //findDuplicateElement(listInt);
        // findFirstElement(listInt);
        // find the first element in stream
        // countTotalElement(listInt);
     // findMinMaxAverage(listInt);
      //findFirstNonRepeatedCharacter(inputStr);
        // sortTheElement(listInt);
       // convertNameToList(studentList);
        //convertNameToSet(studentList);
      //  StringJoining(studentList);
       // sumOfAlltotal(studentList);
        //groupByDept(studentList);
//remove the duplicate elements
        listInt.stream().collect(Collectors.toSet()).forEach(System.out::print);
//sum of all numbers present
        System.out.println(listInt.stream().mapToInt(Integer::intValue).sum());


    }

    private static void groupByDept(List<Student> studentList) {
        Map<String,List<Student>> stu= studentList.stream().collect(Collectors.groupingBy(Student::getDept));
        for (Map.Entry entry:stu.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    private static void sumOfAlltotal(List<Student> studentList) {
        int total= studentList.stream().collect(Collectors.summingInt(Student::getTotal));
        System.out.println(total);
    }

    private static void StringJoining(List<Student> studentList) {
        String str= studentList.stream().map(Student::getName).distinct().collect(Collectors.joining(", "));
        System.out.println(str);
    }

    private static void convertNameToSet(List<Student> studentList) {
        Set<String>  strSet= studentList.stream().map(Student::getName)
                .collect(Collectors.toCollection((TreeSet::new)));
        for(String str:strSet){
            System.out.println(str);
        }
    }

    private static void convertNameToList(List<Student> studentList) {
        List<String> stu= studentList.stream().map(Student::getName).collect(Collectors.toList());
        for(String str:stu){
            System.out.println(str);
        }
    }

    private static List<Student> getStudentObj() {
        List<Student> studentList=new ArrayList<>();
        studentList.add(new Student(1,"Boobalan","IT",25,419));
        studentList.add(new Student(2,"Thiru","EEE",25,500));
        studentList.add(new Student(3,"Udhai","EEE",25,300));
        studentList.add(new Student(4,"Deva","IT",25,200));
        studentList.add(new Student(5,"Jeevan","CSE",25,100));
        studentList.add(new Student(6,"Arun","CSE",25,600));
        studentList.add(new Student(6,"Arun","CSE",25,600));
        studentList.add(new Student(6,"Arun","CSE",25,600));
        return studentList;
    }

    private static void sortTheElement(List<Integer> listInt) {
        listInt.stream().sorted().forEach(System.out::println);
        listInt.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
        List<Student > sortedList = getStudentObj()
                .stream()
                .sorted(Comparator.comparingInt(Student::getAge))
                .collect(Collectors.toList());
    }

    private static void findFirstNonRepeatedCharacter(String inputStr) {
        inputStr.chars().mapToObj(c->Character.toLowerCase((char)c))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry->entry.getValue()<=1L)
                .map(x->x.getKey()).findFirst()
                .ifPresent(System.out::println);
    }

    private static void findMinMaxAverage(List<Integer> listInt) {
        listInt.stream().max(Comparator.naturalOrder()).ifPresent(System.out::println);
        listInt.stream().max((a, b)->a.compareTo(b)).ifPresent(System.out::println);
        listInt.stream().max(Integer::compareTo).ifPresent(System.out::println);
        listInt.stream().min(Comparator.naturalOrder()).ifPresent(System.out::println);
        listInt.stream().min((a, b)->a.compareTo(b)).ifPresent(System.out::println);
        listInt.stream().min(Integer::compareTo).ifPresent(System.out::println);
        IntSummaryStatistics intSum = listInt.stream().mapToInt(x->x).summaryStatistics();
        System.out.println(intSum.toString());
    }

    private static void countTotalElement(List<Integer> listInt) {
        Long totalElement=  listInt.stream().count();
        System.out.println(totalElement);
    }

    private static void findFirstElement(List<Integer> listInt) {
        listInt.stream().findFirst().ifPresent(System.out::println);
    }

    private static void findDuplicateElement(List<Integer> listInt) {
        Set<Integer> setInt=new HashSet<>();
        listInt.stream().filter(x->!setInt.add(x)).distinct().forEach(System.out::println);
    }

    private static void findNumberStartswith(List<Integer> listInt) {
        listInt.stream().filter(x->x.toString().startsWith("1")).forEach(System.out::println);
    }

    private static void findEvenNumber(Integer[] arrInt) {
        Arrays.asList(arrInt).stream().filter(x->(x%2)==0).forEach(System.out::println);
    }


}
