package com.api.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.employees.model.Employees;
import com.api.employees.service.EmployeesService;


@RestController

public class EmployeesController {

	@Autowired
	private EmployeesService employeesService;

	@GetMapping("/employees/{id}")
	@ManagedOperation(description = "Retorna um usuário por Id")
	public Employees getUserById(@PathVariable("id") long id) {
		return employeesService.employeesGetById(id);
	}

	@GetMapping("/employees")
	@ManagedOperation(description = "Retorna uma lista de usuários")
	public List<Employees> getUsers() {
		return employeesService.getEmployees();
	}

	@PostMapping("/add")
	@ManagedOperation(description = "Cria um usuário")
	public ResponseEntity<Employees> createEmployees(@RequestBody Employees employees) {
		Employees createEmployees = employeesService.createEmployees(employees);
		return ResponseEntity.ok(createEmployees);
	}

	@PutMapping("/update/{id}")
	@ManagedOperation(description = "Atualiza um usuário por Id")
	public ResponseEntity<Employees> updateEmployeesById(@RequestBody Employees employees,
			@PathVariable("id") long id) {
		Employees updatedEmployees = employeesService.updateEmployees(employees, id);
		return ResponseEntity.ok(updatedEmployees);
	}

	@DeleteMapping("/delete/{id}")
	@ManagedOperation(description = " Deleta um funcionário por Id ")
	public String deleteEmployees(@PathVariable("id") long id) {
		employeesService.deleteEmployees(id);
		return "Employees Deleted Successfully..";
	}

}
