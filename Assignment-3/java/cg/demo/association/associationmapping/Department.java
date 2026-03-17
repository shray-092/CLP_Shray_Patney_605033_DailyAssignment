package cg.demo.association.associationmapping;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Department {

//    @Id
//    private int deptId;
//    private String deptName;
//
//    @OneToMany
//    private List<Employee> employees;
//
//    public Department(){}
//
//    public Department(int deptId,String deptName){
//        this.deptId = deptId;
//        this.deptName = deptName;
//    }
//
//    public void setEmployees(List<Employee> employees){
//        this.employees = employees;
//    }

    @Id
    private int deptId;

    private String deptName;

   
    private String managerName;

    
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Department(){}

    public Department(int deptId, String deptName, String managerName){
        this.deptId = deptId;
        this.deptName = deptName;
        this.managerName = managerName;
    }

    public int getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getManagerName() {
        return managerName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees){
        this.employees = employees;
    }
}