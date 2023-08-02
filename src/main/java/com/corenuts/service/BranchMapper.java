package com.corenuts.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.corenuts.dto.BranchDTO;
import com.corenuts.entity.Branch;
import com.corenuts.repositories.OrganizationRepository;
import com.corenuts.repositories.UserDetailRepository;

@Component
public class BranchMapper {
	
	private final UserDetailRepository detailRepository ;
	private final OrganizationRepository organizationRepository;
	
	@Autowired
	public BranchMapper(UserDetailRepository detailRepository,OrganizationRepository organizationRepository)
	{
		
		this.detailRepository=detailRepository;
		this.organizationRepository=organizationRepository;
	}
	

    public Branch convertToEntity(BranchDTO branchDTO) {
        Branch branch = new Branch();
       
        branch.setBranch_id(branchDTO.getBranch_id());
        branch.setBranch_name(branchDTO.getBranch_name());
        branch.setStatus(branchDTO.getStatus());
        branch.setModified_on(branchDTO.getModified_on());
        branch.setBranch_location(branchDTO.getBranch_location());
        branch.setOrganization_id(organizationRepository.findById(branchDTO.getOrganization_id()).get());
        if (branchDTO.getModified_admin() != 0) {
            branch.setModified_admin(detailRepository.findById(branchDTO.getModified_admin()).orElse(null));
        }
        branch.setCreated_admin(detailRepository.findById(branchDTO.getCreated_admin()).orElse(null));

        return branch;
    }

    public BranchDTO convertToDTO(Branch branch) {
        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setBranch_id(branch.getBranch_id());
        branchDTO.setBranch_name(branch.getBranch_name());
        branchDTO.setStatus(branch.getStatus());
        branchDTO.setCreated_on(branch.getCreated_on());
        branchDTO.setModified_on(branch.getModified_on());
        branchDTO.setBranch_location(branch.getBranch_location());
        branchDTO.setOrganization_id(branch.getOrganization_id().getOrganization_id());
        if (branch.getCreated_admin() != null) {
            branchDTO.setCreated_admin(branch.getCreated_admin().getUser_id());
        }
        if (branch.getModified_admin() != null) {
            branchDTO.setModified_admin(branch.getModified_admin().getUser_id());
        }
        return branchDTO;
    }
	
	

}
