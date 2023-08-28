package com.myproject.code.java8Stream;

import com.myproject.java8.Stream.Student;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InterviewQuestion {

    public static void main(String[] args) {

        char c = 'A';
        System.out.println((int) c-64);


        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("test1" , Arrays.asList("java","python")));
        employees.add(new Employee("test2" , Arrays.asList("c++","python")));
        employees.add(new Employee("test3" , Arrays.asList("java","node")));
        //expected output -> java , python , c++ , node
        employees.stream().flatMap(m->m.getSkills().stream()).distinct().forEach(System.out::println);
        employees.stream().map(Employee::getSkills).flatMap(Collection::stream).distinct().forEach(System.out::println);

        List<Student> stuList =StreamExperiencedProgram.getStudentObj();
        stuList= stuList.stream().sorted(Comparator.comparing(Student::getName).reversed().thenComparing(Student::getTotal)).collect(Collectors.toList());
        for(Student list:stuList){
            System.out.println(list);

        }


        ArrayList<Integer> l1 = new ArrayList<>();//o/p : 1^2 + 3^2 + 5^2 + 7^2 + 9^2 ==> 165
         l1.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        int sum= l1.stream().filter(i->i%2!=0).map(n->n*n).collect(Collectors.summingInt(Integer::intValue));
        int sum1= l1.stream().filter(i->i%2!=0).mapToInt(n->n*n).sum();
        double average= l1.stream().filter(i->i%2!=0).mapToInt(n->n*n).average().getAsDouble();

        //Coforge 
        List<Integer> myList = Arrays.asList(1,4,4,8,8,7);// 2 3 5 6

            String name="boobalakrishnan";

          //myList.stream().distinct().forEach(System.out::println);

         Map<Character,Long> nameMap= name.chars().mapToObj(s->(char)(s))
                  .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
         for(Map.Entry<Character,Long> map:nameMap.entrySet()){
              System.out.println("The character "+map.getKey()+" occurred in "+map.getValue()+" times");
         }


         /* myList=myList.stream().sorted().collect(Collectors.toList());
          Set<Integer> setInt=new HashSet<>(myList);
          IntStream.range(1,myList.get(myList.size()-1)).filter((s)->setInt.add(s)).forEach(System.out::println);*/

        int number= 17;
        Predicate<Integer> Isprime = num-> IntStream.range(2,num/2).noneMatch(n->num%n==0);
        List<Integer> listInt=IntStream.range(2,100).boxed().filter(Isprime).collect(Collectors.toList());
        System.out.println(listInt);

    }
}
