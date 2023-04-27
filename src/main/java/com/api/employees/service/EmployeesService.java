package com.api.employees.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.employees.model.Employees;

@Service
public interface EmployeesService {

	public Employees createEmployees(Employees employees);

	public List<Employees> getEmployees();

	public Employees employeesGetById(long id);

	public Employees updateEmployees(Employees employees, long id);

	public void deleteEmployees(long id);

}
