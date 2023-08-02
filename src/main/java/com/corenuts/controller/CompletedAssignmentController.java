package com.corenuts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corenuts.dto.CompletedAssingmentDTO;
import com.corenuts.service.CompletedAssignmentService;

@RestController
@RequestMapping("/completedAssignment")
public class CompletedAssignmentController {
	
	@Autowired
	private CompletedAssignmentService service;

	@PostMapping
	public ResponseEntity<CompletedAssingmentDTO> save(@RequestBody CompletedAssingmentDTO sub)
	{
		
		return ResponseEntity.ok().body(service.save(sub));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CompletedAssingmentDTO> get(@PathVariable int id)
	{
		return ResponseEntity.ok().body(service.getby(id));
	}
	
	
	@GetMapping
	public ResponseEntity<List<CompletedAssingmentDTO>>  getall()
	{
		return ResponseEntity.ok().body(service.getall());
	}
	
	@PutMapping
	public ResponseEntity<CompletedAssingmentDTO> update(@RequestBody CompletedAssingmentDTO sub)
	{
		return ResponseEntity.ok().body(service.update(sub));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id)
	{
		 service.delete(id);
	}
	
}
