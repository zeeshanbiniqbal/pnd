package com.digicl.pnd.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.digicl.pnd.dto.ResponseDTO;
import com.digicl.pnd.service.GenericService;
import com.digicl.pnd.util.Constant;

public class GenericController<T> {
	@Autowired
	private GenericService<T> service;

	@PostMapping
	public ResponseEntity<ResponseDTO> create(@Valid @RequestBody T dto) {
		return new ResponseEntity<>(new ResponseDTO(Constant.MESSAGE_ENTITY_CREATED_SUCCESSFULLY, service.create(dto)),
				HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<ResponseDTO> update(@Valid @RequestBody T dto) {
		return new ResponseEntity<>(new ResponseDTO(Constant.MESSAGE_ENTITY_UPDATED_SUCCESSFULLY, service.update(dto)),
				HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO> delete(@Valid @PathVariable long id) {
		service.delete(id);
		return new ResponseEntity<>(new ResponseDTO(Constant.MESSAGE_ENTITY_DELETED_SUCCESSFULLY, null), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO> get(@Valid @PathVariable long id) {
		return new ResponseEntity<>(
				new ResponseDTO(Constant.MESSAGE_SINGLE_ENTITY_FOUND_SUCCESSFULLY, service.read(id)), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<ResponseDTO> getAll() {
		return new ResponseEntity<>(new ResponseDTO(Constant.MESSAGE_ENTITY_LIST_FOUND_SUCCESSFULLY, service.readAll()),
				HttpStatus.OK);
	}
}
