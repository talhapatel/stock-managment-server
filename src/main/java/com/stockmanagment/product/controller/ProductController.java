package com.stockmanagment.product.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmanagment.controller.ApiResponse;
import com.stockmanagment.controller.BaseController;
import com.stockmanagment.controller.GoMessageType;
import com.stockmanagment.product.model.Product;
import com.stockmanagment.product.service.ProductService;

@Scope("request")
@RestController
@RequestMapping("/product")
public class ProductController extends BaseController{
	
	@Autowired
	public ProductService productService;
	
	
	@PostMapping("")
	public ApiResponse addProduct(@Valid @RequestBody Product product) {
		
		setData("product",productService.addProduct(product) );
		addSuccess(GoMessageType.ADD_SUCCESS);
		return renderResponse();
	}

}
