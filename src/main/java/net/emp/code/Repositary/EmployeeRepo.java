package net.emp.code.Repositary;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import net.emp.code.Entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	

	List<Employee>findAll();
	

}
