package com.myproject.code.java8Stream;

import com.myproject.java8.Stream.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExperiencedProgram {


    public static void main(String[] args) {
        Integer[] arrInt = new Integer[]{20, 22, 9, 8, 9, 8, 8, 0, 0, 0, 12, 54, 012, 111, 2, 22, 22, 1, 2, 33, 90, 122, 92, 9, 98, 43, 2, 345, 43, 44, 33, 3, 88};
        int[] intArr = new int[]{20, 22, 9, 8, 9, 8, 8, 0, 0, 0, 12, 54, 012, 111, 2, 22, 22, 1, 2, 33, 90, 122, 92, 9, 98, 43, 2, 345, 43, 44, 33, 3, 88};

        List<Integer> listInt = Arrays.asList(arrInt);
        //List<Integer> listInt= Arrays.asList(9,11,22,43,3,1,1,1,2,3,3,2,44,191,01,100,2,11,44);
        String inputStr = "aavax is Alive Awesome";
        List<Student> studentList = getStudentObj();

        String str="Ram Rahul Rohan Sidharth";

       String str1= Arrays.stream(str.split(" ")).max(Comparator.comparingInt(String::length)).get();
       System.out.println(str1);


      /* listInt.stream().filter(n->n%2==0).forEach(System.out::print);

        listInt.stream()
                .map(str -> str + "")
                .filter(n -> n.startsWith("1"))
                .forEach(System.out::println);

        Set<Integer> intSet= new HashSet<>();
             listInt.stream()
                     .filter(x->!intSet.add(x))
                     .distinct()
                     .forEach(System.out::println);
*/
        Integer firstEle = listInt.stream()
                .findFirst().get();
        System.out.println(firstEle);

        listInt.stream()
                .findFirst().ifPresent(System.out::println);
        Long count = listInt.stream().count();
        System.out.println(count);

        listInt.stream()
                .findFirst().ifPresent(System.out::println);
        Integer sum = listInt.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        listInt.stream().max(Integer::compareTo).ifPresent(System.out::println);

        Character ch = new Character('A');
        char cha = ch.charValue();

                inputStr.chars()
                        .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
                        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(entry -> entry.getValue() == 1L)
                        .map(entry->entry.getKey())
                        .findFirst()
                        .ifPresent(System.out::println);

              inputStr.chars()
                      .mapToObj(s->Character.toLowerCase(Character.valueOf((char) s)))
                      .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                      .entrySet()
                      .stream()
                      .filter(entry->entry.getValue()>1)
                      .map(entry->entry.getKey())
                      .findFirst()
                      .ifPresent(System.out::println);
                Arrays.stream(arrInt)
                        .sorted()
                        .forEach(System.out::println);

                Arrays.stream(arrInt)
                        .sorted(Collections.reverseOrder())
                        .forEach(System.out::println);

              List<Integer> intList=  Arrays.stream(intArr).boxed()
                        .collect(Collectors.toList());
              Set<Integer> disInt=new HashSet(intList);
              if(disInt.size()==intList.size())
                  System.out.println(false);
              else
                  System.out.println(true);
        Set<Integer> intList1=  Arrays.stream(intArr)
                .boxed()
                .collect(Collectors.toSet());

        if(intArr.length==intList1.size())
            System.out.println(false);
        else
            System.out.println(true);

        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());

        Stream<String> stringStream= Stream.concat(Arrays.asList(inputStr.split(" ")).stream(),intList.stream().map(x->x+""));
        stringStream.forEach(System.out::println);

                    listInt.stream()
                                    .map(x->x*x*x)
                                    .filter(x->x>50)
                                    .forEach(System.out::println);
        Arrays.sort(intArr);
        Arrays.asList(intArr).stream().forEach(System.out::print);

       Arrays.asList(inputStr).stream().map(String::toUpperCase).forEach(System.out::println);

     Map<String,Long>  map= Arrays.asList("AA","BB","CC","AA","CC").stream()
               .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
         System.out.println(map);

       List<String> arrList= Arrays.asList("AA","BB","CC","AA","CC");
        Map<String,Long> dubMap=arrList.stream()
                .filter(x->Collections.frequency(arrList,x)>1)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(dubMap);
        List<Student> studentList1=new ArrayList<>();
        studentList1.add(new Student(1,"Boobalan","IT",25,419));
        studentList1.add(new Student(2,"Thiru","EEE",25,500));
        studentList1.add(new Student(3,"Udhai","EEE",25,300));
        Optional.ofNullable(studentList1)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(Student::getName)
                .forEach(System.out::println);

       int i= studentList1.stream().map(Student::getTotal).max(Comparator.naturalOrder()).get();
       System.out.println(i);

     Map<String,Long> mapword= Arrays.stream(inputStr.split(""))
               .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
       System.out.println(mapword);


































    }
    static List<Student> getStudentObj() {
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

}
