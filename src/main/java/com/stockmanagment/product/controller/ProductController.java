package com.stockmanagment.product.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmanagment.controller.ApiResponse;
import com.stockmanagment.controller.BaseController;
import com.stockmanagment.controller.GoMessageType;
import com.stockmanagment.product.model.Product;
import com.stockmanagment.product.service.ProductService;
import com.stockmanagment.security.services.UserPrinciple;

@Scope("request")
@RestController
@RequestMapping("/product")
public class ProductController extends BaseController{
	
	@Autowired
	public ProductService productService;
	
	
	@PostMapping("")
	public ApiResponse addProduct(@Valid @RequestBody Product product,@RequestAttribute("user") UserPrinciple user) {
		
		
		setData("product",productService.addProduct(product) );
		addSuccess(GoMessageType.ADD_SUCCESS,"Product");
		return renderResponse();
	}
	
	@GetMapping("")
	public ApiResponse getAllProduct() {
		setData("productList",productService.getAllProductList());
		return renderResponse();
	}
	
	@GetMapping("/{id}")
	public ApiResponse getProductById(@PathVariable("id") Long id) {
		
		setData("product",productService.getProductById(id));
		return renderResponse();
	}
	
	@DeleteMapping("/{id}")
	public ApiResponse deleteByProductId(@PathVariable("id") Long  id) {
		productService.deleteByProductId(id);
		addSuccess(GoMessageType.DELETE_SUCCESS, "Product");
		return renderResponse();
	}

}
