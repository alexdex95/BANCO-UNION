package com.bancounion.services;

import java.util.Optional;

import com.bancounion.model.EmployeesRequest;
import com.bancounion.model.entity.Employees;

/**
 * @author Jefferson Alexander Moreno Barrera
 *         {@code public interface ApiRestI}
 */
public interface ApiRestI {
	Optional<Iterable<Employees>> get();

	Employees put(EmployeesRequest body);

	Employees post(EmployeesRequest body);

	String delete(EmployeesRequest body);
}
