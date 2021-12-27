package com.veterinaria.service;

import java.util.List;

import com.veterinaria.domain.ProductDTO;

public interface IProductService {
	
	ProductDTO save(ProductDTO pet);

	List<ProductDTO> getAll();

	List<ProductDTO> delete(Long id);

	ProductDTO update(Long id, ProductDTO product);

}
