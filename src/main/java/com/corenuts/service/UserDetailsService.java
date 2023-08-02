package com.corenuts.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.corenuts.dto.UserDetailsDTO;
import com.corenuts.entity.Role;
import com.corenuts.entity.StudentDetails;
import com.corenuts.entity.UserDetails;
import com.corenuts.repositories.StudentRepository;
import com.corenuts.repositories.UserDetailRepository;
import com.corenuts.request.JwtResponse;
import com.corenuts.request.LoginRequest;
import com.corenuts.request.SignupRequest;
import com.corenuts.utils.JwtUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDetailsService {

	private final UserDetailRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private StudentRepository repository;

	@Autowired
	public UserDetailsService(UserDetailRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserDetailsDTO createUser(UserDetailsDTO userDetailsDTO) {
		UserDetails userEntity = UserDetailsMapper.toEntity(userDetailsDTO);
		UserDetails savedUser = userRepository.save(userEntity);
		return UserDetailsMapper.toDTO(savedUser);
	}

	public UserDetailsDTO getUserById(int userId) {
		Optional<UserDetails> optionalUser = userRepository.findById(userId);
		return optionalUser.map(UserDetailsMapper::toDTO).orElse(null);
	}

	public List<UserDetailsDTO> getAllUsers() {
		List<UserDetails> userList = userRepository.findAll();
		return userList.stream().map(UserDetailsMapper::toDTO).collect(Collectors.toList());
	}

	public UserDetailsDTO updateUser(int userId, UserDetailsDTO userDetailsDTO) {
		Optional<UserDetails> optionalUser = userRepository.findById(userId);
		if (optionalUser.isPresent()) {
			UserDetails existingUser = optionalUser.get();

			// Update the fields of the existingUser with userDetailsDTO
			existingUser.setUser_name(null);
			existingUser.setEmail(null);
			existingUser.setPassword(userDetailsDTO.getPassword());
			existingUser.setRole(userDetailsDTO.getRole());
			existingUser.setStatus(userDetailsDTO.getStatus());

			userRepository.save(existingUser);
			return UserDetailsMapper.toDTO(existingUser);
		}
		return null;
	}

	public void deleteUser(int userId) {
		userRepository.deleteById(userId);
	}

	// register

	public String register(SignupRequest signupRequest) {
		log.info("singing in service {}", signupRequest);
		if (userRepository.existsByEmail(signupRequest.getEmail())) {
			return "Error : Email already exist";
		}
		Date date=Date.valueOf(LocalDate.now());
		UserDetails user = UserDetails.builder().email(signupRequest.getEmail())
				.password(encoder.encode(signupRequest.getPassword())).status("active").created_on(date)
				.user_name(signupRequest.getUser_name())
				.created_on(date)
				.role(signupRequest.getRole())
				.build();


if(signupRequest.getRole().equals("student")) {
	StudentDetails student = StudentDetails.builder()
			.email(signupRequest.getEmail())
			.student_name(signupRequest.getUser_name())
			.created_on(date)
			.status("active")
			.build();
	repository.save(student);
}
		
		userRepository.save(user);
		return "User Created Successfully!";
	}

	// login

	public JwtResponse login(LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtUtils.generateToken(authentication);

		UserDetailsDTO userDetails = (UserDetailsDTO) authentication.getPrincipal();

		return new JwtResponse(jwt, userDetails.getUserId(), userDetails.getUsername(), userDetails.getEmail(),
				userDetails.getAuthorities().stream().map(auth -> auth.getAuthority()).collect(Collectors.toSet()));
	}

}
