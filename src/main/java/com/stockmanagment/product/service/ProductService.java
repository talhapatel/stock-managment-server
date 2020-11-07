package com.stockmanagment.product.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmanagment.product.model.Product;
import com.stockmanagment.product.repository.ProductRepository;


@Service
@Transactional
public class ProductService {

	@Autowired
	ProductRepository productRepository ;
	
	public Product addProduct(Product product) {
		
		return	productRepository.save(product);
	
	}

	public List<Product> getAllProductList() {
		// TODO Auto-generated method stub
		return productRepository.findAllByOrderByCreatedDate();
	}

	public Optional<Product> getProductById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}
}
