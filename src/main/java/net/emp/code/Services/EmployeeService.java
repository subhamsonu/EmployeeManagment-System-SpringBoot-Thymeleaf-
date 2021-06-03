package net.emp.code.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import net.emp.code.Entity.Employee;
import net.emp.code.Repositary.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo emprepo;
	
	
	//Save A Employee
	public Employee saveEmp(@RequestBody Employee employee) {
	Employee emp =this.emprepo.save(employee);
	return emp;
	
	}
	
	//Getting Employee
	
	public List<Employee> getEmployees(){
		return this.emprepo.findAll();
	}
	
	
	//Get Employee By Id
	
	public Employee getEmployeeById( int id) {
	return emprepo.findById(id).orElse(null);
	}
	
	//Update Employee
	
	public Employee editEmployee(Employee employee ) {
		Employee emp = emprepo.findById(employee.getId()).orElse(null);
		emp.setMail(employee.getMail());
		emp.setName(employee.getName());
		emp.setSalary(employee.getSalary());
		return emprepo.save(emp);
	}
	
	
	//Delete By ID
	
	public String deleteEmployee(int id) {
		 emprepo.deleteById(id);
		 return "Employee removed id =  " +id  ;
	}
	

}
