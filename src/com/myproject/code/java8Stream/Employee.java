package com.myproject.code.java8Stream;

import java.util.List;

class Employee{
    private String employeeName;
    private List<String> skills;



    public Employee(String employeeName, List<String> skills) {
        this.employeeName = employeeName;
        this.skills = skills;
    }



    public String getEmployeeName() {
        return employeeName;
    }



    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }



    public List<String> getSkills() {
        return skills;
    }



    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
