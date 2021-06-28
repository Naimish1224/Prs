package com.prs.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prs.business.Request;

import com.prs.db.RequestRepo;


@CrossOrigin
@RestController
@RequestMapping("/api/requests")
public class RequestController {
	
	@Autowired
	private RequestRepo requestRepo;

	@GetMapping("/")
	public Iterable<Request> getAll() {
		return requestRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Request> get(@PathVariable Integer id) {
		return requestRepo.findById(id);
	}
	
	@PostMapping("/")
	public Request add(@RequestBody Request request) {
		return requestRepo.save(request);
	}
	
	@PutMapping("/")
	public Request update(@RequestBody Request request) {
		return requestRepo.save(request);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		requestRepo.deleteById(id);
	}

}