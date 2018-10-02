package com.minance.Service;

import com.minance.model.Employee;
import com.minance.model.EmployeeCreateRequest;

public interface EmployeeService {

	public Employee createEmployee(EmployeeCreateRequest createRequest);
	public Employee updateEmployee(EmployeeCreateRequest createRequest , Long id);
	public Boolean DeleteEmployee(Long id);
}
