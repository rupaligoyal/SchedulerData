package com.example.demo.interviewer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Interviewer;

public interface InterviewerRepository extends JpaRepository<Interviewer, Long>{
	
}
