package com.bancounion.services.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.bancounion.model.EmployeesRequest;
import com.bancounion.model.entity.Employees;
import com.bancounion.repository.EmployeesRepository;
import com.bancounion.services.ApiRestI;

/**
 * @author Jefferson Alexander Moreno Barrera
 *         {@code public class ApiRestImplement}
 */
@Service
public class ApiRestImplement implements ApiRestI {

	@Autowired
	EmployeesRepository employeesRepository;

	/**
	 *
	 * Description: metodo para consultar todos los registros;
	 *
	 * @return retorna una lista con todos los empleados 
	 */
	public Optional<Iterable<Employees>> get() {
		return Optional.ofNullable(employeesRepository.findAll());
	}
	/**
	 *
	 * Description: metodo para buscar y actualizar;
	 *
	 * @return retorna el empleado actualizado 
	 */
	public Employees put(@RequestBody EmployeesRequest body) {
		Employees employeesEntity = new Employees();
		Optional<Employees> emp=employeesRepository.findById(Integer.toString(body.getId()));
		if(emp.isPresent()) {
			employeesEntity.setId(body.getId());
			employeesEntity.setName(body.getName());
			return employeesRepository.save(employeesEntity);
		}
		return employeesEntity;
	}
	/**
	 *
	 * Description: metodo crear un nuevo registro;
	 *
	 * @return retorna el empleado actualizado
	 */
	public Employees post(@RequestBody EmployeesRequest body) {
		Employees employeesEntity = new Employees();
		employeesEntity.setId(body.getId());
		employeesEntity.setName(body.getName());
		return employeesRepository.save(employeesEntity);
	}

	/**
	 *
	 * Description: metodo para eliminar el registro por ID;
	 *
	 * @return retorna el empleado actualizado 
	 */
	public String delete(@RequestBody EmployeesRequest body) {
		employeesRepository.deleteById(String.valueOf(body.getId()));
		return "OK";
	}

}
