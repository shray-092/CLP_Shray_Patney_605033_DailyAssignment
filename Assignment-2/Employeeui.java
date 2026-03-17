package cg.demo.jpahibernates;

import cg.demo.jpahibernates.entities.Employee;
import java.util.*;

public class EmployeeDB_UI {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            EmployeeDB_Backend db = new EmployeeDB_Backend();
            int choice = 0;

            while (choice != 9) {

                System.out.println("\n1 Fetch All Employees");
                System.out.println("2 Insert Employee");
                System.out.println("3 Update Salary");
                System.out.println("4 Fetch Employee by ID");
                System.out.println("5 Delete Employee");
                System.out.println("6 Count Employees by Department");
                System.out.println("7 Find Employees by Salary");
                System.out.println("8 Fetch Employee by Phone");
                System.out.println("9 Exit");
                System.out.print("Enter choice: ");

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                case 1:

                    List<Employee> list = db.fetchAll();

                    if (list.isEmpty())
                        System.out.println("No Employees Found");
                    else
                        for (Employee e : list)
                            System.out.println(e);

                    break;

                case 2:

                    Employee emp = new Employee();

                    System.out.print("ID: ");
                    emp.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Name: ");
                    emp.setEname(sc.nextLine());

                    System.out.print("Salary: ");
                    emp.setSalary(sc.nextDouble());
                    sc.nextLine();

                    System.out.print("Dept: ");
                    emp.setDept(sc.nextLine());

                    System.out.print("Phone: ");
                    emp.setPhoneno(sc.nextLong());
                    sc.nextLine();

                    db.insertEmployee(emp);
                    System.out.println("Employee Inserted");

                    break;

                case 3:

                    System.out.print("ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Salary: ");
                    double newSal = sc.nextDouble();
                    sc.nextLine();

                    double updated = db.updateSalary(uid, newSal);

                    if (updated != -1)
                        System.out.println("Salary Updated");
                    else
                        System.out.println("Employee Not Found");

                    break;

                case 4:

                    System.out.print("ID: ");
                    int fid = sc.nextInt();
                    sc.nextLine();

                    Employee fetched = db.fetchById(fid);

                    if (fetched != null)
                        System.out.println(fetched);
                    else
                        System.out.println("Employee Not Found");

                    break;

                case 5:

                    System.out.print("ID: ");
                    int did = sc.nextInt();
                    sc.nextLine();

                    Employee deleted = db.deleteById(did);

                    if (deleted != null)
                        System.out.println("Deleted Employee ID: " + deleted.getId());
                    else
                        System.out.println("Employee Not Found");

                    break;

                case 6:

                    List<Object[]> result = db.countEmployeesByDept();

                    for(Object[] row : result)
                        System.out.println("Dept: " + row[0] + " Employees: " + row[1]);

                    break;

                case 7:

                    System.out.print("Enter Salary: ");
                    double sal = sc.nextDouble();
                    sc.nextLine();

                    List<Employee> salList = db.findBySalary(sal);

                    if(salList.isEmpty())
                        System.out.println("No Employees Found");
                    else
                        for(Employee e : salList)
                            System.out.println(e);

                    break;

                case 8:

                    System.out.print("Enter Phone: ");
                    long ph = sc.nextLong();
                    sc.nextLine();

                    Employee phoneEmp = db.findByPhone(ph);

                    if(phoneEmp != null)
                        System.out.println(phoneEmp);
                    else
                        System.out.println("Employee Not Found");

                    break;

                case 9:

                    db.close();
                    System.out.println("Exited Successfully");

                    break;

                default:
                    System.out.println("Invalid Choice");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}