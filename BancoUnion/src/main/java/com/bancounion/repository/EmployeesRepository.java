package com.bancounion.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bancounion.model.entity.Employees;

@Repository
public interface EmployeesRepository extends CrudRepository<Employees, String> {

}
