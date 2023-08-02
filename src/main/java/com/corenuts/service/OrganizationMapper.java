package com.corenuts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.corenuts.dto.OrganizationDTO;
import com.corenuts.entity.Organization;
import com.corenuts.repositories.UserDetailRepository;

@Component
public class OrganizationMapper {
	
	private final UserDetailRepository detailRepository ;
	
	@Autowired
	public OrganizationMapper(UserDetailRepository detailRepository)
	{
		this.detailRepository=detailRepository;
	}
	

    public Organization convertToEntity(OrganizationDTO organizationDTO) {
        Organization organization = new Organization();
        organization.setOrganization_id(organizationDTO.getOrganization_id());
        organization.setOrganization_name(organizationDTO.getOrganization_name());
        organization.setStatus(organizationDTO.getStatus());
//        organization.setCreated_on(organizationDTO.getCreated_on());
        organization.setModified_on(organizationDTO.getModified_on());

        if (organizationDTO.getModified_by() != 0) {
            organization.setModified_by(detailRepository.findById(organizationDTO.getModified_by()).orElse(null));
        }

        organization.setCreated_by(detailRepository.findById(organizationDTO.getCreated_by()).orElse(null));

        return organization;
    }

    public OrganizationDTO convertToDTO(Organization organization) {
        OrganizationDTO organizationDTO = new OrganizationDTO();
        organizationDTO.setOrganization_id(organization.getOrganization_id());
        organizationDTO.setOrganization_name(organization.getOrganization_name());
        organizationDTO.setStatus(organization.getStatus());
        organizationDTO.setCreated_on(organization.getCreated_on());
        organizationDTO.setModified_on(organization.getModified_on());

        if (organization.getCreated_by() != null) {
            organizationDTO.setCreated_by(organization.getCreated_by().getUser_id());
        }

        if (organization.getModified_by() != null) {
            organizationDTO.setModified_by(organization.getModified_by().getUser_id());
        }

        return organizationDTO;
    }
	
	

}
