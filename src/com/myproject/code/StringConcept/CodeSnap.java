package com.myproject.code.StringConcept;

public class CodeSnap {
    public static String getValue(int num) {

        try {

            int out=num/2;

            return "from try block";

        } catch(Exception e) {

            return "from catch block";

        } finally {

            return "from finally block";

        }

    }



    public static void main(String[] args) {

        int num = 4;

        System.out.println(getValue(num));


        String name = "testing";

        final StringBuilder sb = new StringBuilder(name);

        name = sb.substring(0, 3).toString();

        System.out.println(name);


        String str1=new String("Test");

        String str2=new String("Test");

        String str3="Test";

        String str4="Test";

        System.out.println(str1==str2);  //false

        System.out.println(str1.equals(str2)); //true

        System.out.println(str1==str3);//false

        System.out.println(str1.equals(str3)); //true

        str1=str4;

        System.out.println(str1==str2); //false

        System.out.println(str1.equals(str2));//true

        System.out.println(str1==str3);//true

        System.out.println(str1.equals(str3));//true

    }

}
class Employee {

    public String name;

    public static String getName(String name) {

        return name.toUpperCase();

    }

}



//Scenario 1 :

class Standalone1 {

    public static void main(String[] args) {

        String name = "testing";

        System.out.println(Employee.getName(name));

    }

}



//Scenario 2 :

class Standalone {

    public static void main(String[] args) {

        String name = "testing";

        Employee emp = new Employee();

        System.out.println(emp.getName(name));

    }

}