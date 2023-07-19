package com.myproject.java8.Stream;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeProgram {

    public static void main(String[] args) {

        List<Integer> listInt= Arrays.asList(9,11,22,43,3,1,1,1,2,3,3,2,44,191,01,100,2,11,44);
        String inputStr="aava is Alive Awesome";
       // listInt.stream().filter(x->x%2==0).forEach(System.out::println);//find even number
        //listInt.stream().map(x->x+"").filter(s->s.startsWith("1")).forEach(System.out::println);//find the number start with 1



         Set<Integer> setInt=new HashSet<>();
         listInt.stream().filter(x->!setInt.add(x)).distinct().forEach(System.out::println);

         //find the first element in stream
           System.out.println(listInt.stream().findFirst().get());
           listInt.stream().findFirst().ifPresent(System.out::println);


        //count the total number of element
        System.out.println(listInt.stream().count());

        //find the maximum of the number
        listInt.stream().max((a,b)->a.compareTo(b)).ifPresent(System.out::println);
        listInt.stream().max(Integer::compareTo).ifPresent(System.out::println);




        // find the first non-repeated character
        inputStr.chars().mapToObj(s->Character.toLowerCase((char) s))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream().filter(entry->entry.getValue()==1L)
                .map(entry ->entry.getKey()).findFirst().ifPresent(System.out::println);

        //sort all the values
         listInt.stream().sorted().forEach(System.out::println);


        //sort all the values present in it in descending order
        listInt.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);


        List<Student> studentList=new ArrayList<>();
        studentList.add(new Student(1,"Boobalan","IT",25,419));
        studentList.add(new Student(2,"Thiru","EEE",25,500));
        studentList.add(new Student(3,"Udhai","EEE",25,300));
        studentList.add(new Student(4,"Deva","IT",25,200));
        studentList.add(new Student(5,"Jeevan","CSE",25,100));
        studentList.add(new Student(6,"Arun","CSE",25,600));
        studentList.add(new Student(6,"Arun","CSE",25,600));
        studentList.add(new Student(6,"Arun","CSE",25,600));

        Map<String,Long> studentList1 =studentList.stream().filter(x->x.getTotal()>400).collect(Collectors.groupingBy(Student::getDept,Collectors.counting()));
       // studentList1.forEach((a,b)-> System.out.println("Key :"+a+ " ,"+"Value :"+b));


                   Map<String,Long> stu= studentList.stream().filter(x->x.getTotal()>200).collect(Collectors.groupingBy(Student::getDept,Collectors.counting()));
        stu.forEach((a,b)-> System.out.println("Key :"+a+ " ,"+"Value :"+b));




    }



}
