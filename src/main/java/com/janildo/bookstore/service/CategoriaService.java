package com.janildo.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janildo.bookstore.domain.Categoria;
import com.janildo.bookstore.repositories.CategoriaRepository;
import com.janildo.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

}
