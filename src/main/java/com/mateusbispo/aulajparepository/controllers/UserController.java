package com.mateusbispo.aulajparepository.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
}
