package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ApplicationUser;


@Repository
public interface ApplicationUserRepo extends JpaRepository<ApplicationUser, Integer> {
	
	public List<ApplicationUser> findByUserName(String userName);
	
	public List<ApplicationUser> findByApplicationId(Integer applicationId);
	
	

}
