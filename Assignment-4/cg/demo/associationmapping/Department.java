//////package cg.demo.associationmapping;
//////
//////import jakarta.persistence.*;
//////import java.util.*;
//////
//////@Entity
//////public class Department {
//////
//////    @Id
//////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//////    private int deptId;
//////
//////    private String deptName;
//////
//////    @OneToMany(cascade = CascadeType.ALL)
//////    private List<Employee> employees;
//////
//////    public Department() {}
//////
//////    public Department(String deptName) {
//////        this.deptName = deptName;
//////    }
//////
//////    public int getDeptId() {
//////        return deptId;
//////    }
//////
//////    public String getDeptName() {
//////        return deptName;
//////    }
//////
//////    public List<Employee> getEmployees() {
//////        return employees;
//////    }
//////
//////    public void setEmployees(List<Employee> employees) {
//////        this.employees = employees;
//////    }
//////}
////
////package cg.demo.associationmapping;
////
////import jakarta.persistence.*;
////import java.util.*;
////
////@Entity
////public class Department {
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private int deptId;
////
////    private String deptName;
////
////    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
////    private List<Employee> employees;
////
////    public Department(){}
////
////    public Department(String deptName){
////        this.deptName = deptName;
////    }
////
////    public int getDeptId() {
////        return deptId;
////    }
////
////    public String getDeptName() {
////        return deptName;
////    }
////
////    public List<Employee> getEmployees() {
////        return employees;
////    }
////
////    public void setEmployees(List<Employee> employees) {
////        this.employees = employees;
////    }
////}
//
//
//
//
//
//
//
//
//
//
//
//package cg.demo.associationmapping;
//
//import jakarta.persistence.*;
//import java.util.*;
//















//@Entity
//public class Department {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int deptId;
//
//    private String deptName;
//
//    @OneToMany(mappedBy = "department")
//    private List<Employee> employees;
//
//    public Department() {}
//
//    public Department(String deptName) {
//        this.deptName = deptName;
//    }
//
//    public int getDeptId() {
//        return deptId;
//    }
//
//    public String getDeptName() {
//        return deptName;
//    }
//
//    public void setDeptName(String deptName) {
//        this.deptName = deptName;
//    }
//
//    public List<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(List<Employee> employees) {
//        this.employees = employees;
//    }
//}



//Assignment 4:
package cg.demo.associationmapping;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String managerName;

    //@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    //private List<Employee> employees;

    public Department() {}

    public Department(String name, String managerName) {
        this.name = name;
        this.managerName = managerName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getManagerName() {
        return managerName;
    }

//    public List<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(List<Employee> employees) {
//        this.employees = employees;
//    }
}