package com.corenuts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corenuts.entity.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

}
