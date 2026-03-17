////////package cg.demo.associationmapping;
////////
////////import jakarta.persistence.*;
////////import java.util.*;
////////
////////public class App {
////////
////////    public static void main(String[] args) {
////////
////////        EntityManagerFactory emf =
////////                Persistence.createEntityManagerFactory("mapping-pu");
////////
////////        EntityManager em = emf.createEntityManager();
////////
////////        // ---------------- INSERT ----------------
////////
//////////        em.getTransaction().begin();
//////////
//////////        Citizen citizen = new Citizen("Amit", "Delhi");
//////////        IndianPassport passport = new IndianPassport("IND999888");
//////////
//////////        citizen.setPassport(passport);
//////////        passport.setCitizen(citizen);
//////////
//////////        em.persist(citizen);
//////////
//////////        em.getTransaction().commit();
////////
//////////        Citizen c1 = new Citizen("Amit", "Delhi");
//////////        Citizen c2 = new Citizen("Rahul", "Mumbai");
//////////
//////////        IndianPassport p1 = new IndianPassport("IND111");
//////////        IndianPassport p2 = new IndianPassport("IND222");
//////////
//////////        c1.setPassport(p1);
//////////        p1.setCitizen(c1);
//////////
//////////        c2.setPassport(p2);
//////////        p2.setCitizen(c2);
//////////
//////////        em.persist(c1);
//////////        em.persist(c2);
//////////
//////////        // ---------------- FETCH ----------------
//////////
//////////        em.getTransaction().begin();
//////////
//////////        Citizen fetchedCitizen = em.find(Citizen.class, 1);
//////////
//////////        System.out.println("Citizen Name: " + fetchedCitizen.getName());
//////////        System.out.println("City: " + fetchedCitizen.getCity());
//////////
//////////        System.out.println("Passport Number: " +
//////////                fetchedCitizen.getPassport().getPassportNumber());
//////////
//////////        System.out.println("Passport belongs to: " +
//////////                fetchedCitizen.getPassport().getCitizen().getName());
//////////
//////////        em.getTransaction().commit();
//////////
//////////
//////////        // ---------------- UPDATE ----------------
//////////
//////////        em.getTransaction().begin();
//////////
//////////        Citizen citizenToUpdate = em.find(Citizen.class, 1);
//////////        citizenToUpdate.setCity("Mumbai");
//////////
//////////        em.getTransaction().commit();
//////////
//////////        System.out.println("City updated successfully");
//////////
//////////
//////////        // ---------------- DELETE ----------------
//////////
//////////        em.getTransaction().begin();
//////////
//////////        Citizen citizenToDelete = em.find(Citizen.class, 1);
//////////        em.remove(citizenToDelete);
//////////
//////////        em.getTransaction().commit();
//////////
//////////        System.out.println("Citizen and passport deleted");
////////
////////
//////////        em.getTransaction().begin();
//////////
//////////        Employee e1 = new Employee("Rahul", 50000);
//////////        Employee e2 = new Employee("Amit", 60000);
//////////
//////////        Employee e3 = new Employee("Priya", 55000);
//////////        Employee e4 = new Employee("Sneha", 65000);
//////////
//////////        Department d1 = new Department("IT");
//////////        Department d2 = new Department("HR");
//////////
//////////        List<Employee> empList1 = new ArrayList<>();
//////////        empList1.add(e1);
//////////        empList1.add(e2);
//////////
//////////        List<Employee> empList2 = new ArrayList<>();
//////////        empList2.add(e3);
//////////        empList2.add(e4);
//////////
//////////        d1.setEmployees(empList1);
//////////        d2.setEmployees(empList2);
//////////
//////////        em.persist(d1);
//////////        em.persist(d2);
//////////
//////////        em.getTransaction().commit();
//////////        em.getTransaction().begin();
//////////
//////////        Department dept = em.find(Department.class, 1);
//////////
//////////        System.out.println("Department: " + dept.getDeptName());
//////////
//////////        for(Employee emp : dept.getEmployees()) {
//////////            System.out.println(emp.getEmpName());
//////////        }
//////////        
//////////
//////////        em.getTransaction().commit();
//////////        em.getTransaction().begin();
//////////
//////////        Department dept2 = em.find(Department.class,2);
//////////
//////////        System.out.println("Department: " + dept2.getDeptName());
//////////
//////////        for(Employee emp : dept2.getEmployees()){
//////////            System.out.println(emp.getEmpName());
//////////        }
//////////
//////////        em.getTransaction().commit();
////////        
////////        
////////        em.getTransaction().begin();
////////
////////        Department d1 = new Department("IT");
////////        Department d2 = new Department("HR");
////////
////////        Employee e1 = new Employee("Rahul",50000);
////////        Employee e2 = new Employee("Amit",60000);
////////        Employee e3 = new Employee("Priya",55000);
////////        Employee e4 = new Employee("Sneha",65000);
////////
////////        e1.setDepartment(d1);
////////        e2.setDepartment(d1);
////////
////////        e3.setDepartment(d2);
////////        e4.setDepartment(d2);
////////
////////        List<Employee> empList1 = new ArrayList<>();
////////        empList1.add(e1);
////////        empList1.add(e2);
////////
////////        List<Employee> empList2 = new ArrayList<>();
////////        empList2.add(e3);
////////        empList2.add(e4);
////////
////////        d1.setEmployees(empList1);
////////        d2.setEmployees(empList2);
////////
////////        em.persist(d1);
////////        em.persist(d2);
////////
////////        em.getTransaction().commit();
////////        em.getTransaction().begin();
////////
////////        Department dept = em.find(Department.class,1);
////////
////////        System.out.println("Department: "+dept.getDeptName());
////////
////////        for(Employee e : dept.getEmployees()){
////////            System.out.println(e.getEmpName());
////////        }
////////
////////        em.getTransaction().commit();
////////        em.close();
////////        emf.close();
////////    }
////////}
//////
//////
//
//
//
//
//package cg.demo.associationmapping;
//
//import cg.demo.associationmapping.dao.EmployeeDAO;
//import cg.demo.associationmapping.Employee;
//
//import java.util.List;
//
//public class App {
//
//    public static void main(String[] args) {
//
//        EmployeeDAO dao = new EmployeeDAO();
//
//        // INSERT DATA
//        dao.saveEmployee(new Employee("Rahul", 50000));
//        dao.saveEmployee(new Employee("Amit", 70000));
//        dao.saveEmployee(new Employee("Neha", 90000));
//
//        System.out.println("\nAll Employees");
//
//        List<Employee> list = dao.getAllEmployees();
//
//        for(Employee e : list)
//        {
//            System.out.println(e);
//        }
//
//        System.out.println("\nSalary > 60000");
//
//        List<Employee> highSalary =
//                dao.getEmployeesBySalary(60000);
//
//        for(Employee e : highSalary)
//        {
//            System.out.println(e);
//        }
//
//    }
//}



//assignment 4:
//package cg.demo.associationmapping;
//
//import cg.demo.associationmapping.dao.EmployeeDAO;
//import java.util.*;
//
//public class App {
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        EmployeeDAO dao = new EmployeeDAO();
//
//        while(true) {
//
//            System.out.println("\n1 Insert Employee");
//            System.out.println("2 Fetch All Employees");
//            System.out.println("3 Count Employees Per Department");
//            System.out.println("4 Employees By Department");
//            System.out.println("5 Search Employee By Mobile");
//
//            int choice = sc.nextInt();
//
//            switch(choice) {
//
//                case 1:
//
//                    System.out.println("Employee Name:");
//                    String name = sc.next();
//
//                    System.out.println("Salary:");
//                    double salary = sc.nextDouble();
//
//                    System.out.println("Department Name:");
//                    String dname = sc.next();
//
//                    System.out.println("Manager Name:");
//                    String mname = sc.next();
//
//                    Set<String> mobiles = new HashSet<>();
//
//                    System.out.println("Enter 2 mobile numbers");
//
//                    mobiles.add(sc.next());
//                    mobiles.add(sc.next());
//
//                    Department dept =
//                            new Department(dname, mname);
//
//                    Employee emp =
//                            new Employee(name, salary, mobiles);
//
//                    dao.insertEmployee(emp, dept);
//
//                    break;
//
//                case 2:
//                    dao.fetchAllEmployees();
//                    break;
//
//                case 3:
//                    dao.countEmployeesDept();
//                    break;
//
//                case 4:
//                    System.out.println("Enter Department Name:");
//                    dao.employeesByDepartment(sc.next());
//                    break;
//
//                case 5:
//                    System.out.println("Enter Mobile Number:");
//                    dao.searchByMobile(sc.next());
//                    break;
//            }
//        }
//    }
//}



//Address addr = new Address(201001, "Ghaziabad", "UP");
//
//Employee emp = new Employee("shray", addr);
//
//EntityTransaction tx = em.getTransaction();
//
//tx.begin();
//
//em.persist(emp);
//
//tx.commit();



package cg.demo.associationmapping;

import jakarta.persistence.*;

public class App {

    public static void main(String[] args) {

       
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("mapping-pu");

       
        EntityManager em = emf.createEntityManager();

       
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();

          
            Address addr = new Address(201001, "Ghaziabad", "Uttar Pradesh");

           
            Employee emp = new Employee("Shray", addr);

          
            em.persist(emp);

            tx.commit();
            tx.begin();
            Address addr1 = new Address(201010, "Meerut", "UP");
            Employee emp1 = new Employee("ALice", addr1);
            em.persist(emp1);
            tx.commit();

            System.out.println("Employee inserted successfully!");

        }
        catch(Exception e) {

            if(tx.isActive())
                tx.rollback();

            e.printStackTrace();
        }

    
        em.close();
        emf.close();
    }
}