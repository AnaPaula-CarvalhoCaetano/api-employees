package com.api.employees.repository;

import org.springframework.data.repository.CrudRepository;

import com.api.employees.model.Employees;

public interface EmployeesRepository extends CrudRepository<Employees, Long> {

}
