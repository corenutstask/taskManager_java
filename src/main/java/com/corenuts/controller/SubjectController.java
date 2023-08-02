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

import com.corenuts.dto.SubjectDTO;
import com.corenuts.service.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {
	
	@Autowired
	private SubjectService service;

	@PostMapping
	public ResponseEntity<SubjectDTO> save(@RequestBody SubjectDTO sub)
	{
		
		return ResponseEntity.ok().body(service.save(sub));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SubjectDTO> get(@PathVariable int id)
	{
		return ResponseEntity.ok().body(service.getby(id));
	}
	
	
	@GetMapping
	public ResponseEntity<List<SubjectDTO>>  getall()
	{
		return ResponseEntity.ok().body(service.getall());
	}
	
	@PutMapping
	public ResponseEntity<SubjectDTO> update(@RequestBody SubjectDTO sub)
	{
		return ResponseEntity.ok().body(service.update(sub));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id)
	{
		 service.delete(id);
	}
	
}
