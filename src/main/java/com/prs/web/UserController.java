package com.prs.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prs.business.User;

import com.prs.db.UserRepo;


@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserRepo userRepo;

	@GetMapping("/")
	public Iterable<User> getAll() {
		return userRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<User> get(@PathVariable Integer id) {
		return userRepo.findById(id);
	}
	
	@PostMapping("/")
	public User add(@RequestBody User user) {
		return userRepo.save(user);
	}
	
	@PutMapping("/")
	public User update(@RequestBody User user) {
		return userRepo.save(user);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		userRepo.deleteById(id);
	}
	
	@PostMapping("/login")
	public User login(@RequestBody User user) {
		user.getUsername();
		user.getPassword();
		return user;
	}
}