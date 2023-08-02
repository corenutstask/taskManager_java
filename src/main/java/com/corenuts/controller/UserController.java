package com.corenuts.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corenuts.dto.UserDetailsDTO;
import com.corenuts.request.JwtResponse;
import com.corenuts.request.LoginRequest;
import com.corenuts.request.SignupRequest;
import com.corenuts.service.UserDetailsService;

@RestController
@RequestMapping("/users")

public class UserController {

	private final UserDetailsService userService;

	@Autowired
	public UserController(UserDetailsService userService) {
		this.userService = userService;
	}

	// Endpoint to create a new user
	@PostMapping
	public ResponseEntity<UserDetailsDTO> createUser(@RequestBody UserDetailsDTO userDetailsDTO) {
		UserDetailsDTO createdUser = userService.createUser(userDetailsDTO);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	// Endpoint to get a user by ID
	@GetMapping("/{userId}")
	public ResponseEntity<UserDetailsDTO> getUserById(@PathVariable int userId) {
		UserDetailsDTO userDTO = userService.getUserById(userId);
		if (userDTO != null) {
			return new ResponseEntity<>(userDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Endpoint to get all users
	@GetMapping
	public ResponseEntity<List<UserDetailsDTO>> getAllUsers() {
		List<UserDetailsDTO> usersDTO = userService.getAllUsers();
		return new ResponseEntity<>(usersDTO, HttpStatus.OK);
	}

	// Endpoint to update a user by ID
	@PutMapping("/{userId}")
	public ResponseEntity<UserDetailsDTO> updateUser(@PathVariable int userId,
			@RequestBody UserDetailsDTO userDetailsDTO) {
		UserDetailsDTO updatedUser = userService.updateUser(userId, userDetailsDTO);
		if (updatedUser != null) {
			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Endpoint to delete a user by ID
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable int userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest) {
		return ResponseEntity.ok(userService.login(loginRequest));

	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody SignupRequest request) {
		return ResponseEntity.ok(userService.register(request));

	}
}
