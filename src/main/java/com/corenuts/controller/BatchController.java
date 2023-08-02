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

import com.corenuts.dto. BatchDTO;
import com.corenuts.entity.Batch;
import com.corenuts.entity.SubjectDetails;
import com.corenuts.service.BatchMapper;
import com.corenuts.service. BatchService;

@RestController
@RequestMapping("/batch")
public class  BatchController {
	
	@Autowired
	private  BatchService service;
	@Autowired
	private  BatchMapper mapper;

	@PostMapping
	public ResponseEntity<BatchDTO> save(@RequestBody  BatchDTO sub)
	{


		return ResponseEntity.ok().body(service.save(sub));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity< BatchDTO> get(@PathVariable int id)
	{
		return ResponseEntity.ok().body(service.getby(id));
	}
	
	
	@GetMapping
	public ResponseEntity<List< BatchDTO>>  getall()
	{
		return ResponseEntity.ok().body(service.getall());
	}
	
	@PutMapping
	public ResponseEntity< BatchDTO> update(@RequestBody  BatchDTO sub)
	{
		return ResponseEntity.ok().body(service.update(sub));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id)
	{
		 service.delete(id);
	}
	
}
