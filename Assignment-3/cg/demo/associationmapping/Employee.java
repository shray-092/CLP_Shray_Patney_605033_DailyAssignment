//////package cg.demo.associationmapping;
//////
//////import jakarta.persistence.*;
//////
//////@Entity
//////public class Employee {
//////
//////    @Id
//////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//////    private int empId;
//////
//////    private String empName;
//////
//////    private double salary;
//////
//////    public Employee() {}
//////
//////    public Employee(String empName, double salary) {
//////        this.empName = empName;
//////        this.salary = salary;
//////    }
//////
//////    public int getEmpId() {
//////        return empId;
//////    }
//////
//////    public String getEmpName() {
//////        return empName;
//////    }
//////
//////    public double getSalary() {
//////        return salary;
//////    }
//////
//////    public void setEmpName(String empName) {
//////        this.empName = empName;
//////    }
//////
//////    public void setSalary(double salary) {
//////        this.salary = salary;
//////    }
//////}
////
////
////
////package cg.demo.associationmapping;
////
////import jakarta.persistence.*;
////
////@Entity
////public class Employee {
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private int empId;
////
////    private String empName;
////
////    private double salary;
////
////    @ManyToOne
////    @JoinColumn(name = "dept_id")
////    private Department department;
////
////    public Employee() {}
////
////    public Employee(String empName, double salary) {
////        this.empName = empName;
////        this.salary = salary;
////    }
////
////    public int getEmpId() {
////        return empId;
////    }
////
////    public String getEmpName() {
////        return empName;
////    }
////
////    public double getSalary() {
////        return salary;
////    }
////
////    public Department getDepartment() {
////        return department;
////    }
////
////    public void setDepartment(Department department) {
////        this.department = department;
////    }
////}
//
//
//
//package cg.demo.associationmapping;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name="employee")
//public class Employee {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    private String name;
//
//    private double salary;
//
//    public Employee() {}
//
//    public Employee(String name, double salary) {
//        this.name = name;
//        this.salary = salary;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//
//    @Override
//    public String toString() {
//        return "Employee [id=" + id +
//                ", name=" + name +
//                ", salary=" + salary + "]";
//    }
//}



//Assignment 4:
//package cg.demo.associationmapping;
//
//import jakarta.persistence.*;
//import java.util.*;
//
//@Entity
//public class Employee {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    private String name;
//
//    private double salary;
//
//    @ElementCollection
//    private Set<String> mobileNumbers;
//
//    @ManyToOne
//    @JoinColumn(name = "dept_id")
//    private Department department;
//
//    public Employee() {}
//
//    public Employee(String name, double salary, Set<String> mobileNumbers) {
//        this.name = name;
//        this.salary = salary;
//        this.mobileNumbers = mobileNumbers;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public Set<String> getMobileNumbers() {
//        return mobileNumbers;
//    }
//
//    public void setDepartment(Department department) {
//        this.department = department;
//    }
//
//    public Department getDepartment() {
//        return department;
//    }
//}



package cg.demo.associationmapping;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Embedded
    private Address address;

    public Employee() {}

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}