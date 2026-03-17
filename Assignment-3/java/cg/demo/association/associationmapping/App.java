package cg.demo.association.associationmapping;

import jakarta.persistence.*;
import java.util.*;

public class App {

    public static void main(String[] args) {

//        OLD CODE (kept as requested)
//        EntityManagerFactory emf =
//        Persistence.createEntityManagerFactory("JPAHibernate");

        Scanner sc = new Scanner(System.in);

        EmployeeDAO dao = new EmployeeDAO();

        while(true)
        {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Insert Employee");
            System.out.println("2. Fetch All Employees with Department");
            System.out.println("3. Count Employees per Department");
            System.out.println("4. Employees by Department Name");
            System.out.println("5. Find Employee by Mobile Number");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                    System.out.println("Enter Emp Id:");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Name:");
                    String name = sc.nextLine();

                    System.out.println("Enter Salary:");
                    int salary = sc.nextInt();

                    System.out.println("Enter Department Id:");
                    int deptId = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Department Name:");
                    String deptName = sc.nextLine();

                    System.out.println("Enter Manager Name:");
                    String manager = sc.nextLine();

                    System.out.println("Enter number of mobile numbers:");
                    int n = sc.nextInt();
                    sc.nextLine();

                    Set<String> mobiles = new HashSet<>();
                    for(int i=0;i<n;i++)
                    {
                        mobiles.add(sc.nextLine());
                    }

                    Address addr = new Address("Street","City","Pincode");

                    dao.insertEmployee(id, name, salary, mobiles, addr, deptId, deptName, manager);
                    break;

                case 2:
                    dao.fetchAllEmployees();
                    break;

                case 3:
                    dao.countEmployeesPerDept();
                    break;

                case 4:
                    sc.nextLine();
                    System.out.println("Enter Department Name:");
                    String dname = sc.nextLine();
                    dao.findByDeptName(dname);
                    break;

                case 5:
                    sc.nextLine();
                    System.out.println("Enter Mobile Number:");
                    String mob = sc.nextLine();
                    dao.findByMobile(mob);
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}