package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Application;

@Repository
public interface ApplicationRepo extends JpaRepository<Application, Integer> {

	
	Application findByApplicationKey(String applicationKey);
	
	Application findByApplicationname(String applicationname);

}
