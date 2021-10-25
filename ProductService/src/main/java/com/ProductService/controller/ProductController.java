package com.ProductService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProductService.Entity.Product;
import com.ProductService.service.ProductService;

@RestController
@RequestMapping("/api")

public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProduct() {
		try {
			List<Product> productList = productService.getAll();

			if (productList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(productList, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
		return ((productService.findOneById(id) != null)
				? new ResponseEntity<>(productService.findOneById(id), HttpStatus.CREATED)
				: new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));

	}

	@PostMapping("/product")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return ((productService.add(product) != null)
				? new ResponseEntity<>(productService.add(product), HttpStatus.CREATED)
				: new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));

	}

	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
		return ((productService.update(product, id) != null)
				? new ResponseEntity<>(productService.update(product, id), HttpStatus.CREATED)
				: new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));
	}

}
