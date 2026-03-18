package cg.demo.association.servicelayer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepo {

    private Map<Integer, Employee> emp = new HashMap<>();
    public Employee del(int id) {
    	if(emp.containsKey(id)){
    		emp.remove(emp.get(id));
    		return emp.get(id);
    		
    		
    	}
    	return null;
    	
    }
    public Employee insert(Employee e) {
        int id = e.getId();

        if(emp.containsKey(id)) {
            System.out.println("Employee with id " + id + " already exists");
            return null;
        }
        System.out.println("added Success");

        emp.put(id, e);
        return e;
    }

    public Employee findById(int id) {
    	    if(!emp.containsKey(id)) {
    	    		System.out.println("not present");
    	    }
    	    
        return emp.get(id);
    }

    public Map<Integer, Employee> fetchAll() {
        return emp;
    }
}