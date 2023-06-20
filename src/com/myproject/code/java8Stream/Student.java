package com.myproject.code.java8Stream;


public class Student {

    private Integer id;
    private String name;
    private String dept;
    private Integer age;
    private Integer total;
    public Student(Integer id, String name, String dept, Integer age, Integer total) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.age = age;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", age=" + age +
                ", total=" + total +
                '}';
    }
}
