package com.bancounion.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bancounion.model.EmployeesRequest;
import com.bancounion.model.entity.Employees;
import com.bancounion.model.services.ApiRestImplement;
import com.google.gson.Gson;

/**
 * @author Jefferson Alexander Moreno Barrera
 *         {@code public class ApiRestController}
 */

@RestController
@RequestMapping(path = "/V1/API/")
public class ApiRestController {

	private static final Logger logger = LoggerFactory.getLogger(ApiRestController.class);
	private Gson gson = new Gson();

	@Autowired
	ApiRestImplement apiRestImplement;

	@GetMapping("get")
	public ResponseEntity<Iterable<Employees>> get() {
		logger.info("inicio servicio get");
		return new ResponseEntity<>(apiRestImplement.get(), HttpStatus.OK);
	}

	@PutMapping("put")
	public ResponseEntity<Employees> put(@Valid @RequestBody EmployeesRequest body) {
		if (logger.isDebugEnabled()) {
			logger.info("inicio servicio put con body {}", gson.toJson(body));
		}
		if (body == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "no existen datos de entrada");
		}
		return new ResponseEntity<>(apiRestImplement.put(body), HttpStatus.OK);
	}

	@PostMapping("post")
	public ResponseEntity<Employees> post(@Valid @RequestBody EmployeesRequest body) {
		if (logger.isDebugEnabled()) {
			logger.info("inicio servicio post con body {}", gson.toJson(body));
		}
		if (body == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "datos de entrada requeridos");
		}
		return new ResponseEntity<>(apiRestImplement.post(body), HttpStatus.OK);
	}

	@DeleteMapping("delete")
	public ResponseEntity<String> delete(@Valid @RequestBody EmployeesRequest body) {
		logger.info("inicio servicio delete se eliminara el registro {}", body.getId());
		if (body.getId() == 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id requerido");
		}
		return new ResponseEntity<>(apiRestImplement.delete(body), HttpStatus.OK);
	}
}
