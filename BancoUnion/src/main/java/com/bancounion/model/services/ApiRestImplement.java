package com.bancounion.model.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.bancounion.model.EmployeesRequest;
import com.bancounion.model.dao.EmployeesRepository;
import com.bancounion.model.entity.Employees;
import com.google.gson.Gson;

/**
 * @author Jefferson Alexander Moreno Barrera
 *         {@code public class ApiRestImplement}
 */
@Service
public class ApiRestImplement implements ApiRestI {
	private static final Logger logger = LoggerFactory.getLogger(ApiRestImplement.class);
	public static final String ERROR = "ERROR EN LA API";
	private Gson gson = new Gson();

	@Autowired
	EmployeesRepository employeesRepository;

	/**
	 *
	 * Description: metodo para consultar todos los registros;
	 *
	 * @return retorna una lista con todos los empleados
	 */
	public Iterable<Employees> get() {
		try {
			Iterable<Employees> employeesArrays = employeesRepository.findAll();
			if (logger.isDebugEnabled()) {
				logger.info("Registro encontrado {}", gson.toJson(employeesArrays));
			}
			return employeesArrays;
		} catch (Exception e) {
			logger.error("Error buscando informacion por causa {}", e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ERROR);
		}
	}

	/**
	 *
	 * Description: metodo para buscar y actualizar;
	 *
	 * @return retorna el empleado actualizado
	 */
	public Employees put(@RequestBody EmployeesRequest body) {
		Employees employeesEntity = new Employees();
		Optional<Employees> employees = employeesRepository.findById(body.getId());
		if (employees.isPresent()) {
			employeesEntity.setId(body.getId());
			employeesEntity.setName(body.getName());
			if (!logger.isDebugEnabled()) {
				logger.info("Registro actualizado {}", gson.toJson(employeesEntity));
			}
			return employeesRepository.save(employeesEntity);
		} else {
			logger.error("datos no encontrados con id {}", body.getId());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"no existe informacion en base de datos para el id:" + body.getId());
		}
	}

	/**
	 *
	 * Description: metodo crear un nuevo registro;
	 *
	 * @return retorna el empleado actualizado
	 */
	public Employees post(@RequestBody EmployeesRequest body) {
		try {
			Employees employeesEntity = new Employees();
			employeesEntity.setId(body.getId());
			employeesEntity.setName(body.getName());
			if (logger.isDebugEnabled()) {
				logger.info("Registro insertado {}", gson.toJson(employeesEntity));
			}
			return employeesRepository.save(employeesEntity);
		} catch (Exception e) {
			logger.error("Error registrando informacion {}", e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ERROR);
		}
	}

	/**
	 *
	 * Description: metodo para eliminar el registro por ID;
	 *
	 * @return retorna el empleado actualizado
	 */
	public String delete(@RequestBody EmployeesRequest body) {
		try {
			employeesRepository.deleteById(String.valueOf(body.getId()));
			logger.info("Registro eliminado con id {}", body.getId());
			return "Registro eliminado con id:" + body.getId();
		} catch (Exception e) {
			logger.error("Error eliminando informacion {}", e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ERROR);
		}
	}
}
