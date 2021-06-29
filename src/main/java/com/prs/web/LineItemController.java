package com.prs.web;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.prs.business.LineItem;
import com.prs.db.LineItemRepo;


@CrossOrigin
@RestController
@RequestMapping("/api/lineItems")
public class LineItemController {
	
	@Autowired
	private LineItemRepo lineItemRepo;

	@GetMapping("/")
	public Iterable<LineItem> getAll() {
		return lineItemRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<LineItem> get(@PathVariable Integer id) {
		return lineItemRepo.findById(id);
	}
	
	@GetMapping("/lines-for-pr/{id}")
	public Iterable<LineItem> getAllByRequestId(@PathVariable int id) {
		return lineItemRepo.findAllByRequestId(id);
	}
	
	@PostMapping("/")
	public LineItem add(@RequestBody LineItem lineItem) {
		return lineItemRepo.save(lineItem);
	}
	
	@PutMapping("/")
	public LineItem update(@RequestBody LineItem lineItem) {
		return lineItemRepo.save(lineItem);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		lineItemRepo.deleteById(id);
	}

}