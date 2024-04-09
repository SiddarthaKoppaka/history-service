package com.siddartha.historyservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siddartha.historyservice.model.PrimesRecord;
import com.siddartha.historyservice.repo.PrimesHistoryRepository;

@RestController
@CrossOrigin
@RequestMapping("/primes")
public class PrimesHistoryController {

	private final PrimesHistoryRepository primesHistoryRepository;

	public PrimesHistoryController(PrimesHistoryRepository primesHistoryRepository) {
		super();
		this.primesHistoryRepository = primesHistoryRepository;
	}
	
	@GetMapping("/{customer}")
	public List<PrimesRecord> findAll(@PathVariable String customer){
		return primesHistoryRepository.findAllByCustomer(customer);
	}
}
