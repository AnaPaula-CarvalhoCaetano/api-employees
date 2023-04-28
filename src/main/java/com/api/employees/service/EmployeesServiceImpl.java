package com.api.employees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.employees.model.Employees;
import com.api.employees.repository.EmployeesRepository;

@Service
public class EmployeesServiceImpl implements EmployeesService {

	@Autowired
	private EmployeesRepository employeesRepository;

	@Override
	public Employees createEmployees(Employees employees) {
		return employeesRepository.save(employees);
	}

	@Override
	public List<Employees> getEmployees() {
		return (List<Employees>) employeesRepository.findAll();
	}

	@Override
	public Employees employeesGetById(long id) {
		return employeesRepository.findById(id).get();
	}

	@Override
	public void deleteEmployees(long id) {
		employeesRepository.deleteById(id);

	}

	@Override
	public Employees updateEmployees(Employees employees, long id) {
		Employees employees1 = employeesRepository.findById(id).get();

		employees1.setName(employees1.getName());
		employees1.setPhone(employees1.getPhone());
		employees1.setEmail(employees1.getEmail());
		employees1.setAddress(employees1.getAddress());
		return employeesRepository.save(employees1);
	}
}
