package com.corenuts.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.corenuts.entity.UserDetails;

@Repository
@Component
public interface UserDetailRepository extends JpaRepository<UserDetails, Integer> {

	Optional<UserDetails> findByEmail(String email);

	boolean existsByEmail(String email);
}
