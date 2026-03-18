package cg.demo.association.servicelayer;

import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
	@Autowired
	
	private EmployeeRepo erp;
	public Employee serviceinsert(Employee e) {
		Employee a=erp.insert(e);
		return a;
	
		
		
	}
	public Employee servicefetchbyId(int id) {
		Employee a=erp.findById(id);
		return a;
		
	}
	public Employee servicedelete(int id) {
		Employee a=erp.del(id);
		return a;
	}
	public Map<Integer,Employee>servicefetchall(){
		return erp.fetchAll();
	}

}
