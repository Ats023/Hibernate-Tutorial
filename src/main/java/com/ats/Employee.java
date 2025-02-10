package com.ats;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer salary;

    @ManyToMany()
    private Set<Project> projects;

    @ManyToOne() 
    private Department dept;

    // public Employee(String firstName, String lastName, Integer salary) {
    //     this.firstName = firstName;
    //     this.lastName = lastName;
    //     this.salary = salary;
    // }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Integer getSalary() {
        return salary;
    }

    public Set<Project> getProjects() {
        return projects==null? new HashSet<Project>():projects;
    }

    public void addProjectToEmployee(Project p) {
        projects = projects==null?new HashSet<Project>():projects;
        projects.add(p);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

}
