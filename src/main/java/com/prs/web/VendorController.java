package com.prs.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prs.business.Vendor;

import com.prs.db.VendorRepo;


@CrossOrigin
@RestController
@RequestMapping("/api/vendors")
public class VendorController {
	
	@Autowired
	private VendorRepo vendorRepo;

	@GetMapping("/")
	public Iterable<Vendor> getAll() {
		return vendorRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Vendor> get(@PathVariable Integer id) {
		return vendorRepo.findById(id);
	}
	
	@PostMapping("/")
	public Vendor add(@RequestBody Vendor vendor) {
		return vendorRepo.save(vendor);
	}
	
	@PutMapping("/")
	public Vendor update(@RequestBody Vendor vendor) {
		return vendorRepo.save(vendor);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		vendorRepo.deleteById(id);
	}

}