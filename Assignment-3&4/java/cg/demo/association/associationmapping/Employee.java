package cg.demo.association.associationmapping;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Employee {

//    @Id
//    private int empId;
//    private String empName;
//    private int salary;
//
//    public Employee(){}
//
//    public Employee(int empId,String empName,int salary){
//        this.empId = empId;
//        this.empName = empName;
//        this.salary=salary;
//    }
//    public int getEmpId() {
//        return empId;
//    }
//
//    public String getEmpName() {
//        return empName;
//    }
//    public int getsalary() {
//        return salary;
//    }

    @Id
    private int empId;

    private String empName;

    //
    private int salary;

    // 
    @ElementCollection
    @CollectionTable(name = "employee_mobiles", joinColumns = @JoinColumn(name = "emp_id"))
    @Column(name = "mobile_number")
    private Set<String> mobileNumbers;

    // 
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    // Existing Embedded (kept as is)
    @Embedded
    private Address address;

    public Employee(){}

    public Employee(int empId, String empName, int salary, Set<String> mobileNumbers, Address address, Department department){
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.mobileNumbers = mobileNumbers;
        this.address = address;
        this.department = department;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public int getSalary() {
        return salary;
    }

    public Set<String> getMobileNumbers() {
        return mobileNumbers;
    }

    public Department getDepartment() {
        return department;
    }

    public Address getAddress() {
        return address;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}