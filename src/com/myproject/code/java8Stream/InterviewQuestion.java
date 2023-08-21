package com.myproject.code.java8Stream;

import com.myproject.java8.Stream.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

        List<Student> stuList =StreamExperiencedProgram.getStudentObj();
        stuList= stuList.stream().sorted(Comparator.comparing(Student::getName).thenComparing(Student::getTotal)).collect(Collectors.toList());
        for(Student list:stuList){
            System.out.println(list);

        }


        ArrayList<Integer> l1 = new ArrayList<>();//o/p : 1^2 + 3^2 + 5^2 + 7^2 + 9^2 ==> 165
         l1.addAll(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        int sum= l1.stream().filter(i->i%2!=0).map(n->n*n).collect(Collectors.summingInt(Integer::intValue));
        int sum1= l1.stream().filter(i->i%2!=0).mapToInt(n->n*n).sum();
        double average= l1.stream().filter(i->i%2!=0).mapToInt(n->n*n).average().getAsDouble();



    }
}
