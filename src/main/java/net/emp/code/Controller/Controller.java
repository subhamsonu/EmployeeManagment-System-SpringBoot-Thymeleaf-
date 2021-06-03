package net.emp.code.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import net.emp.code.Entity.Employee;
import net.emp.code.Services.EmployeeService;

@org.springframework.stereotype.Controller
public class Controller {
	 
	@Autowired
	private EmployeeService empservice;

	@GetMapping("/employees")
	
	public String viewHomePage(Model model) {
     	model.addAttribute("listofEmployees", empservice.getEmployees());
		return "index";
	}
	
	@GetMapping("/addemployeeform")
	
	public String addEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
			
	}
	
	@PostMapping("/saveEmployee")
	
	public String addEmployee(@ModelAttribute("employee") Employee employee) {
		this.empservice.saveEmp(employee);
		return "redirect:/employees";
		
	}

	@GetMapping("/editemp/{id}")

	  public String editEmployee(Model model, @PathVariable("id") int id) {
     	Employee entity = empservice.getEmployeeById(id);
		model.addAttribute("employee",entity);	
		return "edit-employee";
	
	}
	
	
	@GetMapping("/delete/{id}")
	
	public String deleteEmployee(Model model,@PathVariable int id) {
	empservice.deleteEmployee(id);
		return "redirect:/employees";
	}
	

}
