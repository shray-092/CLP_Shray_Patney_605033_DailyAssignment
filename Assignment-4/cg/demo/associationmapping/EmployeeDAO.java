//////package cg.demo.associationmapping.dao;
//////
//////import jakarta.persistence.*;
//////import cg.demo.associationmapping.*;
//////import java.util.*;
//////
//////public class EmployeeDAO {
//////
//////    EntityManagerFactory emf =
//////            Persistence.createEntityManagerFactory("mapping-pu");
//////
//////    EntityManager em = emf.createEntityManager();
//////
//////
//////    // 1️) Insert Employee
//////    public void insertEmployee(AssignmentEmployee emp, int deptId) {
//////
//////        em.getTransaction().begin();
//////
//////        AssignmentDepartment dept = em.find(AssignmentDepartment.class, deptId);
//////
//////        emp.setDepartment(dept);
//////        dept.getEmployees().add(emp);
//////
//////        em.persist(emp);
//////
//////        em.getTransaction().commit();
//////
//////        System.out.println("Employee inserted successfully");
//////    }
//////
//////
//////    // 2️) Fetch all employees with department name and manager
//////    public void fetchAllEmployees() {
//////
//////        List<AssignmentEmployee> list =
//////                em.createQuery("SELECT e FROM Employee e", AssignmentEmployee.class)
//////                        .getResultList();
//////
//////        for(AssignmentEmployee e : list) {
//////
//////            System.out.println(
//////                    "Employee: " + e.getName() +
//////                    " | Salary: " + e.getSalary() +
//////                    " | Department: " + e.getDepartment().getName() +
//////                    " | Manager: " + e.getDepartment().getManagerName()
//////            );
//////        }
//////    }
//////
//////
//////    // 3️⃣ Count employees per department
//////    public void employeeCountPerDepartment() {
//////
//////        List<Object[]> result =
//////                em.createQuery(
//////                        "SELECT d.name, COUNT(e) FROM Department d JOIN d.employees e GROUP BY d.name"
//////                ).getResultList();
//////
//////        for(Object[] r : result) {
////
////
////
//////
//////            System.out.println(
//////                    "Department: " + r[0] +
//////                    " | Employee Count: " + r[1]
//////            );
//////        }
//////    }
//////
//////
//////    // 4️⃣ Employees working under given department
//////    public void employeesByDepartment(String deptName) {
//////
//////        List list =
//////                em.createQuery(
//////                        "SELECT e FROM Employee e WHERE e.department.name = :d",
//////                        AssignmentEmployee.class
//////                )
//////                        .setParameter("d", deptName)
//////                        .getResultList();
//////
//////        for(AssignmentEmployee e : list) {
//////
//////            System.out.println(
//////                    e.getName() + " | Salary: " + e.getSalary()
//////            );
//////        }
//////    }
//////
//////
//////    // 5️⃣ Find department using employee mobile number
//////    public void findDepartmentByMobile(String mobile) {
//////
//////        List<AssignmentEmployee> list =
//////                em.createQuery(
//////                        "SELECT e FROM Employee e JOIN e.mobileNumbers m WHERE m = :num",
//////                        AssignmentEmployee.class
//////                )
//////                        .setParameter("num", mobile)
//////                        .getResultList();
//////
//////        for(AssignmentEmployee e : list) {
//////
//////            System.out.println(
//////                    "Employee ID: " + e.getEmpId() +
//////                    " | Name: " + e.getName() +
//////                    " | Department: " + e.getDepartment().getName()
//////            );
//////        }
//////    }
//////}
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////package cg.demo.associationmapping.dao;
////
////import jakarta.persistence.*;
////import cg.demo.associationmapping.Employee;
////import java.util.*;
////
////public class EmployeeDAO {
////
////    EntityManagerFactory emf =
////            Persistence.createEntityManagerFactory("mapping-pu");
////
////    EntityManager em = emf.createEntityManager();
////
////    public List<> getAllEmployees() {
////
////        CriteriaBuilder cb = em.getCriteriaBuilder();
////
////        CriteriaQuery<> cq = cb.createQuery(Employee.class);
////
////        Root<> root = cq.from(Employee.class);
////
////        cq.select(root);
////
////        TypedQuery<> query = em.createQuery(cq);
////
////        return query.getResultList();
////    }
////}
//
//
//
//
//package cg.demo.associationmapping.dao;
//
//import cg.demo.associationmapping.Employee;
//import jakarta.persistence.*;
//import jakarta.persistence.criteria.*;
//
//import java.util.List;
//
//public class EmployeeDAO {
//
//    EntityManagerFactory emf =
//            Persistence.createEntityManagerFactory("mapping-pu");
//
//    EntityManager em = emf.createEntityManager();
//
//
//    // INSERT EMPLOYEE
//    public void saveEmployee(Employee emp) {
//
//        EntityTransaction tx = em.getTransaction();
//
//        tx.begin();
//
//        em.persist(emp);
//
//        tx.commit();
//    }
//
//
//    // FETCH USING CRITERIA QUERY
//    public List<Employee> getAllEmployees() {
//
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//
//        CriteriaQuery<Employee> cq =
//                cb.createQuery(Employee.class);
//
//        Root<Employee> root =
//                cq.from(Employee.class);
//
//        cq.select(root);
//
//        TypedQuery<Employee> query =
//                em.createQuery(cq);
//
//        return query.getResultList();
//    }
//
//
//    // FETCH SALARY > VALUE USING CRITERIA
//    public List<Employee> getEmployeesBySalary(double salary) {
//
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//
//        CriteriaQuery<Employee> cq =
//                cb.createQuery(Employee.class);
//
//        Root<Employee> root =
//                cq.from(Employee.class);
//
//        cq.select(root)
//          .where(cb.gt(root.get("salary"), salary));
//
//        return em.createQuery(cq).getResultList();
//    }
//
//}



//assignment 4:
//package cg.demo.associationmapping.dao;
//
//import jakarta.persistence.*;
//import jakarta.persistence.criteria.*;
//
//import cg.demo.associationmapping.*;
//
//import java.util.*;
//
//public class EmployeeDAO {
//
//    EntityManagerFactory emf =
//            Persistence.createEntityManagerFactory("mapping-pu");
//
//    EntityManager em = emf.createEntityManager();
//
//    EntityTransaction tx = em.getTransaction();
//
//
//    // INSERT EMPLOYEE
//
//    public void insertEmployee(Employee emp, Department dept) {
//
//        tx.begin();
//
//        emp.setDepartment(dept);
//
//        em.persist(dept);
//        em.persist(emp);
//
//        tx.commit();
//    }
//
//
//    // FETCH ALL EMPLOYEES WITH DEPARTMENT DETAILS
//
//    public void fetchAllEmployees() {
//
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//
//        CriteriaQuery<Employee> cq =
//                cb.createQuery(Employee.class);
//
//        Root<Employee> root = cq.from(Employee.class);
//
//        cq.select(root);
//
//        List<Employee> list =
//                em.createQuery(cq).getResultList();
//
//        for (Employee e : list) {
//
//            System.out.println(
//                    e.getId() + " " +
//                    e.getName() + " " +
//                    e.getSalary() + " " +
//                    e.getDepartment().getName() + " " +
//                    e.getDepartment().getManagerName()
//            );
//        }
//    }
//
//
//    // COUNT EMPLOYEES PER DEPARTMENT
//
//    public void countEmployeesDept() {
//
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//
//        CriteriaQuery<Object[]> cq =
//                cb.createQuery(Object[].class);
//
//        Root<Employee> root = cq.from(Employee.class);
//
//        Join<Employee, Department> dept =
//                root.join("department");
//
//        cq.multiselect(dept.get("name"), cb.count(root));
//
//        cq.groupBy(dept.get("name"));
//
//        List<Object[]> result =
//                em.createQuery(cq).getResultList();
//
//        for (Object[] row : result) {
//
//            System.out.println(row[0] + " : " + row[1]);
//        }
//    }
//
//
//    // EMPLOYEES BY DEPARTMENT
//
//    public void employeesByDepartment(String deptName) {
//
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//
//        CriteriaQuery<Employee> cq =
//                cb.createQuery(Employee.class);
//
//        Root<Employee> root = cq.from(Employee.class);
//
//        Join<Employee, Department> dept =
//                root.join("department");
//
//        cq.select(root)
//          .where(cb.equal(dept.get("name"), deptName));
//
//        List<Employee> list =
//                em.createQuery(cq).getResultList();
//
//        for (Employee e : list) {
//
//            System.out.println(e.getId() + " " + e.getName());
//        }
//    }
//
//
//    // SEARCH BY MOBILE NUMBER
//
//    public void searchByMobile(String mobile) {
//
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//
//        CriteriaQuery<Employee> cq =
//                cb.createQuery(Employee.class);
//
//        Root<Employee> root = cq.from(Employee.class);
//
//        Join<Employee, String> mobiles =
//                root.join("mobileNumbers");
//
//        cq.select(root)
//          .where(cb.equal(mobiles, mobile));
//
//        List<Employee> list =
//                em.createQuery(cq).getResultList();
//
//        for (Employee e : list) {
//
//            Department d = e.getDepartment();
//
//            System.out.println(
//                    e.getId() + " " +
//                    e.getName() + " " +
//                    d.getName() + " " +
//                    d.getManagerName()
//            );
//        }
//    }
//}


