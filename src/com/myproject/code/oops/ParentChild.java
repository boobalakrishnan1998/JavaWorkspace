package com.myproject.code.oops;



class Parent{
    public static void Method1(){
        System.out.println("Parent Static Method 1");
    }
    public void Method2(){
        System.out.println("Parent Non Static Method 2");
    }
    public static void ParentMethod3(){
        System.out.println("Parent Static Method 3");
    }
    public void ParentMethod4(){
        System.out.println("Parent Non Static Method 4");
    }
}
class Child extends Parent{
    public static void Method1(){
        System.out.println("Child Static Method 1");
    }
    public void Method2(){
        System.out.println("Child Non Static Method 2");
    }
    public static void ChildMethod3(){
        System.out.println("Child Static Method 3");
    }
    public void ChildMethod4(){
        System.out.println("Child Non Static Method 4");
    }
}
class ParentChild {
    public static void main(String[] args) {

        //case1:Parent Reference with Parent Object
        Parent parent = new Parent();
        parent.Method1();           //output: Parent Static Method 1
        parent.Method2();           //output: Parent Non Static Method 2
        parent.ParentMethod3();     //output: Parent Static Method 3
        parent.ParentMethod4();     //output: Parent Non Static Method 4

        //case2:Child Reference with Child Object
        Child child = new Child();
        child.Method1();           //output: Child Static Method 1
        child.Method2();           //output: Child Non Static Method 2
        child.ChildMethod3();     //output: Child Static Method 3
        child.ChildMethod4();     //output: Child Non Static Method 4

        //case3:Parent Reference with Child Object
        Parent pc = new Child();
        pc.Method1();           //output: Parent Static Method 1
        pc.Method2();           //output: Child Non Static Method 1
        pc.ParentMethod3();     //output: Parent Static Method 3
        pc.ParentMethod4();     //output: Parent Non Static Method 4
//        pc.ChildMethod3(); //Cannot call Child Methods from Parent Reference
//        pc.ChildMethod4(); //Cannot call Child Methods from Parent Reference`
    }
}
