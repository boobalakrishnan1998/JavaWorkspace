package com.myproject.code.StringConcept;


/*
       Declare the class as final so it can’t be extended.
       Make all of the fields private so that direct access is not allowed.
       Don’t provide setter methods for variables.
       Make all mutable fields final so that a field’s value can be assigned only once.
       Initialize all fields using a constructor method performing deep copy.
       Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
*/
public final class ImmutableClass {
    private final String name;

    private final int age;

    private final String address;

    public ImmutableClass(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}
