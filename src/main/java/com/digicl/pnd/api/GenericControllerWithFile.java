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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.digicl.pnd.dto.ResponseDTO;
import com.digicl.pnd.service.GenericServiceWithFile;
import com.digicl.pnd.util.Constant;

public class GenericControllerWithFile<T> {
	@Autowired
	private GenericServiceWithFile<T> serviceWithFile;

	@PostMapping
	public ResponseEntity<ResponseDTO> create(@RequestPart(value = "files", required = false) MultipartFile[] files,
			@RequestPart(value = "body") @Valid T dto) {
		return new ResponseEntity<>(
				new ResponseDTO(Constant.MESSAGE_ENTITY_CREATED_SUCCESSFULLY, serviceWithFile.create(files, dto)),
				HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<ResponseDTO> update(@RequestPart(value = "files", required = false) MultipartFile[] files,
			@RequestPart(value = "body") @Valid T dto) {
		return new ResponseEntity<>(
				new ResponseDTO(Constant.MESSAGE_ENTITY_UPDATED_SUCCESSFULLY, serviceWithFile.update(files, dto)),
				HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO> delete(@Valid @PathVariable long id) {
		serviceWithFile.delete(id);
		return new ResponseEntity<>(new ResponseDTO(Constant.MESSAGE_ENTITY_DELETED_SUCCESSFULLY, null), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO> get(@Valid @PathVariable long id) {
		return new ResponseEntity<>(
				new ResponseDTO(Constant.MESSAGE_SINGLE_ENTITY_FOUND_SUCCESSFULLY, serviceWithFile.read(id)),
				HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<ResponseDTO> getAll() {
		return new ResponseEntity<>(
				new ResponseDTO(Constant.MESSAGE_ENTITY_LIST_FOUND_SUCCESSFULLY, serviceWithFile.readAll()),
				HttpStatus.OK);
	}
}
