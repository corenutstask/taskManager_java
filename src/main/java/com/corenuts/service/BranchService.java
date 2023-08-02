package com.corenuts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corenuts.dto.BranchDTO;
import com.corenuts.entity.Branch;
import com.corenuts.repositories.BranchRepository;

@Service
public class BranchService {
	
	private final BranchRepository branchRepo;
	private final BranchMapper mapper;
	
	@Autowired
	public BranchService(BranchRepository BranchRepo,BranchMapper mapper)
	{
		this.branchRepo= BranchRepo;
		this.mapper=mapper;
	}
	
	public BranchDTO save(BranchDTO branchDTO)
	{
		
	Branch sub=mapper.convertToEntity(branchDTO);

	branchRepo.save(sub);
	return  mapper.convertToDTO(sub);
	
		
	}
	
	public BranchDTO getby(int id) {
		
		return mapper.convertToDTO(branchRepo.findById(id).get());
	}

	public List< BranchDTO> getall() {
		List< BranchDTO>branchs=new ArrayList<>();
		System.out.println("getall");
		List<Branch>branchentity=branchRepo.findAll();
				branchs=branchentity.stream().map((branch)->{
			return mapper.convertToDTO(branch) ;
		}).toList();
		System.out.println(branchs);
		return branchs;
	}

	public BranchDTO update(BranchDTO sub) {
		
		Branch branchent=mapper.convertToEntity(sub);
		branchRepo.save(branchent);
		return mapper.convertToDTO(branchent);
	}
	public void delete(int id)
	{
		branchRepo.deleteById(id);
	}
}
