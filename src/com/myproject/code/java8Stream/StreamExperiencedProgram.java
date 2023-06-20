package com.myproject.code.java8Stream;

import com.myproject.java8.Stream.Student;

import java.util.*;

public class StreamExperiencedProgram {


    public static void main(String[] args) {
        Integer[] arrInt = new Integer[]{20, 22,9,8,9,8,8,0,0,0, 12, 54, 012, 111, 2, 22, 22, 1, 2, 33, 90, 122, 92, 9, 98, 43, 2, 345, 43, 44, 33, 3, 88};
        List<Integer> listInt = Arrays.asList(arrInt);
        //List<Integer> listInt= Arrays.asList(9,11,22,43,3,1,1,1,2,3,3,2,44,191,01,100,2,11,44);
        String inputStr = "aava is Alive Awesome";
        List<Student> studentList = getStudentObj();
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
      Integer firstEle=  listInt.stream()
                .findFirst().get() ;
         System.out.println(firstEle);

        listInt.stream()
                .findFirst().ifPresent(System.out::println);
        Long count=  listInt.stream().mapToInt(x-> x).count();
        System.out.println(count);

        listInt.stream()
                .findFirst().ifPresent(System.out::println);
        Integer sum=  listInt.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        listInt.stream().max(Integer::compareTo).ifPresent(System.out::println);

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

}
