package com.prs.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prs.business.Product;

import com.prs.db.ProductRepo;



@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductRepo productRepo;

	@GetMapping("/")
	public Iterable<Product> getAll() {
		return productRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Product> get(@PathVariable Integer id) {
		return productRepo.findById(id);
	}
	
	@PostMapping("/")
	public Product add(@RequestBody Product product) {
		return productRepo.save(product);
	}
	
	@PutMapping("/")
	public Product update(@RequestBody Product product) {
		return productRepo.save(product);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		productRepo.deleteById(id);
	}

}