package com.digicl.pnd.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface GenericService<T> {
	T create(T dto);

	T read(Long id);

	List<T> readAll();

	T update(T dto);

	T delete(Long id);
}