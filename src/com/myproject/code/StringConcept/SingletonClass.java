package com.myproject.code.StringConcept;

/*To create a singleton class, we must follow the steps, given below:
   Ensure that only one instance of the class exists.
   Provide global access to that instance by:
       1  Declaring all constructors of the class to be private.
       2  Providing a static method that returns a reference to the instance. The lazy initialization concept is used to write the static methods.
       3  The instance is stored as a private static variable.
  */
public class SingletonClass {
    // Static variable reference of single_instanc of type Singleton
    private static SingletonClass singletonInstance =null;

    // Constructor
    // Here we will be creating private constructor
    // restricted to this class itself
    private SingletonClass(){}
    // Static method to create instance of Singleton class
    public static SingletonClass getInstance(){
     if(singletonInstance ==null){
         singletonInstance = new SingletonClass();
     }
      return singletonInstance;
    }
}
