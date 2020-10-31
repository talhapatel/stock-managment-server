package com.stockmanagment.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Long id;
		
		@NotNull
		String slug;
		
		@NotNull
		String name;
		String reference;
		Double price;
		Double igst;
		Double cgst;
		Double sgst;
		Boolean stockable; 

}
