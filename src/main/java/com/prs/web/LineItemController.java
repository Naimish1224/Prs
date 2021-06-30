package com.prs.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.prs.business.LineItem;
import com.prs.business.*;
import com.prs.db.*;

@CrossOrigin
@RestController
@RequestMapping("/api/lineItems")
public class LineItemController {

	@Autowired
	private LineItemRepo lineItemRepo;
	@Autowired
	private RequestRepo requestRepo;

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
		LineItem li = lineItemRepo.save(lineItem);
		if (recalculateSubTotal(lineItem.getRequest())) {
		} else {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception caught during movieCollection post.");
		}
		return li;
	}

	@PutMapping("/")
	public LineItem update(@RequestBody LineItem lineItem) {
		LineItem li = lineItemRepo.save(lineItem);
		if (recalculateSubTotal(lineItem.getRequest())) {
		} else {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception caught during movieCollection put.");
		}
		return li;
	}

	@DeleteMapping("/{id}")
	public Optional<LineItem> delete(@PathVariable int id) {
		Optional<LineItem> lineItem = lineItemRepo.findById(id);
		if (lineItem.isPresent()) {
			try {
				lineItemRepo.deleteById(id);
				if (!recalculateSubTotal(lineItem.get().getRequest())) {
					throw new Exception("Issue recalculating collectionValue on delete.");

				}
			} catch (DataIntegrityViolationException dive) {
				System.err.println(dive.getRootCause().getMessage());
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
						"Foreign Key Constraint Issue - lineItem id: " + id + " is " + "referred to elsewhere.");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
						"Exception caught during request delete.");
			}
		} else {
			System.err.println("LineItem delete error - no lineItem found for id:" + id);
		}
		return lineItem;
	}

	private boolean recalculateSubTotal(Request request) {
		boolean success = false;
		try {
			List<LineItem> lis = lineItemRepo.findAllByRequestId(request.getId());

			double subtotal = 0.0;
			for (LineItem li : lis) {
				subtotal += (li.getQuantity()) * (li.getProduct().getPrice());
			}
			request.setTotal(subtotal);
			requestRepo.save(request);
			success = true;
		} catch (Exception e) {
			System.err.println("Error saving new collection value.");
			e.printStackTrace();
		}

		return success;
	}

}