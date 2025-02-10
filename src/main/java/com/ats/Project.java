package com.ats;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer projId;
    private String projTitle;
    @ManyToMany(mappedBy = "projects")
    private Set<Employee> assignedTo;
    
    public Integer getProjId() {
        return projId;
    }

    public void setProjId(Integer projId) {
        this.projId = projId;
    }

    public String getProjTitle() {
        return projTitle;
    }

    public void setProjTitle(String projTitle) {
        this.projTitle = projTitle;
    }

    public void assignToProject(Employee e) {
        assignedTo = assignedTo==null?new HashSet<Employee>():assignedTo;
        assignedTo.add(e);
    }

    public Set<Employee> getAssignedTo() {
        return assignedTo==null?new HashSet<Employee>():assignedTo;
    }

    public void setAssignedTo(Set<Employee> assignedTo) {
        this.assignedTo = assignedTo;
    }

}
