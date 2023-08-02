package com.corenuts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corenuts.dto.OrganizationDTO;
import com.corenuts.entity.Organization;
import com.corenuts.repositories.OrganizationRepository;

@Service
public class OrganizationService {
	
	private final OrganizationRepository organizationRepo;
	private final OrganizationMapper mapper;
	
	@Autowired
	public OrganizationService(OrganizationRepository OrganizationRepo,OrganizationMapper mapper)
	{
		this.organizationRepo= OrganizationRepo;
		this.mapper=mapper;
	}
	
	public OrganizationDTO save(OrganizationDTO organizationDTO)
	{
		
	Organization sub=mapper.convertToEntity(organizationDTO);

	organizationRepo.save(sub);
	return  mapper.convertToDTO(sub);
	
		
	}
	
	public OrganizationDTO getby(int id) {
		
		return mapper.convertToDTO(organizationRepo.findById(id).get());
	}

	public List< OrganizationDTO> getall() {
		List< OrganizationDTO>organizations=new ArrayList<>();
		System.out.println("getall");
		List<Organization>organizationentity=organizationRepo.findAll();
				organizations=organizationentity.stream().map((organization)->{
			return mapper.convertToDTO(organization) ;
		}).toList();
		System.out.println(organizations);
		return organizations;
	}

	public OrganizationDTO update(OrganizationDTO sub) {
		
		Organization organizationent=mapper.convertToEntity(sub);
		organizationRepo.save(organizationent);
		return mapper.convertToDTO(organizationent);
	}
	public void delete(int id)
	{
		organizationRepo.deleteById(id);
	}
}
