package cg.demo.jpahibernates;

import cg.demo.jpahibernates.entities.Employee;
import jakarta.persistence.*;
import java.util.*;

public class EmployeeDB_Backend {

    private EntityManagerFactory emf;
    private EntityManager em;

    public EmployeeDB_Backend() throws Exception {
        emf = Persistence.createEntityManagerFactory("JPA-PU");
        em = emf.createEntityManager();
    }

    public List<Employee> fetchAll() throws Exception {
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }

    public Employee insertEmployee(Employee emp) throws Exception {
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
        return emp;
    }

    public double updateSalary(int id, double newSalary) throws Exception {
        Employee emp = em.find(Employee.class, id);
        if (emp != null) {
            em.getTransaction().begin();
            emp.setSalary(newSalary);
            em.merge(emp);
            em.getTransaction().commit();
            return newSalary;
        }
        return -1;
    }

    public Employee fetchById(int id) throws Exception {
        return em.find(Employee.class, id);
    }

    public Employee deleteById(int id) throws Exception {
        Employee emp = em.find(Employee.class, id);
        if (emp != null) {
            em.getTransaction().begin();
            em.remove(emp);
            em.getTransaction().commit();
        }
        return emp;
    }

    @SuppressWarnings("unchecked")
	public List<Object[]> countEmployeesByDept() throws Exception {
        Query query = em.createQuery("SELECT e.dept, COUNT(e) FROM Employee e GROUP BY e.dept");
        return query.getResultList();
    }

    public List<Employee> findBySalary(double salary) throws Exception {
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.salary = :sal", Employee.class);
        query.setParameter("sal", salary);
        return query.getResultList();
    }

    public Employee findByPhone(long phone) throws Exception {
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.phoneno = :ph", Employee.class);
        query.setParameter("ph", phone);
        List<Employee> list = query.getResultList();
        if(list.isEmpty()) return null;
        return list.get(0);
    }

    public void close() throws Exception {
        em.close();
        emf.close();
    }
}