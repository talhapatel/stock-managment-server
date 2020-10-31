package com.stockmanagment.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmanagment.product.model.Product;
import com.stockmanagment.product.repository.ProductRepository;


@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository ;
	
	public Product addProduct(Product product) {
		
		return	productRepository.save(product);
	
	}
}
