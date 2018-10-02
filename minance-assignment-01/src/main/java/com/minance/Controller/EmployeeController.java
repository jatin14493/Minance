package com.minance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.minance.Repository.EmployeeRepository;
import com.minance.Service.EmployeeService;
import com.minance.model.Employee;
import com.minance.model.EmployeeCreateRequest;

@RestController
@RequestMapping(value = "api/v1/employee")
public class EmployeeController {


	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@GetMapping("/accounts/{id}")
    public Employee getEmployee(@PathVariable Long id) {
		Employee emp =employeeRepository.getOne(id);
		System.out.println("Employee data : " + emp.toString());
        return emp;
    }
	
	@GetMapping("/accounts")
	public void getAllEmployee() {
		List<Employee> list = employeeRepository.findAll();
		list.forEach(t -> System.out.println(t.toString()));
	}

	@PostMapping("/create")
	String createEmployee(@RequestBody EmployeeCreateRequest createRequest) {

		Employee emp = employeeService.createEmployee(createRequest);
		
		
		if(null!=emp) {
			System.out.println("Value of Employee: "+ emp.toString());
			return "Successfully Created";
			}
		else
			return "Employee Creation Failed!!";
	}


	@PutMapping("/update/{id}")
	String updateEmployee(@RequestBody EmployeeCreateRequest createRequest , @PathVariable Long id) {

		Employee emp = employeeService.updateEmployee(createRequest,id);
		System.out.println("Employee Details :" + emp.toString());
		return "Employee Updated";

	}

	@DeleteMapping("/delete/{id}")
	String deleteEmployee(@PathVariable Long id) {

		Boolean isDeleted = employeeService.DeleteEmployee(id);

		if(isDeleted)
			return "Employee Deleted";
		else
			return "Error Deleting Employee";
	}

}
