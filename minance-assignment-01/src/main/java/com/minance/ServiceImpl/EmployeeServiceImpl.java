package com.minance.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minance.Repository.EmployeeRepository;
import com.minance.Service.EmployeeService;
import com.minance.model.Employee;
import com.minance.model.EmployeeCreateRequest;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(EmployeeCreateRequest createRequest) {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		emp.setFirstName(createRequest.getFname());
		emp.setLastName(createRequest.getLname());
		emp.setEmployeeId(createRequest.getId());

		
		return employeeRepository.save(emp);
	}

	@Override
	public Employee updateEmployee(EmployeeCreateRequest createRequest ,Long id) {
		// TODO Auto-generated method stub
		Employee e = employeeRepository.getOne(id);
		e.setFirstName(createRequest.getFname());
		e.setLastName(createRequest.getLname());

		
		return employeeRepository.save(e);
	}

	@Override
	public Boolean DeleteEmployee(Long id) {
		// TODO Auto-generated method stub
		Boolean isDeleted = false;
		try {
			employeeRepository.deleteById(id);
			isDeleted = true;
		}catch(Exception ex) {
			System.out.println("Exception came while Deleting Employee");
		}
		return isDeleted;
	}

}
