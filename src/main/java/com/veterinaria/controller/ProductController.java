package com.veterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.domain.ProductDTO;
import com.veterinaria.service.IProductService;


@CrossOrigin
@RestController
@RequestMapping("/products")
@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")

	public class ProductController {
	
	@Autowired
	private IProductService service;

	@PostMapping
	public ProductDTO save(@RequestBody ProductDTO product) {
		return service.save(product);
	}

	@GetMapping
	public List<ProductDTO> getAll() {
		return service.getAll();
	}

	@DeleteMapping("/{idProduct}")
	public List<ProductDTO> delete(@PathVariable Long idProduct) {
		return service.delete(idProduct);
	}

	@PutMapping("/{idProduct}")
	public ProductDTO update(@PathVariable Long idProduct, @RequestBody ProductDTO product) {
		return service.update(idProduct, product);
	}
	
}


