package com.example.demo.candidate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
	
}
