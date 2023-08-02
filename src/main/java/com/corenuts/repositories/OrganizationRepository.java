package com.corenuts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corenuts.entity.Organization;


@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

}
