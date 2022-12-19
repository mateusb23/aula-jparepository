package com.mateusbispo.aulajparepository.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mateusbispo.aulajparepository.entities.User;
import com.mateusbispo.aulajparepository.respositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	/*@Autowired
	private UserRepository userRepository;*/
	
	private final UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> result = userRepository.findAll();
		return ResponseEntity.ok(result);
	}

	@GetMapping(value = "/page")
	public ResponseEntity<Page<User>> findAll(Pageable pageable) {
		Page<User> result = userRepository.findAll(pageable);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/search-salary")
	public ResponseEntity<Page<User>> searchBySalary(
			@RequestParam(defaultValue = "0") Double minSalary, 
			@RequestParam(defaultValue = "1000000000000") Double maxSalary, Pageable pageable) {
		Page<User> result = userRepository.searchSalary(minSalary, maxSalary, pageable);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/search-name")
	public ResponseEntity<Page<User>> searchByName(
			@RequestParam(defaultValue = "") String name, Pageable pageable) {
		Page<User> result = userRepository.searchName(name, pageable);
		return ResponseEntity.ok(result);
	}
			
	
}
