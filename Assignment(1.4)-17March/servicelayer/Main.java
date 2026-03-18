package cg.demo.association.servicelayer;

import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Service service = context.getBean(Service.class);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Insert Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Find Employee by ID");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    Employee emp = new Employee(id, name, (int) salary);
                    service.serviceinsert(emp);

                    System.out.println("Employee inserted!");
                    break;

                case 2:
                    Map<Integer, Employee> all = service.servicefetchall();

                    if (all.isEmpty()) {
                        System.out.println("No employees found");
                    } else {
                        for (Employee e : all.values()) {
                            System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int searchId = sc.nextInt();

                    Employee found = service.servicefetchbyId(searchId);

                    if (found != null) {
                        System.out.println(found.getId() + " " + found.getName() + " " + found.getSalary());
                    } else {
                        System.out.println("Employee not found");
                    }
                    break;

                case 4:
                    System.out.println("delete.");
                    int deleteid=sc.nextInt();
                    Employee del=service.servicedelete(deleteid);
                    if(del==null) {
                    	System.out.println("cannot delete");
                    }
                    else{
                    	System.out.println("Successfully deleted");
                    	
                    }
               

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}