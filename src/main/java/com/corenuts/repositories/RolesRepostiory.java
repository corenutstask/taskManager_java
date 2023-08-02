package com.corenuts.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corenuts.entity.ERole;
import com.corenuts.entity.Role;

public interface RolesRepostiory extends JpaRepository<Role, Integer> {
	
	Optional<Role> findByName(ERole name);

}
