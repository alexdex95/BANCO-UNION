package com.bancounion.controller;

import java.util.Optional;

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

import com.bancounion.model.EmployeesRequest;
import com.bancounion.model.entity.Employees;
import com.bancounion.services.implementations.ApiRestImplement;

/**
 * @author Jefferson Alexander Moreno Barrera
 *         {@code public class ApiRestController}
 */

@RestController
@RequestMapping(path = "/V1/API/")
public class ApiRestController {

	@Autowired
	ApiRestImplement apiRestImplement;

	@GetMapping("get")
	public ResponseEntity<Optional<Iterable<Employees>>> get() {
		return new ResponseEntity<>(apiRestImplement.get(), HttpStatus.OK);
	}

	@PutMapping("put")
	public ResponseEntity<Employees> put(@RequestBody EmployeesRequest body) {
		return new ResponseEntity<>(apiRestImplement.put(body), HttpStatus.OK);
	}

	@PostMapping("post")
	public ResponseEntity<Employees> post(@RequestBody EmployeesRequest body) {
		return new ResponseEntity<>(apiRestImplement.post(body), HttpStatus.OK);
	}

	@DeleteMapping("delete")
	public ResponseEntity<String> delete(@RequestBody EmployeesRequest body) {
		return new ResponseEntity<>(apiRestImplement.delete(body), HttpStatus.OK);
	}
}
