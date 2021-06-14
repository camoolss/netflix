package com.netflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.service.CategoriaService;

@RestController
public class CategoriaController {

	@Autowired
	@Qualifier("CategoriaServiceImpl")
	private CategoriaService categoriaService;

	@GetMapping("/listAllCategoria")
	public List<Categoria> getAllCategorias() {
		return categoriaService.getAllCategorias();
	}

	@GetMapping("/book/{categoriaid}")
	private Categorias getBooks(@PathVariable("categiaid") int categoriaid) {
		return categoriaService.getBooksById(categoriaid);
	}

	// creating a delete mapping that deletes a specified book
	@DeleteMapping("/book/{categoriaid}")
	private void deleteBook(@PathVariable("categoriaid") int categoriaid) {
		categoriaService.delete(categoriaid);
	}

	// creating post mapping that post the book detail in the database
	@PostMapping("/categorias")
	private int saveBook(@RequestBody Categorias categorias) {
		booksService.saveOrUpdate(categorias);
		return books.getBookid();
	}

	// creating put mapping that updates the book detail
	@PutMapping("/categorias")
	private Books update(@RequestBody Categorias categorias) {
		categoriaService.saveOrUpdate(categorias);
		return categorias;
	}
}