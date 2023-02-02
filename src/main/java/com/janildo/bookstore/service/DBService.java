package com.janildo.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janildo.bookstore.domain.Categoria;
import com.janildo.bookstore.domain.Livro;
import com.janildo.bookstore.repositories.CategoriaRepository;
import com.janildo.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Aventura", "Livros de Aventura");
		Categoria cat3 = new Categoria(null, "Português", "Livros de Português");

		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsum", cat1);
		Livro l2 = new Livro(null, "Engeharia de Software", "Louis V.", "Lorem Ipsum", cat1);
		Livro l3 = new Livro(null, "Aventura Code", "Robert Aventura", "Lorem Aventura", cat2);
		Livro l4 = new Livro(null, "Teste Code", "Robert Teste", "Lorem Teste", cat3);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4));
	}

}
