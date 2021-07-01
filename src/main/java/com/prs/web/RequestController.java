package com.prs.web;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
		request.setStatus("New");
		request.setSubmitDate(LocalDateTime.now());
		return requestRepo.save(request);
	}

	@PutMapping("/")
	public Request update(@RequestBody Request request) {
		return requestRepo.save(request);
	}

	@DeleteMapping("/{id}")
	public Optional<Request> delete(@PathVariable int id) {
		Optional<Request> request = requestRepo.findById(id);
		if (request.isPresent()) {
			try {
				requestRepo.deleteById(id);
			} catch (DataIntegrityViolationException dive) {
				System.err.println(dive.getRootCause().getMessage());
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
						"Foreign Key Constraint Issue - request id: " + id + " is " + "referred to elsewhere.");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
						"Exception caught during request delete.");
			}
		} else {
			System.err.println("Request delete error - no vendor found for id:" + id);
		}
		return request;
	}

	@PutMapping("/submit-review")
	public Request submitReview(@RequestBody Request request) {
		request.setStatus(request.getTotal() <= 50 ? "Approved" : "Review");
		request.setSubmitDate(LocalDateTime.now());
		return requestRepo.save(request);
	}

	@PutMapping("/approve")
	public Request approve(@RequestBody Request approve) {
		approve.setStatus("Approved");
		return requestRepo.save(approve);
	}

	@PutMapping("/reject")
	public Request reject(@RequestBody Request reject) {
		reject.setStatus("Rejected");
		return requestRepo.save(reject);
	}
	
	@GetMapping("/list-review/{id}")
	public List<Request> getAllReview(@PathVariable int id) {
		return requestRepo.findAllByUserIdNotAndStatus(id, "Review");
	}

}